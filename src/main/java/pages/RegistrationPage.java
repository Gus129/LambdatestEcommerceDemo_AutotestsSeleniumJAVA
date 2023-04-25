package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public static final String RegistrationPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    public static final String RegistrationPageTitle = "Register Account";

    public static final String PrivacyPolicyUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=information/information/agree&information_id=3";


    public WebElement registrationLogo() { return driver.findElement(By.xpath("//*[@title='Poco Electro']")); }

    public WebElement mainHeading() { return driver.findElement(By.tagName("h1")); }
    public WebElement mainErrorSummary() { return driver.findElement(By.className("alert-dismissible")); } //всплывающее окошко с ошибкой когда не проставлена галочка соглашения

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

    public WebElement newsletterSubscribeYes() { return driver.findElement(By.xpath("//*[@id='content']/form/fieldset[3]/div/div/div[1]/label")); }
    public WebElement newsletterSubscribeNo() {  return driver.findElement(By.xpath("//*[@id='content']/form/fieldset[3]/div/div/div[2]/label"));  }

    public WebElement subscribeLabel() { return driver.findElement(By.xpath("//*[@id='content']/form/fieldset[3]/div/label")); }

    public WebElement privacyPolicyCheckbox() { return driver.findElement(By.xpath("//input[@id='input-agree']/following-sibling::label")); }
    public WebElement privacyPolicyLink() { return driver.findElement(By.xpath("//a[@class='agree']")); }
    public WebElement privacyPolicyError() { return driver.findElement(By.xpath("//*[@id='account-register']/div[1]")); }

    public WebElement continueButton() { return driver.findElement(By.xpath("//input[@value='Continue']")); }

    public void openPrivacyPolicy() {
        privacyPolicyLink().click();
    }

    public String getErrorMessage(String inputLabel) {  //метод возвращает элемент с выводом текста ошибки - по вводу названия label'a текс инпута вызывающего ошибку
        String xpathLocator = String.format("//label[text()='%s']//following-sibling::div/div", inputLabel); // локатор икспаса элемента с текстом ошибки, по лейблу
        return driver.findElement(By.xpath(xpathLocator)).getText();
    }

    public void assertFirstNameErrorValidation() {  //ассерт на ожидаемый и актуальный текст ошибки
        String actualError = getErrorMessage("First Name");
        Assert.assertEquals("First Name must be between 1 and 32 characters!", actualError,"Wrong error message displayed for First Name input\n");
    }

    public void assertLastNameErrorValidation() {
        String actualError = getErrorMessage("Last Name");
        Assert.assertEquals("Last Name must be between 1 and 32 characters!", actualError,"Wrong error message displayed for Last Name input\n");
    }

    public void assertEmailErrorValidation() {
        String actualError = getErrorMessage("E-Mail");
        Assert.assertEquals("E-Mail Address does not appear to be valid!", actualError,"Wrong error message displayed for E-mail input\n");
    }

    public void assertTelephoneErrorValidation() {
        String actualError = getErrorMessage("Telephone");
        Assert.assertEquals("Telephone must be between 3 and 32 characters!", actualError,"Wrong error message displayed for Telephone number input\n");
    }

    public void assertPasswordErrorValidation() {
        String actualError = getErrorMessage("Password");
        Assert.assertEquals("Password must be between 4 and 20 characters!", actualError,"Wrong error message displayed for Password input\n");
    }

    public void assertPasswordConfirmationMismatchValidation() {
        String actualError = getErrorMessage("Password Confirm");
        Assert.assertEquals("Password confirmation does not match password!", actualError,"Wrong error message displayed for Password Confirmation input\n");
    }

    public void assertPrivacyPolicyAgreementErrorValidation() {

        Assert.assertEquals("Warning: You must agree to the Privacy Policy!", privacyPolicyError().getText(),"Wrong error message displayed when NOT agree to the Privacy Policy\n");
    }




    public void register(User user, Boolean useEnter) {
        if (!user.getFirstName().isEmpty()) {
            firstNameInput().sendKeys(user.getFirstName());
        }

        if (!user.getLastName().isEmpty()) {
            lastNameInput().sendKeys(user.getLastName());
        }

        if (!user.getEmail().isEmpty()) {
            emailInput().sendKeys(user.getEmail());
        }

        if (!user.getTelephone().isEmpty()) {
            phoneNumberInput().sendKeys(user.getTelephone());
        }

        if (!user.getPassword().isEmpty()) {
            passwordInput().sendKeys(user.getPassword());
        }

        if (!user.getPasswordConfirm().isEmpty()) {
            passwordConfirmInput().sendKeys(user.getPasswordConfirm());
        }

        if (user.getShouldSubscribe() && !newsletterSubscribeYes().isSelected()) {
            newsletterSubscribeYes().click();
        } else if (!user.getShouldSubscribe() && !newsletterSubscribeNo().isSelected()) {
            newsletterSubscribeNo().click();
        }

        if (user.getAgreePrivacyPolicy()) {
           privacyPolicyCheckbox().click();
        }

        if (useEnter) {
            continueButton().sendKeys(Keys.ENTER);
        } else {
            continueButton().click();
        }
    }










}
