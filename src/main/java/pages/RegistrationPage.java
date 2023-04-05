package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public static final String RegistrationPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    public static final String RegistrationPageTitle = "Register Account";

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

    public WebElement newsletterSubscribeYes() { return driver.findElement(By.id("input-newsletter-yes")); }
    public WebElement newsletterSubscribeNo() {  return driver.findElement(By.id("input-newsletter-no"));  }

    public WebElement subscribeLabel() { return driver.findElement(By.xpath("//*[@id='content']/form/fieldset[3]/div/label")); }

    public WebElement privacyPolicyCheckbox() { return driver.findElement(By.xpath("//input[@id='input-agree']/following-sibling::label")); }
    public WebElement privacyPolicyLink() { return driver.findElement(By.xpath("//a[@class='agree']")); }

    public WebElement continueButton() { return driver.findElement(By.xpath("//input[@value='Continue']")); }

    public void openPrivacyPolicy() {
        privacyPolicyLink().click();
    }

    public String getErrorMessage(String inputLabel) {  //метод возвращает элемент с выводом текста ошибки - по вводу названия label'a текс инпута вызывающего ошибку
        String xpathLocator = String.format("//label[text()='%s']//following-sibling::div/div", inputLabel); // локатор икспаса элемента с текстом ошибки, по лейблу
        return driver.findElement(By.xpath(xpathLocator)).getText();
    }

    public void assertFirstNameValidation() {  //ассерт на ожидаемый и актуальный текст ошибки
        String actualError = getErrorMessage("First Name");
        Assert.assertEquals("First Name must be between 1 and 32 characters!", actualError);
    }

    public void assertLastNameValidation() {
        String actualError = getErrorMessage("Last Name");
        Assert.assertEquals("Last Name must be between 1 and 32 characters!", actualError);
    }

    public void assertEmailValidation() {
        String actualError = getErrorMessage("E-Mail");
        Assert.assertEquals("E-Mail Address does not appear to be valid!", actualError);
    }

    public void assertTelephoneValidation() {
        String actualError = getErrorMessage("Telephone");
        Assert.assertEquals("Telephone must be between 3 and 32 characters!", actualError);
    }

    public void assertPasswordValidation() {
        String actualError = getErrorMessage("Password");
        Assert.assertEquals("Password must be between 4 and 20 characters!", actualError);
    }

    public void assertPasswordConfirmationMismatchValidation() {
        String actualError = getErrorMessage("Password Confirm");
        Assert.assertEquals("Password confirmation does not match password!", actualError);
    }

    public void assertPrivacyPolicyAgreementValidation() {
        String actualError = getErrorMessage("Password Confirm");
        Assert.assertEquals(" Warning: You must agree to the Privacy Policy!", mainErrorSummary().getText());
    }

    public String getPlaceholder(WebElement element) {   // плейсхолдер текст в полях ввода (когда ничего не введено)
        return element.getAttribute("placeholder");
    }

    public void assertPlaceholder(String expectedText, WebElement element) {
        String actualPlaceHolder = getPlaceholder(element);
        Assert.assertEquals(expectedText, actualPlaceHolder);
    }

    /*  public void register(User user, Boolean useEnter) {     //TODO: этот блок активировать только при регистрации
        if (!user.getFirstName().isEmpty()) {
            fistNameInput().sendKeys(user.getFirstName());
        }

        if (!user.getLastName().isEmpty()) {
            lastNameInput().sendKeys(user.getLastName());
        }

        if (!user.getEmail().isEmpty()) {
            emailInput().sendKeys(user.getEmail());
        }

        if (!user.getTelephone().isEmpty()) {
            telephoneInput().sendKeys(user.getTelephone());
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
*/








}
