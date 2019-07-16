package creator.components;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Inline {
	String abc = "Inline";
	List<String> processes = new ArrayList<String>();
	Logger log = LogManager.getLogger(Inline.class);
	String scrcpy  = "./resources/scrcpy-win64/scrcpy-noconsole.exe";
	//Appium application address - change address according to the location of Appium
	String[] str = new String[] { "./resources/Appium/Appium.exe" };
	//Location of Uiautomator
	String[] str1 = new String[] { "./resources/scrcpy-win64/uiautomatorviewer.bat" };
	//When setting the capabilities - You cannot set capabilities manually so below function gives us the android version, AppPackage, AppActivity
	String[] capabilities = new String[] {"./resources/scrcpy-win64/adb","shell","dumpsys window windows | grep -E ‘mCurrentFocus’"};
	WebDriver driver;
	DesiredCapabilities dc = new DesiredCapabilities();
	
	//this is sample function to check if adb is working properly and the connectivity status
	public void connectadb() {
		/*
		 *	//Uncomment below code if you need adb to take screenshot on mobile and save the .png file on your computer
		 *
		 *
		 * //processes.add("cd /Users/edcast");
		 * //processes.add("adb shell screencap /sdcard/screen.png");
		 * //processes.add("adb pull /sdcard/screen.png"); try { Process ss = new
		 * ProcessBuilder("adb", "shell", "screencap", "/sdcard/screen.png").start(); }
		 * catch (Exception e) { // TODO Auto-generated catch block
		 * log.info("Exception "+e.getMessage()); }
		 */
		try {
			// Runtime.getRuntime().exec(str);
			Process pro = new ProcessBuilder(str).start(); //change the constructor parameter to whatever is desired
			//BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			String line; 
			//while ((line = br.readLine()) != null) { log.info(line); }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		abc = "adb";
	}

	/*
	 * The below function starts the Appium server and gives desired capabilities for selenium
	 * The Minimum 5 properties required for proper working are :-
	 * $platformName - e.g- Android/iOS
	 * $platformVersion - e.g- Android Version/iOS version - 7,7.1,8,9,10,etc
	 * $deviceName - Obtained via adb devices
	 * $appPackage - This tells the package name, mainly app name
	 * 					Obtained via adb shell -> "dumpsys window windows | grep -E ‘mCurrentFocus’" command
	 * $appActivity - This tells the current Activity running inside app, e.g- main_activity,main_activity2,etc
	 * 					Obtained via adb shell -> "dumpsys window windows | grep -E ‘mCurrentFocus’" command
	 * 
	*/
	public void execute() throws InterruptedException, IOException {
		dc.setCapability("platformName","Android");
		dc.setCapability("platformVersion","9");
		//dc.setCapability("deviceName","JJ7AAB7601734FUD"); //set This capability for asus mobile
		dc.setCapability("deviceName","emulator-5554"); //set This capability for sdk emulator

		//dc.setCapability("appPackage","com.asus.calculator");
		dc.setCapability("appPackage","com.android.calculator2"); //default calculator app

		//dc.setCapability("appActivity","com.asus.calculator.Calculator");
		dc.setCapability("appActivity","com.android.calculator2.Calculator"); // default calculator main activity

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//		driver.findElement(By.id("com.asus.calculator:id/digit3")).click();
		
		  //This is for asus mobile - below code uses absolute xpaths for asus default calculator
//		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.Button[11]")).click();
//		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"plus\"]")).click(); 
//		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.Button[6]")).click(); 
//		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"equals\"]")).click();
		 
		//below code does not work or takes too much time as the xpath specified is relative, do not use such type of xpaths
//		driver.findElement(By.xpath("//button[contains(text(),'3')]")).click();
//		driver.findElement(By.xpath("//button[contains(text(),'+')]")).click();
//		driver.findElement(By.xpath("//button[contains(text(),'5')]")).click();
//		driver.findElement(By.xpath("//button[contains(text(),'=')]")).click();
		
		//for emulator - below code uses absolute xpaths
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[9]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"multiply\"]")).click();
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[1]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"equals\"]")).click();
		//driver.quit();
	}
}
