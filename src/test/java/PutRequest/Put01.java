package PutRequest;

import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import techproed.testBase.JsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Put01 extends JsonPlaceHolder {
    @Test
    public void put01(){

/*
{
    "userId": 10,
    "title": "vero rerum temporibus dolor",
    "completed": true,
    "id": 198
}
 */

        spec.pathParams("first", "todos", "second", 198);

        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
        JSONObject expectedRequest=obj.setUpPut();
        System.out.println(expectedRequest);//{"completed":true,"title":"vero rerum temporibus dolor","userId":10}

        Response response=given().spec(spec).contentType(ContentType.JSON).
                auth().basic("admin", "password123").
                body(expectedRequest.toString()).
                when().put("/{first}/{second}");

        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();
        assertEquals(200, response.getStatusCode());
        assertEquals(expectedRequest.get("userId"), jsonPath.getInt("userId"));
        assertEquals(expectedRequest.get("title"), jsonPath.getString("title"));
        assertEquals(expectedRequest.get("completed"), jsonPath.getBoolean("completed"));

    }
}
