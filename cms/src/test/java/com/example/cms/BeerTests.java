package com.example.cms;

import com.example.cms.model.entities.Beer;
import com.example.cms.model.repositories.BeerRepository;
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
	private BeerRepository beerRepository;

	// test get all beers
	@Test
	void getAllBeer() throws Exception{
		// Perform GET request to get all beers
		MockHttpServletResponse response = mockMvc.perform(get("/beer"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());
	}

	// test get beer by ID
	@Test
	void getBeerbyId() throws Exception{
		// Perform GET request to get beer by ID
		MockHttpServletResponse response = mockMvc.perform(get("/beer/630"))
				.andReturn().getResponse();

		assertEquals(200, response.getStatus());

		ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
		assertEquals(630L, receivedJson.get("id").longValue());
		assertEquals("Ales", receivedJson.get("beerType").textValue());
		assertEquals("Brussels, Belgium", receivedJson.get("beerOrigin").textValue());
	}

	// test posting beer
	@Test
	void addStudent() throws Exception{

		ObjectNode beerJson = objectMapper.createObjectNode();
		beerJson.put("id", 8888L); // 8888 - Long
		beerJson.put("beerType", "Lagers");
		beerJson.put("beerOrigin", "Toronto, Canada");

		// Perform POST request to add a Beer
		MockHttpServletResponse response = mockMvc.perform(
				post("/beer"). // POST -> /beer
						contentType("application/json").
						content(beerJson.toString()))
				.andReturn().getResponse();

		// assert HTTP code of response is 200 OK
		assertEquals(200, response.getStatus());

		// Assert student with id 8888 exists in our repository and then get the student object
		assertTrue(beerRepository.findById(8888L).isPresent());
		Beer addedBeer = beerRepository.findById(8888L).get();

		// Assert the details of the students are correct
		assertEquals(8888L, addedBeer.getId());
		assertEquals("Lagers", addedBeer.getBeerType());
		assertEquals("Toronto, Canada", addedBeer.getBeerOrigin());
		assertEquals(1L, addedBeer.getAlcohol().getCategory_id().getCategory_id()); // 1L = Beer
	}

	// test adding then deleting beer
	@Test
	void addThenDeleteBeer() throws Exception {
		ObjectNode beerJson = objectMapper.createObjectNode();
		beerJson.put("id", 8899L);
		beerJson.put("beerType", "Lagers");
		beerJson.put("beerOrigin", "Toronto, Canada");

		// Perform POST request to add a Beer
		MockHttpServletResponse addResponse = mockMvc.perform(
						post("/beer")
								.contentType("application/json")
								.content(beerJson.toString()))
				.andReturn().getResponse();

		// Assert HTTP response status is 200 OK for adding beer
		assertEquals(200, addResponse.getStatus());
		assertTrue(beerRepository.findById(8899L).isPresent());

		// Perform DELETE request to remove the Beer
		MockHttpServletResponse deleteResponse = mockMvc.perform(
						delete("/beer/8899") // Use DELETE instead of POST
								.contentType("application/json"))
				.andReturn().getResponse();

		// Assert HTTP response status is 200 OK for deleting beer
		assertEquals(200, deleteResponse.getStatus());
		assertTrue(beerRepository.findById(8899L).isEmpty());
	}

	// test updating beer
	@Test
	void addThenUpdateBeer() throws Exception {
		ObjectNode beerJson = objectMapper.createObjectNode();
		beerJson.put("id", 8899L);
		beerJson.put("beerType", "Lagers");
		beerJson.put("beerOrigin", "Toronto, Canada");

		// Perform POST request to add a Beer
		MockHttpServletResponse addResponse = mockMvc.perform(
						post("/beer")
								.contentType("application/json")
								.content(beerJson.toString()))
				.andReturn().getResponse();

		// Assert HTTP response status is 200 OK for adding beer
		assertEquals(200, addResponse.getStatus());
		assertTrue(beerRepository.findById(8899L).isPresent());

		// Modify beer JSON for update
		beerJson.put("beerType", "Ales");
		beerJson.put("beerOrigin", "Vancouver, Canada");

		// Perform PUT request to update the Beer
		MockHttpServletResponse putResponse = mockMvc.perform(
						put("/beer/8899")
								.contentType("application/json")
								.content(beerJson.toString()))
				.andReturn().getResponse();

		// Assert HTTP response status is 200 OK for updating beer
		assertEquals(200, putResponse.getStatus());

		// Verify that beer was updated
		Beer updatedBeer = beerRepository.findById(8899L).orElseThrow();
		assertEquals("Ales", updatedBeer.getBeerType());
		assertEquals("Vancouver, Canada", updatedBeer.getBeerOrigin());
	}


}
