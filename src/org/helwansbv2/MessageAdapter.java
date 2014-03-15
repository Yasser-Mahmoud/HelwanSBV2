package org.helwansbv2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MessageAdapter extends ArrayAdapter<String[]> {
	
	private Context mContext;
	public ArrayList<String[]> messageListArray;
	private String[] message = null;
	
	Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy  h:m");
    String oldDATE = null;
    Boolean isFirstMsg = false;
	
	private final HistoryDatabase Hist_db = new HistoryDatabase(mContext);
	
	public MessageAdapter(Context context, int textViewResourceId,
			ArrayList<String[]> messageListArray) {
		super(context, textViewResourceId);
		this.messageListArray = messageListArray;
		this.mContext = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;
		if (convertView == null) {
			holder = new Holder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.bubble_message, parent, false);
			holder.date = (TextView) convertView.findViewById(R.id.message_date);
			holder.time = (TextView) convertView.findViewById(R.id.message_time);
			holder.content = (TextView) convertView.findViewById(R.id.message_text);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		message = getItem(position);
	    holder.date.setText(message[0]);
		holder.time.setText(message[1]);
		holder.content.setText(message[2]);

		return convertView;
	}

	@Override
	public int getCount() {
		return messageListArray.size();
	}

	@Override
	public String[] getItem(int position) {
		return messageListArray.get(position);
	}

	private class Holder {
		public TextView content, date, time;
	}
}

