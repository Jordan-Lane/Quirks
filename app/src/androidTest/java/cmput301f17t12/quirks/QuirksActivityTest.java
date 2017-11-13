package cmput301f17t12.quirks;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cmput301f17t12.quirks.Activities.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by root on 11/13/17.
 */


@RunWith(AndroidJUnit4.class)
public class QuirksActivityTest {
    String test;
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);
    private LoginActivity loginActivity;

    @Before
    public void initQuirk()
    {
        loginActivity = mActivityRule.getActivity();
    }

    @Test
    public void newQuirkButton(){
        Intents.init();
        onView(withId(R.id.loginUser)).perform(typeText("intenttesting"), closeSoftKeyboard());
        onView(withId(R.id.loginBtn)).perform(click());
        onView(withId(R.id.action_quirklist)).perform(click());
        onView(withId(R.id.add_quirk_button)).perform(click());
        onView(withId(R.id.CancelBut)).perform(click());
        Intents.release();

    }

}
