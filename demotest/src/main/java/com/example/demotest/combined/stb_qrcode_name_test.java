package com.example.demotest.combined;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
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
public class stb_qrcode_name_test {

    private AndroidDriver driver;
    private Date testStart;
    private long testStartTime;
    private int t = 2;


    public void setUp(String _deviceName, String _udid, String _platformVersion, int port) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", _deviceName);
        desiredCapabilities.setCapability("udid", _udid);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", _platformVersion);
        desiredCapabilities.setCapability("appPackage", "tw.com.mabow.mabowgo");
        desiredCapabilities.setCapability("appActivity", "tw.com.mabow.mabowgo.OnboardingActivity");
        desiredCapabilities.setCapability("androidInstallTimeout", "tw.com.mabow.mabowgo.OnboardingActivity");

        String _url = "http://127.0.0.1:" + port + "/wd/hub";
        URL remoteUrl = new URL(_url);

        //URL remoteUrl = new URL("http://127.0.0.1:4724/wd/hub");

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
        desiredCapabilities.setCapability("appPackage", "tw.com.mabow.mabowgo");
        desiredCapabilities.setCapability("appActivity", "tw.com.mabow.mabowgo.OnboardingActivity");

        String _url = "http://127.0.0.1:" + port_ + "/wd/hub";
        URL remoteUrl = new URL(_url);

        //URL remoteUrl = new URL("http://127.0.0.1:4724/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    /*@Test
    public void sampleTest1() throws InterruptedException {
        Thread.sleep(3000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
        Thread.sleep(3000);


    }*/


    @Test
    public void Test1() throws InterruptedException {

        GeneralFunction _generalFunction = new GeneralFunction();
        _generalFunction.getGitVersion();

        System.out.println("[STB] 電視檢查手機修改暱稱測試 開始");
        Reporter.log("[STB] 電視檢查手機修改暱稱測試 開始");

        Date testStart1 = new Date();
        long testStartTime1 = testStart1.getTime();

        testStartTime = testStart1.getTime();

        boolean isTestPass = true;

        Thread.sleep(10000);

        try {
            List<MobileElement> els = (List<MobileElement>) driver.findElementsById("tw.com.mabow.mabowgo:id/guidance_title");
            System.out.println("[STB] 條款頁");
            for (int i = 0; i < els.size(); i++) {
                System.out.println("[STB] " + els.get(i).getText());
            }
        } catch (NoSuchElementException e) {
            System.out.println("[STB] 無法開啟條款頁");
            Reporter.log("[STB] 無法開啟條款頁");
            isTestPass = false;
            Assert.assertEquals(isTestPass, true);  //force stop
        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));  //按按鍵往下
        Thread.sleep(1000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER)); //點擊確認同意服務條款
        Thread.sleep(3000);

        driver.pressKey(new KeyEvent(AndroidKey.PROG_RED));
        System.out.println("[STB] 按紅色鍵跳過動畫");
        Reporter.log("[STB] 按紅色鍵跳過動畫");

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(3000);
        System.out.println("[STB] 跳過廣告 OK");
        Reporter.log("[STB] 跳過廣告 OK");

        Date testAddAlbumDone = new Date();
        long testAddAlbumDoneTime = testAddAlbumDone.getTime();
        long diffTime = (testAddAlbumDoneTime - testStartTime1) / 1000;

        System.out.println("[STB] [PASS] 登入APP完成 時間總計 : " + diffTime + " 秒");
        Reporter.log("[STB] [PASS] 登入APP完成 時間總計 : " + diffTime + " 秒");


