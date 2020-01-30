package com.bridgelabz.script;

import com.bridgelabz.base.Base;
import com.twilio.Twilio;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OTPHandlerTest extends Base {

    public static final String ACCOUNT_SID="AC3411923ede32679386958e9cfb740218";
    public static final String AUTH_TOKEN="58f13e83f7716ce77958edbb1e4964f3";

    @BeforeTest
    public void setUp(){
        initializartion();
    }

    @Test
    public void OTPnumberHandler() {
        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//span[contains(text(),'Hello. Sign in')]")).click();
        driver.findElement(By.linkText("Start here.")).click();
        driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("priyanka");
        driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
        driver.findElement(By.xpath("//a[@id='auth-country-picker_212']")).click();
        driver.findElement(By.id("ap_phone_number")).sendKeys("6265872205");
        driver.findElement(By.id("ap_password")).sendKeys("123456789priya");
        driver.findElement(By.id("continue")).click();

        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        String smsBody=getMessage();
        System.out.println(smsBody);
        String otpNumber= smsBody.replaceAll("[^-0-9]"," ");
        System.out.println(otpNumber);
        driver.findElement(By.xpath("//input[@id='auth-pv-enter-code']")).sendKeys("628084");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
