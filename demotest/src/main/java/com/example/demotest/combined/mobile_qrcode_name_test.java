
package com.example.demotest.combined;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

//import org.junit.Test;

public class mobile_qrcode_name_test {

    private AndroidDriver driver;
    private Date testStart;
    private long testStartTime;

    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "HTC U");
        desiredCapabilities.setCapability("udid", "FA71S1701819");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "8.0");
        desiredCapabilities.setCapability("appPackage", "tw.com.mabow");
        desiredCapabilities.setCapability("appActivity", "tw.com.mabow.v3.activity.MainActivity");

        URL remoteUrl = new URL("http://127.0.0.1:4724/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @BeforeTest
    @Parameters(value = {"Device_", "UDID_", "platformVersion_", "port_"})
    public void setCapabilities(String Device_, String UDID_, String platformVersion_, int port_) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", Device_);
        desiredCapabilities.setCapability("udid", UDID_);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", platformVersion_);
        desiredCapabilities.setCapability("appPackage", "tw.com.mabow");
        desiredCapabilities.setCapability("appActivity", "tw.com.mabow.v3.activity.MainActivity");

        String _url = "http://127.0.0.1:" + port_ + "/wd/hub";
        URL remoteUrl = new URL(_url);

        //URL remoteUrl = new URL("http://127.0.0.1:4724/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        testStart = new Date();
        testStartTime = testStart.getTime();
    }

    @Test
    public void Test1() throws InterruptedException {

        System.out.println("[??????] ??????QRcode ????????????");

        Date testStart1 = new Date();
        long testStartTime1 = testStart1.getTime();

        boolean isTestPass = true;

        Thread.sleep(1000);

        // ?????? ?????????webview

        WebDriverWait wait = new WebDriverWait(driver, 60);

        Thread.sleep(3000);
        System.out.println("[??????] ????????????MabowHome??????");
        Reporter.log("[??????] ????????????MabowHome??????");
        MobileElement el_skip = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button");
        wait = new WebDriverWait(driver, 20);
        if (wait.until(ExpectedConditions.visibilityOf(el_skip)) != null) {
            System.out.println("[??????] ?????????");
            Reporter.log("[??????] ?????????");
            driver.pressKey(new KeyEvent(AndroidKey.HOME));
            System.out.println("???home?????????????????????");
        } else {
            System.out.println("[??????] ?????????");
            Reporter.log("[??????] ?????????");
            isTestPass = false;
        }

        Thread.sleep(5000);
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"QR?????????\"]");
        el1.click();
        System.out.println("[??????] ????????????QRCODE APP");

        Thread.sleep(3000);
        System.out.println("[??????] ????????????QRcodeAPP");
        Reporter.log("[??????] ????????????QRcodeAPP??????");
        MobileElement el_QRcodeAPP = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/b.r.a.f/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button[1]");
        wait = new WebDriverWait(driver, 20);
        if (wait.until(ExpectedConditions.visibilityOf(el_QRcodeAPP)) != null) {
            System.out.println("[??????] ????????????app");
            Reporter.log("[??????] ????????????app");

        } else {
            System.out.println("[??????] ????????????");
            Reporter.log("[??????] ????????????");
            isTestPass = false;
        }

        Thread.sleep(5000);
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/b.r.a.f/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button[2]");
        el2.click();
        System.out.println("[??????] ?????? ????????????");

        Thread.sleep(5000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView[1]");
        el3.click();
        System.out.println("[??????] ?????? QRcode??????");

        System.out.println("[??????] ????????????????????????????????????");
        MobileElement elinternet = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]");
        WebDriverWait wait2 = new WebDriverWait(driver, 300);
        wait2.until(ExpectedConditions.visibilityOf(elinternet));
        System.out.println("[??????] [PASS] ????????????");
        Reporter.log("[??????] [PASS] ????????????");

        Thread.sleep(5000);
        MobileElement el4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"??????\"]");
        el4.click();
        System.out.println("[??????] ?????? ????????????");

        System.out.println("[??????] ????????????????????????????????????");
        MobileElement elInternet = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView[1]");
        WebDriverWait wait3 = new WebDriverWait(driver, 300);
        wait3.until(ExpectedConditions.visibilityOf(elInternet));
        System.out.println("[??????] [PASS] ????????????");
        Reporter.log("[??????] [PASS] ????????????");

        Thread.sleep(5000);
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.LinearLayout[3]");
        el5.click();
        System.out.println("[??????] ?????? ????????????");

        // ?????? ?????????webview
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames)
        {
            System.out.println(contextName);

            // UI ?????? WEBVIEW_tw.com.mabow
            if(contextName.equals("WEBVIEW_chrome"))
            {
                driver.context(contextName);
                Thread.sleep(5000);
            }
        }

        Thread.sleep(3000);
        System.out.println("[??????] ????????????Mabowgo????????????");
        Reporter.log("[??????] ????????????Mabowgo????????????");
        MobileElement el_picture = (MobileElement) driver.findElementByXPath("//div[@id=\"user-info-root\"]/div[1]/img");
        wait = new WebDriverWait(driver, 200);
        if (wait.until(ExpectedConditions.visibilityOf(el_picture)) != null) {
            System.out.println("[??????] ????????????QRcde??????");
            Reporter.log("[??????] ?????????");
        } else {
            System.out.println("[??????] ?????????");
            Reporter.log("[??????] ?????????");
            isTestPass = false;
        }

        Thread.sleep(5000);

        System.out.println("[??????] ????????????");
        MobileElement el6 = (MobileElement) driver.findElementByXPath("//div[@id=\"user-info-main\"]/div[2]/input");
        el6.clear();
        el6.sendKeys("????????????123");

        Thread.sleep(5000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("//button[@id=\"save-btn\"]");
        el7.click();
        System.out.println("[??????] ?????? ????????????");

        Thread.sleep(20000);
        System.out.println("[??????] ????????????????????????1");
        (new TouchAction(driver)).tap(PointOption.point(250, 674)).perform();

        Thread.sleep(20000);
        System.out.println("[??????] ????????????????????????2");
        (new TouchAction(driver)).tap(PointOption.point(250, 674)).perform();

        Thread.sleep(20000);
        System.out.println("[??????] ????????????????????????3");
        (new TouchAction(driver)).tap(PointOption.point(250, 674)).perform();

        System.out.println("[??????] ????????????");
        MobileElement el8 = (MobileElement) driver.findElementByXPath("//div[@id=\"user-info-main\"]/div[2]/input");
        el8.clear();
        el8.sendKeys("????????????");

        Thread.sleep(5000);
        MobileElement el9 = (MobileElement) driver.findElementByXPath("//button[@id=\"save-btn\"]");
        el9.click();
        System.out.println("[??????] ?????? ????????????");

        Date testAddAlbumDone = new Date();
        long testAddAlbumDoneTime = testAddAlbumDone.getTime();
        long diffTime = (testAddAlbumDoneTime - testStartTime1) / 1000;

        System.out.println("[??????] ??????QRcode?????????????????? ???????????? : " + diffTime + " ???");
        Reporter.log("[??????] ??????QRcode???????????? ???????????? : " + diffTime + " ???");

        System.out.println("[??????] ??????QRcode????????????:" + isTestPass);
        Reporter.log("[??????] ??????QRcode????????????:" + isTestPass);

        Assert.assertEquals(isTestPass, true);

    }
}


