package PostRequest;

import TestData.DummyTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import techproed.testBase.DummyRest;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post01 extends DummyRest {

    @Test
    public void post14(){
        spec.pathParam("first", "create");

        DummyTestData obj=new DummyTestData();

        //post request yaparken body göndermek zorundayız, testdata classında oluşturduğumuz request body i burada cağırıyoruz
       HashMap<String, String> requestBodyMap= obj.setupRequestBody();
       HashMap<String, Object> expectedDataMap=obj.setupExpecteddata();

        Response response= given().spec(spec).accept(ContentType.JSON).
                auth().basic("admin", "password123").//Aoutharizotion--> post işlemi veri tabanında değişiklik yaptiği için genelde şirketlerde Aoutharizotion gerekli olur.
                body(requestBodyMap).
                when().post("/{first}");

        response.prettyPrint();
        //post yaparken get yerine post yazıyorum ve body kısmını ekleyip bodynin içine hazırladığımız requestbodynin olduğu mapi yazıyoruz

        //De-Serilization
        HashMap<String, Object> actualData=response.as(HashMap.class);
        assertEquals(expectedDataMap.get("statusCode"), response.getStatusCode());
        assertEquals(expectedDataMap.get("status"), actualData.get("status"));

        //JsonPath

        JsonPath jsonPath=response.jsonPath();
        assertEquals(expectedDataMap.get("statusCode"), response.getStatusCode());
        assertEquals(expectedDataMap.get("status"), jsonPath.getString("status"));

    }

}
