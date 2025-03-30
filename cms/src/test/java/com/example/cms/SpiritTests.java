package com.example.cms;

import com.example.cms.model.entities.Spirit;
import com.example.cms.model.repositories.SpiritRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class BeerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private SpiritRepository spiritRepository;

	// test get all spirits
	@Test
	void getAllBeer() throws Exception{
		// Perform GET request to get all spirits
		MockHttpServletResponse response = mockMvc.perform(get("/spirit"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());
	}

	// test get spirit by ID
	@Test
	void getBeerbyId() throws Exception{
		// Perform GET request to get spirit by ID
		MockHttpServletResponse response = mockMvc.perform(get("/beer/100"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());

		ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
		assertEquals(100L, receivedJson.get("id").longValue());
		assertEquals("Whiskey", receivedJson.get("spiritType").get("name").textValue());
	}

	// test posting beer
	@Test
	void FindSpirit() throws Exception{

		ObjectNode spiritJson = objectMapper.createObjectNode();
		spiritJson.put("price", 1); 
		spiritJson.put("alcoholType", 1L); // 8888 - Long
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
		ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
		assertEquals(100L, receivedJson.get("id").longValue());
		assertEquals("Whiskey", receivedJson.get("spiritType").get("name").textValue());
	}

	// test adding then deleting spirit
	@Test
	void addThenDeleteSpirit() throws Exception {
		ObjectNode spirittypeJson = objectMapper.createObjectNode();
		spirittypeJson.put("id", 39280L);
		spirittypeJson.put("name","Whiskey");

		ObjectNode spiritJson = objectMapper.createObjectNode();
		spiritJson.set("spiritType",spirittypeJson);

		// Perform POST request to add a Beer
		MockHttpServletResponse addResponse = mockMvc.perform(
						post("/spirit")
								.contentType("application/json")
								.content(spiritJson.toString()))
				.andReturn().getResponse();

		// Assert HTTP response status is 200 OK for adding beer
		assertEquals(200, addResponse.getStatus());
		assertTrue(spiritRepository.findById(39280L).isPresent());

		// Perform DELETE request to remove the Beer
		MockHttpServletResponse deleteResponse = mockMvc.perform(
						delete("/beer/39280") // Use DELETE instead of POST
								.contentType("application/json"))
				.andReturn().getResponse();

		// Assert HTTP response status is 200 OK for deleting beer
		assertEquals(200, deleteResponse.getStatus());
		assertTrue(spiritRepository.findById(39280L).isEmpty());
	}

	// test updating beer
	@Test
	void addThenUpdateSpirit() throws Exception {
		ObjectNode spirittypeJson = objectMapper.createObjectNode();
		spirittypeJson.put("id", 39280L);
		spirittypeJson.put("name","Whiskey");

		ObjectNode spiritJson = objectMapper.createObjectNode();
		spiritJson.set("spiritType",spirittypeJson);
		

		// Perform POST request to add a Beer
		MockHttpServletResponse addResponse = mockMvc.perform(
						post("/spirit")
								.contentType("application/json")
								.content(spiritJson.toString()))
				.andReturn().getResponse();

		// Assert HTTP response status is 200 OK for adding beer
		assertEquals(200, addResponse.getStatus());
		assertTrue(spiritRepository.findById(39280L).isPresent());

		// Modify beer JSON for update
		spirittypeJson.put("id", 39280L);
		spirittypeJson.put("name","Whiskey");
		spiritJson.set("spiritType",spirittypeJson);

		// Perform PUT request to update the Beer
		MockHttpServletResponse putResponse = mockMvc.perform(
						put("/beer/39280")
								.contentType("application/json")
								.content(spiritJson.toString()))
				.andReturn().getResponse();

		// Assert HTTP response status is 200 OK for updating beer
		assertEquals(200, putResponse.getStatus());

		// Verify that beer was updated
		Spirit updatedspirit = spiritRepository.findById(39280L).orElseThrow();
		assertEquals("Whiskey", updatedspirit.getSpiritType().getName());
	}


}
