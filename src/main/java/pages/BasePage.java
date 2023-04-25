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
        Reporter.log("Waiting WebElement: '"+element.getAttribute("textContent")+"' to be visible");
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;

    }

    public void open(String url){
        Reporter.log("Opening url - "+url, true);
        driver.navigate().to(url);

    }

    public void verifyTitle(String pageTitle){
        Assert.assertEquals(pageTitle, driver.getTitle(),"Wrong page title\n");
    }

    public void verifyInput(WebElement inputName){
        Assert.assertTrue(inputName.isDisplayed(),"TextInput: '"+inputName.getAttribute("textContent")+"' is NOT present on page\n");
        Reporter.log("Field '"+inputName.getAttribute("name")+"' is present on the page – verification successful", true);
        //System.out.println("Field '"+fieldName.getAttribute("name")+"' verified – Assert passed");
    }


    public void verifyLabel(WebElement fieldName){
        Assert.assertTrue(fieldName.isDisplayed(),"Label: '"+fieldName.getAttribute("textContent")+"' is NOT present on page\n");
        Reporter.log("Label '"+fieldName.getAttribute("textContent")+"' is present on the page – verification successful", true);
        //System.out.println("Label '"+fieldName.getAttribute("textContent")+"' verified – Assert passed");
    }


    public String getPlaceholder(WebElement element) {   // плейсхолдер текст в полях ввода (когда ничего не введено)
        return element.getAttribute("placeholder");
    }

    public void assertPlaceholder(String expectedText, WebElement element) {
        String actualPlaceHolder = getPlaceholder(element);
        Reporter.log("Verifying placeholder text at element - '"+element.getAttribute("textContent"+"'" ));
        Assert.assertEquals(expectedText, actualPlaceHolder,"Wrong placeholder text for element: '"+element.getAttribute("textContent"+"'")+"\n");
        Reporter.log("Placeholder verified successfully, expected - '"+expectedText+"', actual - '"+actualPlaceHolder+"'");
    }

    // public void verifyField_isMandatory (WebElement fieldName){ - пока не нужно, но если делать то отдельно для каждого филда


    public void assertPageLoaded(String url){

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
            Reporter.log("Page did not load / incorrect page loaded, expected Url: "+ url, true);  //TODO: логает все в одной строке (в файле тестНГ - сделать чтобы переносило на некст)
            fail();


        }
    }


    public void scrollToBottom (){
        Reporter.log("Scrolling to the BOTTOM of the page",true);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }  //симуляция скролла в самый НИЗ страницы

    public void scrollToTop (){
        Reporter.log("Scrolling to the TOP of the page",true);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
    }  //симуляция скролла в самый ВЕРХ странциы


    public void scrollToElement (WebElement element){    //скролл ДО данного вебэлемента
        Reporter.log("Scrolling to the element of the page : '"+element.getAttribute("textContent")+"'",true);
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
        Assert.assertFalse(isVisibleInViewport(element),"Fail: WebElement - "+element.getAttribute("textContent")+" is visible\n");
        Reporter.log("Element '"+element.getAttribute("textContent")+"' is NOT visible in viewport - assert successful", true);
    }


    public void assertWebElement_isVisibleInViewport(WebElement element){
        Assert.assertTrue(isVisibleInViewport(element),"Fail: WebElement - "+element.getAttribute("textContent")+" is not visible\n");
        Reporter.log("Element '"+element.getAttribute("textContent")+"' is visible in viewport - assert successful", true);
    }


    public void MouseClickOnElement(WebElement element){   // ХАРД клик мышкой по элементу
        Reporter.log("Trying to perform HARD click on element: '"+element.getAttribute("textContent")+"' at page", true);
        Actions action = new Actions(driver);
        action.moveToElement(element).click(element).build().perform();
    }


    public void clickOutside() {          //клик вне активных элементов сайта (пустое место) -  !!!! не на всех сайтах работает корректно
        Reporter.log("Trying to perform click on blank space at page", true);
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }




}
