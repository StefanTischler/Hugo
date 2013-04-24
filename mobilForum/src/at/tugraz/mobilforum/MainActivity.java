package at.tugraz.mobilforum;

import java.util.LinkedList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final String TAG = "mforum";
	public static List<String> categoryList; // todo 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e(TAG, "test");
		categoryList = new LinkedList<String>();
		categoryList.add("Cat 1");
		categoryList.add("Cat 2");
		categoryList.add("Cat 3");
		categoryList.add("Cat 4");
		categoryList.add("Cat 5");
		showCategories();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void showCategories(){
		setContentView(R.layout.categorys);
		LinearLayout categoryListView = (LinearLayout)findViewById(R.id.category_list);
		for(String category : categoryList){
			Button categoryView = new Button(this);
			categoryView.setText(category);
			categoryView.setGravity(Gravity.CENTER);
			categoryListView.addView(categoryView);
		}
		
	}

}