        // 主頁 切換至webview
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }

        // UI 切回 NATIVE_APP
        driver.context((String) contextNames.toArray()[0]);
        Thread.sleep(3000);

        Thread.sleep(20000);
        System.out.println("[STB] 等待手機掃描QRCODE修改暱稱1");
        Reporter.log("[STB] 等待手機掃描QRCODE修改暱稱1");
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));

        Thread.sleep(20000);
        System.out.println("[STB] 等待手機掃描QRCODE修改暱稱2");
        Reporter.log("[STB] 等待手機掃描QRCODE修改暱稱2");
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));

        Thread.sleep(20000);
        System.out.println("[STB] 等待手機掃描QRCODE修改暱稱3");
        Reporter.log("[STB] 等待手機掃描QRCODE修改暱稱3");
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));

        Thread.sleep(3000);
        System.out.println("[STB]  開始檢查手機是否修改暱稱 ");
        Reporter.log("[STB] 開始檢查手機是否修改暱稱");

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));  //按按鍵往下
        Thread.sleep(3000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));  //按按鍵往下
        Thread.sleep(3000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));  //按按鍵往下
        Thread.sleep(3000);
        MobileElement elsetting = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[4]/android.view.View/android.view.View[1]");
        String elText1 = elsetting.getText();
        System.out.println("欄位名稱:" + elText1);

        if(elText1.equals("設定"))
        {
            System.out.println("[STB] 成功移動至設定區");
            Reporter.log("[STB] 成功移動至設定區");
        }
        else
        {
            System.out.println("[STB] 沒有移動至設定區");
            Reporter.log("[STB] 沒有移動至設定區");
            isTestPass = false;
        }

        MobileElement elname = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[2]");
        String elText2 = elname.getText();
        System.out.println("帳戶名稱:" + elText2);

        if(elText2.equals("冠綸爺爺123"))
        {
            System.out.println("[STB] 用戶暱稱修改成功");
            Reporter.log("[STB] 用戶暱稱修改成功");
        }
        else
        {
            System.out.println("[STB] 用戶暱稱修改失敗");
            Reporter.log("[STB] 用戶暱稱修改失敗");
            isTestPass = false;
        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
        Thread.sleep(3000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
        Thread.sleep(3000);

        MobileElement eldemo = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]");
        String elText3 = eldemo.getText();
        System.out.println("欄位名稱:" + elText3);

        if(elText3.equals("體驗區"))
        {
            System.out.println("[STB] 成功移動至體驗區");
            Reporter.log("[STB] 成功移動至體驗區");
        }
        else
        {
            System.out.println("[STB] 沒有移動至體驗區");
            Reporter.log("[STB] 沒有移動至體驗區");
            isTestPass = false;
        }

        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.PROG_GREEN));
        System.out.println("[STB] 按綠色鍵進入體驗");
        Reporter.log("[STB] 按綠色鍵進入體驗");

        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.PROG_GREEN));
        System.out.println("[STB] 按綠鍵發送罐頭訊息檢查暱稱是否變更");
        Reporter.log("[STB] 按綠鍵發送罐頭訊息檢查暱稱是否變更");

        Thread.sleep(3000);
        MobileElement eltestname = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[1]");
        String elText4 = eltestname.getText();
        System.out.println("帳戶名稱:" + elText4);

        if(elText4.equals("冠綸爺爺123"))
        {
            System.out.println("[STB] 暱稱更改成功");
            Reporter.log("[STB] 暱稱更改成功");
        }
        else
        {
            System.out.println("[STB] 暱稱更改失敗");
            Reporter.log("[STB] 暱稱更改失敗");
            isTestPass = false;
        }

        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.PROG_RED));
        System.out.println("[STB] 按紅鍵離開");
        Reporter.log("[STB] 按紅鍵離開");

        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.PROG_RED));
        System.out.println("[STB] 再按一次紅鍵確定離開");
        Reporter.log("[STB] 再按一次紅鍵確定離開");

        Thread.sleep(20000);
        System.out.println("[STB] 等待手機掃描QRCODE改回暱稱1");
        Reporter.log("[STB] 等待手機掃描QRCODE修改暱稱1");
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));

        Thread.sleep(20000);
        System.out.println("[STB] 等待手機掃描QRCODE修改暱稱2");
        Reporter.log("[STB] 等待手機掃描QRCODE修改暱稱2");
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));

        Thread.sleep(3000);
        System.out.println("[STB]  開始檢查手機是否將暱稱改回 ");
        Reporter.log("[STB] 開始檢查手機是否將暱稱改回");

        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.PROG_GREEN));
        System.out.println("[STB] 按綠色鍵進入體驗");
        Reporter.log("[STB] 按綠色鍵進入體驗");

        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.PROG_GREEN));
        System.out.println("[STB] 按綠鍵發送罐頭訊息檢查暱稱是否變更");
        Reporter.log("[STB] 按綠鍵發送罐頭訊息檢查暱稱是否變更");

        Thread.sleep(3000);
        MobileElement eltestname2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[1]");
        String elText5 = eltestname2.getText();
        System.out.println("帳戶名稱:" + elText5);

        if(elText5.equals("冠綸爺爺"))
        {
            System.out.println("[STB] 暱稱恢復成功");
            Reporter.log("[STB] 暱稱恢復成功");
        }
        else
        {
            System.out.println("[STB] 暱稱恢復失敗");
            Reporter.log("[STB] 暱稱恢復失敗");
            isTestPass = false;
        }

        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.PROG_RED));
        System.out.println("[STB] 按紅鍵離開");
        Reporter.log("[STB] 按紅鍵離開");

        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.PROG_RED));
        System.out.println("[STB] 再按一次紅鍵確定離開");
        Reporter.log("[STB] 再按一次紅鍵確定離開");

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));  //按按鍵往下
        Thread.sleep(3000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));  //按按鍵往下
        Thread.sleep(3000);

        MobileElement elsetting2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[4]/android.view.View/android.view.View[1]");
        String elText6 = elsetting2.getText();
        System.out.println("欄位名稱:" + elText6);

        if(elText6.equals("設定"))
        {
            System.out.println("[STB] 成功移動至設定區");
            Reporter.log("[STB] 成功移動至設定區");
        }
        else
        {
            System.out.println("[STB] 沒有移動至設定區");
            Reporter.log("[STB] 沒有移動至設定區");
            isTestPass = false;
        }

        MobileElement elname3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[2]");
        String elText7 = elname3.getText();
        System.out.println("帳戶名稱:" + elText7);

        if(elText7.equals("冠綸爺爺"))
        {
            System.out.println("[STB] 用戶暱稱修改成功");
            Reporter.log("[STB] 用戶暱稱修改成功");
        }
        else
        {
            System.out.println("[STB] 用戶暱稱恢復失敗");
            Reporter.log("[STB] 用戶暱稱恢復失敗");
            isTestPass = false;
        }

        Date testViewNewAlbumDone = new Date();
        long testViewNewAlbumDoneTime = testViewNewAlbumDone.getTime();
        long diffTime2 = (testViewNewAlbumDoneTime - testStartTime1) / 1000;

        System.out.println("[STB] 出團測試完成 時間總計 : " + diffTime2 + " 秒");
        Reporter.log("[STB] 出團測試完成 時間總計 : " + diffTime2 + " 秒");

    }

}
