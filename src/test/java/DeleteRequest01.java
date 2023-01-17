import TestData.DummyTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import techproed.testBase.DummyRest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteRequest01 extends DummyRest {
    /*https://dummy.restapiexample.com/api/v1/delete/2 url e bir DELETE gönderderdiğimde,
     dönen kodun 200 ve response bodynin aşağıdaki gibi olduğunu test edin.
     {"status": "success",
     "data": "2",
     "message": "Successsfully! Record has been deleted"
     }
    */
@Test
    public void delete01(){
    spec.pathParams("first", "delete", "second", 2);
    DummyTestData obj=new DummyTestData();
    JSONObject expectedData=obj.setUpDeleteExpectedData();

    Response response=given().contentType(ContentType.JSON). spec(spec).
            auth().basic("admin", "password123").//delete da body göndermiyoruz.
            when().
            delete("/{first}/{second}");

    response.prettyPrint();
    //Matcher class ile
    response.
            then().
            assertThat().
            statusCode(200).
            body("status", equalTo(expectedData.getString("status")),
                    "data", equalTo(expectedData.getString("data")),
                    "message", equalTo(expectedData.getString("message")));
}

}
