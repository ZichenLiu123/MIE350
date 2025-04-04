package com.example.cms;

import com.example.cms.model.entities.Wine;
import com.example.cms.model.repositories.WineRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class WineTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WineRepository wineRepository;

    // test get all wines
    @Test
    void getAllWine() throws Exception{
        // Perform GET request to get all wines
        MockHttpServletResponse response = mockMvc.perform(get("/wine"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
    }

    // test get beer by ID
    @Test
    void getWineById() throws Exception{
        // Perform GET request to get beer by ID
        MockHttpServletResponse response = mockMvc.perform(get("/wine/21"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals(21L, receivedJson.get("id").longValue());
        assertEquals(1L, receivedJson.get("wineType").get("id").longValue());
        assertEquals(5L, receivedJson.get("age").longValue());
    }

    // test posting wine
    @Test
    void addWine() throws Exception{

        ObjectNode wineJson = objectMapper.createObjectNode();
        wineJson.put("id", 22L);
        wineJson.put("age", 2);

        ObjectNode wineTypeNode = objectMapper.createObjectNode();
        wineTypeNode.put("id", 2L);
        wineJson.set("wineType", wineTypeNode);

        MockHttpServletResponse response = mockMvc.perform(
                        post("/wine")
                                .contentType("application/json")
                                .content(wineJson.toString()))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        assertTrue(wineRepository.findById(22L).isPresent());
        Wine addedWine = wineRepository.findById(22L).get();

        assertEquals(22L, addedWine.getId());
        assertEquals(2L, addedWine.getWineType().getId());
        assertEquals(2, addedWine.getAge());

    }


    @Test
    @Transactional
    void addThenDeleteWine() throws Exception {
        ObjectNode wineJson = objectMapper.createObjectNode();
        wineJson.put("id", 25L);

        ObjectNode wineTypeJson = objectMapper.createObjectNode();
        wineTypeJson.put("id", 1);

        wineJson.set("wineType", wineTypeJson);
        wineJson.put("age", 5);

        // Perform POST request to add a Wine
        MockHttpServletResponse addResponse = mockMvc.perform(
                        post("/wine")
                                .contentType("application/json")
                                .content(wineJson.toString()))
                .andReturn().getResponse();

        // Assert POST was successful
        assertEquals(200, addResponse.getStatus());
        assertTrue(wineRepository.findById(25L).isPresent());

        // Perform DELETE request to remove the Wine
        MockHttpServletResponse deleteResponse = mockMvc.perform(
                        delete("/wine/25")
                                .contentType("application/json"))
                .andReturn().getResponse();

        // Assert DELETE was successful
        assertEquals(200, deleteResponse.getStatus());
        assertTrue(wineRepository.findById(25L).isEmpty());
    }

    @Test
    void addThenUpdateWine() throws Exception {
        ObjectNode wineJson = objectMapper.createObjectNode();
        wineJson.put("id", 26L);
        wineJson.put("age", 3);

        ObjectNode wineTypeJson = objectMapper.createObjectNode();
        wineTypeJson.put("id", 1);

        wineJson.set("wineType", wineTypeJson);

        // Perform POST request to add a Wine
        MockHttpServletResponse addResponse = mockMvc.perform(
                        post("/wine")
                                .contentType("application/json")
                                .content(wineJson.toString()))
                .andReturn().getResponse();

        assertEquals(200, addResponse.getStatus());
        assertTrue(wineRepository.findById(26L).isPresent());

        // Modify wine JSON for update
        wineJson.put("age", 8);

        ObjectNode updatedWineTypeJson = objectMapper.createObjectNode();
        updatedWineTypeJson.put("id", 2);
        wineJson.set("wineType", updatedWineTypeJson);

        // Perform PUT request to update the Wine
        MockHttpServletResponse putResponse = mockMvc.perform(
                        put("/wine/26")
                                .contentType("application/json")
                                .content(wineJson.toString()))
                .andReturn().getResponse();

        assertEquals(200, putResponse.getStatus());

        // Validate the update
        Wine updatedWine = wineRepository.findById(26L).orElseThrow();
        assertEquals(8, updatedWine.getAge());
        assertEquals(2L, updatedWine.getWineType().getId());
    }




}
