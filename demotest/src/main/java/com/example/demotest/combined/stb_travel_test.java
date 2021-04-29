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
public class stb_travel_test {

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

        System.out.println("[STB] 實境旅行出團測試 開始");
        Reporter.log("[STB] 實境旅行出團測試 開始");

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
        System.out.println("[STB] 跳過廣告 ");
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
        Thread.sleep(5000);

        System.out.println("[STB] 體驗全景照片");
        Reporter.log("[STB] 按藍色鍵體驗");
        Thread.sleep(1000);

        driver.pressKey(new KeyEvent(AndroidKey.PROG_BLUE));
        System.out.println("[STB] 按藍色鍵體驗");
        Reporter.log("[STB] 按藍色鍵體驗");

        WebDriverWait wait = new WebDriverWait(driver, 60);

        System.out.println("[STB] 檢查有沒有成功進入體驗全景照片模式");
        MobileElement el_control = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView");
        wait = new WebDriverWait(driver, 20);
        if (wait.until(ExpectedConditions.visibilityOf(el_control)) != null) {
            System.out.println("[STB] 成功進入體驗全景照片模式");
            Reporter.log("[STB] 成功進入體驗全景照片模式");
        } else {
            System.out.println("[STB] 沒有進入全景照片模式");
            Reporter.log("[STB] 沒有進入全景照片模式");
            isTestPass = false;
        }

        System.out.println("[STB] 開始體驗全景照片");
        Thread.sleep(1000);

        driver.longPressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
        System.out.println("[STB] 按方向鍵進行左移");
        Reporter.log("[STB] 按方向鍵進行左移");
        Thread.sleep(1000);

        driver.longPressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
        System.out.println("[STB] 按方向鍵進行右移");
        Reporter.log("[STB] 按方向鍵進行右移");
        Thread.sleep(1000);

        System.out.println("[STB] 體驗完畢");
        Reporter.log("[STB] 體驗完畢");
        Thread.sleep(1000);

        driver.pressKey(new KeyEvent(AndroidKey.PROG_RED));
        System.out.println("[STB] 按紅鍵返回");
        Reporter.log("[STB] 按紅鍵返回");
        Thread.sleep(10000);

        driver.pressKey(new KeyEvent(AndroidKey.PROG_GREEN));
        System.out.println("[STB] 按綠鍵進入候車室");
        Reporter.log("[STB] 按綠鍵進入候車室");
        Thread.sleep(10000);

        System.out.println("[STB] 檢查有沒有成功進入候車室");
        MobileElement el_travel = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout[5]/android.widget.RelativeLayout[2]");
        wait = new WebDriverWait(driver, 20);
        if (wait.until(ExpectedConditions.visibilityOf(el_travel)) != null) {
            System.out.println("[STB] 成功進入候車室");
            Reporter.log("[STB] 成功進入候車室");
        } else {
            System.out.println("[STB] 沒有進入候車室");
            Reporter.log("[STB] 沒有進入候車室");
            isTestPass = false;
        }

        driver.pressKey(new KeyEvent(AndroidKey.PROG_GREEN));
        System.out.println("[STB] 按綠鍵發送罐頭訊息");
        Reporter.log("[STB] 按綠鍵發送罐頭訊息");
        Thread.sleep(3000);

        MobileElement elname = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[1]");
        String elText1 = elname.getText();
        System.out.println("帳戶名稱:" + elText1);

        if(elText1.equals("冠綸爺爺"))
        {
            System.out.println("[STB] 罐頭訊息發送成功");
            Reporter.log("[STB] 罐頭訊息發送成功");
        }
        else
        {
            System.out.println("[STB] 罐頭訊息發送失敗");
            Reporter.log("[STB] 罐頭訊息發送失敗");
            isTestPass = false;
        }

