package at.tugraz.mobilforum;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final String TAG = "mforum";
	public static Map<Integer, String> categorys; // todo 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e(TAG, "test");
//		categorys = new HashMap<Integer, String>();
//		categorys.put(0,"Cat 1");
//		categorys.put(1,"Cat 2");
//		categorys.put(2,"Cat 3");
//		categorys.put(3,"Cat 4");
//		categorys.put(4,"Cat 5");
//		categorys.put(5,"Cat 6");
		categorys = new AccessDataBase().getCategories(); // TODO singelton
		showCategories();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void showTopics(int categoryId){
		setContentView(R.layout.topics);
		// TODO continue
	}
	
	private void showCategories(){
		setContentView(R.layout.categories);
		LinearLayout categoryListView = (LinearLayout)findViewById(R.id.category_list);
		for(int categoryId : categorys.keySet()){
			Button categoryView = new Button(this);
			categoryView.setText(categorys.get(categoryId));
			categoryView.setGravity(Gravity.CENTER);
			final int catID = categoryId;
			categoryView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					showTopics(catID);
				}
			});
			categoryListView.addView(categoryView);
		}
		
	}

}
