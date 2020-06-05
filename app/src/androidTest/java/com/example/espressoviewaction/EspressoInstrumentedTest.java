package com.example.espressoviewaction;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class EspressoInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void single() {
        onView(withId(R.id.single)).perform(click());
        onView(withId(R.id.text)).perform(longClick()).check(matches(withText("1")));
        onView(withId(R.id.text)).perform(longClick()).check(matches(withText("1")));
    }

    @Test
    public void continuous() {
        onView(withId(R.id.continuous)).perform(click());
        onView(withId(R.id.text)).perform(longClick()).check(matches(withText("1")));
        onView(withId(R.id.text)).perform(longClick()).check(matches(withText("2")));
    }
}
