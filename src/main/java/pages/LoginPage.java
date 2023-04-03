package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final String LoginPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/login";
    public static final String LoginPageTitle = "Account Login";

    public WebElement loginLogo() {return driver.findElement(By.xpath("logo xpath here"));}







}
