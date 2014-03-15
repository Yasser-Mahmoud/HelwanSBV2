package org.helwansbv2;

import java.io.IOException;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;


/**
 * Activity which displays a registration screen to the user.
 */
public class RegisterActivity extends Activity implements OnItemSelectedListener {

	/**
	 * The default email to populate the email field with.
	 */
	public static final String EXTRA_EMAIL = "com.example.android.authenticatordemo.extra.EMAIL";

	/**
	 * Keep track of the register task to ensure we can cancel it if requested.
	 */
	private UserRegisterTask mRegTask = null;

	// Values for email and password at the time of the register attempt.
	private String mName;
	private String mEmail;
	private String mMobile;
	private String mSpinner;

	// UI references.
	private EditText mNameView;
	private EditText mEmailView;
	private EditText mMobileView;
	private Spinner mSpinnerView;
	private View mRegisterFormView;
	private View mRegisterStatusView;
	private TextView mRegStatusMessageView;
	
	final Context mContext = this;
	
	// GCM references
	String SENDER_ID = "700505043315";
	private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
	public static final String PROPERTY_REG_ID = "registration_id";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    GoogleCloudMessaging gcm;
    String regid;

    //Shared preferences used to persist GCM preferences
    SharedPreferences prefs;
    
    /**
     * Tag used on log messages.
     */
    static final String TAG = "Helwan SB v2";
	
	// Connection detector
	ConnectionDetector cd;
	
	// Alert dialog manager
	AlertDialogManager alert = new AlertDialogManager();

	//Home Activity Intent
	//Intent i = new Intent(getApplicationContext(), Home.class);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_register);
			
		checkPlayServices();

		// Set up the register form.
		mNameView = (EditText) findViewById(R.id.name);
		mEmail = getIntent().getStringExtra(EXTRA_EMAIL);
		mEmailView = (EditText) findViewById(R.id.email);
		mEmailView.setText(mEmail);
		mMobileView = (EditText) findViewById(R.id.mobile);

		mSpinnerView = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.committee_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpinnerView.setAdapter(adapter);
		mSpinnerView.setOnItemSelectedListener(this);
		
		mRegisterFormView = findViewById(R.id.register_form);
		mRegisterStatusView = findViewById(R.id.register_status);
		mRegStatusMessageView = (TextView) findViewById(R.id.register_status_message);

