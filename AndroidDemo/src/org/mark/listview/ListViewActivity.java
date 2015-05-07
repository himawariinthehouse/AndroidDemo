package org.mark.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mark.androiddemo.R;
import org.mark.androiddemo.R.layout;
import org.mark.androiddemo.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListViewActivity extends Activity {
private ListView listView;
private ArrayAdapter<String> arr_adapter;
private SimpleAdapter simp_adapter;
private List<Map<String,Object>>dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		listView=(ListView)findViewById(R.id.listView);
		String[]arr_data=new String[]{"a","b","c","d"};
		//dataList=new ArrayList<Map<String,Object>>();
		//1.context,2 layout file,data source
		arr_adapter=new ArrayAdapter<String>(ListViewActivity.this,android.R.layout.simple_list_item_1,arr_data);
		
		//simp_adapter=new SimpleAdapter(this, dataList, R.layout.listitem, new String[]{"pic","text"},new int[]{R.id.pic,R.id.txt} );
		listView.setAdapter(arr_adapter);
		
	}
private List<Map<String,Object>> getData() {
	dataList = new ArrayList<Map<String, Object>>();
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("text", "java");
	map.put("image", R.drawable.ic_launcher);
	Map<String, Object> map2 = new HashMap<String, Object>();
	map2.put("text", "C++");
	map2.put("image", R.drawable.ic_launcher);
	Map<String, Object> map3 = new HashMap<String, Object>();
	map3.put("text", "JavaScript");
	map3.put("image", R.drawable.ic_launcher);
	Map<String, Object> map4 = new HashMap<String, Object>();
	map4.put("text", "Php");
	map4.put("image", R.drawable.ic_launcher);
	Map<String, Object> map5 = new HashMap<String, Object>();
	map5.put("text", "Python2");
	map5.put("image", R.drawable.ic_launcher);
	dataList.add(map);
	dataList.add(map2);
	dataList.add(map3);
	dataList.add(map4);
	dataList.add(map5);
	Log.i("Main", dataList.size() + "");
	
	return dataList;
	
}

}
