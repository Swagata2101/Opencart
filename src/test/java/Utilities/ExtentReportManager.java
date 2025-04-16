package Utilities;

import java.awt.Desktop;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testcase.BaseClass;

public class ExtentReportManager implements ITestListener  {
         public ExtentSparkReporter sparkRepoter;
         public ExtentReports extent;
         public ExtentTest test;
         
         String repName;
         public void onStart(ITestContext testContext) {
        	/* SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        	 Date dt=new Date(0);
        	 String currentdatetimestamp=df.format(dt);*/
        	 
        	 String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        	 repName="Test-Report-" +timeStamp +".html";
        	 sparkRepoter =new ExtentSparkReporter(".\\reports\\"+repName);
        	 sparkRepoter.config().setReportName("Tutorialsninja functional testing");
        	 sparkRepoter.config().setTheme(Theme.DARK);
        	 
        	 extent=new ExtentReports();
        	 extent.attachReporter(sparkRepoter);
        	 extent.setSystemInfo("Application", "Tutorialsninja");
        	 extent.setSystemInfo("Module", "Admin");
        	 extent.setSystemInfo("Sub Module", "Customers");
        	 extent.setSystemInfo("User Name", System.getProperty("User.name"));
        	 extent.setSystemInfo("Environemnt", "QA");
        	 
        	 String os=testContext.getCurrentXmlTest().getParameter("os");
        	 extent.setSystemInfo("Operating system", os);
        	 
        	 String browser=testContext.getCurrentXmlTest().getParameter("browser");
        	 extent.setSystemInfo("browser", browser);
        	 
        	 List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
        	 if(includedGroups.isEmpty())
        		 extent.setSystemInfo("Groups", includedGroups.toString());
         }
         public void onTestSucccess(ITestResult result) {
        	 test=extent.createTest(result.getTestClass().getName());
        	 test.assignCategory(result.getMethod().getGroups());//to display groups in report
        	 test.log(Status.PASS, result.getName()+"got successfully executed");
         }
         public void onTestFailure(ITestResult result) {
        	 test=extent.createTest(result.getTestClass().getName());
        	 test.assignCategory(result.getMethod().getGroups());
        	 test.log(Status.FAIL, result.getName()+"Got Failed");
        	 test.log(Status.INFO, result.getThrowable().getMessage());
        	 
        	 try {
        		 String imgpath=new BaseClass().captureScreen(result.getName());
        		 test.addScreenCaptureFromPath(imgpath);
        	 }
        	 catch(IOException e1) {
                   e1.printStackTrace();
        		 }
      }
        		 public void onTestSkipped(ITestResult result) {
        		 test=extent.createTest(result.getTestClass().getName());
        		 test.assignCategory(result.getMethod().getGroups());
        		 test.log(Status.SKIP, result.getName()+"got Skipped");
        		 test.log(Status.INFO, result.getThrowable().getMessage());
        	 }
        	 public void onFinish(ITestContext testContext) {
        		 extent.flush();
        		 String pathofExtentReport= System.getProperty("user.dir")+".\\reports\\"+repName;
        		 File extentReport=new File(pathofExtentReport);
        		 try {
        			 Desktop.getDesktop().browse(extentReport.toURI());
        		 }
        		 catch(IOException e) {
        			 e.printStackTrace();
        		 }
        		 
        	/* try {
        		 URL url=new
        				 URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
        		 //Create the email message
        		 ImageHtmlEmail email=new ImageHtmlEmail();
        		 email.setDataSourceResolver(new DataSourceUrlResolver(url));
        		 email.setHostName("smtp.googlemail.com");
        		 email.setSmtpPort(465);
        		 email.setAuthenticator(new DefaultAuthenticator("John213@gmail.com","John@21"));
        		 email.setSSLOnConnect(true);
        		 email.setFrom("John213@gmail.com");
        		 email.setSubject("Test Results");
        		 email.setMsg("Please find Attached Report..........");
        		 email.addTo("pavanKumar,busyqa@gmail.com");
        		 email.attach(url,"extent report","please check report");
        		 email.send();
        	 }
        	 catch(Exception e) {
        		 e.printStackTrace();
        		 
        	 }*/
        	 
        	 
        	 
        	 
         }
         
         
}
