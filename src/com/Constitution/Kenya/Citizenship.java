package com.Constitution.Kenya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Citizenship extends Activity {
    TextView tvText;
    Button back, next;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sovereign);
		tvText = (TextView) findViewById (R.id.txtView);
		tvText.setText(readRawFile());
		back =(Button) findViewById(R.id.bPrevious);
		next =(Button) findViewById(R.id.bNext);
	}
	 private String readRawFile(){
		InputStream inputstream = getResources().openRawResource(R.raw.citizen);
		InputStreamReader reader = new InputStreamReader(inputstream);
		BufferedReader breader = new BufferedReader(reader);
		String line;
		StringBuilder text = new StringBuilder();
		
		try {
			while(( line= breader.readLine()) != null){
			    text.append(line);
			    text.append('\n');
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		return text.toString(); 
	 }

}
