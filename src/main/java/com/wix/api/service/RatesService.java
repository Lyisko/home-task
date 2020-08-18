package com.wix.api.service;

import com.wix.api.models.Rate;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class RatesService {

    private static final Logger logger = LoggerFactory.getLogger(RatesService.class);
    private static final double DEFAULT_HRYVNIA_RATE = 25.50;

    private static Rate[] fetchRateFromNBU() {
        logger.info("fetch NBU rates");
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();

        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri("https://bank.gov.ua/NBUStatService/v1/")
                .build();
        return given()
                .spec(spec)
                .when()
                .log().all()
                .get(String.format("statdirectory/exchange?valcode=USD&date=%s&json", dateFormat.format(date)))
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().all()
                .extract().body().as(Rate[].class);
    }

    public static double getTodayHryvniaUSDRate(){
        try {
            Rate[] rates = fetchRateFromNBU();
            if (rates.length == 1 && "USD".equals(rates[0].cc)){
                logger.info("NBU rate = " + rates[0].rate);
                return rates[0].rate;
            } else {
                throw new AssertionError();
            }
        } catch (AssertionError | IndexOutOfBoundsException e){
            logger.warn("NBU rates fetched unsuccessfully. Default rate is used.");
        }
        return DEFAULT_HRYVNIA_RATE;
    }
}
