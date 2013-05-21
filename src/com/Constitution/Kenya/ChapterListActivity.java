package com.Constitution.Kenya;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChapterListActivity extends ListActivity  {
	
	String [] chapters = {"Preamble","Sovereignty","Therepublic", "Citizenship","Bill of Rights","LandAndEnvironment",
     "Leadership","PeopleRepresentation","Legislature","Executive","Judiciary","DevolvedGovernment","PublicFinance",
	 "PublicService","NationalSecurity","Commissions","Amendments","Generalprovisions",
	 "Transitionalprovisions","schedules"};			
		    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(ChapterListActivity.this,android.R.layout.simple_list_item_1,chapters));
	}


	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	    String link = chapters[position];
		try {
		@SuppressWarnings("rawtypes")
		Class ourClass = Class.forName ("com.Constitution.Kenya." + link);
		Intent articles = new Intent(ChapterListActivity.this, ourClass);
		startActivity(articles);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}