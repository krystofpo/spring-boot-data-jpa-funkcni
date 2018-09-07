package kr;

import kr.persistence.Person;
import kr.persistence.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner execute(PersonRepository repository) {
        return (args) -> {
            repository.save(new Person("Jack"));
            repository.save(new Person("Chloe"));

            // fetch all persons
            log.info("Persons found with findAll():");
            log.info("-------------------------------");
            for (Person person : repository.findAll()) {
                log.info(person.toString());
            }
            log.info("");

            // fetch an individual person by ID
            repository.findById(1L)
                    .ifPresent(person -> {
                        log.info("Person found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(person.toString());
                        log.info("");
                    });
        };
    }
}
