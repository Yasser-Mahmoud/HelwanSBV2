package org.helwansbv2;

import android.content.Context;
import android.content.Intent;

public class displayMessage {
		
		static final String DISPLAY_MESSAGE_ACTION = "org.helwansbv2";
		static final String EXTRA_MESSAGE = "message";

		static void displayMessage(Context context, String message) {
	        Intent intent = new Intent(DISPLAY_MESSAGE_ACTION);
	        intent.putExtra(EXTRA_MESSAGE, message);
	        context.sendBroadcast(intent);
	    }
	}


