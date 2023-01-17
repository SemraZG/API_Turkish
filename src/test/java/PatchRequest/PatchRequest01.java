package PatchRequest;

import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import techproed.testBase.JsonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class PatchRequest01 extends JsonPlaceHolder {
    //https://jsonplaceholder.typicode.com/todos/198

        /*
        https://jsonplaceholder.typicode.com/todos/198 url ine aşağıdaki body gönderildiğinde,
        {
        "title" : "API çalışmalıyım"
        }
        dönen response body nin status codunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin.
        {
        "userId" :10,
        "title" :"API çalışmalıyım",
        "completed": true,
        "id": 198
        }
         */

    @Test
    public void patch01(){
        //url oluştur
        spec.pathParams("first", "todos", "second", 198);
        //expected ve request datayı oluştur
        JsonPlaceHolderTestData obj= new JsonPlaceHolderTestData();
        JSONObject requestData=obj.setUpPatchRequestBody();
        JSONObject expectedData=obj.setUpPatchExpectedData();
        //request gönder
        Response response=given().accept("application/json").spec(spec).
                auth().basic("admin", "password123").
                body(requestData.toString()).
                when().patch("/{first}/{second}");

        response.prettyPrint();
        //De-serilization
        HashMap<String, Object> actualData=response.as(HashMap.class);
        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.getInt("userId"), actualData.get("userId"));
        assertEquals(expectedData.getInt("id"), actualData.get("id"));
        assertEquals(expectedData.getString("title"), actualData.get("title"));
        assertEquals(expectedData.getBoolean("completed"), actualData.get("completed"));


    }






}
