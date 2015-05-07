package org.mark.androiddemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FragmentView extends Activity  {
	private Context mContext=this;
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_view);
		
		 btn=(Button)findViewById(R.id.button1);
		//btn.setOnClickListener(this);
		
       btn.setOnClickListener(new OnClickListener(){
       	@Override
       	public void onClick(View v){
       		Intent intent=new Intent(FragmentView.this,SecondActivity.class);
       		//first parm is context
       		//second parm is target file
       		//MainActivity.this.startActivity(intent);
       		startActivity(intent);
       	}
       });
	}

//	@Override
//	public void onClick(View v) {
//		// TODO Auto-generated method stub
//		switch (v.getId()) {
//		case R.id.button1:
//			btn.setText("click");
//			Intent intent=new Intent(mContext,SecondActivity.class);
//    		startActivityForResult(intent,1);
//			break;
//
//		default:
//			break;
//		}
//	}



}
