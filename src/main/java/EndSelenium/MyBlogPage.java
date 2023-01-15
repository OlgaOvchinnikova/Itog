package EndSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyBlogPage extends BaseAction{
    public MyBlogPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[2]")
    public WebElement firstClic;
    public MyBlogPage FirstClic(){
        firstClic.click();
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[1]")));
        return this;
    }

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[1]")
    public WebElement secondClic;
    public MyBlogPage SecondClic() {
        secondClic.click();
        return this;
    }

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[3]/div[2]/div/a[2]")
    public  WebElement nextPage;
    public SecondPage NextPageClic(){
        nextPage.click();
        return new SecondPage(driver);
    }
}
