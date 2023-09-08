package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class heroBookingDatesPojo {
    //{
    //“checkin”:2021-06-01 ve
    // “checkout” :2021-06-10 ve “additionalneeds”in,“wi-fi” olduğunu test edin (edited)
    //   }

    private String checkin;
    private String checkout;


}
