package EndSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondPage extends BaseAction {

    public SecondPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[3]/div[2]/div/a[1]")
    public WebElement previousClic;

    public MyBlogPage PreviousClic() {
        previousClic.click();
        return new MyBlogPage(driver);
    }

}
