import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
/*
Otići na http://www.strela.co.rs/, kliknuti na dugme Prodavnica u headeru,
izabrati opciju Lukovi - Bows iz leve navigacije, potom kliknuti na luk koji
se zove Samick Sage, i onda proveriti da ime tog luka na njegovoj stranici zaista
sadrži reč Samick.
 */

public class StrelaMain {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raven\\Desktop\\QA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.strela.co.rs/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.manage().window().maximize();

        WebElement headerBtnProdavnica = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a/span"));
        headerBtnProdavnica.click();

        WebElement optionLukoviBows = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
        optionLukoviBows.click();


        //    WebElement lukSamickSage = driver.findElement(By.xpath("//*[text()='Bow Samick Sage']"));


        WebElement lukoviBowsLink = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure"));
        lukoviBowsLink.click();

        WebElement articleTitle = driver.findElement(By.xpath ("//*[contains(text(),'Samick')]"));
        String actualTitle = articleTitle.getText();
        System.out.println(actualTitle);
    }
}
