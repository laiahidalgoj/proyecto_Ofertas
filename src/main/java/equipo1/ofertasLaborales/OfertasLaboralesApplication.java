package equipo1.ofertasLaborales;


import equipo1.ofertasLaborales.entities.Oferta;
import equipo1.ofertasLaborales.entities.Tecnologia;
import equipo1.ofertasLaborales.repositories.OfertaRepository;
import equipo1.ofertasLaborales.repositories.TecnologiaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.*;

@SpringBootApplication
public class OfertasLaboralesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OfertasLaboralesApplication.class,
				args);
		OfertaRepository ofertaRepository = context.getBean(OfertaRepository.class);
		TecnologiaRepository tecnologiaRepository = context.getBean(TecnologiaRepository.class);

		Tecnologia tecJava = new Tecnologia(null, "Java");
		Tecnologia tecSpring = new Tecnologia(null, "Spring");
		Tecnologia tecJS = new Tecnologia(null, "Javascript");
		Tecnologia tecAngular = new Tecnologia(null, "Angular");
		Tecnologia tecCSS = new Tecnologia(null, "CSS");
		Tecnologia tecPython = new Tecnologia(null, "Python");
		Tecnologia tecReact = new Tecnologia(null, "React");
		Tecnologia tecDjango = new Tecnologia(null, "Django");

		System.out.println("Número de ofertas en base de datos: " + ofertaRepository.findAll().size());
		System.out.println("Número de tecnologías en base de datos: " + tecnologiaRepository.findAll().size());

		tecnologiaRepository.saveAll(Arrays.asList(tecJava, tecSpring, tecJS, tecAngular, tecCSS, tecPython, tecReact, tecDjango));

		Date fecha1 = new Date (20/12/23) ;
		Date fecha2 = new Date (21/10/7) ;
		Date fecha3 = new Date (21/2/28) ;


		Oferta oferta1 = new Oferta(null,"Desarrollador Backend Jr.", "Orange","Comunicaciones",
				4,"Barcelona",12000,18000,
				"Presencial",2,
				"Ingeniero","Frontend","Indefinido" ,fecha1,true,"") ;

		Oferta oferta2 = new Oferta(null, "Desarrollador Frontend Jr.","Vodafone","Comunicaciones",
				2,"Madrid",11000,16000,
				"Remoto",1,
				"CFGS","Frontend","Practicas" ,fecha2,false,"");

		Oferta oferta3 = new Oferta(null, "Desarrollador Fullstack Sr.","Movistar", "Comunicaciones",
				2, "Zaragoza", 14000, 19000,
				"Remoto", 3,
				"CFGS", "Fullstack", "Practicas", fecha3, true, "");

		ofertaRepository.save(oferta1);
		ofertaRepository.save(oferta2);
		ofertaRepository.save(oferta3);

		List<Tecnologia> tecnologias1 = Arrays.asList(tecJava, tecSpring);
		List<Tecnologia> tecnologias2 = Arrays.asList(tecJS, tecAngular, tecCSS);
		List<Tecnologia> tecnologias3 = Arrays.asList(tecJS, tecCSS, tecReact, tecPython, tecDjango);

		for (Tecnologia tecnologia : tecnologias1) {
			oferta1.addTecnologia(tecnologia);
		}
		for (Tecnologia tecnologia : tecnologias2) {
			oferta2.addTecnologia(tecnologia);
		}
		for (Tecnologia tecnologia : tecnologias3) {
			oferta3.addTecnologia(tecnologia);
		}

		ofertaRepository.saveAll(Arrays.asList(oferta1, oferta2, oferta3));

		System.out.println("Número de ofertas en base de datos: " + ofertaRepository.findAll().size());
		System.out.println("Número de tecnologías en base de datos: " + tecnologiaRepository.findAll().size());

		List<Oferta> ofertas = ofertaRepository.findAll();

		for (Oferta oferta : ofertas) {
			Set<Tecnologia> tecnologias = oferta.getTecnologias();
			String idTecnologias = "";
			for(Tecnologia tecnologia : tecnologias) {
				idTecnologias += tecnologia.getId() + " ";
			}
			System.out.println(" Id Oferta: " + oferta.getId() + " - Id Tecnologia: " + idTecnologias);
		}

	}
}
