package com.bridgelabz.script;

import com.bridgelabz.base.Base;
import com.bridgelabz.base.Listner;
import jdk.internal.net.http.ResponseBodyHandlers;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

@Listeners(Listner.class)
public class ScreenShortTest extends Base {

    private File folder;


    @BeforeMethod
   public void setUp(){
       initialization();
   }



    @Test
    public void navigationOfBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

     @Test
      public  void fileUpload () throws InterruptedException {
        driver.get("https://www.monsterindia.com/seeker/registration?spl=IN-Acq-SEM-Google-Core_Brand_Old_Exact_Web_S-GSN-Core_Brand_Old-monster-desktop-Brand-CPC-6645446156&utm_campaign=IN_Acq_SEM-Google-Core_Brand_Old_Exact_Web_S-GSN-Core_Brand_Old-monster&utm_medium=SEM&utm_source=Google-GSN-CPC&utm_term=SEM_monster&gclid=Cj0KCQiA9orxBRD0ARIsAK9JDxTmroS4GjL_URZfsDJzhwLfsXdJWiuxkKvLM74uPXpuQ1F8JfeuWvgaAjl2EALw_wcB");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS)  ;
        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("//home//user//Desktop//priyanka gund.cv.pdf");
        String expectedvalue=    driver.findElement(By.xpath("//input[@id='file-upload']")).getAttribute("value");
        if(expectedvalue.equalsIgnoreCase("employee db file upload"));
        Thread.sleep(3000);
        System.out.println("File Uploaded successfully");

    }


  @Test
    public void downloadFile() throws InterruptedException {
     driver.get("http://demo.automationtesting.in/Register.html");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
     driver.findElement(By.xpath("//a[@class='dropdown-toggle' and @href='#']")).click();
     Thread.sleep(4000);
      driver.findElement(By.xpath("//a[@href='FileDownload.html']")  ).click();
      driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
    }

    @AfterMethod
    public  void tearDown(){
        driver.close();
    }


}
