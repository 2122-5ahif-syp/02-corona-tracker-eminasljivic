package at.htl.repository;

import at.htl.entities.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    @Transactional
    public Person createPerson(Person person){
        return getEntityManager().merge(person);
    }
}
