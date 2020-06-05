package com.example.espressoviewaction;

import android.content.Context;
import android.content.Intent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SdkSuppress;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class UiAutomatorInstrumentedTest {

    private static final String BASIC_SAMPLE_PACKAGE
            = "com.example.espressoviewaction";
    private static final int LAUNCH_TIMEOUT = 5000;
    private UiDevice device;
    private UiSelector currentValueSelector = new UiSelector().description("currentValue");

    @Before
    public void startMainActivityFromHomeScreen() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();
        final String launcherPackage = device.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        Context context = ApplicationProvider.getApplicationContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        device.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);
    }

    @Test
    public void single() throws Exception {
        UiObject button = device.findObject(new UiSelector().text("SINGLE"));
        button.click();
        UiObject currentValueObject = device.findObject(currentValueSelector);
        currentValueObject.longClick();
        assertEquals("1", currentValueObject.getText());
        currentValueObject.longClick();
        assertEquals("1", currentValueObject.getText());
    }

    @Test
    public void continuous() throws Exception {
        UiObject button = device.findObject(new UiSelector().text("CONTINUOUS"));
        button.click();
        UiObject currentValueObject = device.findObject(currentValueSelector);
        currentValueObject.longClick();
        assertEquals("1", currentValueObject.getText());
        currentValueObject.longClick();
        assertEquals("2", currentValueObject.getText());
    }
}
