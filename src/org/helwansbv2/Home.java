package org.helwansbv2;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class Home extends ActionBarActivity implements
		ActionBar.TabListener {
	
	String regid;
	
	/**
     * Tag used on log messages.
     */
    static final String TAG = "Helwan SB v2";
    
    public static final String PROPERTY_REG_ID = "registration_id";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    
	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	// Tab titles
	private String[] tabs = { "Inbox", "YouTube", "About us" };
	
	ResultReceiver reciver;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		IntentFilter filter = new IntentFilter(ResultReceiver.ACTION_RESP);
		filter.addCategory(Intent.CATEGORY_DEFAULT);
		reciver = new ResultReceiver();
        registerReceiver(reciver, filter);
		
		//Check if already registered or not
		regid = getRegistrationId(this);		
		if (regid.equals("")) {
			Intent i = new Intent(this, RegisterActivity.class);
			startActivity(i);
			finish();
		}

		// Initilization
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getSupportActionBar();
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);		

				// Adding Tabs
				for (String tab_name : tabs) {
					actionBar.addTab(actionBar.newTab().setText(tab_name)
							.setTabListener(this));
				}


		/**
		 * on swiping the viewpager make respective tab selected
		 * */
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}
	
	@Override
	protected void onDestroy() {
		super.onPause();
		unregisterReceiver(reciver);
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// on tab selected
		// show respected fragment view
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}
	

	/**
	 * @return Application's {@code SharedPreferences}.
	 */
	private SharedPreferences getGCMPreferences(Context context) {
	    return getSharedPreferences(RegisterActivity.class.getSimpleName(),
	            Context.MODE_PRIVATE);
	}
	
	/**
	 * @return Application's version code from the {@code PackageManager}.
	 */
	private static int getAppVersion(Context context) {
	    try {
	        PackageInfo packageInfo = context.getPackageManager()
	                .getPackageInfo(context.getPackageName(), 0);
	        return packageInfo.versionCode;
	    } catch (NameNotFoundException e) {
	        // should never happen
	        throw new RuntimeException("Could not get package name: " + e);
	    }
	}
	
	/**
     * Gets the current registration ID for application on GCM service, if there is one.
     * <p>
     * If result is empty, the app needs to register.
     *
     * @return registration ID, or empty string if there is no existing
     *         registration ID.
     */
    private String getRegistrationId(Context context) {
        final SharedPreferences prefs = getGCMPreferences(context);
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        if (registrationId.isEmpty()) {
            Log.i(TAG, "Registration not found.");
            return "";
        }
        // Check if app was updated; if so, it must clear the registration ID
        // since the existing regID is not guaranteed to work with the new
        // app version.
        int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
        int currentVersion = getAppVersion(context);
        if (registeredVersion != currentVersion) {
            Log.i(TAG, "App version changed.");
            return "";
        }
        return registrationId;
    }
    
    public class ResultReceiver extends BroadcastReceiver {
    	   public static final String ACTION_RESP =    
    	      "org.helwansbv2";
    	    
    	   @Override
    	   public void onReceive(Context context, Intent intent) {
    	       String date = intent.getStringExtra("date");
    	       String time = intent.getStringExtra("time");
    		   String content = intent.getStringExtra("content");
    		   
    		   String[] msg = {date, time, content};
    		   
    	       Inbox inbox = (Inbox) getSupportFragmentManager().
    	    		   findFragmentByTag("android:switcher:" + R.id.pager+":0");
    	       inbox.addNewMessage(msg);
    	   }
    }

}
