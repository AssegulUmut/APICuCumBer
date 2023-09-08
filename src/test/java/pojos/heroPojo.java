package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class heroPojo {
    /*
     "bookingid": 4979,
    "booking": {
    “firstname” : “Ahmet”,
  “lastname” : “Bulut”,
  “totalprice” : 500,
  “depositpaid” : false,
  “bookingdates” : {
                    “checkin” : “2021-06-01”,
                    “checkout” : “2021-06-10”
                    },
   “additionalneeds” : “wi-fi”
     */
    //pojo class olusturulurken amaç genel cevabı(response)

    private int bookingid;
    private heroBookingDatesPojo booking;
}
