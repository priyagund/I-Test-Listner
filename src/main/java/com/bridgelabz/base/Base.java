package com.bridgelabz.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

import java.util.Date;

public class Base  {

  public static WebDriver driver;

    public void initialization()
    {
    System.setProperty("webdriver.gecko.driver", "/home/user/IdeaProjects/ListnerScreenShort/Driver/geckodriver");
    driver=new FirefoxDriver();
    driver.get("https://www.google.com");
    }


    public void screenShort(WebDriver driver)
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        System.out.println("Driver:" + driver);

        File src = ts.getScreenshotAs(OutputType.FILE);
        Date date=new Date();
        File dest = new File("/home/user/IdeaProjects/ListnerScreenShort/Screenshort" + date.toString() + ".png");
        //File dest1=new File("/home/user/IdeaProjects/ListnerScreenShort/Screenshort"+".png");
        try
        {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

