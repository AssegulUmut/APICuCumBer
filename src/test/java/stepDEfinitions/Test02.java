package stepDEfinitions;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Test02 {
    static RequestSpecification spec;

    @Test
    public void test01(){

        //api/opdList endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde
        // dönen status code'un 200 oldugu
        // ve response message bilgisinin "Success" oldugu dogrulanmali

        //https://www.heallifehospital.com
       String token="Wbg6prp8qsGoOjfnY5nerVhTikDGDv";


        spec=new RequestSpecBuilder().setBaseUri("http://www.heallifehospital.com").build();
        spec.pathParams("pp1","api","pp2","opdList");//parametreler olusturuldu
        String fullPath="/{pp1}/{pp2}";//parametre girisi icin kolay bir string olusturuldu



        Response response=given()
                .contentType(ContentType.JSON)//gonderdigim veriler Json formatında
                .spec(spec)//olusturdugum(sprc) base url ve paramereleri kullanacagim
                .headers(
                        "Authorization","Bearer "+token,//gerekli authorization bilgisi
                        "Content-Type",ContentType.JSON,//gonderdigim bilgiler Json formatinda
                        "Accept",ContentType.JSON//gelen cevap Json formatında
                )
                .when()
                //.body(reqBody.toString())//request icinde body varsa
                .log().all()
                .post(fullPath);
        System.out.println("^^^^^^^^^^^^^^^^^^RESPONSE^^^^^^^^^^^^^^^^^^^^^^");
        response.prettyPrint();


    }
}
