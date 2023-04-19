package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;

import static common.Config.EXPLICIT_WAIT;
import static org.testng.AssertJUnit.fail;


public class BasePage {

    public final WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    public WebElement waitElementIsVisible(WebElement element){

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));

        return element;

    }


    public void open(String url){

        driver.navigate().to(url);
    }

    public void verifyTitle(String pageTitle){
        Assert.assertEquals(pageTitle, driver.getTitle());
    }

    public void verifyInput(WebElement fieldName){
        Assert.assertTrue(fieldName.isDisplayed());
        Reporter.log("Field '"+fieldName.getAttribute("name")+"' is present on the page – verification successful", true);
        //System.out.println("Field '"+fieldName.getAttribute("name")+"' verified – Assert passed");
    }


    public void verifyLabel(WebElement fieldName){
        Assert.assertTrue(fieldName.isDisplayed());
        Reporter.log("Label '"+fieldName.getAttribute("textContent")+"' is present on the page – verification successful", true);
        //System.out.println("Label '"+fieldName.getAttribute("textContent")+"' verified – Assert passed");
    }


    public String getPlaceholder(WebElement element) {   // плейсхолдер текст в полях ввода (когда ничего не введено)
        return element.getAttribute("placeholder");
    }

    public void assertPlaceholder(String expectedText, WebElement element) {
        String actualPlaceHolder = getPlaceholder(element);
        Assert.assertEquals(expectedText, actualPlaceHolder);
    }

    // public void verifyField_isMandatory (WebElement fieldName){ - пока не нужно, но если делать то отдельно для каждого филда


    public void assertPageLoaded(String url){ //TODO поменять на чтото получше, не всегда корректно работает (возможно только на "избранных" сайтах

        // Javascript executor to return value
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("return document.readyState")
                .toString().equals("complete");
        // get the current URL
        String urlString = driver.getCurrentUrl();
        // checking condition if the URL is loaded
        if (urlString.equals(url)) {
            Reporter.log("Correct page loaded, current Url - "+ urlString, true);
            //System.out.println("Page Loaded");
            //System.out.println("Current Url: " + s);
        }
        else {
            Reporter.log("Page did not load / incorrect page loaded, expected Url: "+ url, true);  //TODO: проверить корректно ли логает фейл
            fail();


        }
    }


    public void scrollToBottom (){((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");}  //симуляция скролла в самый НИЗ страницы

    public void scrollToTop (){((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");}  //симуляция скролла в самый ВЕРХ странциы


    public void scrollToElement (WebElement element){    //скролл ДО данного вебэлемента
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }


    public  Boolean isVisibleInViewport(WebElement element) {    // виден ли элемент в данном положении окна браузера

        WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();

        return (Boolean)((JavascriptExecutor)driver).executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , element);
    }


    public void assertWebElement_isNOTVisibleInViewport(WebElement element){
        Assert.assertFalse(isVisibleInViewport(element),"Fail: WebElement - "+element.getAttribute("textContent")+" is visible");
    }


    public void assertWebElement_isVisibleInViewport(WebElement element){
        Assert.assertTrue(isVisibleInViewport(element),"Fail: WebElement - "+element.getAttribute("textContent")+" is not visible");
    }


    public void MouseClickOnElement(WebElement element){   // ХАРД клик мышкой по элементу
        Actions action = new Actions(driver);
        action.moveToElement(element).click(element).build().perform();
    }


    public void clickOutside() {          //клик вне активных элементов сайта (пустое место) -  !!!! не на всех сайтах работает корректно
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }




}
