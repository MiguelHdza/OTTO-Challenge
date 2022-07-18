package Test;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        try {
            //Configuration
            String Browser = "Chrome";
            String StringToSearch = "Artikelbeschreibung";
            //String ArtikelNr = "1";
            String BrowserWebDriver;
            String WebDriverPath;

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

            //Testcases
            Testcases TC = new Testcases(Browser,BrowserWebDriver, WebDriverPath);

            //Testcase1
            TC.Testcase1(StringToSearch);
            //Wait to the next Test
            Thread.sleep(3000);
            //Testcase2
            TC.Testcase2(StringToSearch);
            //Thread.sleep(3000);
        }
        //TODO ErrorHandler
//        catch (SecurityException e){
//
//        }
        finally
        {
            //Thread.sleep(1000);
        }
    }
}