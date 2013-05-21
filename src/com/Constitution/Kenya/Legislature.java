package com.Constitution.Kenya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Legislature extends Activity implements TextToSpeech.OnInitListener {
	TextView comm;
	Button back, next,btnSpeak;
    private TextToSpeech tts;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sovereign);
		comm = (TextView) findViewById(R.id.txtView);
		comm.setText(readRawFile());
		back =(Button) findViewById(R.id.bPrevious);
		btnSpeak =(Button) findViewById(R.id.btnSpeak);
		next =(Button) findViewById(R.id.bNext);
		tts = new TextToSpeech(this, this);
		btnSpeak.setOnClickListener(new View.OnClickListener(){

			public void onClick(View arg0) {
				speakOut();
			}
		}
		
				);
	}
	@Override
	public void onDestroy() {
		// Don't forget to shutdown!
		if (tts != null) {
			tts.stop();
			tts.shutdown();
		}
		super.onDestroy();
	}
	private String readRawFile() {
		// TODO Auto-generated method stub
		InputStream inputstream = getResources().openRawResource(R.raw.legislature);
		InputStreamReader ireader = new InputStreamReader(inputstream);
		BufferedReader breader  = new BufferedReader(ireader);
		String line;
		StringBuilder words = new StringBuilder();
		
		try {
			while((line = breader.readLine()) != null){
			words.append(line);
			words.append("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return words.toString();
	}
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if (status == TextToSpeech.SUCCESS) {

			int result = tts.setLanguage(Locale.US);

			 tts.setPitch(5); // set pitch level

			 tts.setSpeechRate(2); // set speech speed rate

			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "Language is not supported");
				
			} else {
				btnSpeak.setEnabled(true);
				speakOut();
			}

		} else {
			Log.e("TTS", "Initilization Failed");
		}

		
	}
	private void speakOut() {
		// TODO Auto-generated method stub
		String text = comm.getText().toString();

		tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
		
	}
}
