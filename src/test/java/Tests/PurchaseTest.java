package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PurchaseTest extends BaseTest {

    By books = By.xpath("//div[@class='header-menu'] /ul/li[1]/a");
    By computerslink = By.xpath("//div[@class='header-menu']/ul/li[2]/a");
    By desktopLink = By.xpath("//h2[@class='title']/a");

    By desktop = By.xpath("//div[@class='product-item']/div[@class='picture']/a");
    By addToCartDesktop = By.id("add-to-cart-button-72");

    By firstBook = By.xpath("//div[@class='product-grid']/div[@class='item-box']/div[@data-productid='13']/div[@class='details']/div[@class='add-info']/div[@class='buttons']/input[@type='button']");

   By secondBook = By.xpath("//div[@class='product-grid']/div[@class='item-box']/div[@data-productid='45']/div[@class='details']/div[@class='add-info']/div[@class='buttons']/input[@type='button']");

    By shoppingCart = By.xpath("//div[@class='header-links']//ul/li[3]/a");

    @Test

    public void purchase() throws InterruptedException {



        getElement(books).click();
        getElement(secondBook).click();
        Thread.sleep(1000);
       getElement(firstBook).click();


        getElement(computerslink).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getElement(desktopLink).click();

        getElement(desktop).click();

        getElement(addToCartDesktop).click();

        getElement(shoppingCart).click();

        WebElement total = driver.findElement(By.xpath("//table[@class='cart-total']/tbody/tr[4]/td[@class='cart-total-right']"));
        String totalExpected = total.getText();

        int integerNumber = (int) Double.parseDouble(totalExpected);
        System.out.println(integerNumber);

        WebElement firstBook = driver.findElement(By.cssSelector(".cart-item-row:nth-child(1) .product-subtotal"));
        String firstBookP = firstBook.getText();

        int integerNumber1 = (int) Double.parseDouble(firstBookP);
        System.out.println(integerNumber1);

        WebElement secondBook = driver.findElement(By.cssSelector(".cart-item-row:nth-child(2) .product-subtotal"));
        String secondBook1 = secondBook.getText();

        int integerNumber2 = (int) Double.parseDouble(secondBook1);
        System.out.println(integerNumber2);


        WebElement desktop = driver.findElement(By.cssSelector(".cart-item-row:nth-child(3) .product-subtotal"));
        String desktop1 = desktop.getText();

        int integerNumber3 = (int) Double.parseDouble(desktop1);
        System.out.println(integerNumber3);

        double actualTotal = integerNumber1 + integerNumber2 + integerNumber3;
        System.out.println(actualTotal);

        double number = Double.parseDouble(totalExpected);
        int trimmedNumberExpected = (int) number;

        double number1 = actualTotal;
        int trimmedNumberActual = (int) number;

        Assert.assertEquals(trimmedNumberActual, trimmedNumberExpected);














































        Thread.sleep(3000);








    }


}
