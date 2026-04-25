package com.example.hw04_gymlog_v300;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testAddGymLog() {
        onView(withId(R.id.exerciseInputEditText))
                .perform(typeText("Bench Press"), closeSoftKeyboard());

        onView(withId(R.id.weightInputEditText))
                .perform(typeText("225"), closeSoftKeyboard());

        onView(withId(R.id.repInputEditText))
                .perform(typeText("5"), closeSoftKeyboard());

        onView(withId(R.id.logButton))
                .perform(click());

        onView(withText("Bench Press"))
                .check(matches(isDisplayed()));
    }
}
