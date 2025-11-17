package UtilsFile;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class UtilsPage {
    public static void saveEmployee(String username,String password,String confirmPassword) throws IOException, ParseException {
        String filePath="src/test/resources/employee.json";
        JSONParser parser=new JSONParser();
        JSONArray addedArray= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject addedObject=new JSONObject();
        addedObject.put("UserName",username);
        addedObject.put("Password",password);
        addedObject.put("ConfirmPassword",confirmPassword);
        addedArray.add(addedObject);
        FileWriter writer=new FileWriter(filePath);
        writer.write(addedArray.toJSONString());
        writer.flush();
        writer.close();

    }

    public static void scrollBy(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 60)");
    }
}
