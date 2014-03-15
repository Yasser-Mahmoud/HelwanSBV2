/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.helwansbv2;

//import org.helwansbv2.Home.ResultReceiver;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.helwansbv2.Home.ResultReceiver;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

/**
 * This {@code IntentService} does the actual handling of the GCM message.
 * {@code GcmBroadcastReceiver} (a {@code WakefulBroadcastReceiver}) holds a
 * partial wake lock for this service while the service does its work. When the
 * service is finished, it calls {@code completeWakefulIntent()} to release the
 * wake lock.
 */
public class GcmIntentService extends IntentService {
    public static final int NOTIFICATION_ID = 1;
    private NotificationManager mNotificationManager;
    NotificationCompat.Builder builder;
    
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf_date = new SimpleDateFormat("d MMM yyyy");
    SimpleDateFormat sdf_time = new SimpleDateFormat("H:m");
    
    Message message;
    
    HistoryDatabase Hist_db;
 
    public GcmIntentService() {
        super("GcmIntentService");
    }
    public static final String TAG = "Helwan SB v2";

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        String content = intent.getExtras().getString("price").trim();
        String date = sdf_date.format(c.getTime());
        String time = sdf_time.format(c.getTime());
        
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        // The getMessageType() intent parameter must be the intent you received
        // in your BroadcastReceiver.
        String messageType = gcm.getMessageType(intent);

        if (!extras.isEmpty()) {  // has effect of unparcelling Bundle
            /*
             * Filter messages based on message type. Since it is likely that GCM will be
             * extended in the future with new message types, just ignore any message types you're
             * not interested in, or that you don't recognize.
             */
            if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
                sendNotification("Send error: " + extras.toString());
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED.equals(messageType)) {
                sendNotification("Deleted messages on server: " + extras.toString());
            // If it's a regular GCM message, do some work.
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
            	
            	String[] message = {date, time, content};
            	
            	//message = new Message();
            	//message.messageContent = content;
            	//message.messageDate = sdf_date.format(c.getTime());
            	//message.messageTime = sdf_time.format(c.getTime());
            	
            	Hist_db = new HistoryDatabase(this);
            	Hist_db.addMessage(message);
            	Log.i("Helwan SB v2", "Successfuly added new message");
            	
            	Intent broadcastIntent = new Intent();
            	broadcastIntent.setAction(ResultReceiver.ACTION_RESP);
            	broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            	broadcastIntent.putExtra("date", date);
            	broadcastIntent.putExtra("time", time);
            	broadcastIntent.putExtra("content", content);
            	sendBroadcast(broadcastIntent);
            	
                // Post notification of received message.
            	sendNotification(content);
                Log.i(TAG, "Received: " + extras.toString());
            }
        }
        // Release the wake lock provided by the WakefulBroadcastReceiver.
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    // Put the message into a notification and post it.
    // This is just one simple example of what you might choose to do with
    // a GCM message.
    private void sendNotification(String msg) {
        mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, Home.class), 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.ic_launcher)
        .setContentTitle("Helwan SB")
        .setStyle(new NotificationCompat.BigTextStyle()
        .bigText(msg))
        .setDefaults(Notification.DEFAULT_SOUND)
        .setDefaults(Notification.DEFAULT_VIBRATE)
        .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}
