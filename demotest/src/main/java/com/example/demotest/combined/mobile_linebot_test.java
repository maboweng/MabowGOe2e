
package com.example.demotest.combined;

import net.bytebuddy.dynamic.scaffold.MethodGraph;

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

import javax.swing.plaf.basic.BasicBorders;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

//import org.junit.Test;

public class mobile_linebot_test {

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

        System.out.println("[??????] linebot?????? ????????????");

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
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"LINE\"]\n");
        el1.click();
        System.out.println("[??????] ??????line APP");

        Thread.sleep(3000);
        System.out.println("[??????] ????????????lineAPP");
        Reporter.log("[??????] ????????????lineapp??????");
        MobileElement el_QRcodeAPP = (MobileElement) driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"@{bottomNavigationBarButtonViewModel.contentDescription\"])[2]/android.widget.TextView");
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
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView");
        el2.click();
        System.out.println("[??????] ?????? ??????QRcode");

        MobileElement el_lineQRcodeAPP = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        wait = new WebDriverWait(driver, 20);
        if (wait.until(ExpectedConditions.visibilityOf(el_lineQRcodeAPP)) != null) {
            System.out.println("[??????] ??????????????????");
            Reporter.log("[??????] ??????????????????");

        } else {
            System.out.println("[??????] ????????????");
            Reporter.log("[??????] ????????????");
            isTestPass = false;
        }

        Thread.sleep(5000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ImageView");
        el3.click();
        System.out.println("[??????] ?????? ????????????");

        Thread.sleep(5000);
        MobileElement el4 = (MobileElement) driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"??????\"])[1]");
        el4.click();
        System.out.println("[??????] ????????????");

        System.out.println("[??????] ????????????????????????????????????");
        MobileElement elinternet = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]");
        WebDriverWait wait2 = new WebDriverWait(driver, 300);
        wait2.until(ExpectedConditions.visibilityOf(elinternet));
        System.out.println("[??????] [PASS] ????????????");
        Reporter.log("[??????] [PASS] ????????????");

        Thread.sleep(5000);
        MobileElement el5 = (MobileElement) driver.findElementByXPath("\t/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]");
        el5.click();
        System.out.println("[??????] ?????? ??????");

        System.out.println("[??????] ?????????????????????????????????");
        MobileElement elchrome = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.widget.Image");
        WebDriverWait wait3 = new WebDriverWait(driver, 300);
        wait3.until(ExpectedConditions.visibilityOf(elchrome));
        System.out.println("[??????] [PASS] ????????????");
        Reporter.log("[??????] [PASS] ????????????");

        Thread.sleep(5000);
        MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View[1]");
        el6.click();
        System.out.println("[??????] ?????? ??????");

        System.out.println("[??????] ???????????????????????????linebot????????????");
        MobileElement ellinebot = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"??????\"]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView");
        WebDriverWait wait4 = new WebDriverWait(driver, 300);
        wait4.until(ExpectedConditions.visibilityOf(ellinebot));
        System.out.println("[??????] [PASS] ????????????");
        Reporter.log("[??????] [PASS] ????????????");

        Thread.sleep(5000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"??????\"]");
        el7.click();
        System.out.println("[??????] ???????????????????????? ");

        Thread.sleep(5000);
        MobileElement el8 = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"??????\"]");
        el8.click();
        System.out.println("[??????] ?????????????????? ");

        System.out.println("[??????] ?????????????????????????????????");
        MobileElement ellist = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"??????\"]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView");
        WebDriverWait wait5 = new WebDriverWait(driver, 300);
        wait5.until(ExpectedConditions.visibilityOf(ellist));
        System.out.println("[??????] [PASS] ????????????");
        Reporter.log("[??????] [PASS] ????????????");

        Date testAddAlbumDone = new Date();
        long testAddAlbumDoneTime = testAddAlbumDone.getTime();
        long diffTime = (testAddAlbumDoneTime - testStartTime1) / 1000;

        (new TouchAction(driver)).tap(PointOption.point(453, 1982)).perform();
        System.out.println("????????????????????????");
        Thread.sleep(5000);

        System.out.println("[??????] ???????????????????????????????????????");
        MobileElement elreservation = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout");
        WebDriverWait wait6 = new WebDriverWait(driver, 300);
        wait6.until(ExpectedConditions.visibilityOf(elreservation));
        System.out.println("[??????] [PASS] ????????????");
        Reporter.log("[??????] [PASS] ????????????");
        Thread.sleep(5000);

        MobileElement el9 = (MobileElement) driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"??????\"])[2]");
        el9.click();
        System.out.println("[??????] ????????????");
        Thread.sleep(5000);

        (new TouchAction(driver)).tap(PointOption.point(1178, 1785)).perform();
        System.out.println("??????????????????");
        Thread.sleep(5000);

        System.out.println("[??????] ???????????????????????????????????????");
        MobileElement elcheck = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]");
        WebDriverWait wait7 = new WebDriverWait(driver, 300);
        wait7.until(ExpectedConditions.visibilityOf(elcheck));
        System.out.println("[??????] [PASS] ????????????");
        Reporter.log("[??????] [PASS] ????????????");
        Thread.sleep(5000);

        System.out.println("[??????] ??????????????????????????? ");
MobileElement elcheck2 = (MobileElement)driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View");
        wait = new WebDriverWait(driver, 20);
        if (wait.until(ExpectedConditions.visibilityOf(elcheck2)) != null) {
            System.out.println("[??????] ????????????");
            Reporter.log("[??????] ????????????");

        } else {
            System.out.println("[??????] ????????????");
            Reporter.log("[??????] ????????????");
            isTestPass = false;
        }

        MobileElement el10 = (MobileElement) driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"??????\"])[2]");
        el10.click();
        System.out.println("[??????] ????????????");
        Thread.sleep(5000);

        (new TouchAction(driver)).tap(PointOption.point(1175, 2226)).perform();
        System.out.println("??????????????????");
        Thread.sleep(5000);

        System.out.println("[??????] ?????????????????????????????????");
        MobileElement elweb = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.widget.Image");
        WebDriverWait wait8 = new WebDriverWait(driver, 300);
        wait8.until(ExpectedConditions.visibilityOf(elweb));
        System.out.println("[??????] [PASS] ??????????????????");
        Reporter.log("[??????] [PASS] ??????????????????");
        Thread.sleep(5000);

        MobileElement el11 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView");
        el11.click();
        System.out.println("[??????] ????????????");
        Thread.sleep(5000);



        System.out.println("[??????] ??????QRcode?????????????????? ???????????? : " + diffTime + " ???");
        Reporter.log("[??????] ??????QRcode???????????? ???????????? : " + diffTime + " ???");

        System.out.println("[??????] ??????QRcode????????????:" + isTestPass);
        Reporter.log("[??????] ??????QRcode????????????:" + isTestPass);

        Assert.assertEquals(isTestPass, true);

    }
}


