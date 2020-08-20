package org.xtron;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class BeanValidationResourceTest {

    @Test
    public void testBeanValidation() {
        given()
          .when().get("/test-jpa-validation")
          .then()
             .statusCode(500)
             .body(containsString("javax.validation.ConstraintViolationException"));
    }

}