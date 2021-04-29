package com.example.demotest.combined;

import org.testng.Reporter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GeneralFunction {

    public void getGitVersion() {
        System.out.println("檢查測試程式版本");

        try {
            String command = "git describe --tags";
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            String text = command + "\n";
            System.out.println(text);

            while ((line = input.readLine()) != null) {
                text += line;
                System.out.println("程式 版本tag = " + line);
                Reporter.log("程式 版本tag =" + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
