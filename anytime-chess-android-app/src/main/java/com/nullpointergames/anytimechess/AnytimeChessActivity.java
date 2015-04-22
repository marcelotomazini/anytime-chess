package com.nullpointergames.anytimechess;

import static com.nullpointergames.anytimechess.utils.Preferences.PLAYER;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.nullpointergames.anytimechess.layouts.ContentView;
import com.nullpointergames.anytimechess.message.HandShakeManager;
import com.nullpointergames.anytimechess.utils.Alerts;
import com.nullpointergames.anytimechess.utils.Messages;
import com.nullpointergames.anytimechess.utils.Preferences;
import com.nullpointergames.anytimechess.utils.TelephonyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AnytimeChessActivity extends ActionBarActivity {

    public static final int PICK_CONTACT_REQUEST = 1;
    RecyclerView mRecyclerView;
    ContentView drawer;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawer = new ContentView(this);
        setContentView(drawer);

        setSupportActionBar(drawer.getToolbar());

        mRecyclerView = drawer.getRecyclerView();
        mRecyclerView.setAdapter(new MyAdapter(getGames(), this));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawer,
                drawer.getToolbar(),
                getResources().getIdentifier("open_drawer", "strings", getPackageName()),
                getResources().getIdentifier("close_drawer", "strings", getPackageName())){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }
        };
        drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    private List<String> getGames() {
        List<String> games = buildGamesList();

        for (String player : getPlayers())
            games.add(player);

        return games;
    }

    private List<String> buildGamesList() {
        List<String> games = new ArrayList<>();
        games.add(Messages.getString(Messages.GAMES_IN_PROGRESS));
        return games;
    }

    private Set<String> getPlayers() {
        return new Preferences(this).getSharedPreferences().getAll().keySet();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, Messages.getString(Messages.NEW_GAME));
		menu.add(0, 0, 0, Messages.getString(Messages.ABOUT));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle().equals(Messages.getString(Messages.NEW_GAME)))
            openContacts();
        if(item.getTitle().equals(Messages.getString(Messages.ABOUT)))
            showAbout();

        return super.onOptionsItemSelected(item);
    }

    private void showAbout() {
        AlertDialog.Builder ok = new AlertDialog.Builder(this);
        ok.setMessage("Anytime Chess");
	    ok.setPositiveButton("OK", null);
	    ok.show();
    }

    private void openContacts() {
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, AnytimeChessActivity.PICK_CONTACT_REQUEST);
    }

    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Check which request we're responding to
	    if (requestCode == PICK_CONTACT_REQUEST) {
	        if (resultCode == RESULT_OK) {
	        	Uri contactUri = data.getData();
	            String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};

	            Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
	            cursor.moveToFirst();

	            String player = TelephonyUtils.filterNumber(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
				new HandShakeManager(this).newChallenge(player);

	            String playerName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                cursor.close();

				new Alerts(this).displayBundleMessage("challenge.sent", playerName);
	        }
	    }
	}

    @Override
    protected void onResume() {
        super.onResume();
        loadGame();
    }

    private void loadGame() {
        Bundle extras = getIntent().getExtras();
        if (extras == null || extras.getString(PLAYER) == null)
            return;

        drawer.load(extras.getString(PLAYER));
    }

    public ContentView getDrawer() {
        return drawer;
    }
}
