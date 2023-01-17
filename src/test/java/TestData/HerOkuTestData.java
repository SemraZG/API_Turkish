package TestData;

import org.json.JSONObject;

import java.util.HashMap;

public class HerOkuTestData {

    public HashMap<String, Object> setUpTestData(){
        HashMap<String, Object> bookingdates=new HashMap<String, Object>();
        bookingdates.put("checkin", "2016-09-01");
        bookingdates.put("checkout", "2020-04-01");

        HashMap<String, Object> expectedData= new HashMap<String, Object>();
        expectedData.put("firstname", "Susan");
        expectedData.put("lastname", "Jackson");
        expectedData.put("depositpaid", true);
        expectedData.put("totalprice", 537);
        expectedData.put( "bookingdates", bookingdates);
        expectedData.put("additionalneeds", "Breakfast");

        return expectedData;
    }

    public JSONObject setUpTestAndRequestData(){
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin", "2016-09-01");
        bookingdates.put("checkout", "2020-04-01");

        JSONObject expectedRequest=new JSONObject();
        expectedRequest.put("firstname" ,"Semra");
        expectedRequest.put("lastname", "Zengin");
        expectedRequest.put("totalprice", 537);
        expectedRequest.put("depositpaid",true);
        expectedRequest.put("bookingdates", bookingdates);
        return expectedRequest;
    }






    /*
            "firstname": "Susan",
            "lastname": "Jackson",
            "totalprice": 537,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2016-09-01",
                "checkout": "2020-04-01"
            "additionalneeds": "Breakfast"
              */

}
