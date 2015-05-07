package org.mark.androiddemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThirdActivity extends Activity {
    private Button bt;
    private String content="hello main page";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		bt=(Button)findViewById(R.id.button7);
		bt.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent data=new Intent();
				data.putExtra("data",content);
				setResult(3,data);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
	}

}
