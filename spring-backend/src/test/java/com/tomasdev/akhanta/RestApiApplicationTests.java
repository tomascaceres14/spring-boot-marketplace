package com.tomasdev.akhanta;

import com.tomasdev.akhanta.auth.dto.UserRegisterDTO;
import com.tomasdev.akhanta.users.Address;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RestApiApplicationTests {

	MockMvc mvc;

	@Test
	void createUser() throws Exception {

		UserRegisterDTO requestBody = UserRegisterDTO.builder()
				.firstName("John").lastName("Smith").email("johnsmith@yahoo.com")
				.password("testpassword").phoneNumber("+55750123").username("john_smith").address(
						Address.builder().apartmentNumber("7A").street("Fake St.").city("Los Angeles")
								.buildingNumber("123").zipCode("454").build()
				).build();

		mvc.perform(post("/api/v1/auth/register")
				.content(requestBody.toString())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(201));
	}

}
