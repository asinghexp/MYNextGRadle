package MYNEXTGRadle;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LocaliOSTest {

    private String accessKey = "eyJ4cC51IjozNDIzNTYsInhwLnAiOjIsInhwLm0iOiJNVFUzTWpRNU9UVTRNRFV3TWciLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4ODc4NTk1ODAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.Ma9vuJesB4w7uxkHpFr3WEnf5nCh4G1eLl5KmhxCxTQ";
    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeTest
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start iOS Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<>(new URL("https://demo.experitest.com/wd/hub"), dc);
    }

    @Test
    public void quickStartiOSNativeDemo() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
        driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
        driver.findElement(By.xpath("//*[@id='countryButton']")).click();
        driver.findElement(By.xpath("//*[@id='Switzerland']")).click();
        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@id='Yes']")).click();
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
}