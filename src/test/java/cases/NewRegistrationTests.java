package cases;

import base.BaseTest;
import factories.UserFactory;

import models.User;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static pages.RegistrationPage.*;
import static pages.AccountSuccessPage.*;


@Listeners(base.Listener.class)
public class NewRegistrationTests extends BaseTest {

//    private List<JavascriptException> jsExceptionsList;
//    private List<String> consoleMessages;


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
        user.setFirstName(StringUtils.repeat("A", 1));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_firstName32Characters() {
        User user = UserFactory.createDefault();
        user.setFirstName(StringUtils.repeat("A", 32));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_lastName1Character() {
        User user = UserFactory.createDefault();
        user.setLastName(StringUtils.repeat("A", 1));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_lastName32Characters() {
        User user = UserFactory.createDefault();
        user.setLastName(StringUtils.repeat("A", 32));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_email4Character() {
        User user = UserFactory.createDefault();
        user.setEmail("z@z.z");                                         //TODO: выдает ошибку что такой уже существует, сделать рандомно?

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_email32Characters() {
        User user = UserFactory.createDefault();
        user.setEmail("z@" + StringUtils.repeat("Z", 26) + ".io");  //TODO: выдает ошибку что такой уже существует, сделать рандомно?

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_telephone3Character() {
        User user = UserFactory.createDefault();
        user.setTelephone("123");

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }


    //TODO: как-то имплементировать коды стран использую TestNG (фича ниже только для junit)
//    @ParameterizedTest(name = "{index}. user created successfully when correct telephone set for country = {0}")
//    @ValueSource(strings = {
//            "+9370123456789",
//            "+358457012345678",
//            "+3584570123456789",
//            "+35845701234567890",
//            "+35567123456789",
//            "+2135123456789",
//            "+97335512345678",
//    })
//    @Test
//    public void userCreatedSuccessfully_when_correctTelephoneSetForCountry(String telephone) {
//        User user = UserFactory.createDefault();
//        user.setTelephone(telephone);
//
//        basePage.open(RegistrationPageUrl);
//
//        registrationPage.register(user, false);
//
//        accountSuccessPage.assertAccountCreatedSuccessfully();
//        accountSuccessPage.logOut();
//    }

    @Test
    public void userCreatedSuccessfully_when_telephone32Characters() {
        User user = UserFactory.createDefault();
        user.setTelephone(StringUtils.repeat("0", 33));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();  //TODO: выдает ошибку что такой уже существует, сделать рандомно?
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_password4Character() {
        User user = UserFactory.createDefault();
        user.setPassword("1234");
        user.setPasswordConfirm("1234");

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_password20Characters() {
        User user = UserFactory.createDefault();
        user.setPassword(StringUtils.repeat("9", 20));
        user.setPasswordConfirm(StringUtils.repeat("9", 20));

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);

        accountSuccessPage.assertAccountCreatedSuccessfully();
        accountSuccessPage.logOut();
    }

    @Test
    public void userCreatedSuccessfully_when_newsletterSubscribeTrue() {
        User user = UserFactory.createDefault();
        user.setShouldSubscribe(true);

        basePage.open(RegistrationPageUrl);

        registrationPage.register(user, false);  //TODO: ошибка прои клике радио баттона -element click intercepted - проставить ожидание или какой-то другой способ

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
