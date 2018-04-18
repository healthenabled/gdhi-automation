package core;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CustomScreenGrabber implements ICustomScreenshotGrabber {

    public byte[] takeScreenshot() {

        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
