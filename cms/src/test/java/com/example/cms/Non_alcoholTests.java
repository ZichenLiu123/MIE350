package com.example.cms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.cms.model.entities.Non_Alcoholic;
import com.example.cms.model.repositories.Non_AlcoholicRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class Non_alcoholTests {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @Autowired
        private Non_AlcoholicRepository nonAlcoholicRepository;

        // Test retrieving all non alcoholic drinks
        @Test
        void getAllNonAlcoholicDrinks() throws Exception {
                MockHttpServletResponse response = mockMvc.perform(get("/alcohol/non-alcoholic"))
                                .andReturn().getResponse();
                assertEquals(200, response.getStatus());
        }

        // Test retrieving a non alcoholic drink by ID
        @Test
        void getNonAlcoholicById() throws Exception {

                // Perform GET request
                MockHttpServletResponse response = mockMvc.perform(get("/alcohol/non-alcoholic/900"))
                                .andReturn().getResponse();
                assertEquals(200, response.getStatus());

                // Parse JSON and verify fields
                ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
                assertEquals(900L, receivedJson.get("id").longValue());
                assertEquals(true, receivedJson.get("isCarbonated").booleanValue());
                assertEquals("Beer", receivedJson.get("alcoholicEquivalent").textValue());
        }

        // Test the posting endpoint (POST /alcohol/non-alcoholic/create)
        @Test
        void createNonAlcoholicTest() throws Exception {
                ObjectNode non_alcoJson = objectMapper.createObjectNode();
                non_alcoJson.put("id", 9999L);
                non_alcoJson.put("isCarbonated", true);
                non_alcoJson.put("alcoholicEquivalent", "Beer");

                // Perform POST request to add
                MockHttpServletResponse response = mockMvc.perform(
                                post("/alcohol/non-alcoholic/create"). // POST
                                                contentType("application/json").content(non_alcoJson.toString()))
                                .andReturn().getResponse();

                // assert HTTP code of response is 200 OK
                assertEquals(200, response.getStatus());

                // object
                assertTrue(nonAlcoholicRepository.findById(9999L).isPresent());
                Non_Alcoholic addeddrink = nonAlcoholicRepository.findById(9999L).get();

                // Assert the details are correct
                assertEquals(9999L, addeddrink.getId());
                assertEquals("Beer", addeddrink.getAlcoholicEquivalent());
                assertEquals(true, addeddrink.getIsCarbonated());

        }

        // Test updating a non alcoholic drink
        @Test
        void updateNonAlcoholicDrinkTest() throws Exception {
                
                ObjectNode updateJson = objectMapper.createObjectNode();
                updateJson.put("id", 5001L);
                updateJson.put("isCarbonated", false);
                updateJson.put("alcoholicEquivalent", "Beer");

                // Perform POST request to add
                MockHttpServletResponse postresponse = mockMvc.perform(
                                post("/alcohol/non-alcoholic/create"). // POST
                                                contentType("application/json").content(updateJson.toString()))
                                .andReturn().getResponse();

                // assert HTTP code of response is 200 OK
                assertEquals(200, postresponse.getStatus());
                assertTrue(nonAlcoholicRepository.findById(5001L).isPresent());

                //modify for update
                updateJson.put("isCarbonated", true);
                updateJson.put("alcoholicEquivalent", "Wine");

                // Perform PUT request
                MockHttpServletResponse response = mockMvc.perform(
                                put("/alcohol/non-alcoholic/5001")
                                                .contentType("application/json")
                                                .content(updateJson.toString()))
                                .andReturn().getResponse();
                assertEquals(200, response.getStatus());

                // Retrieve and verify updated record
                Non_Alcoholic updatedDrink = nonAlcoholicRepository.findById(5001L).orElseThrow();
                assertEquals("Wine", updatedDrink.getAlcoholicEquivalent());
                assertEquals(true, updatedDrink.getIsCarbonated());
        }

        // Test deleting a non alcoholic drink
        @Test
        void deleteNonAlcoholicDrinkTest() throws Exception {
                ObjectNode updateJson = objectMapper.createObjectNode();
                updateJson.put("id", 5001L);
                updateJson.put("isCarbonated", false);
                updateJson.put("alcoholicEquivalent", "Beer");

                // Perform POST request to add
                MockHttpServletResponse postresponse = mockMvc.perform(
                                post("/alcohol/non-alcoholic/create"). // POST
                                                contentType("application/json").content(updateJson.toString()))
                                .andReturn().getResponse();

                // assert HTTP code of response is 200 OK
                assertEquals(200, postresponse.getStatus());
                assertTrue(nonAlcoholicRepository.findById(5001L).isPresent());

                // Perform PUT request
                MockHttpServletResponse response = mockMvc.perform(
                                delete("/alcohol/non-alcoholic/5001")
                                                .contentType("application/json")
                                                .content(updateJson.toString()))
                                .andReturn().getResponse();
                assertEquals(200, response.getStatus());
                assertTrue(nonAlcoholicRepository.findById(5001L).isEmpty());
        }
}
