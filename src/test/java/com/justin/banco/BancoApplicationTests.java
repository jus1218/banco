package com.justin.banco;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.justin.banco.constants.Message;
import com.justin.banco.dto.Ubicacion.UbicacionInfoDTO;
import com.justin.banco.dto.Ubicacion.UbicationCreateDTO;
import com.justin.banco.helpers.Result;
import com.justin.banco.models.Ubicacion;
import com.justin.banco.service.UbicacionService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

// @ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc // Permite la configuracion automatica del mockMvc
class BancoApplicationTests {

	@MockBean
	private UbicacionService ubicacionService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {

	}

	// @Test
	// void create() throws Exception {

	// // Crea una instancia de UbicacionInfoDTO
	// var objEsperado = new UbicacionInfoDTO(77, "KONOHA", null);
	// // Crea un Result que contenga el UbicacionInfoDTO
	// Result<UbicacionInfoDTO> result = Result.get(objEsperado,
	// Message.UBICATION_CREATE_SUCCESS, 0);
	// // Envuelve el Result en un ResponseEntity
	// ResponseEntity<Result<UbicacionInfoDTO>> responseEntity =
	// ResponseEntity.ok(result);

	// var ubicationCreateDTO = new UbicationCreateDTO(77, "KONOHA", 0, null);
	// // Convertir el DTO a JSON
	// ObjectMapper objectMapper = new ObjectMapper();
	// String provinciaJson = objectMapper.writeValueAsString(ubicationCreateDTO);
	// // Simula el comportamiento del servicio
	// doReturn(result).when(ubicacionService).createProvince(ubicationCreateDTO);

	// // Ejecución del mockMvc y verificación del resultado
	// var response = mockMvc.perform(post("/ubicacion/create")
	// .contentType(MediaType.APPLICATION_JSON)
	// .content(provinciaJson))
	// .andExpect(status().isCreated())
	// .andExpect(jsonPath("$.value.codigo").value(77))
	// .andExpect(jsonPath("$.value.nombre").value("KONOHA"))
	// .andExpect(jsonPath("$.value.idRelacion").value(JsonNull.INSTANCE))
	// // .andExpect(jsonPath("$.value.idRelacion").value(null))
	// .andExpect(jsonPath("$.message").value("Provincia creada
	// satisfactoriamente."))
	// .andExpect(jsonPath("$.success").value(true));

	// System.out.println(response);

	// }
	@Test
	void getProvincia() throws Exception {

		var provinciaMock = new Ubicacion("5", 0);
		var esperado = new UbicacionInfoDTO(5, "Guanacaste", null);

		Result<UbicacionInfoDTO> result = Result.get(esperado, Message.UBICATION_CREATE_SUCCESS, 0);

		doReturn(result).when(ubicacionService).getUbication(provinciaMock);

		mockMvc.perform(get("/ubicacion/get?codigo=5&type=0")) 
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.value.codigo").value(5));

	}

}
