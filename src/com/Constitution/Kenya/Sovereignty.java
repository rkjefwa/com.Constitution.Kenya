package com.Constitution.Kenya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sovereignty extends Activity {
	TextView sover;
	Button back, next;
    
    protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sovereign);
		sover = (TextView)findViewById(R.id.txtView);
		sover.setText(readRawSfile());
		back =(Button) findViewById(R.id.bPrevious);
		next =(Button) findViewById(R.id.bNext);
		back.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent prevChapter = new Intent(Sovereignty.this,Preamble.class);
				startActivity(prevChapter);
			}
		});
		next.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent nextChapter = new Intent(Sovereignty.this,Therepublic.class);
				startActivity(nextChapter);
				
			}
		});
	}

	public String readRawSfile() {
		InputStream  input =getResources().openRawResource(R.raw.sovereignty);
		InputStreamReader ireader = new InputStreamReader(input);
		BufferedReader breader = new BufferedReader(ireader);
		String textword;
		StringBuilder words = new StringBuilder();
		
		try{
		while(( textword = breader.readLine()) != null){
			words.append(textword);
			words.append('\n');
		     }
		   } catch(IOException e){
			   e.printStackTrace();
		   }
		  return words.toString();
		  }
}
