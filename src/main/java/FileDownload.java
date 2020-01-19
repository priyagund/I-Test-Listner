import com.bridgelabz.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class FileDownload extends Base {


    private static File folder;

    public static void download() {
        {
            folder =new File(UUID.randomUUID().toString());
            folder.mkdir();
            ChromeOptions options=new ChromeOptions();
            Map<String,Object> prefe=new HashMap<String,Object>();
            prefe.put("profile.default.content_setting.popup",0);
            prefe.put("download.default_directory",folder.getAbsolutePath());

            options.setExperimentalOption("prefe",prefe);
            DesiredCapabilities cap=DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY,options);
            driver=new ChromeDriver(options);
            driver.get("http://the-internet.herokuapp.com/download");

        }
    }

}
