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
	String[] str = new String[] { "./resources/Appium/Appium.exe" };
	String[] str1 = new String[] { "./resources/scrcpy-win64/uiautomatorviewer.bat" };
	String[] capabilities = new String[] {"./resources/scrcpy-win64/adb","shell","dumpsys window windows | grep -E ‘mCurrentFocus’"};
	WebDriver driver;
	DesiredCapabilities dc = new DesiredCapabilities();
	
	public void connectadb() {
		/*
		 * //processes.add("cd /Users/edcast");
		 * //processes.add("adb shell screencap /sdcard/screen.png");
		 * //processes.add("adb pull /sdcard/screen.png"); try { Process ss = new
		 * ProcessBuilder("adb", "shell", "screencap", "/sdcard/screen.png").start(); }
		 * catch (Exception e) { // TODO Auto-generated catch block
		 * log.info("Exception "+e.getMessage()); }
		 */
		try {
			// Runtime.getRuntime().exec(str);
			Process pro = new ProcessBuilder(str).start();
			//BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			String line; 
			//while ((line = br.readLine()) != null) { log.info(line); }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		abc = "adb";
	}
	public void execute() throws InterruptedException, IOException {
		dc.setCapability("platformName","Android");
		dc.setCapability("platformVersion","9");
		//dc.setCapability("deviceName","JJ7AAB7601734FUD");
		dc.setCapability("deviceName","emulator-5554");

		//dc.setCapability("appPackage","com.asus.calculator");
		dc.setCapability("appPackage","com.android.calculator2");

		//dc.setCapability("appActivity","com.asus.calculator.Calculator");
		dc.setCapability("appActivity","com.android.calculator2.Calculator");

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//		driver.findElement(By.id("com.asus.calculator:id/digit3")).click();
//		Process pro = new ProcessBuilder(scrcpy).start();
		/* //This is for asus mobile
		 * driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.Button[11]"
		 * )).click();
		 * driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"plus\"]"
		 * )).click(); driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.Button[6]"
		 * )).click(); driver.findElement(By.xpath(
		 * "//android.widget.Button[@content-desc=\"equals\"]")).click();
		 */
//		driver.findElement(By.xpath("//button[contains(text(),'3')]")).click();
//		driver.findElement(By.xpath("//button[contains(text(),'+')]")).click();
//		driver.findElement(By.xpath("//button[contains(text(),'5')]")).click();
//		driver.findElement(By.xpath("//button[contains(text(),'=')]")).click();
		/*
		 * MobileElement el1 = (MobileElement) driver.findElement(By.id("digit3"));
		 * el1.click(); el1.click(); MobileElement el2 = (MobileElement)
		 * driver.findElement(By.id("plus")); el2.click(); MobileElement el3 =
		 * (MobileElement) driver.findElement(By.id("digit5")); el3.click();
		 * MobileElement el4 = (MobileElement) driver.findElement(By.id("equals"));
		 * el4.click();
		 *//*
			 * Thread.sleep(1000);
			 */
		//for emulator
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[9]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"multiply\"]")).click();
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[1]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"equals\"]")).click();
		//driver.quit();
	}
}
