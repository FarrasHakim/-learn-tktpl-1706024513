package id.ac.ui.cs.mobileprogramming.farras.myfirstapp;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentalTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testGreet() {
        onView(withId(R.id.greet_text))
                .check(matches(withText("")));
        onView(withId(R.id.name_input))
                .perform(typeText("Testy"), closeSoftKeyboard());
        onView(withId(R.id.greet_button)).perform(click());
        onView(withId(R.id.greet_text))
                .check(matches(withText("Hello there Testy!")));
    }
}
