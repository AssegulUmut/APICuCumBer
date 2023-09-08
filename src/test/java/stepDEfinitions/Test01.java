package stepDEfinitions;

import com.google.gson.JsonObject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Test01 {
    static RequestSpecification spec;
    public static void main(String[] args) {

         /*
https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip bir POST
request gonderdigimizde
{
  “firstname” : “Ahmet”,
  “lastname” : “Bulut”,
  “totalprice” : 500,
  “depositpaid” : false,
  “bookingdates” : {
                    “checkin” : “2021-06-01”,
                    “checkout” : “2021-06-10”
                    },
   “additionalneeds” : “wi-fi”
}
            donen Response’un,
            status code’unun 200,
            ve content type’inin application-json, ve response body’sindeki
            “firstname”in,“Ahmet”, ve “lastname”in, “Bulut”,
            ve “totalprice”in,500,
            ve “depositpaid”in,false,
            ve “checkin” tarihinin 2021-06-01 ve “checkout” tarihinin 2021-06-10 ve “additionalneeds”in,“wi-fi” olduğunu test edin (edited)
     */
        //Anasayfa olusturuldu
        spec=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

        spec.pathParams("pp1","booking");//parametreler olusturuldu

        String fullPath="/{pp1}";//parametre girisi icin kolay bir string olusturuldu


        JSONObject innerBody=new JSONObject();//kücük objemiz
        innerBody.put("checkin" , "2021-06-01");
        innerBody.put("checkout" , "2021-06-10");

        JSONObject reqBody=new JSONObject();//ana request body olusturuldu
        reqBody.put("firstname","Ahmet");
        reqBody.put("lastname","Bulut");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerBody);
        reqBody.put("additionalneeds","wi-fi");



        Response response=given()
                .contentType(ContentType.JSON)//gonderdigim veriler Json formatında
                .spec(spec)//olusturdugum(sprc) base url ve paramereleri kullanacagim
                .headers(
                        "Content-Type",ContentType.JSON,//gonderdigim bilgiler Json formatinda
                        "Accept",ContentType.JSON//gelen cevap Json formatında
                )
                .when()
                .body(reqBody.toString())//request icinde body varsa
                .log().all()
                .post(fullPath);
        System.out.println("^^^^^^^^^^^^^^^^^^RESPONSE^^^^^^^^^^^^^^^^^^^^^^");
        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("booking.firstname",equalTo("Ahmet"))
                .body("booking.lastname",equalTo("Bulut"))
                .body("booking.totalprice",equalTo(500))
                .body("booking.depositpaid",equalTo(false))
                .body("booking.bookingdates.checkin",equalTo("2021-06-01"))
                .body("booking.bookingdates.checkout",equalTo("2021-06-10"))
                .body("booking.additionalneeds",equalTo("wi-fi"));







    }
}
