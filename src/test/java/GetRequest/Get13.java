package GetRequest;

import TestData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Test;
import techproed.testBase.DummyRest;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get13 extends DummyRest {
@Test
    public void get13(){

    spec.pathParam("first", "employees");

    DummyTestData obj=new DummyTestData();
    HashMap<String, Object> expectedData= obj.setUp();
    System.out.println(expectedData);
//{arananyaşlar=[40, 21, 19], beşinciçalışan=Airi Satou, çalışansayısı=24, onbirinciçalışan={profile_image=,
// employee_name=Garrett Winters, employee_salary=170750, id=2, employee_age=63}, sondanikiciçalısanmaası=106450, statusCode=200}

    Response response= given().spec(spec).accept("application/json").
            when().get("/{first}");

    HashMap<String, Object> actualData= response.as(HashMap.class);
    System.out.println(actualData);

    assertEquals(expectedData.get("statusCode"), response.getStatusCode());
    assertEquals(expectedData.get("beşinciçalışan"),((Map) ((List)actualData.get("data")).get(4)).get("employee_name"));
    assertEquals(expectedData.get("çalışansayısı"), ((List) actualData.get("data")).size());
    //sondanikiciçalısanmaası bulmak için önce bize dönene datanın size nı bulmalıyız
    int datasize=((List<?>) actualData.get("data")).size();
    assertEquals(expectedData.get("sondanikiciçalısanmaası"), ((Map)((List)actualData.get("data")).get(datasize-2)).get("employee_salary"));

    List<Integer> actualarananyaslar=new ArrayList<>();
    for (int i=0; i<datasize; i++){
        actualarananyaslar.add((Integer) ((Map)((List<?>) actualData.get("data")).get(i)).get("employee_age"));
    }
    assertTrue(actualarananyaslar.containsAll((List) expectedData.get("arananyaşlar")));
    response.then().statusCode((Integer)expectedData.get("statusCode")).
            body("data[4].employee_name", equalTo(expectedData.get("beşinciçalışan")),
                    "data.id", hasSize((Integer)expectedData.get("çalışansayısı")),
                    "data[-2].employee_salary", equalTo(expectedData.get("sondanikiciçalısanmaası")),
                    "data.employee_age", hasItems(((List)expectedData.get("arananyaşlar")).get(0),((List)expectedData.get("arananyaşlar")).get(1),((List)expectedData.get("arananyaşlar")).get(2)),
                    "data[10].employee_name", equalTo(((Map)expectedData.get("onbirinciçalışan")).get("employee_name")));





}
}
