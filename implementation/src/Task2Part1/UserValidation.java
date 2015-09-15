package Task2Part1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ehelepola on 14/09/2015.
 */

public class UserValidation {

    @DataProvider
    public Object[][] UsersProvider() {
        return new Object[][] { { new String[] {"user1","sdfsdf@sa","sasd^*&sdfsd)()_)(","SFDSFSDcvxcv","54654654lkjlkj"} } };
    }

    @Test(dataProvider = "UsersProvider")
    public void ValidUsersTest(String[] Users) {

        WebDriver driver;

        WebDriverWait wait;
        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();

        driver.get("http://localhost:8080/hello");

        for (String temp : Users) {

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            driver.findElement(By.id("inputName")).clear();

            driver.findElement(By.id("inputName")).sendKeys(temp);

            driver.findElement(By.id("searchButton")).click();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            String element = driver.findElement(By.id("userFrom")).getText();
            System.out.println(element);
            if(element.equals(temp)){
                System.out.println("Test OK");
            }else{
                System.out.println("Test Fail");
            }
            Assert.assertEquals(temp,element );

            driver.findElement(By.id("submitAnother")).click();

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        driver.quit();

    }
}
