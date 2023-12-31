package sorting;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static sorting.StartTesting.driver;

public class TestListener implements TestWatcher {
    @Override
    public void testSuccessful(ExtensionContext context) {
        Allure.getLifecycle().addAttachment(
                "screenshot"
                ,"image/png"
                ,"png"
                ,((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
    }
}
