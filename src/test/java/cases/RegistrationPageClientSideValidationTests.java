package cases;

import base.BaseTest;
import factories.UserFactory;

import listeners.TestCaseListener;
import models.User;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import static common.UniqueGeneration.buildUniqueCharString;
import static common.UniqueGeneration.buildUniqueNumberString;
import static pages.RegistrationPage.*;

import java.util.List;


@Listeners(TestCaseListener.class)
public class RegistrationPageClientSideValidationTests extends BaseTest {



    // validations

    @BeforeMethod
    public void notLoggedIn_check() { //проверка залогинен ли пользователь - иначе страница регистрации редиректит на страницу аккаунта
        List<WebElement> logoutButtonRightPanel = driver.findElements(By.xpath("//*[@id='column-right']/div/a[14]"));

        if (logoutButtonRightPanel.size() == 1) {
            logoutButtonRightPanel.get(0).click();
        }
    }


    @Test
    public void privacyPolicyNotCheckedValidationDisplayed_when_notAgree() {
        User user = UserFactory.createDefault();
        user.setAgreePrivacyPolicy(false);

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);
        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertPrivacyPolicyAgreementErrorValidation();

    }

    @Test
    public void firstNameValidationDisplayed_when_emptyFirstName() {
        User user = UserFactory.createDefault();
        user.setFirstName("");

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);
        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertFirstNameErrorValidation();

    }

    @Test
    public void firstNameValidationDisplayed_when_firstName33Characters() {
        User user = UserFactory.createDefault();
        user.setFirstName(buildUniqueCharString(33));

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);
        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertFirstNameErrorValidation();

    }

    @Test
    public void lastNameValidationDisplayed_when_emptyLastName() {
        User user = UserFactory.createDefault();
        user.setLastName("");

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);
        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertLastNameErrorValidation();

    }

    @Test
    public void lastNameValidationDisplayed_when_lastName33Characters() {
        User user = UserFactory.createDefault();
        user.setLastName(buildUniqueCharString(33));

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);
        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertLastNameErrorValidation();

    }

    @Test
    public void emailValidationDisplayed_when_emptyEmail() {
        User user = UserFactory.createDefault();
        user.setEmail("");

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);
        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertEmailErrorValidation();


    }

    @Test
    public void emailValidationDisplayed_when_email33Characters() {  // не выставлены алерты для данного поля при 33+ знаках в поле = тест всегда будет Failed
        User user = UserFactory.createDefault();
        user.setEmail(buildUniqueCharString(21) + "@example.com" );

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);

        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertEmailErrorValidation();

    }

    @Test
    public void emailValidationDisplayed_when_email77Characters() {  // на этом конкретном сайте почему-то именно 77 символов boundary (76 пропускает)
        User user = UserFactory.createDefault();
        user.setEmail(buildUniqueCharString(65) + "@example.com" );   // 64 length (76 for all textinput) is MAX

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);
        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertEmailErrorValidation();
    }

    @Test
    public void emailValidationDisplayed_when_incorrectEmailSet() {
        User user = UserFactory.createDefault();
        user.setEmail(buildUniqueCharString(4));

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);
        accountSuccessPage.assertAccountNOTCreated();
        //registrationPage.assertEmailErrorValidation(); - ошибка генерируется в PopUp сообщение с default языком браузера = такой метод не подходит, поэтому просто проверяем прошла ли регистрация или нет

    }

    @Test
    public void telephoneValidationDisplayed_when_emptyTelephone() {
        User user = UserFactory.createDefault();
        user.setTelephone("");

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);
        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertTelephoneErrorValidation();

    }

    @Test
    public void telephoneValidationDisplayed_when_telephone33Characters() {
        User user = UserFactory.createDefault();
        user.setTelephone(buildUniqueNumberString(33));

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);
        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertTelephoneErrorValidation();

    }

    @Test
    public void passwordValidationDisplayed_when_emptyPassword() {
        User user = UserFactory.createDefault();
        user.setPassword("");
        user.setPasswordConfirm("");

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);
        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertPasswordErrorValidation();

    }

    @Test
    public void passwordValidationDisplayed_when_password21Characters() {  // не выставлены алерты для данного поля при 21+ знаках в поле = тест всегда будет Failed
        User user = UserFactory.createDefault();
        user.setPassword(StringUtils.repeat("0", 21));
        user.setPasswordConfirm(StringUtils.repeat("0", 21));

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);

        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertPasswordErrorValidation();

    }

    @Test
    public void passwordConfirmationValidationDisplayed_when_passwordMismatch() {
        User user = UserFactory.createDefault();
        user.setPassword("1234");
        user.setPasswordConfirm("4321");

        basePage.open(RegistrationPageUrl);
        registrationPage.register(user, false);
        accountSuccessPage.assertAccountNOTCreated();
        registrationPage.assertPasswordConfirmationMismatchValidation();

    }

    @Test
    public void passwordDisplayedEncrypted_when_typePassword() {

        basePage.open(RegistrationPageUrl);
        registrationPage.passwordInput().sendKeys("1234");

        Assert.assertEquals("password", registrationPage.passwordInput().getAttribute("type"));
    }

    @Test
    public void passwordConfirmDisplayedEncrypted_when_typePassword() {


        basePage.open(RegistrationPageUrl);
        registrationPage.passwordConfirmInput().sendKeys("1234");

        Assert.assertEquals("password", registrationPage.passwordConfirmInput().getAttribute("type"));
    }




}
