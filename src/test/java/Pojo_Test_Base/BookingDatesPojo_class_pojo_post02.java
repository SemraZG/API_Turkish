package Pojo_Test_Base;

public class BookingDatesPojo_class_pojo_post02 {
      /*
                {
            "checkin": "2016-09-01",
             "checkout": "2020-04-01"
        }

        */

    private  String checkin;
    private  String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public BookingDatesPojo_class_pojo_post02() {
    }

    public BookingDatesPojo_class_pojo_post02(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
