package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login {
    private WebDriver driver = new ChromeDriver();
    Duration timeout = Duration.ofSeconds(10);
    private WebDriverWait wait = new WebDriverWait(driver, timeout);
    @Given("Navigate to home page")
    public void navigate_to_home_page() {
        driver.get("https://www.n-sport.net/");
    }

    @Given("Navigate to login page")
    public void navigate_to_login_page() {
        driver.get("https://www.n-sport.net/index.php?mod=customers&op=my_account");
        // dodato gašenje kolačića zbog prekida izvršenja ostalih testova usled nemogućnosti lociranja elemenata
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[3]/a")).click();
    }

    @When("Click Login button")
    public void click_login_button1() {
        driver.findElement(By.xpath("//*[@id=\"topcontainer\"]/div[2]/form/div[3]/div[1]/button")).click();
    }

    @Then("Validate login error message")
    public void validate_login_error_message() {2
       String message=driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/p")).getText();
       System.out.println(message);
       String expected_message="Morate uneti sifru!!";
        Assert.assertTrue(message.contains(expected_message));
    }

    @When("Enter login email")
    public void enter_login_email() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/input")).sendKeys("kristinablazic12@gmail.com");
    }

    @When("Enter login password")
    public void enter_login_password() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/input")).sendKeys("ASDfgh!@#456");
    }

    @When("Click login button")
    public void click_login_button2() {
        driver.findElement(By.xpath("//*[@id=\"topcontainer\"]/div[2]/form/div[3]/div[1]/button")).click();
    }

    @Then("Login confirmation")
    public void login_confirmation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div[2]/div/a/h1")));
        String message=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/a/h1")).getText();
        System.out.println(message);
        String expected_message="MOJ PROFIL";
        Assert.assertTrue(message.contains(expected_message));
    }


    @And("Website is closed")
    public void websiteIsClosed() {
        driver.quit();
    }
}
