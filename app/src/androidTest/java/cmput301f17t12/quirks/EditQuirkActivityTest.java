package cmput301f17t12.quirks;

import android.support.test.espresso.contrib.PickerActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.DatePicker;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cmput301f17t12.quirks.Activities.EditQuirkActivity;
import cmput301f17t12.quirks.Activities.LoginActivity;
import cmput301f17t12.quirks.Activities.QuirksActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

/**
 * Created by root on 11/13/17.
 */

//Note before testing make sure intentTesting has quirks inside its quirklist
@RunWith(AndroidJUnit4.class)
public class EditQuirkActivityTest {
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
    public void EditQuirkTitleTest(){
        Intents.init();
        onView(withId(R.id.loginUser)).perform(typeText("intest3"), closeSoftKeyboard());
        onView(withId(R.id.loginBtn)).perform(click());
        onView(withId(R.id.action_quirklist)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.quirk_listview)).atPosition(0).
                perform(click());
        onView(withId(R.id.QuirkeditTextTitle)).perform(replaceText("EditQuirkTitleTest"), closeSoftKeyboard());
        onView(withId(R.id.SaveBut)).perform(click());
        intended(hasComponent(QuirksActivity.class.getName()));
        onData(anything()).inAdapterView(withId(R.id.quirk_listview)).atPosition(1).perform(click());
        onView(withId(R.id.QuirkeditTextTitle)).check(matches(withText("EditQuirkTitleTest")));
        Intents.release();

    }
//    @Test
//    public void EditQuirkType(){
//        Intents.init();
//        onView(withId(R.id.loginUser)).perform(typeText("intest3"), closeSoftKeyboard());
//        onView(withId(R.id.loginBtn)).perform(click());
//        onView(withId(R.id.action_quirklist)).perform(click());
//        onData(anything()).inAdapterView(withId(R.id.quirk_listview)).atPosition(0).perform(click());
//        onView(withId(R.id.QuirkeditTextType)).perform(replaceText("EditQuirkTypeTest"), closeSoftKeyboard());
//        onView(withId(R.id.SaveBut)).perform(click());
//        intended(hasComponent(QuirksActivity.class.getName()));
//        onData(anything()).inAdapterView(withId(R.id.quirk_listview)).atPosition(0).perform(click());
//        onView(withId(R.id.QuirkeditTextType)).check(matches(withText("EditQuirkTypeTest")));
//        Intents.release();
//    }
//
//    @Test
//    public void EditQuirkReason(){
//        Intents.init();
//        onView(withId(R.id.loginUser)).perform(typeText("intest3"), closeSoftKeyboard());
//        onView(withId(R.id.loginBtn)).perform(click());
//        onView(withId(R.id.action_quirklist)).perform(click());
//        onData(anything()).inAdapterView(withId(R.id.quirk_listview)).atPosition(0).perform(click());
//        onView(withId(R.id.QuirkeditTextReason)).perform(replaceText("EditQuirkReasonTest"), closeSoftKeyboard());
//        onView(withId(R.id.SaveBut)).perform(click());
//        intended(hasComponent(QuirksActivity.class.getName()));
//        onData(anything()).inAdapterView(withId(R.id.quirk_listview)).atPosition(0).perform(click());
//        onView(withId(R.id.QuirkeditTextReason)).check(matches(withText("EditQuirkReasonTest")));
//        Intents.release();
//
//    }
//
//    @Test
//    public void EditQuirkGoal(){
//        Intents.init();
//        onView(withId(R.id.loginUser)).perform(typeText("intest3"), closeSoftKeyboard());
//        onView(withId(R.id.loginBtn)).perform(click());
//        onView(withId(R.id.action_quirklist)).perform(click());
//        onData(anything()).inAdapterView(withId(R.id.quirk_listview)).atPosition(0).perform(click());
//        onView(withId(R.id.QuirkeditTextGoal)).perform(replaceText(String.valueOf("25")));
//        onView(withId(R.id.SaveBut)).perform(click());
//        intended(hasComponent(QuirksActivity.class.getName()));
//        onData(anything()).inAdapterView(withId(R.id.quirk_listview)).atPosition(0).perform(click());
//        onView(withId(R.id.QuirkeditTextGoal)).check(matches(withText("25")));
//        Intents.release();
//    }
//
//    @Test
//    public void EditQuirkCancel(){
//        Intents.init();
//        onView(withId(R.id.loginUser)).perform(typeText("intest"), closeSoftKeyboard());
//        onView(withId(R.id.loginBtn)).perform(click());
//        onView(withId(R.id.action_quirklist)).perform(click());
//        onData(anything()).inAdapterView(withId(R.id.quirk_listview)).atPosition(0).perform(click());
//        onView(withId(R.id.CancelBut)).perform(click());
//        intended(hasComponent(QuirksActivity.class.getName()));
//        Intents.release();
//    }
//
//    @Test
//    public void EditQuirkDelete(){
//        Intents.init();
//
//        onView(withId(R.id.loginUser)).perform(typeText("intest"), closeSoftKeyboard());
//        onView(withId(R.id.loginBtn)).perform(click());
//        //Create a Quirk to be deleted
//        onView(withId(R.id.action_quirklist)).perform(click());
//        onView(withId(R.id.add_quirk_button)).perform(click());
//        onView(withId(R.id.QuirkeditTextTitle)).perform(typeText("Title"), closeSoftKeyboard());
//        onView(withId(R.id.QuirkeditTextType)).perform(typeText("Type"),closeSoftKeyboard());
//        onView(withId(R.id.QuirkeditTextGoal)).perform(typeText(String.valueOf("15")));
//        onView(withId(R.id.QuirkeditTextReason)).perform(typeText("Reason"),closeSoftKeyboard());
//        int year  = 2017;
//        int monthOfYear  = 11;
//        int dayOfMonth =  25;
//        onView( withId(R.id.textViewSelDate)).perform(click());
//        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).
//                perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));
//        onView(withId(android.R.id.button1)).perform(click());
//
//        onView(withId(R.id.QuirkEditradioButtonMon)).perform(click());
//        onView(withId(R.id.SaveBut)).perform(click());
//        //Delete the Quirk
//        onView(withId(R.id.action_quirklist)).perform(click());
//        onData(anything()).inAdapterView(withId(R.id.quirk_listview)).atPosition(1).perform(click());
//        onView(withId(R.id.DeleteBut)).perform(click());
//        intended(hasComponent(QuirksActivity.class.getName()));
//        Intents.release();
//    }







    }
