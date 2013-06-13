package at.tugraz.mobilforum;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity {

	private int topicid = 0;
	private int categoryid = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  this.topicid = getIntent().getIntExtra("topicid", 1);
		  this.categoryid = getIntent().getIntExtra("categoryid", 1);

		setContentView(R.layout.activity_register);
		findViewById(R.id.activity_register_button_next).setEnabled(true);
		final Button button = (Button) findViewById(R.id.activity_register_button_next);
		
		
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				checkInput();
			}
		});
	}

	void checkInput() {
		if(!AccessDataBase.hasInstance()){
			AccessDataBase.setInstance(new AccessDataBase(this));
			AccessDataBase.isDefined = false;
		}
		AccessDataBase db = AccessDataBase.getInstance();
		 
		Editable username = ((EditText) findViewById(R.id.activity_register_username))
				.getText();
		Editable passwd = ((EditText) findViewById(R.id.activity_register_edit_password))
				.getText();
		Editable passwdconf = ((EditText) findViewById(R.id.activity_register_edit_password_confirm))
				.getText();


		if (username.toString().isEmpty() || passwd.toString().isEmpty()
				|| passwdconf.toString().isEmpty()) {
			showAlert(getString(R.string.alert_reg_input_error), getString(R.string.title_reg_input_error));
		}
		else if(!passwdconf.toString().equals(passwd.toString())){
			showAlert(getString(R.string.alert_reg_input_error), getString(R.string.title_reg_input_error));
			
		}
		else if(db.isUsernameTaken(username.toString())){
			showAlert(getString(R.string.alert_reg_username), getString(R.string.title_reg_username));
		}
		else
		{
			Intent i = new Intent();

			i.putExtra("username", username.toString());
			i.putExtra("password",passwd.toString());
			i.putExtra("topicid",this.topicid);
			i.putExtra("categorycid",this.categoryid);
			
			i.setClass(getApplicationContext(), RegisterAvatarActivity.class);
			startActivity(i);
			finish();
		}
	}

	void showAlert(String message, String title) {
		// Alert Start
		final Context context = this;
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);

		// set title
		alertDialogBuilder.setTitle(title);

		alertDialogBuilder
				.setMessage(message)
				.setCancelable(false)
				.setPositiveButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.cancel();
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
		// Alert Ende
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 */
}
