package at.htl.resource;

import at.htl.entities.Person;
import at.htl.repository.PersonRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.Instant;

@Path("/person")
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Person createPerson(
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("email") String email,
            @FormParam("telephoneNo") String telephoneNo
    ) {
        return personRepository.createPerson(new Person(firstName, lastName, email, telephoneNo, Instant.now()));
    }
}
