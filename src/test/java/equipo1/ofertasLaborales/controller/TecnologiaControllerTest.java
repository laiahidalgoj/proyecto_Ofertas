package equipo1.ofertasLaborales.controller;

import equipo1.ofertasLaborales.entities.Tecnologia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TecnologiaControllerTest {
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }



    @Test
    void findAll() {
        ResponseEntity<Tecnologia[]> response = testRestTemplate.getForEntity("/api/tecnologias", Tecnologia[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Tecnologia> books = Arrays.asList(response.getBody());
        System.out.println(books.size());
    }

    @Test
    void findById() {
        ResponseEntity<Tecnologia> response = testRestTemplate.getForEntity("/api/tecnologias/2", Tecnologia.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                 {
                         "tecnologias": [
                             {
                     
                                 "nombre": "C#"
                             }
                         ],
                         "empresa": "IT",
                         "descripcion": "Comunicaciones",
                         "numeroVacantes": 4,
                         "localidad": "Barcelona",
                         "salarioMinimo": 20000,
                         "salarioMaximo": 24000,
                         "modalidad": "Remoto",
                         "anyosExperiencia": 2,
                         "titulacion": "Ingeniero",
                         "categoria": 4,
                         "tipoContrato": "Indefinido",
                         "fechaPublicacion": "2021-12-01T00:00:00.000+00:00",
                         "estadoProceso": true
                     }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Tecnologia> response = testRestTemplate.exchange("/api/tecnologias", HttpMethod.POST, request, Tecnologia.class);

        Tecnologia result = response.getBody();

        assertEquals(1L, result.getId());
    }

    @Test
    void update() {

    }

//    @Test
//    void delete() {
//        HttpHeaders headers=new HttpHeaders();
//        headers.setContentType(MediaType.TEXT_PLAIN);
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        //creamos el httpEntity para pasarlo al testresttempalte
//        HttpEntity<String> httpEntity=new HttpEntity<String>(headers);
//
//        ResponseEntity<Tecnologia> respuesta = testRestTemplate.exchange("/api/tecnologias",
//                HttpMethod.DELETE,httpEntity,Tecnologia.class);
//
//        assertEquals(HttpStatus.OK,respuesta.getStatusCode());
//        //Si metemos un numero de serie incorrecto utilizar este assert
//        //assertEquals(HttpStatus.BAD_REQUEST,respuesta.getStatusCode());
//
//    }

    @Test
    void deleteAll() {

    }
}