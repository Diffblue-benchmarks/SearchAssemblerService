package com.marksandspencer.search.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.marksandspencer.search.service.EnrichService;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class SearchAssemblyControllerTest {
private MockMvc mockMvc;
	
	@Mock
	EnrichService enrichService;
	
	@InjectMocks
	SearchAssemblyController searchAssemblyController;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(searchAssemblyController)
                .build();
	}

	@Test
	@Ignore
	public void should_parse_content_l2_and_return_200() throws Exception {
	//	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/create/fullfeed");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/create/fullfeed").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int expected = 200;
		int resultString = result.getResponse().getStatus();
		assertEquals(expected,resultString);
		
		

		


		
	}
}
