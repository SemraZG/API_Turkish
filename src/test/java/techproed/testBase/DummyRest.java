package techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRest {
    protected RequestSpecification spec;
    @Before
    public void Setup(){
        spec= new RequestSpecBuilder().
                setBaseUri("https://dummy.restapiexample.com/api/v1").build();
    }
}

