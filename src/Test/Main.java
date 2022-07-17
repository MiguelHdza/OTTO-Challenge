package Test;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        try {
            //Configuration
            String Browser = "Chrome";
            String StringToSearch = "Artikelbeschreibung";

            Testcases TC = new Testcases(Browser);

            TC.Testcase1(StringToSearch);
            Thread.sleep(3000);
            TC.Testcase2(StringToSearch);
            Thread.sleep(3000);
        }
        //TODO ErrorHandler
//        catch (SecurityException e){
//
//        }
        finally
        {
            Thread.sleep(3000);
        }
    }
}