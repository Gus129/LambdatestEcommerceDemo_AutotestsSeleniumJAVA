package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Assertions;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public static final String RegistrationPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    public static final String RegistrationPageTitle = "Register Account";

    public WebElement registrationLogo() { return driver.findElement(By.xpath("logo xpath here")); }

    public WebElement mainHeading() { return driver.findElement(By.tagName("h1")); }
    public WebElement mainErrorSummary() { return driver.findElement(By.className("alert-dismissible")); }

    public WebElement loginPageLink() { return driver.findElement(By.xpath("//h1/following-sibling::p/a")); }

    public WebElement firstNameInput() { return driver.findElement(By.id("input-firstname")); }
    public WebElement firstNameLabel() { return driver.findElement(By.xpath("//label[@for='input-firstname']")); }

    public WebElement lastNameInput() { return driver.findElement(By.id("input-lastname")); }
    public WebElement lastNameLabel() { return driver.findElement(By.xpath("//label[@for='input-lastname']")); }

    public WebElement emailInput() { return driver.findElement(By.id("input-email")); }
    public WebElement emailLabel() { return driver.findElement(By.xpath("//label[@for='input-email']")); }

    public WebElement phoneNumberInput() { return driver.findElement(By.id("input-telephone")); }
    public WebElement phoneNumberLabel() { return driver.findElement(By.xpath("//label[@for='input-telephone']")); }

    public WebElement passwordInput() { return driver.findElement(By.id("input-password")); }
    public WebElement passwordLabel() { return driver.findElement(By.xpath("//label[@for='input-password']")); }
    public WebElement passwordConfirmInput() { return driver.findElement(By.id("input-confirm")); }
    public WebElement passwordConfirmLabel() { return driver.findElement(By.xpath("//label[@for='input-confirm']")); }

    public WebElement newsletterSubscribeYes() { return driver.findElement(By.id("input-newsletter-yes")); }
    public WebElement newsletterSubscribeNo() {  return driver.findElement(By.id("input-newsletter-no"));  }

    public WebElement subscribeLabel() { return driver.findElement(By.xpath("//*[@id='content']/form/fieldset[3]/div/label")); }

    public WebElement privacyPolicyCheckbox() { return driver.findElement(By.xpath("//input[@id='input-agree']/following-sibling::label")); }
    public WebElement privacyPolicyLink() { return driver.findElement(By.xpath("//a[@class='agree']")); }

    public WebElement continueButton() { return driver.findElement(By.xpath("//input[@value='Continue']")); }









}
