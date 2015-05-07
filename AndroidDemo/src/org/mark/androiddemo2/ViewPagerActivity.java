package org.mark.androiddemo2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Transformer;

import org.mark.androiddemo.MainActivity;
import org.mark.androiddemo.R;
import org.mark.androiddemo.R.layout;
import org.mark.androiddemo.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ViewPagerActivity extends Activity {
private ViewPager mViewPager;
private int[] mImgIds=new int[]{
		R.drawable.guide_image1,R.drawable.guide_image2,R.drawable.guide_image2
};
private List<ImageView> mImages=new ArrayList<ImageView>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);
		
		mViewPager=(ViewPager)findViewById(R.id.id_viewpager);
		//mViewPager.setPageTransformer(true, );
		mViewPager.setAdapter(new PagerAdapter() {
			@Override
			public Object instantiateItem(ViewGroup container,int position){
				ImageView imageview=new ImageView(ViewPagerActivity.this);
				imageview.setImageResource(mImgIds[position]);
				imageview.setScaleType(ScaleType.CENTER_CROP);
				container.addView(imageview);
				mImages.add(imageview);
				return imageview;
			}
			@Override
			public void destroyItem(ViewGroup container, int position, Object object){
				container.removeView(mImages.get(position));
				super.destroyItem(container, position, object);
				
			}
			@Override
			public boolean isViewFromObject(View view, Object object) {
				// TODO Auto-generated method stub
				return view==object;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mImgIds.length;
			}
		});
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_pager, menu);
		return true;
	}

}
