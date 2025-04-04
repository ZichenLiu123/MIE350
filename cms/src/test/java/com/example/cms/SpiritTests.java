package com.example.cms;

import com.example.cms.model.entities.Spirit;
import com.example.cms.model.repositories.SpiritRepository;
import com.example.cms.model.repositories.SpiritTypeRepository;
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
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import com.fasterxml.jackson.core.type.TypeReference;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpiritTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private SpiritRepository spiritRepository;

	
	@Autowired
	private SpiritTypeRepository spirittypeRepository;

	// test get all spirits
	@Test
	void getAllSpirit() throws Exception{
		// Perform GET request to get all spirits
		MockHttpServletResponse response = mockMvc.perform(get("/spirit"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());
	}

	// test get spirit by ID
	@Test
	void getSpiritbyId() throws Exception{
		// Perform GET request to get spirit by ID
		MockHttpServletResponse response = mockMvc.perform(get("/spirit/100"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());

		ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
		assertEquals(100L, receivedJson.get("id").longValue());
		assertEquals("Whiskey", receivedJson.get("spiritType").get("name").textValue());
	}

	// test posting spirit
	@Test
	void FindSpirit() throws Exception{

		ObjectNode spiritJson = objectMapper.createObjectNode();
		spiritJson.put("price", 1); 
		spiritJson.put("alcoholType", 1L); // 1 - Long
		spiritJson.put("flavor", "Sweet");


		// Perform POST request to add a Beer
		MockHttpServletResponse response = mockMvc.perform(
				post("/spirit/search"). // POST -> /beer
						contentType("application/json").
						content(spiritJson.toString()))
				.andReturn().getResponse();

		// assert HTTP code of response is 200 OK
		assertEquals(200, response.getStatus());
		

		// Assert the details of the spirits are correct
		List<ObjectNode> receivedSpirits = objectMapper.readValue(response.getContentAsString(), new TypeReference<List<ObjectNode>>() {});
        
		// Verify each returned spirit matches our search criteria
		for (ObjectNode spirit : receivedSpirits) {
			// Verify the spirit has the expected properties
			assertTrue(spirit.has("id"), "Spirit should have an ID");
			assertTrue(spirit.has("spiritType"), "Spirit should have a spiritType");
	}}
	@Test
	@Transactional
    void addThenDeleteSpirits() throws Exception {
        ObjectNode spiritJson = objectMapper.createObjectNode();
        spiritJson.put("id", 303L);

        ObjectNode spiritTypeJson = objectMapper.createObjectNode();
        spiritTypeJson.put("id", 6);

        spiritJson.set("spiritType", spiritTypeJson);

        // Perform POST request to add a Wine
        MockHttpServletResponse addResponse = mockMvc.perform(
                        post("/spirit")
                                .contentType("application/json")
                                .content(spiritJson.toString()))
                .andReturn().getResponse();

        // Assert POST was successful
        assertEquals(200, addResponse.getStatus());
        assertTrue(spiritRepository.findById(303L).isPresent());

		// Perform DELETE request to remove the Spirit
        MockHttpServletResponse deleteResponse = mockMvc.perform(
                        delete("/spirit/303")
                                .contentType("application/json"))
                .andReturn().getResponse();

        // Assert DELETE was successful
        assertEquals(200, deleteResponse.getStatus());
        assertTrue(spiritRepository.findById(303L).isEmpty());

    }




	// test updating spirit
	@Test
	void addThenUpdateSpirit() throws Exception {
		ObjectNode spirittypeJson = objectMapper.createObjectNode();
		spirittypeJson.put("id", 2L);
		spirittypeJson.put("name","Brandy");

		ObjectNode spiritJson = objectMapper.createObjectNode();
		spiritJson.set("spiritType",spirittypeJson);
		

		// Perform PUT request to update the Beer
		MockHttpServletResponse putResponse = mockMvc.perform(
						put("/spirit/105")
								.contentType("application/json")
								.content(spiritJson.toString()))
				.andReturn().getResponse();

		// Assert HTTP response status is 200 OK for updating beer
		assertEquals(200, putResponse.getStatus());

		// Verify that spirit was updated
		Spirit updatedspirit = spiritRepository.findById(105L).orElseThrow();
		assertEquals("Brandy", updatedspirit.getSpiritType().getName());
	}


}
