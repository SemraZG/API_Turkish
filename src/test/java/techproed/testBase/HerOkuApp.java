package techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuApp {
  protected RequestSpecification spec02;
  @Before
    public void Setup(){
      spec02=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
  }
}
