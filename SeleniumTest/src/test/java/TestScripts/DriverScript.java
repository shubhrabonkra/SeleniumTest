package TestScripts;

import java.lang.reflect.Method;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestScripts.AutomationScriptXero;

public class DriverScript extends ReusableMethods{
	public static WebDriver driver;
	public static Properties prop;
	public static String status="true";
	
	public static void loadProperty()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/utility/config.properties");
			prop.load(ip);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Test
	public static void mainMethod() throws Exception{
		String cur_dir=System.getProperty("user.dir");
		String dt_Path = cur_dir+"\\src\\test\\resources\\Utility\\TestSuite.xls";
		String testCase =null;
		String flag = null;
		System.out.println("execution started from driverfile");
		initializeExtentReport("salesforceTestscriptsReport");
		String[][] TestSuitedata = readxlData(dt_Path,"Sheet1");
		for(int i = 1; i< TestSuitedata.length; i++) {
			flag = TestSuitedata[i][1];
			if(flag.equalsIgnoreCase("Y")) {
					testCase = TestSuitedata[i][0];
					Method testScript = AutomationScriptXero.class.getMethod(testCase);
					testScript.invoke(testScript);
					
				}else {
					System.out.println("**********Row  number "+ i+" test case Name "+ TestSuitedata[i][0]+" is not Executed*********");
				}
				
			
			
			
		}
		
		endExtentReport();
	}

}