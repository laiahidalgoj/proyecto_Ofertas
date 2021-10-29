package equipo1.ofertasLaborales.controller;

import equipo1.ofertasLaborales.entities.Oferta;
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
class OfertaControllerTest {

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
        ResponseEntity<Oferta[]> response = testRestTemplate.getForEntity("/api/ofertas",Oferta[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Oferta> ofertas = Arrays.asList(response.getBody());
        System.out.println(ofertas.size());
    }

    @Test
    void findById() {
        ResponseEntity<Oferta[]> response = testRestTemplate.getForEntity("/api/ofertas", Oferta[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Oferta> ofertas = Arrays.asList(response.getBody());
        System.out.println(ofertas.size());
    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                 {
                     "tecnologia": "html"
                 }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Tecnologia> response = testRestTemplate.exchange("/api/tecnologias", HttpMethod.POST, request, Tecnologia.class);

        Tecnologia result = response.getBody();

        assertEquals(1L, result.getId());
    }

//    HttpEntity<String> request1=new HttpEntity<String>(Tecnologia1,headers);
//    HttpEntity<String> request2=new HttpEntity<String>(Tecnologia2,headers);
//    HttpEntity<String> request3=new HttpEntity<String>(Tecnologia3,headers);
//    //Pasamos los datos
//    ResponseEntity<Tecnologia> response1 =testRestTemplate.exchange("/api/tecnologias",HttpMethod.POST,request1,Tecnologia.class);
//    ResponseEntity<Tecnologia> response2 =testRestTemplate.exchange("/api/tecnologias",HttpMethod.POST,request2,Tecnologia.class);
//    ResponseEntity<Tecnologia> response3 =testRestTemplate.exchange("/api/tecnologias",HttpMethod.POST,request3,Tecnologia.class);

//    @Test
//    void update() {
//        HttpHeaders headers= new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//
//        ResponseEntity<Tecnologia> response = testRestTemplate.getForEntity("/api/tecnologias/1", Tecnologia.class);
//        String jsonOrdenador= """
//                {
//                "marca":"Asus",
//                "modelo":"TUF Gamming F15","""+
//                """
//                "numSerie"
//                """
//                +":"+response.getBody()+
//                """
//                ,
//                "memRam":16,
//                "procesador":"Intel Core i5 10300H",
//                "pantallaInch":15.6,
//                "sO":"FREE DOS"
//                }
//                """;
//        HttpEntity<String> request1 = new HttpEntity<String>(Tecnologia1,headers);
//        ResponseEntity<Tecnologia> response2=testRestTemplate.exchange("/api/tecnologias",HttpMethod.PUT,request1,Tecnologia.class);
//        assertEquals(HttpStatus.OK, response2.getStatusCode());
//        //Utilizar este asset si quieres hacer test sobre un numero de serie que no exista. habra que modificar el JSON
//        //assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
//    }

    @Test
    void delete() {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //creamos el httpEntity para pasarlo al testresttempalte
        HttpEntity<String> httpEntity=new HttpEntity<String>(headers);

        ResponseEntity<Tecnologia> response2= testRestTemplate.exchange("/api/tecnologias/1",
                HttpMethod.DELETE,httpEntity,Tecnologia.class);

        //assertEquals(HttpStatus.OK,respuesta2.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND,response2.getStatusCode());
    }

    @Test
    void deleteAll() {
        //Creamos las cabeceras
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //creamos el httpEntity para pasarlo al testresttempalte
        HttpEntity<String> httpEntity=new HttpEntity<String>(headers);

        ResponseEntity<String> respuesta= testRestTemplate.exchange("/api/tecnologias",
                HttpMethod.DELETE,httpEntity,String.class);

        //assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        assertEquals(HttpStatus.NO_CONTENT, respuesta.getStatusCode());
    }
}