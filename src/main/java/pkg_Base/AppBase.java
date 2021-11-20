package pkg_Base;

import java.io.IOException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AppBase {	
	
	public static WebDriver driver;
	public static String userDir = System.getProperty("user.dir");

	public void launch() {
		driver.get("https://dd7dev.oneshield.com/osdd/");
		//driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(130, TimeUnit.SECONDS);
	}

	public void setBrowser(String browsername) {

		if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browsername.equalsIgnoreCase("chrome")) {
			// path setup of chrome before launching
			System.setProperty("webdriver.chrome.driver", userDir + "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}

		if (browsername.equalsIgnoreCase("ie")) {
			// path setup of ie before launching
			System.setProperty("webdriver.ie.driver", userDir + "//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

	}

	public static String captureScreenshot(String TcName, WebDriver driver) throws IOException {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy hh mm ss");
		String currentDate = df.format(date);
		// String currentDate=date.toString();
		String path = userDir + "//Screenshots//" + TcName + "" + currentDate + ".png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(path));
		return path;
	}

}