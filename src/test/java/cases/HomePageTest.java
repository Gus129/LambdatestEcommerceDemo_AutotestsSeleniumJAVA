package cases;

import base.BaseTest;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import static pages.HomePage.*;




public class HomePageTest extends BaseTest{

    @Test //(timeOut = 5000) - выполняется >5000 мс = fail, (invocationCount = 2)  - количество раз сколько нужно выполнить тест, (successPercentage = 100) - процент успеха теста чтобы он не упал
    public void check_HomePage_AppearCorrect(){

        basePage.open(HomePageUrl);
        basePage.assertPageLoaded(HomePageUrl);
        basePage.verifyTitle(HomePageTitle);
    }




}
