import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test extends BaseTest {
    public void loginbeforetests(){

    }
    WebDriver driver = new ChromeDriver();
    String mailRandom = "mbilici" + createRandomNumber(5) + "@gmail.com";
    public test openPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver.get("http://demo.borland.com/InsuranceWebExtJS/");
        driver.manage().window().maximize();
        return this;
    }
    public String createRandomNumber(int length) {
        Random r = new Random();
        List<Integer> digits = new ArrayList<Integer>();
        String number = "";

        for (int i = 0; i < length - 1; i++) {
            digits.add(i);
        }

        for (int i = length - 1; i > 0; i--) {
            int randomDigit = r.nextInt(i);
            number += digits.get(randomDigit);
            digits.remove(randomDigit);
        }

        number = "1" + number;

        return number;
    }


    public test signUp() {
        driver.findElement(By.id("login-form:signup")).click();
        driver.findElement(By.id("signup:fname")).sendKeys("Mertcan");
        driver.findElement(By.id("signup:lname")).sendKeys("Bilici");
        driver.findElement(By.id("BirthDate")).sendKeys("18.08.08");
        driver.findElement(By.id("signup:email")).sendKeys(mailRandom);
        driver.findElement(By.id("signup:street")).sendKeys("asfdsa");
        driver.findElement(By.id("signup:city")).sendKeys("asfdsa");
        driver.findElement(By.id("signup:state")).sendKeys("Texas");
        driver.findElement(By.id("signup:zip")).sendKeys("4314");
        driver.findElement(By.id("signup:password")).sendKeys("qwe");
        driver.findElement(By.id("signup:signup")).click();
        driver.findElement(By.id("home")).click();
        driver.findElement(By.id("logout-form:logout")).click();
        driver.findElement(By.id("login-form:email")).sendKeys(mailRandom);
        driver.findElement(By.id("login-form:password")).sendKeys("qwe");
        driver.findElement(By.id("login-form:login")).click();
        return this;
    }



    @Test(enabled = true, description = "TS0001 ghgh")
    public void TS0001() throws InterruptedException{

        openPage();
        signUp();
        }

}






