package org.helwansbv2;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class Inbox extends ListFragment {
	private MessageAdapter msgAdapter;
	private ArrayList<String[]> list = new ArrayList<String[]>();
	private HistoryDatabase Hist_db;
	
	 
	 @Override
	 public void onCreate (Bundle savedInstanceState){
		 super.onCreate(savedInstanceState);
		 
		 Hist_db = new HistoryDatabase(getActivity().getBaseContext());
	     list = Hist_db.getAllMessages();
	       
	     msgAdapter = new MessageAdapter(getActivity().getBaseContext()
	    		 , R.id.message_text, list);
	     setListAdapter(msgAdapter);
	 }
	 
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.activity_inbox, container, false);
	        return view;
	    }
	 
	 @Override
	 public void onResume() {
		 super.onResume();
		 getListView().setSelection(list.size()-1);
	 }
	 
	 public void addNewMessage (String[] message) {
	     list.add(message);
		 msgAdapter.notifyDataSetChanged();
		 getListView().setSelection(list.size()-1);
	 }
}
