package com.example.demotest.combined;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

@Listeners(GenerateReport.class)
public class stb_install_test {

    private AndroidDriver driver;

    @BeforeTest
    @Parameters(value = {"Device_", "UDID_", "platformVersion_", "port_", "app_"})
    public void setCapabilities(String Device_, String UDID_, String platformVersion_, int port_, String app_) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", Device_);
        desiredCapabilities.setCapability("udid", UDID_);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", platformVersion_);
        desiredCapabilities.setCapability("appPackage", "tw.com.mabow.liveinteraction");
        desiredCapabilities.setCapability("appActivity", "tw.com.mabow.liveinteraction.OnboardingActivity");
        desiredCapabilities.setCapability("app", app_);
        desiredCapabilities.setCapability("androidInstallTimeout", 600000);

        String _url = "http://127.0.0.1:" + port_ + "/wd/hub";
        URL remoteUrl = new URL(_url);

        //URL remoteUrl = new URL("http://127.0.0.1:4724/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    @Test
    public void Test1() throws InterruptedException {

        GeneralFunction _generalFunction = new GeneralFunction();
        _generalFunction.getGitVersion();

        System.out.println("[STB] ??????????????????");
        Reporter.log("[STB] ??????????????????");

        Date testStart = new Date();
        long testStartTime = testStart.getTime();

        boolean isTestPass = true;

        Thread.sleep(10000);


        try {
            List<MobileElement> els = (List<MobileElement>) driver.findElementsById("tw.com.mabow.liveinteraction:id/guidedactions_item_title");
            System.out.println("[STB] ?????????");
            for (int i = 0; i < els.size(); i++) {
                System.out.println("[STB] " + els.get(i).getText());
            }
        } catch (NoSuchElementException e) {
            System.out.println("[STB] ?????????????????????");
            Reporter.log("[STB] ?????????????????????");
            isTestPass = false;
            Assert.assertEquals(isTestPass, true);  //force stop
        }
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(3000);

        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.PROG_RED));
        System.out.println("[STB] ????????????????????????");
        Reporter.log("[STB] ????????????????????????");
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(1000);
        System.out.println("[STB] ???????????? OK");
        Reporter.log("[STB] ???????????? OK");

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(1000);
        System.out.println("[STB] ??????1 OK");
        Reporter.log("[STB] ??????1 OK");

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(1000);
        System.out.println("[STB] ??????2 OK");
        Reporter.log("[STB] ??????2 OK");

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(1000);
        System.out.println("[STB] ??????3 OK");
        Reporter.log("[STB] ??????3 OK");

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(1000);
        System.out.println("[STB] ??????4 OK");
        Reporter.log("[STB] ??????4 OK");

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        System.out.println("[STB] ??????5 OK");
        Reporter.log("[STB] ??????5 OK");

        Thread.sleep(20000);

        // ?????? ?????????webview
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }

        // UI ?????? WEBVIEW_tw.com.mabow.liveinteraction
        driver.context((String) contextNames.toArray()[1]);
        Thread.sleep(1000);

        System.out.println("[STB] [PASS] ?????????????????? webview");
        Reporter.log("[STB] [PASS] ?????????????????? webview");

        Date testDone = new Date();
        long testDoneTime = testDone.getTime();
        long diffTime = (testDoneTime - testStartTime) / 1000;

        System.out.println("[STB] [PASS] ??????APP?????? ???????????? : " + diffTime + " ???");
        Reporter.log("[STB] [PASS] ??????APP?????? ???????????? : " + diffTime + " ???");

        System.out.println("[STB] ??????????????????:" + isTestPass);
        Reporter.log("[STB] ??????????????????:" + isTestPass);

        Assert.assertEquals(isTestPass, true);
    }


    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
