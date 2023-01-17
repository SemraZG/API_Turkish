package PostRequest;

import TestData.HerOkuTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import techproed.testBase.HerOkuApp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post02 extends HerOkuApp {

  /*{
        "firstname": "Semra",
        "lastname": "Zengin",
        "totalprice": 537,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2016-09-01",
            "checkout": "2020-04-01"
        }
        */

@Test
    public void post02(){
    //https://restful-booker.herokuapp.com/booking
    //url i oluştur
    spec02.pathParam("first", "booking");

    //request body ve expected data aynı olduğu için tek bir JSONObject kullanılması yeterlidir.
    //request gönder
    HerOkuTestData obj=new HerOkuTestData();
    JSONObject expectedRequestData=obj.setUpTestAndRequestData();
    System.out.println(expectedRequestData);

    Response response=given().spec(spec02).contentType(ContentType.JSON).
            body(expectedRequestData.toString()).
            auth().basic("admin", "password123").
            when().
            post("/{first}");
    //response.prettyPrint();

    //Do Assertion
    //De-Serilization yöntemi
    HashMap<String, Object> actulaDataMap=response.as(HashMap.class);
    System.out.println(actulaDataMap);
    //{booking={firstname=Semra, lastname=Zengin, totalprice=537, depositpaid=true, bookingdates={checkin=2016-09-01, checkout=2020-04-01}}, bookingid=807}

    assertEquals(expectedRequestData.get("firstname"), ((Map)actulaDataMap.get("booking")).get("firstname"));
    assertEquals(expectedRequestData.get("lastname"), ((Map<?, ?>) actulaDataMap.get("booking")).get("lastname"));
    assertEquals(expectedRequestData.get("totalprice"), ((Map<?, ?>) actulaDataMap.get("booking")).get("totalprice"));
    assertEquals(expectedRequestData.get("depositpaid"), ((Map<?, ?>) actulaDataMap.get("booking")).get("depositpaid"));
    assertEquals(expectedRequestData.getJSONObject("bookingdates").get("checkin"),
            ((Map) ((Map<?, ?>) actulaDataMap.get("booking")).get("bookingdates")).get("checkin"));
    assertEquals(expectedRequestData.getJSONObject("bookingdates").get("checkout"),
            ((Map) ((Map<?, ?>) actulaDataMap.get("booking")).get("bookingdates")).get("checkout"));

    //JsonPath yöntemi
    JsonPath jsonPath=response.jsonPath();
    assertEquals(expectedRequestData.get("firstname"), jsonPath.getString("booking.firstname"));
    assertEquals(expectedRequestData.get("lastname"), jsonPath.getString("booking.lastname"));
    assertEquals(expectedRequestData.get("totalprice"), jsonPath.getInt("booking.totalprice"));
    assertEquals(expectedRequestData.get("depositpaid"), jsonPath.getBoolean("booking.depositpaid"));
    assertEquals(expectedRequestData.getJSONObject("bookingdates").get("checkin"), jsonPath.getString("booking.bookingdates.checkin"));
    assertEquals(expectedRequestData.getJSONObject("bookingdates").get("checkout"), jsonPath.getString("booking.bookingdates.checkout"));

}
}
