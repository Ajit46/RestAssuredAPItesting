package com.thetestingacademy.modules;

import com.google.gson.Gson;
import com.thetestingacademy.pojos.*;

public class PayloadManager {
    Gson gson;
    public String createPayloadBookingAsString()
    {
        Booking booking = new Booking();
        booking.setFirstname("Ajit");
        booking.setLastname("Singh");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2025-01-02");
        bookingdates.setCheckout("2025-02-02");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        gson = new Gson();
        String jsonPayload = gson.toJson(booking);
        return jsonPayload;
    }
    public String FullUpdatePayloadAsString(){
        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Singh");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2025-01-02");
        bookingdates.setCheckout("2025-02-02");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        gson = new Gson();
        String jsonPayload = gson.toJson(booking);
        return jsonPayload;
    }

    //for Deserialize
    public BookingResponse bookingResponseJava(String responseString){
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString,BookingResponse.class );
        return bookingResponse;
    }

    //tokenAuth
    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to "+jsonPayloadString);
        return jsonPayloadString;
    }

    //getting token
    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        //Response(JSON) -> Object TokenResponse
        //Deserialization
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();

    }
    //getting Response
    public Booking getResponseFromJSON(String getResponse){
        gson = new Gson();
        //Response(JSON) -> Object TokenResponse
        //Deserialization
        Booking booking = gson.fromJson(getResponse, Booking.class);
        return booking;

    }

}
