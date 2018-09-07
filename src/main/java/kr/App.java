package kr;

import kr.persistence.Person;
import kr.persistence.PersonRepository;
import kr.propbean.PropertyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@SpringBootApplication
@EnableTransactionManagement
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    @Transactional
    public CommandLineRunner execute(PersonRepository repository, PropertyBean pb) {
        return (args) -> {
            log.info("z app.properties se vzala hodnota " + pb.toString());

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

//    @Bean
//    @ConfigurationProperties(prefix="app.datasource")//spring boot vezme z application.properties vse co zacina na app.datasource a nasetuje to do Datasource bean
//    public DataSource dataSource() {
//        return new DriverManagerDataSource();
//    }
}