        driver.pressKey(new KeyEvent(AndroidKey.PROG_YELLOW));
        System.out.println("[STB] 按黃色鍵發送語音留言");
        Reporter.log("[STB] 按黃色鍵發送語音留言");
        Thread.sleep(2000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(1000);
        System.out.println("[STB] 麥克風權限 OK");
        Reporter.log("[STB] 麥克風權限 OK");

        System.out.println("[STB] 檢查語音留言按鍵是否成功啟動");
        MobileElement elvoice = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[1]");
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        wait2.until(ExpectedConditions.visibilityOf(elvoice));
        System.out.println("[STB] [PASS] 語音留言啟動成功");
        Reporter.log("[STB] [PASS] 語音留言啟動成功");

        MobileElement notificationPage = (MobileElement) driver.findElementById("tw.com.mabow.mabowgo:id/img_ic_btn_blue");
        WebDriverWait wait3 = new WebDriverWait(driver, 300);
        wait3.until(ExpectedConditions.visibilityOf(notificationPage));
        System.out.println("[STB] [PASS] 導遊開始出團");
        Reporter.log("[STB] [PASS] 導遊開始出團");

        System.out.println("[STB] 體驗全景照片");
        Reporter.log("[STB] 按藍色鍵體驗");
        Thread.sleep(1000);

        driver.pressKey(new KeyEvent(AndroidKey.PROG_BLUE));
        System.out.println("[STB] 按藍色鍵體驗");
        Reporter.log("[STB] 按藍色鍵體驗");
        Thread.sleep(5000);

        System.out.println("[STB] 檢查有沒有成功進入體驗全景照片模式");
        MobileElement el_allscreen = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView");
        wait = new WebDriverWait(driver, 20);
        if (wait.until(ExpectedConditions.visibilityOf(el_allscreen)) != null) {
            System.out.println("[STB] 成功進入體驗全景照片模式");
            Reporter.log("[STB] 成功進入體驗全景照片模式");
        } else {
            System.out.println("[STB] 沒有進入全景照片模式");
            Reporter.log("[STB] 沒有進入全景照片模式");
            isTestPass = false;
        }

        System.out.println("[STB] 開始體驗全景照片");
        Thread.sleep(1000);

        driver.longPressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
        System.out.println("[STB] 按方向鍵進行左移");
        Reporter.log("[STB] 按方向鍵進行左移");
        Thread.sleep(1000);

        driver.longPressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
        System.out.println("[STB] 按方向鍵進行右移");
        Reporter.log("[STB] 按方向鍵進行右移");
        Thread.sleep(1000);

        System.out.println("[STB] 體驗完畢");
        Reporter.log("[STB] 體驗完畢");
        Thread.sleep(1000);

        driver.pressKey(new KeyEvent(AndroidKey.PROG_BLUE));
        System.out.println("[STB] 按藍鍵返回");
        Reporter.log("[STB] 按藍鍵返回");
        Thread.sleep(3000);

        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        System.out.println("[STB] 切換導遊視角");
        Reporter.log("[STB] 切換導遊視角");
        Thread.sleep(3000);

        MobileElement travel_end = (MobileElement) driver.findElementById("tw.com.mabow.mabowgo:id/img_live_score_3");
        WebDriverWait wait4 = new WebDriverWait(driver, 600);
        wait4.until(ExpectedConditions.visibilityOf(travel_end));
        System.out.println("[STB] [PASS] 導遊結束出團");
        Reporter.log("[STB] [PASS] 導遊結束出團");

       /* driver.pressKey(new KeyEvent(AndroidKey.PROG_RED));
        System.out.println("[STB] 按紅鍵離開");
        Reporter.log("[STB] 按紅鍵離開");
        Thread.sleep(1000);

        driver.pressKey(new KeyEvent(AndroidKey.PROG_RED));
        System.out.println("[STB] 按第二次紅鍵確認離開");
        Reporter.log("[STB] 按第二次紅鍵確認離開");
        Thread.sleep(1000);*/

        System.out.println("[STB] 檢查有沒有進入評分模式");
        MobileElement el_Grades = (MobileElement) driver.findElementById("tw.com.mabow.mabowgo:id/img_live_score_3");
        wait = new WebDriverWait(driver, 5);
        if (wait.until(ExpectedConditions.visibilityOf(el_Grades)) != null) {
            System.out.println("[STB] 進入評分模式成功");
            Reporter.log("[STB] 進入評分模式成功");
        } else {
            System.out.println("[STB] 進入評分模式失敗");
            Reporter.log("[STB] 進入評分模式失敗");
            isTestPass = false;
        }

        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        System.out.println("[STB] 導遊評分");
        Reporter.log("[STB] 導遊評分");
        Thread.sleep(3000);

        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        System.out.println("[STB] 景點評分");
        Reporter.log("[STB] 景點評分");
        Thread.sleep(3000);

        System.out.println("[STB] 檢查有沒有進入語音回饋");
        MobileElement el_voice = (MobileElement) driver.findElementById("tw.com.mabow.mabowgo:id/ic_speech_yellow_hint");
        wait = new WebDriverWait(driver, 20);
        if (wait.until(ExpectedConditions.visibilityOf(el_voice)) != null) {
            System.out.println("[STB] 進入語音回饋成功");
            Reporter.log("[STB] 進入語音回饋成功");
        } else {
            System.out.println("[STB] 進入評分模式失敗");
            Reporter.log("[STB] 進入評分模式失敗");
            isTestPass = false;
        }

        driver.pressKey(new KeyEvent(AndroidKey.PROG_YELLOW));
        System.out.println("[STB] 按黃色鍵發送語音留言");
        Reporter.log("[STB] 按黃色鍵發送語音留言");
        Thread.sleep(1000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Thread.sleep(1000);
        System.out.println("[STB] 麥克風權限 OK");
        Reporter.log("[STB] 麥克風權限 OK");

        System.out.println("[STB] 檢查語音回饋按鍵是否成功啟動");
        MobileElement elvoice2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[1]");
        WebDriverWait wait5 = new WebDriverWait(driver, 20);
        wait5.until(ExpectedConditions.visibilityOf(elvoice2));
        System.out.println("[STB] [PASS] 語音回饋啟動成功");
        Reporter.log("[STB] [PASS] 語音回饋啟動成功");

        driver.pressKey(new KeyEvent(AndroidKey.PROG_RED));
        System.out.println("[STB] 按紅鍵離開");
        Reporter.log("[STB] 按紅鍵離開");
        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));  //按按鍵往下
        Thread.sleep(1000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));  //按按鍵往下
        Thread.sleep(1000);

        MobileElement eldemo = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]");
        String elText2 = eldemo.getText();
        System.out.println("欄位名稱:" + elText2);

        if(elText2.equals("我的足跡"))
        {
            System.out.println("[STB] 成功移動至我的足跡");
            Reporter.log("[STB] 成功移動至我的足跡");
        }
        else
        {
            System.out.println("[STB] 沒有移動至我的足跡");
            Reporter.log("[STB] 沒有移動至我的足跡");
            isTestPass = false;
        }

        System.out.println("[STB] 檢查有沒有成功完成出團並記錄到紀念票根");
        MobileElement el_ticket = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View");
        wait = new WebDriverWait(driver, 20);
        if (wait.until(ExpectedConditions.visibilityOf(el_ticket)) != null) {
            System.out.println("[STB] 成功記錄到票根");
            Reporter.log("[STB] 成功記錄到票根");
        } else {
            System.out.println("[STB] 沒有票根");
            Reporter.log("[STB] 沒有票根");
            isTestPass = false;
        }

        Date testViewNewAlbumDone = new Date();
        long testViewNewAlbumDoneTime = testViewNewAlbumDone.getTime();
        long diffTime2 = (testViewNewAlbumDoneTime - testStartTime1) / 1000;

        System.out.println("[STB] 出團測試完成 時間總計 : " + diffTime2 + " 秒");
        Reporter.log("[STB] 出團測試完成 時間總計 : " + diffTime2 + " 秒");

    }

}
