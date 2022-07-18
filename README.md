This Repository is part of my application as "Test-Engineer" at Otto (GmbH & Co KG).

The requirements were described as follows:

  "The QA coding challenge:
  Please develop two UI-test for www.otto.de:
  Please use Java and selenium for that. 
  The first testcase consists of the following steps:
  1)Go to www.otto.de
  2)Search for "Jeans"
  3)Open the first product
  4)Validate, that the product detail page contains the string "Artikelbeschreibung"
  
  Second Testcase:
  1)Go to www.otto.de
  2)Click in the navigation menu on "multimedia"
  3)Click in the left navigation on "Blu-Ray-Player"
  4)Open the first product
  5)Validate, that the product detail page contains the string "Artikelbeschreibung"
  
  Please write and document the code as you would normally do.
  Please also provide some kind of script to execute the tests and check, if they run through.
  
  You can upload the code to your github account or something similar. Please don't send an email with attachment."



------------------------------------------------------------------------------------------------------------------------
The Repository contains two important files, where the requirements are implemented. The first one is the file “Main.java” and in it has the script to execute the test. The second one is the Testcases.java file, in which the Testcases were programmed.

**********Configuration Section**********
Two Browsers are supported for this Task, Chrome and Firefox, and it can be controlled through a Variable named "Browser" in the “Main.java” file.
          String Browser = "Chrome";
                        Or
          String Browser = "Firefox";
If the variable is left empty or the Name of the Browser is not recognized, by default Browser is set to Firefox. For Example:
            String Browser = "Crome";            ->            Default Browser “Firefox”

Although one of the requirements is to search a specific string, the Testcases can search any desired string. through a Variable named “StringToSearch”. It only has to be setting the Variable as follows:
            String StringToSearch = "Artikelbeschreibung";
                                    Or
            String StringToSearch = "Artikel-N";
                                    Or
            String StringToSearch = "Details";
                                    etc.

There are two variables to configure the WebDriver of the Browser “BrowserWebDriver” and “WebDriverPath”
BrowserWebDriver is used to define the WebDriver and in which Browser it is going to perform the Testcases and it can set up as follows:
            BrowserWebDriver = "webdriver.chrome.driver";
                                    Or
            BrowserWebDriver = "webdriver.gecko.driver";

The variable to WebDriverPath difines where the WebDriver is located. Example:
            WebDriverPath = "C:\\Users\\migue\\Selenium\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe";
                                    Or
            WebDriverPath = "C:\\Users\\migue\\Selenium\\Drivers\\Firefox\\geckodriver-v0.31.0-win64\\geckodriver.exe";



**********Testcases**********
The Testcases were implemented in the File “Testcases.java”. There is one definition of a Class with 1 constructor and 2 Methods.
One of each method contains each of the required Testcase.
The constructor is used to set the property of the System.
The Methods Testcase1 and Testcase2 are used to execute the described Testcases of the challenge.

If the Page, in which the described Testcases are implemented, were changed, the following objects have to be checked to ensure that functionality of the Testcases.
            By.xpath("//*[@id=\"cookieBanner\"]/div/div/div[2]/button")
            By.xpath("/html/body/div[2]/div[1]/header/div[1]/div/div[3]/div[1]/form/div/div/input")
            By.xpath("//*[@id=\"san_resultSection\"]/article[1]")
            By.xpath("//*[@id=\"nav_menu\"]/div/div/div/ul/li[17]/a")
            By.xpath("//*[@id=\"find_localNavigation\"]/div/div[1]/div[1]/div[2]/ul/li[3]")
            By.xpath("//*[@id=\"san_resultSection\"]/article[1]")

