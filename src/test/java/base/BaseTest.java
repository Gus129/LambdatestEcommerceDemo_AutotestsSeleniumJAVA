package base;

import factories.BrowserFactory;
import org.apache.commons.io.FilenameUtils;
import org.testng.Reporter;
import pages.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;
import java.util.Date;




public class BaseTest {

    // !!!!! Сюда добавляются переменные для каждой новой страницы проекта - загрузка драйвера

    protected WebDriver driver = BrowserFactory.getBrowser("Chrome");

    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected RegistrationPage registrationPage = new RegistrationPage(driver);
    protected AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);



    public void failureScreenshot (String methodName){
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();

        String TimeStampScreenshot = d.toString().replace(":", "_").replace(" ", "_");
        try {
            FileUtils.copyFile(srcFile, new File ("./screenshots/" + methodName + "_" + TimeStampScreenshot + ".png"));
            Reporter.log("Failure screenshot is created - " + FilenameUtils.getName(methodName + "_" + TimeStampScreenshot + ".png"), true);

        } catch (IOException e){
            e.printStackTrace();
        }
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() throws InterruptedException
    {
        Thread.sleep(2500); //чтобы увидеть результат визуально :)
        BrowserFactory.closeAllDriver();
    }

}
