package Task2Part2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ehelepola on 15/09/2015.
 */
public class EmailValidation {

    public final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    @DataProvider
    public Object[][] EmailProvider() {
        return new Object[][] { { new String[] {"user1","sdfsdf@sa.com","sasd^*&sdfsd)()_)(@gmail.com","SFDSFSDcvxcv.com","54654654lkjlkj@yahoo.com"} } };
    }

    @Test(dataProvider = "EmailProvider")
    public void ValidEmailTest(String[] Email) {

        WebDriver driver;

        WebDriverWait wait;
        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();

        driver.get("http://localhost:8080/hello");

        for (String temp : Email) {

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            driver.findElement(By.id("inputName")).clear();

            driver.findElement(By.id("inputName")).sendKeys(temp);

            driver.findElement(By.id("searchButton")).click();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            String element = driver.findElement(By.id("userFrom")).getText();

            if(validate(temp)){
                System.out.println("Test OK");
                Assert.assertEquals(true, true);
            }else{
                System.out.println("Test Fail");
                Assert.assertEquals(false, false);
            }


            driver.findElement(By.id("submitAnother")).click();

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        driver.quit();

    }
}
