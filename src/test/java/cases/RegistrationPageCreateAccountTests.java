package cases;

import base.BaseTest;
import factories.UserFactory;

import listeners.TestCaseListener;
import models.User;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import static common.UniqueGeneration.buildUniqueCharString;
import static common.UniqueGeneration.buildUniqueNumberString;
import static pages.RegistrationPage.*;

import common.DataProviderTestNG;



@Listeners(TestCaseListener.class)
public class RegistrationPageCreateAccountTests extends BaseTest {




    // happy path
    @Test
    public void userCreatedSuccessfully_when_allRequiredFieldsField_and_clickContinueButton() {
        User user = UserFactory.createDefault();

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_allRequiredFieldsField_and_pressContinueButtonWithEnter() {
        User user = UserFactory.createDefault();

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, true);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    // boundary values

    @Test
    public void userCreatedSuccessfully_when_firstName1Character() {
        User user = UserFactory.createDefault();
        user.setFirstName(buildUniqueCharString(1));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_firstName32Characters() {
        User user = UserFactory.createDefault();
        user.setFirstName(buildUniqueCharString(32));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_lastName1Character() {
        User user = UserFactory.createDefault();
        user.setLastName(buildUniqueCharString(1));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_lastName32Characters() {
        User user = UserFactory.createDefault();
        user.setLastName(buildUniqueCharString(32));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_email4Character() {
        User user = UserFactory.createDefault();
        user.setEmail(buildUniqueCharString(1) + "@" + buildUniqueCharString(1) + "." + buildUniqueCharString(1));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_email32Characters() {
        User user = UserFactory.createDefault();
        user.setEmail(buildUniqueCharString(1) + "@" + buildUniqueCharString(26) + "." + buildUniqueCharString(2));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_telephone3Character() {
        User user = UserFactory.createDefault();
        user.setTelephone(buildUniqueNumberString(3));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }



    @Test (dataProvider="telephone", dataProviderClass= DataProviderTestNG.class) //повторяет тест N раз в заивисимости от количества значекний в датапровайдере (в данном случае телефон и 7 значений)
    public void userCreatedSuccessfully_when_correctTelephoneSetForCountry(String telephone) {
        User user = UserFactory.createDefault();
        user.setTelephone(telephone);

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_telephone32Characters() {
        User user = UserFactory.createDefault();
        user.setTelephone(buildUniqueNumberString(32));  // метод по генерации рандом строки состоящий из цифр 0-9 длиной в 32 символа

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_password4Character() {
        User user = UserFactory.createDefault();
        user.setPassword("7777");
        user.setPasswordConfirm("7777");

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_password20Characters() {
        User user = UserFactory.createDefault();
        user.setPassword(StringUtils.repeat("2", 20));
        user.setPasswordConfirm(StringUtils.repeat("2", 20));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_newsletterSubscribeTrue()  {
        User user = UserFactory.createDefault();
        user.setShouldSubscribe(true);

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);


        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

//    @AfterMethod
//    public void tearDown() {
//        System.out.println("###########################");
//        System.out.println();
//        // print all JS errors
//        for (JavascriptException jsException : jsExceptionsList) {
//            System.out.println("JS exception message: " + jsException.getMessage());
//            jsException.printStackTrace();
//            System.out.println();
//        }
//
//        System.out.println("###########################");
//        System.out.println();
//        // print all console messages
//        for (String consoleMessage : consoleMessages) {
//            System.out.println(consoleMessage);
//        }
//
//        if (driver != null) {
//            driver.quit();
//        }
//    }




}
