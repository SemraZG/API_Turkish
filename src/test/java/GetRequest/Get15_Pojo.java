package GetRequest;

import Pojo_Test_Base.Get15_pojo_Data;
import Pojo_Test_Base.Get15_pojo_expected;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Data;
import pojos.DummyPojo;
import techproed.testBase.DummyRest;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get15_Pojo extends DummyRest {
/*
"https://dummy.restapiexample.com/api/v1/employee/1"
 {
       "status": "success",
                "data": {
                "id": 1,
                "employee_name": "Semra Semra",
                "employee_salary": 560522,
                "employee_age": 29,
                "profile_image" :""
                },
                "message":"Successfully! Record has been fetched."
                }

 */


    @Test
    public void test(){
        spec.pathParams("first", "employee", "second", 1);

        Get15_pojo_Data data=new Get15_pojo_Data(1,"Semra Semra", 560522, 29, "");
        Get15_pojo_expected expectedData=new Get15_pojo_expected("success", data, "Successfully! Record has been fetched.");

        Response response=given().contentType(ContentType.JSON).spec(spec).
                when().get("/{first}/{second}");

        Get15_pojo_expected actualData=response.as(Get15_pojo_expected.class);

        /*
        assertEquals(200, response.getStatusCode());

        assertEquals(expectedData.getStatus(), actualData.getStatus());
        assertEquals(expectedData.getMessage(), actualData.getMessage());
        assertEquals(expectedData.getData().getEmployeeAge(), actualData.getData().getEmployeeAge());
        assertEquals(expectedData.getData().getEmployeeName(), actualData.getData().getEmployeeName());
        assertEquals(expectedData.getData().getId(), actualData.getData().getId());
        assertEquals(expectedData.getData().getEmployeeSalary(), actualData.getData().getEmployeeSalary());
        assertEquals(expectedData.getData().getProfileImage(), actualData.getData().getProfileImage());
  */
    }
}
