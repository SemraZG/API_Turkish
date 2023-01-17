package GetRequest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import techproed.testBase.DummyRest;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get10 extends DummyRest {
    @Test
    public void get10() {

        //https://dummy.restapiexample.com/api/v1/employees
        spec.pathParam("first", "employees");
        Response response = given().spec(spec).accept(ContentType.JSON).
                when().get("/{first}");

        JsonPath jsonPath = response.jsonPath();
        assertEquals(200, response.getStatusCode());

        //10dan büyük id leri ekrana yazdır ve 10dan büyük 14 id olduğunu assert etme
        List<Integer> idList = jsonPath.getList("data.findAll{it.id>10}.id");
        System.out.println(idList);
        assertEquals(14, idList.size());


        //30dan büyük yaşları ekrana yazdırma
        List<Integer> ages = jsonPath.getList("data.findAll{it.employee_age>30}.employee_age");
        System.out.println(ages);

        //30dan büyük 16 yaş olduğunu assert etme
        assertEquals(16, ages.size());

        //En büyük yaşın 66 olduğunu assert etme
        Collections.sort(ages);
        assertEquals((Integer) 66, ages.get(ages.size() - 1));
        //veya
        assertEquals(66, (int) ages.get(ages.size() - 1));

        //Maaşı 350000den büyük olan çalışanları ekrana yazdır ve bunların içişnde "Charde Marshall" olduğunu assert etme
        List<String> nameOfSalary = jsonPath.
                getList("data.findAll{it.employee_salary>350000}.employee_name");
        System.out.println(nameOfSalary);
        assertTrue(nameOfSalary.contains("Charde Marshall"));
    }

}
