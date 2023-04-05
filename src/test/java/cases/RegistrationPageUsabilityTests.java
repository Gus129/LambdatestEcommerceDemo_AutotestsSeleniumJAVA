package cases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


import static pages.LoginPage.LoginPageUrl;
import static pages.RegistrationPage.*;



public class RegistrationPageUsabilityTests extends BaseTest{


    // верификация ссылок
    @Test //(timeOut = 5000) - выполняется >5000 мс = fail, (invocationCount = 2)  - количество раз сколько нужно выполнить тест, (successPercentage = 100) - процент успеха теста чтобы он не упал

    public void registerAccountTitleDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.assertPageLoaded(RegistrationPageUrl);
        basePage.verifyTitle(RegistrationPageTitle);

    }


    @Test

    public void correctPrivacyPolicyLinkSet_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.privacyPolicyLink());
        Assert.assertEquals(PrivacyPolicyUrl, registrationPage.privacyPolicyLink().getAttribute("href"));

    }


    @Test

    public void correctLoginLinkSet_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.loginPageLink());
        Assert.assertEquals(LoginPageUrl, registrationPage.loginPageLink().getAttribute("href"));

    }


    // верификация лейблов
    @Test

    public void firstNameLabelDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.firstNameLabel());
        basePage.verifyLabel(registrationPage.firstNameLabel());

    }

    @Test

    public void lastNameLabelDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.lastNameLabel());
        basePage.verifyLabel(registrationPage.lastNameLabel());

    }


    @Test

    public void emailLabelDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.emailLabel());
        basePage.verifyLabel(registrationPage.emailLabel());

    }


    @Test

    public void telephoneLabelDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.phoneNumberLabel());
        basePage.verifyLabel(registrationPage.phoneNumberLabel());

    }


    @Test

    public void passwordLabelDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.passwordLabel());
        basePage.verifyLabel(registrationPage.passwordLabel());

    }


    @Test

    public void confirmPasswordLabelDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.passwordConfirmLabel());
        basePage.verifyLabel(registrationPage.passwordConfirmLabel());

    }


    // верификация текст инпутов
    @Test

    public void firstNameInputDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.firstNameInput());
        basePage.verifyInput(registrationPage.firstNameInput());

    }

    @Test

    public void lastNameInputDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.lastNameInput());
        basePage.verifyInput(registrationPage.lastNameInput());

    }


    @Test

    public void emailInputDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.emailInput());
        basePage.verifyInput(registrationPage.emailInput());

    }


    @Test

    public void telephoneInputDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.phoneNumberInput());
        basePage.verifyInput(registrationPage.phoneNumberInput());

    }


    @Test

    public void passwordInputDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.passwordInput());
        basePage.verifyInput(registrationPage.passwordInput());

    }


    @Test

    public void confirmPasswordInputDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.passwordConfirmInput());
        basePage.verifyInput(registrationPage.passwordConfirmInput());

    }

    // проверка текста плейсхолдеров
    @Test

    public void correctFirstNamePlaceholderDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.firstNameInput());
        basePage.assertPlaceholder("First Name", registrationPage.firstNameInput());

    }


    @Test

    public void correctLastNamePlaceholderDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.lastNameInput());
        basePage.assertPlaceholder("Last Name", registrationPage.lastNameInput());

    }


    @Test

    public void correctEmailPlaceholderDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.emailInput());
        basePage.assertPlaceholder("E-Mail", registrationPage.emailInput());

    }


    @Test

    public void correctTelephonePlaceholderDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.phoneNumberInput());
        basePage.assertPlaceholder("Telephone", registrationPage.phoneNumberInput());

    }


    @Test

    public void correctPasswordPlaceholderDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.passwordInput());
        basePage.assertPlaceholder("Password", registrationPage.passwordInput());

    }


    @Test

    public void correctConfirmPasswordPlaceholderDisplayed_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.passwordConfirmInput());
        basePage.assertPlaceholder("Password Confirm", registrationPage.passwordConfirmInput());

    }


    @Test

    public void continueButtonNameCorrectly_when_navigateToRegistrationPage() {

        basePage.open(RegistrationPageUrl);
        basePage.waitElementIsVisible(registrationPage.continueButton());
        Assert.assertEquals("Continue", registrationPage.continueButton().getAttribute("value"));

    }


}
