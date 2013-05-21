package com.Constitution.Kenya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Therepublic extends Activity {
    TextView rep;
    Button back, next;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sovereign);
		rep = (TextView)findViewById(R.id.txtView);
		rep.setText(readRawFile());
		back =(Button) findViewById(R.id.bPrevious);
		next =(Button) findViewById(R.id.bNext);
		}
	public String readRawFile(){
		InputStream inputstream = getResources().openRawResource(R.raw.republic);
		InputStreamReader reader = new InputStreamReader(inputstream);
		BufferedReader bReader = new BufferedReader(reader);
		String line;
		StringBuilder text = new StringBuilder();
		
		try {
			while(( line = bReader.readLine()) != null){
				text.append(line);
			    text.append('\n');
			 }
			} catch (IOException e) {
				return null;
		}
		return text.toString();
		
	}

}
