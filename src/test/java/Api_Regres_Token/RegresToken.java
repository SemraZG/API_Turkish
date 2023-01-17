package Api_Regres_Token;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RegresToken {

    public String tokenAl(){

        String url="https://regres.in/api/login";

        HashMap<String, String> requestBody=new HashMap<String, String>();
        requestBody.put("email", "eve.holt@regres.in");
        requestBody.put("password", "cityslicka");

        Response response=given().contentType(ContentType.JSON).
                        body(requestBody). //auth().basic("admin", "password123")
                        when().post(url);

        //response.prettyPrint();
        JsonPath json=response.jsonPath();
        String token= json.getString("token");
        System.out.println(token);
        return token;


    }




}
