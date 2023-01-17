package PostRequest;

import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.json.JSONObject;
import org.junit.Test;
import techproed.testBase.JsonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Post03 extends JsonPlaceHolder {
    //https://jsonplaceholder.typicode.com/todos
    /*
    }
    "userId":55,
    "title":"Tidy your room",
    "completed": false
    }
    yukarıdaki body gönderildiğinde status kodun 201 ve response body nin aşağıdaki gibi olduğunu test edin.
      }
    "userId":55,
    "title":"Tidy your room",
    "completed": false,
    "id":-
    }
     */
    @Test
    public void post03(){

        spec.pathParam("first", "todos");

        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
        JSONObject expectedData=obj.setUpRequestAndExpected();

        Response response=given().spec(spec).contentType(ContentType.JSON).
                body(expectedData.toString()).
                auth().basic("admin", "password1233").
                when().
                post("/{first}");

        response.prettyPrint();

        //Matcher Class yöntemi
        response.then().assertThat().
                statusCode((Integer) expectedData.getInt("statusCode")).
                body("completed", equalTo(expectedData.getBoolean("completed")),
                        "title", equalTo(expectedData.getString("title")),
                        "userId", equalTo(expectedData.getInt("userId")));

        //JsonPath yöntemi ile
        JsonPath jsonPath=response.jsonPath();//actual datayı burda jsonnın içine attık.
        assertEquals(expectedData.getInt("statusCode"), response.getStatusCode());
        assertEquals(expectedData.getInt("userId"), jsonPath.getInt("userId"));
        assertEquals(expectedData.get("title"), jsonPath.getString("title"));
        assertEquals(expectedData.getBoolean("completed"), jsonPath.getBoolean("completed"));

        //De-Serilization yöntemi ile
        HashMap<String, Object> actualData=response.as(HashMap.class);
        assertEquals(expectedData.getInt("statusCode"), response.getStatusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));


    }
}
