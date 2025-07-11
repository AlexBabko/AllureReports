package Helpers;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.Screenshot;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Attach {


    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }


    @Attachment(value = "Видео теста", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body>" +
                "<video width='100%' height='300' controls autoplay>" +
                "<source src='" + getVideoUrl() + "' type='video/mp4'>" +
                "Браузер не поддерживает видео-тег." +
                "</video>" +
                "</body></html>";
    }

    public static URL getVideoUrl() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();

        String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId + ".mp4";

        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to create video URL for session: " + sessionId, e);
        }
    }
}



