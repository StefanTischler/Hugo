package at.tugraz.mobilforum.test;

import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.util.Log;
import android.widget.LinearLayout;
import at.tugraz.mobilforum.MainActivity;
import at.tugraz.mobilforum.R;

public class MainActTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private static final String TAG = "main test";
	private Solo solo;
	
	public MainActTest() {
		super(MainActivity.class);
	}
	
	
	

	@Override
	public void setUp() throws Exception{
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	@UiThreadTest
	public void testCategoryView(){
		Log.e(TAG, getActivity().getFilesDir().toString());
		Log.e(TAG, getActivity().getPackageName());
		LinearLayout ll = (LinearLayout)solo.getView(R.id.category_list);
		assertNotNull(ll);
	}
	
}
