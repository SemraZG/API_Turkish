package Pojo_Test_Base;

public class BookingPojo_class_pojo_post02 {
   /* {
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

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatesPojo_class_pojo_post02 bookingdates;//daha önce oluşturduğumuz pojo kalıbını data type olarak belirterek yeni pojonun içerisine koyduk.

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDatesPojo_class_pojo_post02 getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDatesPojo_class_pojo_post02 bookingdates) {
        this.bookingdates = bookingdates;
    }

    public BookingPojo_class_pojo_post02() {
    }

    public BookingPojo_class_pojo_post02(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDatesPojo_class_pojo_post02 bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
    }

    @Override
    public String toString() {
        return "BookingPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                '}';
    }
}
