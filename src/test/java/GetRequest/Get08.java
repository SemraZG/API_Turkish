package GetRequest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import techproed.testBase.DummyRest;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get08 extends DummyRest {
    @Test
    public void get08(){
        spec.pathParam("first", "employees");
        Response response=given().spec(spec).accept(ContentType.JSON).
                when().get("/{first}");
        response.prettyPrint();

        JsonPath jsonPath= response.jsonPath();
        //Bütün çalışanların ismini yazdırma
        System.out.println(jsonPath.getList("data.employee_name"));
        //3. kişinin ismini yazdırma
        System.out.println(jsonPath.getString("data[2].employee_name"));
        //ilk 5 kişinin ismini yazdırma
        System.out.println(jsonPath.getString("data.employee_name[0,1,2,3,4,5]"));
        //son kişinin ismini yazdırma
        System.out.println(jsonPath.getString("data.employee_name[-1]"));

        assertEquals(200, response.getStatusCode());

        //3.kişinin adını assert etme
        Assert.assertEquals("Ashton Cox", jsonPath.getString("data[2].employee_name"));
       assertEquals("Doris Wilder", jsonPath.getString("data.employee_name[-1]"));




    }

}