		findViewById(R.id.register_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						// Check if Internet present
						cd = new ConnectionDetector(getApplicationContext());
						if (!cd.isConnectingToInternet()) {
							alert.showAlertDialog(RegisterActivity.this, 
									"Internet Connection Error", 
									"Please connect to working Internet connection", false);
							return;
						}
						
						// Check device for Play Services APK. If check succeeds, proceed with GCM registration.
				        if (checkPlayServices()) {
				        	attemptRegisteration();
				        } else {
				            Log.i(TAG, "No valid Google Play Services APK found.");
				        }
					}
				});
	}

	//@Override
	//public boolean onCreateOptionsMenu(Menu menu) {
		//super.onCreateOptionsMenu(menu);
		//getMenuInflater().inflate(R.menu.login, menu);
		//return true;
	//}

	/**
	 * Attempts to register the account specified by the Registration form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual registration attempt is made.
	 */
	public void attemptRegisteration() {
		if (mRegTask != null) {
			return;
		}

		// Reset errors
		mNameView.setError(null);
		mEmailView.setError(null);
		mMobileView.setError(null);

		// Store values at the time of the login attempt
		mName = mNameView.getText().toString();
		mEmail = mEmailView.getText().toString();
		mMobile = mMobileView.getText().toString();
		mSpinner = mSpinnerView.getSelectedItem().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password
		if (TextUtils.isEmpty(mMobile)) {
			mMobileView.setError(getString(R.string.error_field_required));
			focusView = mMobileView;
			cancel = true;
		} else if (mMobile.length() < 13) {
			mMobileView.setError(getString(R.string.error_incorrect_mobile));
			focusView = mMobileView;
			cancel = true;
		}

		// Check for a valid email address
		if (TextUtils.isEmpty(mEmail)) {
			mEmailView.setError(getString(R.string.error_field_required));
			focusView = mEmailView;
			cancel = true;
		} else if (!mEmail.contains("@")) {
			mEmailView.setError(getString(R.string.error_invalid_email));
			focusView = mEmailView;
			cancel = true;
		}

		// Check for a valid name
		if (TextUtils.isEmpty(mName)) {
			mNameView.setError(getString(R.string.error_field_required));
			focusView = mNameView;
			cancel = true;
		}
		
		if (cancel) {
			// There was an error; don't attempt registration and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {
			// Show a progress spinner, and kick off a background task to
			// perform the user registration attempt.
			mRegStatusMessageView.setText(R.string.registering);
			showProgress(true);
			
			mRegTask = new UserRegisterTask();
			mRegTask.execute((Void) null);
		}
	}

	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mRegisterStatusView.setVisibility(View.VISIBLE);
			mRegisterStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mRegisterStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});

			mRegisterFormView.setVisibility(View.VISIBLE);
			mRegisterFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mRegisterFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mRegisterStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mRegisterFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	/**
	 * Registers the application with GCM servers asynchronously.
	 * <p>
	 * Stores the registration ID and app versionCode in the application's
	 * shared preferences.
	 */
	public class UserRegisterTask extends AsyncTask<Void, Void, String> {
		
		
		

		protected String doInBackground(Void... params) {
			String msg = "";
			try {
				if (gcm == null) {
                    gcm = GoogleCloudMessaging.getInstance(mContext);
				}
				regid = gcm.register(SENDER_ID);
				msg = "Device registered, registration ID=" + regid;
				
				// Persist the regID - no need to register again.
                storeRegistrationId(mContext, regid);
				
				// Send user's name, email, mobile and position to our server
				ServerUtilities.register(mContext, mName, mEmail, mMobile, mSpinner, regid);
				
				
				
			} catch (IOException e) {
				msg = "Error :" + e.getMessage();
                
			}
			return msg;
		}

		@Override
		protected void onPostExecute(String msg) {
			Log.i(TAG, msg);
			mRegTask = null;
			showProgress(false);
			startActivity(new Intent(getApplicationContext(), Home.class));
			finish();
		}

		@Override
		protected void onCancelled() {
			mRegTask = null;
			showProgress(false);
		}
	}
	
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
	        long id) {
	    // On selecting a spinner item
	}
	
	@Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
 
    }
	
	/**
	 * Check the device to make sure it has the Google Play Services APK. If
	 * it doesn't, display a dialog that allows users to download the APK from
	 * the Google Play Store or enable it in the device's system settings.
	 */
	private boolean checkPlayServices() {
	    int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
	    if (resultCode != ConnectionResult.SUCCESS) {
	        if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
	            GooglePlayServicesUtil.getErrorDialog(resultCode, this,
	                    PLAY_SERVICES_RESOLUTION_REQUEST).show();
	        } else {
	            Log.i(TAG, "This device is not supported.");
	            Toast.makeText(mContext, "No valid Google Play Services APK found. " +
	            		"This device is not supported", Toast.LENGTH_LONG).show();
	            finish();
	        }
	        return false;
	    }
	    return true;
	}
	
	/**
	 * Stores the registration ID and app versionCode in the application's
	 * {@code SharedPreferences}.
	 *
	 * @param context application's context.
	 * @param regId registration ID
	 */
	private void storeRegistrationId(Context context, String regId) {
	    final SharedPreferences prefs = getGCMPreferences(context);
	    int appVersion = getAppVersion(context);
	    Log.i(TAG, "Saving regId on app version " + appVersion);
	    SharedPreferences.Editor editor = prefs.edit();
	    editor.putString(PROPERTY_REG_ID, regId);
	    editor.putInt(PROPERTY_APP_VERSION, appVersion);
	    editor.commit();
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
	
}



