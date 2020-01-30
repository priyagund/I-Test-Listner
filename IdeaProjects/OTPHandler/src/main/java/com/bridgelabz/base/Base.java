package com.bridgelabz.base;

import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Base {

    public static WebDriver driver;
    public static final String ACCOUNT_SID="AC3411923ede32679386958e9cfb740218";

    public void initializartion(){
        {
            System.setProperty("webdriver.gecko.driver", "/home/user/IdeaProjects/ListnerScreenShort/Driver/geckodriver");
            driver = new FirefoxDriver();
        }
    }

    public static String getMessage(){
        return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND)==0)
                .filter( m -> m.getTo().equals("+16265872205")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private static Stream<Message> getMessages(){
        ResourceSet<Message> messages= Message.reader(ACCOUNT_SID).read();
        return StreamSupport.stream(messages.spliterator(),false);
    }
}
