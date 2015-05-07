package org.mark.androiddemo;
import org.mark.androiddemo2.ViewPagerActivity;
import org.mark.listview.ListViewActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class TabFragment extends Fragment {
private String mTitle="Default";
static final String TITLE="Title";

@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	 View mMainView ;
	if(getArguments()!=null)
	{
		mTitle =getArguments().getString(TITLE);
		
	}
	
	mMainView=inflater.inflate(R.layout.activity_fragment_view,container,false);
	TextView tv=(TextView) mMainView.findViewById(R.id.textView1);
	Button btn=(Button) mMainView.findViewById(R.id.button1);
	if (mTitle.equals("First Fragment !")){
		tv.setTextSize(20);
		tv.setBackgroundColor(Color.parseColor("#ffffffff"));
		tv.setText(mTitle);
		tv.setGravity(Gravity.CENTER);
	btn.setOnClickListener(new OnClickListener(){
       	@Override
       	public void onClick(View v){
       		Intent intent=new Intent(getActivity(),SecondActivity.class);
       		//first parm is context
       		//second parm is target file
       		//MainActivity.this.startActivity(intent);
       		startActivity(intent);
       	}
       });
	
	}
	else if (mTitle.equals("Second Fragment !")) {
		
		btn.setOnClickListener(new OnClickListener(){
	       	@Override
	       	public void onClick(View v){
	       		Intent intent=new Intent(getActivity(),ViewPagerActivity.class);
	       		//first parm is context
	       		//second parm is target file
	       		//MainActivity.this.startActivity(intent);
	       		startActivity(intent);
	       	}
	       });
		
		tv.setTextSize(20);
		tv.setBackgroundColor(Color.parseColor("#ffffffff"));
		tv.setText(mTitle);
		tv.setGravity(Gravity.CENTER);
	}
	else if (mTitle.equals("Third Fragment !")){
		btn.setOnClickListener(new OnClickListener(){
	       	@Override
	       	public void onClick(View v){
	       		Intent intent=new Intent(getActivity(),ListViewActivity.class);
	       		//first parm is context
	       		//second parm is target file
	       		//MainActivity.this.startActivity(intent);
	       		startActivity(intent);
	       	}
	       });
		tv.setTextSize(20);
		tv.setBackgroundColor(Color.parseColor("#ffffffff"));
		tv.setText(mTitle);
		tv.setGravity(Gravity.CENTER);
	}
	
	return 	mMainView;
		
	
	}


}
