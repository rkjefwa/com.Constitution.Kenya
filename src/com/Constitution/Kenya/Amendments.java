package com.Constitution.Kenya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Amendments extends Activity {
     TextView amend;
     Button back, next;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sovereign);
		amend = (TextView) findViewById(R.id.txtView);
		amend.setText(readRawFile());
		back =(Button) findViewById(R.id.bPrevious);
		next =(Button) findViewById(R.id.bNext);
		
	}
	public String readRawFile(){
		InputStream inputstream = getResources().openRawResource(R.raw.amendments);
		InputStreamReader ireader =  new InputStreamReader(inputstream);
		BufferedReader breader = new BufferedReader(ireader);
		String line;
		StringBuilder words = new StringBuilder();
		
		try {
			while(( line = breader.readLine()) != null){
				 words.append(line);
				 words.append('\n');
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	     return words.toString();
	}
	

}
