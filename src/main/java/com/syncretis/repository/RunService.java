package com.syncretis.repository;

import com.syncretis.SpringHibernateApplication;
import com.syncretis.entity.Department;
import com.syncretis.entity.Document;
import com.syncretis.entity.Language;
import com.syncretis.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RunService {

    private final Logger log = LoggerFactory.getLogger(SpringHibernateApplication.class);
    private final DepartmentRepository departmentRepository;
    private final PersonRepository personRepository;
    private final LanguageRepository languageRepository;
    private final DocumentRepository documentRepository;

    public RunService(DepartmentRepository departmentRepository, PersonRepository personRepository,
                      LanguageRepository languageRepository, DocumentRepository documentRepository) {
        this.departmentRepository = departmentRepository;
        this.personRepository = personRepository;
        this.languageRepository = languageRepository;
        this.documentRepository = documentRepository;
    }

    public void run() {
        departmentRepository.save(new Department("Developers department"));
        departmentRepository.save(new Department("Artists department"));
        departmentRepository.save(new Department("HR department"));

        languageRepository.save(new Language("English"));
        languageRepository.save(new Language("Russian"));
        languageRepository.save(new Language("German"));

        documentRepository.save(new Document(LocalDate.of(2021, 12, 31)));
        documentRepository.save(new Document(LocalDate.of(2022, 2, 1)));
        documentRepository.save(new Document(LocalDate.of(2021, 9, 21)));
        documentRepository.save(new Document(LocalDate.of(2022, 12, 31)));
        documentRepository.save(new Document(LocalDate.of(2021, 9, 30)));

        List<Document> documents = (List<Document>) documentRepository.findAll();
        List<Department> departments = (List<Department>) departmentRepository.findAll();

        personRepository.save(new Person("Amir", "Kadyrov", LocalDate.of(1997, 6, 9), departments.get(0), documents.get(0)));
        personRepository.save(new Person("Anastasia", "Grichenko", LocalDate.of(1993, 1, 19), departments.get(1), documents.get(1)));
        personRepository.save(new Person("Sergey", "Le", LocalDate.of(1997, 5, 30), departments.get(2), documents.get(2)));
        personRepository.save(new Person("Azamat", "Abuov", LocalDate.of(1997, 12, 22), departments.get(1), documents.get(4)));
        personRepository.save(new Person("Dmitrii", "Evseev", LocalDate.of(1998, 11, 9), departments.get(0), documents.get(5)));

//        Department department1 = departmentRepository.findById(1);
//        log.info(department1.toString());

//        Person person1 = personRepository.findById(2);
//        log.info(person1.toString());

//        Language language1 = languageRepository.findById(3);
//        log.info(language1.toString());

//        List<Language> languageList = new ArrayList<>();
//        languageList.add(languageRepository.findById(1));
//        languageList.add(languageRepository.findById(2));
//        person1.setLanguageList(languageList);
//        personRepository.save(person1);

//        List<Language> languageList1 = new ArrayList<>();
//        languageList1.add(languageRepository.findById(1));
//        languageList1.add(languageRepository.findById(3));
//        Person person2 = personRepository.findById(3);
//        person2.setLanguageList(languageList1);
//        personRepository.save(person2);

        log.info("----------------------------------------------------------");
//        log.info(personRepository.findById(2).getLanguageList().toString());
//        log.info(languageRepository.findByName("English").getPersonList().toString());
        log.info("----------------------------------------------------------");

//        Department department2 = departmentRepository.save(new Department(3, "Testing department"));
//        log.info(department2.toString());

//        log.info(departmentRepository.findById(3).getPersonList().toString());

//        Person person3 = personRepository.save(new Person(3, "Alexander", "Tatashin", LocalDate.of(1999, 1, 6), departments.get(2), documents.get(2)));
//        log.info(person3.toString());

//        departmentRepository.deleteById(3L);

//        personRepository.deleteById(3L);

//        documentRepository.save(new Document(LocalDate.of(2022, 12, 31)));
//        documentRepository.save(new Document(LocalDate.of(2022, 6, 1)));
//        documentRepository.save(new Document(LocalDate.of(2021, 9, 15)));

//        List<Person> personList1 = new ArrayList<>();
//        personList1.add(new Person("Maxim", "Rublev", LocalDate.of(1995, 9, 24), departmentRepository.findById(2), documents.get(3)));
//        personList1.add(new Person("Alexey", "Kolmakov", LocalDate.of(1994, 4, 15), departmentRepository.findById(1), documents.get(4)));
//        personList1.add(new Person("Olga", "Mazur", LocalDate.of(1997, 3, 27), departmentRepository.findById(2), documents.get(5)));
//        personRepository.saveAll(personList1);

//        documentRepository.deleteById("2c91948c7af06c63017af06c67d20000");

//        documentRepository.save(new Document(LocalDate.of(2023, 1, 1)));
//        documentRepository.save(new Document(LocalDate.of(2022, 9, 22)));
//        List<Person> personList2 = new ArrayList<>();
//        personList2.add(new Person(6, "Andrew", "Golovach", LocalDate.of(1997, 7, 13), departmentRepository.findById(1), documents.get(5)));
//        personList2.add(new Person(8, "Kazybek", "Gabdolla", LocalDate.of(1998, 2, 20), departmentRepository.findById(2), documents.get(6)));
//        personRepository.saveAll(personList2);

//        List<Person> personList3 = personRepository.findByIdBetween(7, 9);
//        personRepository.deleteAll(personList3);

//        for (Person person : personRepository.findAll()) {
//            log.info(person.toString());
//        }

//        log.info(personRepository.findById(1).getDocument().toString());
//        log.info(documentRepository.findById("2c91948c7af068b0017af068b4490000").getPerson().toString());

//        log.info(languageRepository.findAll().toString());
    }
}
