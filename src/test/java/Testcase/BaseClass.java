package Testcase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {

    public static WebDriver driver;
    public Logger logger;

    @BeforeClass(groups= {"Sanity","Regression","Master","Datadriven"})
    @Parameters({"os","browser"})
    public void setup(String os,String br) {
        // Initializing logger
    	  File logDir = new File(System.getProperty("user.dir") + "/logs");
    	    if (!logDir.exists()) {
    	        logDir.mkdirs();
    	    }

        logger = LogManager.getLogger(this.getClass());
        switch(br.toLowerCase()) {
        case "chrome" : driver=new ChromeDriver();break;
        case "firefox" : driver=new FirefoxDriver();break;
        case "edge" : driver=new EdgeDriver();break;
        default :System.out.println("invalid browser name");return;
        }
        
        driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterClass(groups= {"Sanity","Regression","Master","Datadriven"})
	void teardown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
	public String randomstring() {
		String generaterand=RandomStringUtils.randomAlphabetic(5);
		return generaterand;
		
	}
	public String randomanumeric() {
	String generatenumber=RandomStringUtils.randomNumeric(10);
				return generatenumber;
	}
	public String randomAlphaNumeric(){
		String generatepass=RandomStringUtils.randomAlphabetic(5);
		String geeratepass=RandomStringUtils.randomNumeric(5);
		return (generatepass+"@" +geeratepass);
	}
	public String captureScreen(String tname) throws IOException{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot= (TakesScreenshot)driver;
		File sourceFile= takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilepath=System.getProperty("user.dir")+"\\screenshot\\"+tname+"_"+timeStamp+ ".png";
		File targetFile=new File(targetFilepath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilepath;
	}
	
	}

