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

public class Preamble extends Activity  {
	TextView show;
	Button back, next;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
  @Override
  protected void onCreate(Bundle savedInstanceState)   {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article);
		show = (TextView)findViewById(R.id.tvArticle);
		show.setText(readRawFile(R.raw.preamble));
		back =(Button) findViewById(R.id.bPrevious);
		next =(Button) findViewById(R.id.bNext);
		
		back.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent start =new Intent(Preamble.this,ChapterListActivity.class);
				startActivity(start);
			}
		});
		next.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent nextchapter = new Intent(Preamble.this,Sovereignty.class);
				startActivity(nextchapter);
			}
		});
	
	}
  
  

public String readRawFile(int resid){
	  InputStream inputstream =getResources().openRawResource(resid);
	  InputStreamReader read = new InputStreamReader(inputstream);
	  BufferedReader buffreader = new BufferedReader(read);
	  String line;
	  StringBuilder text = new StringBuilder();
	  
	  try {
          while (( line = buffreader.readLine()) != null) {
              text.append(line);
              text.append( '\n' );
            }
      } catch (IOException e) {
          return null;
      }
	  return text.toString();
	  
  }



  
}
			
     
   