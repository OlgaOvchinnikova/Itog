package TestWeb;
import EndSelenium.LoginPage;
import EndSelenium.MyBlogPage;
import EndSelenium.SecondPage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Story("Что-то за Ленту и Посты")
public class TestLentaPostObjectPage extends  BaseActionBeforeAndAfterTest {

    @Test
    @Description("Тест логина и перехода по страницам ")
    void testPageAssert() throws InterruptedException {
        driver.get(getURL);
        new LoginPage(driver)
                .inputUsername("autotest")
                .inputPassword("4956318935")
                .inputClicButton();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[2]")));
        new MyBlogPage(driver);

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/label/span")).getText(), is("Order"));

    }
    @Test
    @Description("Цвета ")
    void testPageAssert_1() throws InterruptedException {
        driver.get(getURL);
        new LoginPage(driver)
                .inputUsername("autotest")
                .inputPassword("4956318935")
                .inputClicButton();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[2]")));
        new MyBlogPage(driver)
                .FirstClic()
                .SecondClic();

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div[1]/h1"))
                .getCssValue("color"), is("rgba(0, 0, 0, 1)"));


    }
    @Test
    @Description("Переход на следующую страницу")
    void testNextPage() throws InterruptedException {
        driver.get(getURL);
        new LoginPage(driver)
                .inputUsername("autotest")
                .inputPassword("4956318935")
                .inputClicButton();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[2]")));
        new MyBlogPage(driver)
                .FirstClic()
                .SecondClic();

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div[1]/h1"))
                .getCssValue("color"), is("rgba(0, 0, 0, 1)"));

              new SecondPage(driver);

             assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div[3]/div[1]/a/h2"))
                    .getCssValue("color"), is("rgba(64, 179, 255, 1)"));
    }

    @Test
    @Description("Переход на следующую страницу")
    void testPreviousPage() throws InterruptedException {
        driver.get(getURL);
        new LoginPage(driver)
                .inputUsername("autotest")
                .inputPassword("4956318935")
                .inputClicButton();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[2]")));
        new MyBlogPage(driver)
                .FirstClic()
                .SecondClic();

        new SecondPage(driver)
                .PreviousClic();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[2]")));

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div[3]/div[1]/a[1]/h2"))
                .getCssValue("color"), is("rgba(64, 179, 255, 1)"));
    }

}
