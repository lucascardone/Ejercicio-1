package com.utn.ejercicio1;

import com.utn.ejercicio1.entities.Persona;
import com.utn.ejercicio1.repositories.RepositoryPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio1Application {

    @Autowired
    private RepositoryPersona repositoryPersona;

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio1Application.class, args);
    }

    @Bean
    CommandLineRunner init(RepositoryPersona repositoryPersona) {
        return args -> {
            System.out.println("######## Codigo funcionando correctamente ########");
            Persona persona = new Persona();
            persona.setNombre("Lucas");
            persona.setApellido("Cardone");
            persona.setEdad(21);

            // Guardar en base de datos
            repositoryPersona.save(persona);

            // Recuperar el objeto Persona desde la base de datos
            Persona personaRecuperada = repositoryPersona.findById(persona.getId()).orElse(null);
            if (personaRecuperada != null) {
                System.out.println("------------------------------------------------");
                System.out.println("Nombre:   " + personaRecuperada.getNombre());
                System.out.println("Apellido: " + personaRecuperada.getApellido());
                System.out.println("Edad:     " + personaRecuperada.getEdad());
            }
        };
    }
}
