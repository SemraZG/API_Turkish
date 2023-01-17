package techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class AutomationPractice {
    protected RequestSpecification spec;
    @Before
    public void SetUpAutomation(){
        spec=new RequestSpecBuilder().setBaseUri("https://automationexercise.com/api").build();
    }
}
