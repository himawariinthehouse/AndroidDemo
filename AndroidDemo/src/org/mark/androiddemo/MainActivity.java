package org.mark.androiddemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener, OnPageChangeListener {
final String TAG="tag";
private Button bt2;
private TextView tv;
Context mContext=this;

private ViewPager mViewPager;
private List<Fragment> mTabs=new ArrayList<Fragment>();
private String[] mTitles=new String[]{
	"First Fragment !","Second Fragment !","Third Fragment !","Fourth Fragment !"
};
private FragmentPagerAdapter mAdapter;

private List<ChangeColorIconWithText> mTabIndicators=new ArrayList<ChangeColorIconWithText>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.activity_main);
        setOverflowButtonAlways();
        getActionBar().setDisplayShowHomeEnabled(false);
        
        initView();
        initDatas();
        
        mViewPager.setAdapter(mAdapter);
        initEvent();
        
        
        
        
        
        
        Log.i(TAG,"MainActivity-->onCreate");
//        Button btn=(Button)findViewById(R.id.button7);
//        btn.setOnClickListener(new OnClickListener(){
//        	@Override
//        	public void onClick(View v){
//        		Intent intent=new Intent(MainActivity.this,SecondActivity.class);
//        		//first parm is context
//        		//second parm is target file
//        		//MainActivity.this.startActivity(intent);
//        		startActivity(intent);
//        	}
//        });
//        bt2=(Button)findViewById(R.id.button8);
//        bt2.setOnClickListener(new OnClickListener(){
//        	@Override
//        	public void onClick(View v){
//        		Intent intent=new Intent(mContext,ThirdActivity.class);
//        		startActivityForResult(intent,1);
//        	}
//        });
//        tv=(TextView) findViewById(R.id.TextView01);
    }

    private void initEvent() {
		// TODO Auto-generated method stub
		mViewPager.setOnPageChangeListener(this);
	}

	private void initView(){
    	mViewPager=(ViewPager) findViewById(R.id.id_viewpager);
    	ChangeColorIconWithText one=(ChangeColorIconWithText) findViewById(R.id.id_indicator_one);
    	mTabIndicators.add(one);
    	ChangeColorIconWithText two=(ChangeColorIconWithText) findViewById(R.id.id_indicator_two);
    	mTabIndicators.add(two);
    	ChangeColorIconWithText three=(ChangeColorIconWithText) findViewById(R.id.id_indicator_three);
    	mTabIndicators.add(three);
    	ChangeColorIconWithText four=(ChangeColorIconWithText) findViewById(R.id.id_indicator_four);
    	mTabIndicators.add(four);
    	
    	one.setOnClickListener(this);
    	two.setOnClickListener(this);
    	three.setOnClickListener(this);
    	four.setOnClickListener(this);
    	
    	one.setIconAlpha(1.0f);
    	
    }
    // create four fragment view
    private void initDatas(){
    	for(String title:mTitles)
    	{
    		TabFragment tabFragment=new TabFragment();
    		Bundle bundle=new Bundle();
    		bundle.putString(TabFragment.TITLE,title);
    		tabFragment.setArguments(bundle);
    		mTabs.add(tabFragment);
    		
    	}
    	mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mTabs.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return mTabs.get(arg0);
			}
		};
    }
    
    
    //requset, 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode==1&&resultCode==3){
    		String content = data.getStringExtra("data");
    		tv.setText(content);
    	}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    private void setOverflowButtonAlways(){
    	try{
    	ViewConfiguration config=ViewConfiguration.get(this);
    	Field menuKey=ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
    	menuKey.setAccessible(true);
    	menuKey.setBoolean(config, false);
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    	}
    }

 @Override
 public boolean onMenuOpened(int featureId,Menu menu)
 {
	 if(featureId==Window.FEATURE_ACTION_BAR&&menu!=null)
	 {  
		 if(menu.getClass().getSimpleName().equals("MenuBuilder")){
			 try{
			 Method m=menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
			 m.setAccessible(true);
			 m.invoke(menu, true);
			 }
			 catch(Exception e){
				 e.printStackTrace();
			 }
		 }
	 }
	 return super.onMenuOpened(featureId, menu);
 }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG,"MainActivity-->onStart");
    }
    @Override
    protected void onResume(){
    	super.onResume();
    	Log.i(TAG,"MainActivity-->onResume");
    }
    @Override
    protected void onPause(){
    	super.onPause();
    	Log.i(TAG,"MainActivity-->onPause");
    }
    @Override
    protected void onStop(){
    	super.onStop();
    	Log.i(TAG,"MainActivity-->onStop");
    }
    @Override
    protected void onDestroy(){
    	super.onDestroy();
    	Log.i(TAG,"MainActivity-->onDestroy");
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		resetOtherTabs();
		switch (v.getId()) {
		case R.id.id_indicator_one:
			mTabIndicators.get(0).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(0,false);
			break;

case R.id.id_indicator_two:
	mTabIndicators.get(1).setIconAlpha(1.0f);
	mViewPager.setCurrentItem(1,false);
			break;
			case R.id.id_indicator_three:
				mTabIndicators.get(2).setIconAlpha(1.0f);
				mViewPager.setCurrentItem(2,false);
				break;
				case R.id.id_indicator_four:
					mTabIndicators.get(3).setIconAlpha(1.0f);
					mViewPager.setCurrentItem(3,false);
					break;
		}
	}
	
	private void resetOtherTabs(){
		for(int i=0;i<mTabIndicators.size();i++){
			mTabIndicators.get(i).setIconAlpha(0);
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		// TODO Auto-generated method stub
		Log.e("tag", "position="+position+",positionOffset = "+positionOffset);
		if(positionOffset>0){
			ChangeColorIconWithText left=mTabIndicators.get(position);
			ChangeColorIconWithText right=mTabIndicators.get(position+1);
			
			left.setIconAlpha(1-positionOffset);
			right.setIconAlpha(positionOffset);
		}
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		
	}
 
}
