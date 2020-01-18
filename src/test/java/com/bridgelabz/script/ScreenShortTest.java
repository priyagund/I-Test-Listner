package com.bridgelabz.script;

import com.bridgelabz.base.Base;
import com.bridgelabz.base.Listner;
import org.testng.annotations.*;

@Listeners(Listner.class)
public class ScreenShortTest extends Base {

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

    @AfterMethod
    public  void tearDown(){
        driver.close();
    }


}
