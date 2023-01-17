package Pojo_Test_Base;

public class BookingResponsePojo_class_pojo_post02 {
   /*
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
        "booking" :11,
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
    private int bookingid;
    private BookingPojo_class_pojo_post02 booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo_class_pojo_post02 getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo_class_pojo_post02 booking) {
        this.booking = booking;
    }

    public BookingResponsePojo_class_pojo_post02() {
    }

    public BookingResponsePojo_class_pojo_post02(int bookingid, BookingPojo_class_pojo_post02 booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }


}
