package Pojo;

import Pojo_Test_Base.BookingDatesPojo_class_pojo_post02;
import Pojo_Test_Base.BookingPojo_class_pojo_post02;
import Pojo_Test_Base.BookingResponsePojo_class_pojo_post02;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import techproed.testBase.HerOkuApp;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Pojo_Post02 extends HerOkuApp {
/*

https://restful-booker.herokuapp.com/booking
      request body;
       {
       "firstname": "Semra",
                "lastname": "Sezgin",
                "totalprice": 537,
                "depositpaid": true,
                "bookingdates":
                {
                    "checkin": "2016-09-01",
                    "checkout": "2020-04-01"
        }
        }
        response body;
        {
            "booking" :12,
            "booking":
         {
       "firstname": "Semra",
                "lastname": "Sezgin",
                "totalprice": 537,
                "depositpaid": true,
                "bookingdates":
                {
                    "checkin": "2016-09-01",
                    "checkout": "2020-04-01"
        }
        }
 */


@Test
    public void post02(){

    spec02.pathParam("first", "booking");

    BookingDatesPojo_class_pojo_post02 bookingDates=
                        new BookingDatesPojo_class_pojo_post02("2016-09-01", "2020-04-01");
    BookingPojo_class_pojo_post02 bookingPojo=
                        new BookingPojo_class_pojo_post02("Semra", "Sezgin", 537, true, bookingDates);

    Response response=given().spec(spec02).contentType(ContentType.JSON).
            auth().basic("admin", "password123").
            body(bookingPojo).
            post("/{first}");

    response.prettyPrint();

    BookingResponsePojo_class_pojo_post02 actualData=response.as(BookingResponsePojo_class_pojo_post02.class);

    assertEquals(200, response.getStatusCode());
    assertEquals(bookingPojo.getFirstname(), actualData.getBooking().getFirstname());
    assertEquals(bookingPojo.getLastname(),actualData.getBooking().getLastname());
    assertEquals(bookingPojo.getTotalprice(), actualData.getBooking().getTotalprice());
assertEquals(bookingPojo.getBookingdates().getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
assertEquals(bookingPojo.getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());

}



}
