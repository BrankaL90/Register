package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LoginPage {

    public static void main(String[] args) {

        By emailLocator = By.id("Email");
        By passwordLocator = By.id("Password");
        By rememberMeLocator = By.id("RememberMe");
        By loginButton = By.className("login-button");

        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();


        driver.get("https://demowebshop.tricentis.com");

        WebElement div = driver.findElement(By.className("header-links"));
        WebElement ul = div.findElement(By.tagName("ul"));
        List<WebElement> liElements = div.findElements(By.tagName("li"));
        liElements.get(1).click();


        WebElement email = driver.findElement(emailLocator);
        email.sendKeys("branka.svojic90@gmail.com");

        WebElement password = driver.findElement(passwordLocator);
        password.sendKeys("practice123");

        WebElement click = driver.findElement(rememberMeLocator);
        click.click();

        WebElement loginB = driver.findElement(loginButton);
        loginB.click();

        String expectedLogout = "Log out";
        String expected = "branka.svoji90@gmail.com";

        WebElement actualLogout = driver.findElement(By.className("ico-logout"));
        String actualLogoutConfirm = actualLogout.getText();

        WebElement account = driver.findElement(By.className("account"));
        String accountActual = account.getText();

        softAssert.assertEquals(expectedLogout, actualLogoutConfirm);
        softAssert.assertEquals(expected, accountActual);

        driver.quit();



    }
}
