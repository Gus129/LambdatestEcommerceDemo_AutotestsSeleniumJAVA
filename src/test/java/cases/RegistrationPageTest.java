package cases;

import base.BaseTest;
import org.testng.annotations.Test;


import static pages.RegistrationPage.*;



public class RegistrationPageTest extends BaseTest{

    @Test //(timeOut = 5000) - выполняется >5000 мс = fail, (invocationCount = 2)  - количество раз сколько нужно выполнить тест, (successPercentage = 100) - процент успеха теста чтобы он не упал
    public void check_RegistrationPage_AppearCorrect(){

        basePage.open(RegistrationPageUrl);
        basePage.assertPageLoaded(RegistrationPageUrl);
        basePage.verifyTitle(RegistrationPageTitle);
    }




}
