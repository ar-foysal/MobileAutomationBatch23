package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;
import java.time.Duration;

public class AppTest {
    public AndroidDriver driver;
    @BeforeTest
    public AndroidDriver startApp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:deviceName", "local");
        desiredCapabilities.setCapability("appium:udid", "emulator-5554");
        desiredCapabilities.setCapability("appium:appPackage", "com.androidsample.generalstore");
        desiredCapabilities.setCapability("appium:appActivity", "com.androidsample.generalstore.SplashActivity");

        URL remoteUrl = new URL("http://127.0.0.1:4723");


        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    @AfterTest
    public void quitApp(){
        driver.quit();
    }
    @Test
    public void testApp() throws MalformedURLException, InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Angola']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).clear();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(5000);
    }

}
