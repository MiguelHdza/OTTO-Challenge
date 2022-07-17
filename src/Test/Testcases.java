package Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
//import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Testcases {
    public String Browser;
    public String BrowserWebDriver;
    public String WebDriverPath;
    public WebDriver driver;
    public WebDriverWait Wait ;
    public Testcases(String Browser) {
        //WebDriver driver;

        this.Browser = Browser;
        if (Browser.equals("Chrome")) {
            //For Chrome
            BrowserWebDriver = "webdriver.chrome.driver";
            WebDriverPath = "C:\\Users\\migue\\Selenium\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe";
            System.setProperty(BrowserWebDriver,WebDriverPath);
        } else {
            //For Firefox
            BrowserWebDriver = "webdriver.gecko.driver";
            WebDriverPath = "C:\\Users\\migue\\Selenium\\Drivers\\Firefox\\geckodriver-v0.31.0-win64\\geckodriver.exe";
            System.setProperty(BrowserWebDriver,WebDriverPath);
        }

        LogFile("Constructor");
    }

    public void Testcase1 (String StringToSearch) {
        try
        {
            if (Browser.equals("Chrome")) {
                driver = new ChromeDriver();            //For Chrome
            } else {
                driver = new FirefoxDriver();           //For Firefox
            }

            Wait = new WebDriverWait(driver, Duration.ofSeconds(50));

            driver.manage().window().maximize();
            driver.get("https://www.otto.de");

            //Accept All Cookies
            Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cookieBanner\"]/div/div/div[2]/button"))).click();

            //Search for "Jeans"
            WebElement SearchBox = driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[1]/div/div[3]/div[1]/form/div/div/input"));
            SearchBox.sendKeys("Jeans");
            SearchBox.sendKeys(Keys.ENTER);

            //Open the first product
            Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"san_resultSection\"]/article[1]"))).click();

            //Validate, that the product detail page contains the string "Artikelbeschreibung"
            if ( driver.getPageSource().contains(StringToSearch)){
                System.out.println("Text: " + StringToSearch + " found. ");
                LogFile("Text: " + StringToSearch + " found. ");
            } else {
                System.out.println("Text: " + StringToSearch + " not found. ");
                LogFile("Text: " + StringToSearch + " not found. ");
            }
        }
        finally
        {
            //Thread.sleep(3000);
            driver.close();
            //driver.quit();
        }
    }

    public void Testcase2 (String StringToSearch) {
        try
        {
            if (Browser.equals("Chrome")) {
                driver = new ChromeDriver();                //For Chrome
            } else {
                driver = new FirefoxDriver();               //For Firefox
            }

            Wait = new WebDriverWait(driver, Duration.ofSeconds(50));

            driver.manage().window().maximize();
            driver.get("https://www.otto.de");

            //Accept All Cookies
            Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cookieBanner\"]/div/div/div[2]/button"))).click();

            //Click in the navigation menu on "multimedia"
            Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav_menu\"]/div/div/div/ul/li[17]/a"))).click();

            //Click in the left navigation on "Blu-Ray-Player"
            Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"find_localNavigation\"]/div/div[1]/div[1]/div[2]/ul/li[3]"))).click();

            //Open the first product
            Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"san_resultSection\"]/article[1]"))).click();

            //Validate, that the product detail page contains the string "Artikelbeschreibung"
            if (driver.getPageSource().contains(StringToSearch)){
                System.out.println("Text: " + StringToSearch + " found. ");
                LogFile("Text: " + StringToSearch + " found. ");
            } else {
                System.out.println("Text: " + StringToSearch + " not found. ");
                LogFile("Text: " + StringToSearch + " not found. ");
            }
        }
        finally
        {
            //Thread.sleep(3000);
            driver.close();
            //driver.quit();
        }
    }

    //TODO LogFile
    private static void LogFile (String LogText){

        Logger logger = Logger.getLogger("TestLog");
        FileHandler fh;

        try {
            fh = new FileHandler(System.getProperty("user.home") + "/MyLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info(LogText);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
