package org.xtron;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test-jpa-validation")
public class BeanValidationResource {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String hello() {
        em.persist(new TestEntity());
        return "test ok";
    }
}