package GetRequest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import techproed.testBase.DummyRest;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get09 extends DummyRest {
    @Test
    public void get09(){
       spec.pathParam("first", "employees");
        Response response=given().spec(spec).accept(ContentType.JSON).
                when().get("/{first}");
        response.prettyPrint();

        JsonPath jsonPath= response.jsonPath();
        Assert.assertEquals(200, response.getStatusCode());

        //ToplM 24 ÇALIŞANIN OLDUĞUNU ASSERT ETME
        System.out.println(jsonPath.getList("data.id").size());
        assertEquals(24, jsonPath.getList("data.id").size());
        //5. çalışanın ismini assert etme
        System.out.println(jsonPath.getString("data[4].employee_name"));
        assertEquals("Airi Satou", jsonPath.getString("data[4].employee_name"));
        //2. çalışanın maaaşının 170750 olduğunu assert etme
        assertEquals(170750, jsonPath.getInt("data[1].employee_salary"));

        //Çalışanlardan birinin "Yuri Berry" olduğunu assert etme
        assertTrue(response.asString().contains("Yuri Berry"));
        //veya
        assertTrue(jsonPath.getList("data.employee_name").contains("Yuri Berry"));


        //61,63 ve 66 yaşların olup olmadığını assert etme
        List<Integer> ages= new ArrayList<>();
        ages.add(61);
        ages.add(63);
        ages.add(66);
      assertTrue(jsonPath.getList("data.employee_age").containsAll(ages));

    }
}
