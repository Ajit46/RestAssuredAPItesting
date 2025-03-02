package com.thetestingacademy.tests.integration.sample;

import com.thetestingacademy.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCIntegration extends BaseTest {

    //Creata a Booking, Create a token
    //Get Booking
    //Update a Booking
    //Delete the Booking

    @Test(groups = "integration",priority = 1)
    @Owner("Ajit Singh")
    @Description("TC#INT1 - Step 1. Verify that the Booking can be created")
    public void testCreateBooking()
    {
        Assert.assertTrue(true);
    }
    @Test(groups = "integration",priority = 2)
    @Owner("Ajit Singh")
    @Description("TC#INT1 - Step 2. Verify the Booking by id")
    public void testVerifyBookingid()
    {
        Assert.assertTrue(true);
    }
    @Test(groups = "integration",priority = 3)
    @Owner("Ajit Singh")
    @Description("TC#INT1 - Step 3. Verify Updated Booking By id")
    public void testUpdateBookingByID()
    {
        Assert.assertTrue(true);
    }
    @Test(groups = "integration",priority = 4)
    @Owner("Ajit Singh")
    @Description("TC#INT1 - Step 4. Delete the booking By id")
    public void testDeleteBookingById()
    {
        Assert.assertTrue(true);
    }

}

