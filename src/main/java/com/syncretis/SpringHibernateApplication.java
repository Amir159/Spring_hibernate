package com.syncretis;

import com.syncretis.entity.Department;
import com.syncretis.entity.Person;
import com.syncretis.repository.DepartmentRepository;
import com.syncretis.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.zip.DataFormatException;

@SpringBootApplication
public class SpringHibernateApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringHibernateApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(DepartmentRepository departmentRepository, PersonRepository personRepository) {
        return (args) -> {
            departmentRepository.save(new Department("Developers department"));
            departmentRepository.save(new Department("Artists department"));
            departmentRepository.save(new Department("HR department"));

            personRepository.save(new Person("Amir", "Kadyrov", LocalDate.of(1997, 6, 9), departmentRepository.findById(1)));
            personRepository.save(new Person("Anastasia", "Grichenko", LocalDate.of(1993, 1, 19), departmentRepository.findById(2)));
            personRepository.save(new Person("Sergey", "Le", LocalDate.of(1997, 5, 30), departmentRepository.findById(2)));
            personRepository.save(new Person("Azamat", "Abuov", LocalDate.of(1997, 12, 22), departmentRepository.findById(3)));
            personRepository.save(new Person("Dmitrii", "Evseev", LocalDate.of(1998, 11, 9), departmentRepository.findById(1)));

            Department department1 = departmentRepository.findById(1);
            log.info(department1.toString());

            Person person1 = personRepository.findById(2);
            log.info(person1.toString());

            Department department2 = departmentRepository.save(new Department(3, "Testing department"));
            log.info(department2.toString());

            Person person2 = personRepository.save(new Person(4,"Alexander", "Tatashin", LocalDate.of(1999, 1, 6), department2));
            log.info(person2.toString());

            departmentRepository.deleteById(1L);
            personRepository.deleteById(3L);
        };
    }
}
