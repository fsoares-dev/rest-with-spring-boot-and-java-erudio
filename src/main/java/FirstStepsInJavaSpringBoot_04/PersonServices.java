package FirstStepsInJavaSpringBoot_04;

import FirstStepsInJavaSpringBoot_04.controllers.PersonController;
import FirstStepsInJavaSpringBoot_04.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service //aqui ele fica disponivel para podermos fazer a injecao de dependencia dele em qualquer lugar
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonController.class.getName()); //aqui eu logo informações importantes para esta classe, sera explorado mais pra frente no curso

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        logger.info("Finding one Person!");

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Felipe");
        person.setLastName("Soares");
        person.setAddress("Blumenau - Santa Catarina - Brasil");
        person.setGender("Male");
        return person;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Address " + i);
        person.setGender("Gender " + i);
        return person;
    }

    public Person crate(Person person) {
        logger.info("Crating Person!");//o logger funciona basicamente como o console.log do JavaScript
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating Person!");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting Person!");
    }

}
