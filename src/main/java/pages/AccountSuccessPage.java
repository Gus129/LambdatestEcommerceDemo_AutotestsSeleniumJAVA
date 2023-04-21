package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.IOException;

public class AccountSuccessPage extends BasePage {

    public AccountSuccessPage(WebDriver driver) {
        super(driver);
    }

    public static final String AccountSuccessPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/success";
    public static final String AccountSuccessTitle = "Your Account Has Been Created!";

    private WebElement mainHeading() { return driver.findElement(By.tagName("h1")); }
    private WebElement MyAccountDropDown() { return driver.findElement(By.xpath("//*[@id='widget-navbar-217834']/ul/li[6]"));}
    private WebElement logoutDropDownOption() { return driver.findElement(By.xpath("//*[@id='widget-navbar-217834']/ul/li[6]/ul/li[6]/a")); }





    public void assertAccountCreatedSuccessfully() {

        Assert.assertEquals(AccountSuccessTitle, mainHeading().getText().trim());
        Reporter.log("Account created successfully as intended", true);
        //System.out.println("Account created successfully as intended");

    }

    public void assertAccountNOTCreated() {

        Assert.assertNotEquals(AccountSuccessTitle, mainHeading().getText().trim());
        Reporter.log("Account is NOT created as intended", true);

        //System.out.println("Account is NOT created as intended");

    }

    public void logOut() {
          try {
              Reporter.log("Trying to log out from account", true);
            Actions action = new Actions(driver);
            action.moveToElement(MyAccountDropDown()).perform();
            logoutDropDownOption().click();
              Reporter.log("Successfully logged out", true);
        } catch (NoSuchElementException e) {
              Reporter.log("Can't log out from account", true);
              System.out.println(e.getMessage());
          }
    }

}
