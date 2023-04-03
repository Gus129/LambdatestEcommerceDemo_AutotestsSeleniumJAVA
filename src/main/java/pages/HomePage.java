package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final String HomePageUrl = "https://ecommerce-playground.lambdatest.io/";
    public static final String HomePageTitle = "Your Store";

    public WebElement homePageLogo() {return driver.findElement(By.xpath("logo xpath here"));}







}
