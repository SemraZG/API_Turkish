package GetRequest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import techproed.testBase.JsonPlaceHolder;

import java.util.HashMap;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;

public class Get11 extends JsonPlaceHolder {
//https://jsonplaceholder.typicode.com/todos/3
    @Test
    public void get11(){
      spec.pathParams("first", "todos","second", 3);
        //expected data oluşturma
        HashMap<String, Object> expectedData=new HashMap<String, Object>();
        expectedData.put("statusCode", 200);
        expectedData.put("userId", 1 );
        expectedData.put("title", "fugiat veniam minus");
        expectedData.put("completed", false);
        expectedData.put("Server", "cloudflare");
        System.out.println(expectedData);

        //Send the request and get the response
        Response response=given().spec(spec).accept(ContentType.JSON).
                when().get("/{first}/{second}");
        response.prettyPrint();
        //1.way-->Matcher Class ile assertion yapıyoruz
        /*response.
                then().
                assertThat().
                statusCode((Integer)expectedData.get("statusCode")).
                body("userId", equalTo(expectedData.get("userId")),
                        "title", equals(expectedData.get("title")),
                        "completed", equalTo(expectedData.get("completed")));
                        */


        //2.way JsonPath ile assert etme
        JsonPath jsonPath=response.jsonPath();
        /*
        JsonPath ile sadece body kısmını assert edebildiğimiz için,
        statuscode ve header kısmını yine Matcher class ile assert ediyoruz.
         */
        assertEquals(expectedData.get("statusCode"), response.statusCode());
        assertEquals(expectedData.get("Server"), response.getHeader("Server"));
        //Body kısmını jsonPsth ile assert ediyoruz.
        assertEquals(expectedData.get("userId"), jsonPath.getInt("userId"));
        assertEquals(expectedData.get("title"), jsonPath.getString("title"));
        assertEquals(expectedData.get("completed"), jsonPath.getBoolean("completed"));

        //3.way De-Serialization--> --object mapper, --pojo class ile birlikte map


    }

}
