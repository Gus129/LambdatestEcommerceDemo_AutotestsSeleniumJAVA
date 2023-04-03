package base;

import common.CommonAction;
import pages.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class BaseTest {

    // !!!!! Сюда добавляются переменные для каждой новой страницы проекта - загрузка драйвера

    protected WebDriver driver = CommonAction.createDriver();

    protected BasePage basePage = new BasePage(driver);
    protected HomePage HomePage = new HomePage(driver);



    public void FailureScreenshot (String methodName){
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();

        String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");
        try {
            FileUtils.copyFile(srcFile, new File ("./screenshots/" + methodName + "_" + TimeStamp + ".png"));

        } catch (IOException e){
            e.printStackTrace();
        }
    }


    @AfterSuite(alwaysRun = true)
    public void closeBrowser () throws InterruptedException {
        Thread.sleep(2500); //чтобы увидеть результат визуально :)
        driver.quit();
    }

}
