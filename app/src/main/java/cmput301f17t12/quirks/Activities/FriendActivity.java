package cmput301f17t12.quirks.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import cmput301f17t12.quirks.Adapters.FriendListItemAdapter;
import cmput301f17t12.quirks.Helpers.HelperFunctions;
import cmput301f17t12.quirks.Models.Inventory;
import cmput301f17t12.quirks.Models.QuirkList;
import cmput301f17t12.quirks.Models.User;
import cmput301f17t12.quirks.R;

/**
 * Created by root on 11/29/17.
 */

public class FriendActivity extends SocialActivity {
    public User currentlylogged;
    private FriendListItemAdapter adapter;
    private ArrayList<User> friendlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences settings = getSharedPreferences("dbSettings", Context.MODE_PRIVATE);
        String jestID = settings.getString("jestID", "defaultvalue");

        if (jestID.equals("defaultvalue")) {
            Log.i("Error", "Did not find correct jestID");
        }

        Inventory dummyInv = new Inventory();
        ArrayList<User> friends = new ArrayList<>();
        ArrayList<User> requests = new ArrayList<>();
        QuirkList quirks = new QuirkList();
        User dummy = new User("dummy",dummyInv,friends,requests,quirks);
        User dummy2 = new User("dummy2",dummyInv,friends,requests,quirks);
        User dummy3 = new User("Alex",dummyInv,friends,requests,quirks);
        currentlylogged = HelperFunctions.getUserObject(jestID);
        super.onCreate(savedInstanceState);
        currentlylogged.addFriend(dummy);
        currentlylogged.addFriend(dummy2);
        currentlylogged.addFriend(dummy3);

        friendlist = currentlylogged.getFriends();
        adapter = new FriendListItemAdapter(friendlist,this);
        ListView lView = (ListView)findViewById(R.id.friendlistView);
        lView.setAdapter(adapter);


    }





    @Override
    int getContentViewId() {
        return R.layout.activity_friends;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.action_friends;
    }
}
