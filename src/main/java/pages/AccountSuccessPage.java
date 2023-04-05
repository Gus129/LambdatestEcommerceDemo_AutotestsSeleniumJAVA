package pages;

import org.openqa.selenium.WebDriver;

public class AccountSuccessPage extends BasePage {

    public AccountSuccessPage(WebDriver driver) {
        super(driver);
    }

    public static final String AccountSuccessPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/success";
    public static final String AccountSuccessTitle = "Your Account Has Been Created!";

}
