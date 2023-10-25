package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class RegisterPage {


    public static void main(String[] args) throws InterruptedException {

        By registerLocator = By.className("ico-register");

        By genderClickLocator = By.id("gender-female");
        By firstNameLocator = By.id("FirstName");
        By lastNameLocator = By.id("LastName");
        By emailLocator = By.id("Email");
        By passwordLocator = By.id("Password");
        By confirmPasswordLocator = By.id("ConfirmPassword");
        By registerButtonLocator = By.id("register-button");


      WebDriver driver = new ChromeDriver();
      SoftAssert softAssert = new SoftAssert();

      Thread.sleep(2000);

      driver.get("https://demowebshop.tricentis.com");

      WebElement register = driver.findElement(registerLocator);
      register.click();

      WebElement genderClick = driver.findElement(genderClickLocator);
      genderClick.click();

      WebElement firstName = driver.findElement(firstNameLocator);
      firstName.sendKeys("Branka");

      WebElement lastName = driver.findElement(lastNameLocator);
      lastName.sendKeys("Lazic");

      WebElement email = driver.findElement(emailLocator);
      email.sendKeys("branka.svoji@gmail.com");


      WebElement password = driver.findElement(passwordLocator);
      password.sendKeys("practice123");

      WebElement confirmPassword = driver.findElement(confirmPasswordLocator);
      confirmPassword.sendKeys("practice123");

      WebElement registerButton = driver.findElement(registerButtonLocator);
      registerButton.click();


      String expectedText = "Your registration completed";
      String expectedLogout = "Log out";


      WebElement actualText = driver.findElement(By.className("result"));
      String actualTextConfirm = actualText.getText();

      WebElement actualLogout = driver.findElement(By.className("ico-logout"));
      String actualLogoutConfirm = actualLogout.getText();



      softAssert.assertEquals(expectedText,actualTextConfirm);
      softAssert.assertEquals(actualLogoutConfirm, expectedLogout);
      softAssert.assertAll();

      driver.quit();







    }






}
