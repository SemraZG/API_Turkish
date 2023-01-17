package GetRequest;

import TestData.HerOkuTestData;
import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import techproed.testBase.HerOkuApp;

import java.awt.geom.RectangularShape;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get12 extends HerOkuApp {
    @Test
    public void get12(){
        //https://restful-booker.herokuapp.com/booking/2
        spec02.pathParams("first", "booking", "second", 2);

        //expected datayı oluşturma
        HerOkuTestData obj=new HerOkuTestData();
        HashMap<String, Object> expectedData= obj.setUpTestData();
        System.out.println(expectedData);//{firstname=Susan, bookingdates={checkin=2016-09-01, checkout=2020-04-01}, totalprice=537, depositpaid=true, lastname=Jackson}

        //request gönderme
        Response response= given().spec(spec02).accept("application/json").
                           when().get("/{first}/{second}");
        response.prettyPrint();
        /*      "firstname": "Susan",
                "lastname": "Jackson",
                "totalprice": 537,
                "depositpaid": true,
                "bookingdates":
                {
            "checkin": "2016-09-01",
                    "checkout": "2020-04-01"
        },
                "additionalneeds": "Breakfast"
    }*/

        //1.way-->De-Serilization
        HashMap<String, Object> actualData= response.as(HashMap.class);//responsedan gelen datayı bir map in içine attık ve actual datayı almış olduk.
        System.out.println(actualData);//{firstname=Susan, additionalneeds=Breakfast, bookingdates={checkin=2016-09-01, checkout=2020-04-01}, totalprice=537, depositpaid=true, lastname=Jackson}

        assertEquals(200, response.statusCode());

        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get( "depositpaid"), actualData.get( "depositpaid"));
        assertEquals(expectedData.get( "additionalneeds"), actualData.get( "additionalneeds"));

        assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"), ((Map)actualData.get("bookindates")).get("checkin"));
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"), ((Map)actualData.get("bookindates")).get("checkout"));


    //2.way JsonPath
        JsonPath jsonPath= response.jsonPath();
        assertEquals(expectedData.get("firstname"), jsonPath.getString("firstname"));
        assertEquals(expectedData.get("lastname"), jsonPath.getString("lastname"));
        assertEquals(expectedData.get("totalprice"), jsonPath.getInt("totalprice"));

        assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"), jsonPath.getString("bookingdates.checkin"));
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"), jsonPath.getString("bookingdates.checkout"));



    }
}
