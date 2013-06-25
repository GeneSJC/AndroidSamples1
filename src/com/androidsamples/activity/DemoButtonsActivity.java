package com.androidsamples.activity;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.androidsamples.util.Util;

public class DemoButtonsActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_buttons);

		uiDemoButtons();
		backendDemoButtons();
	}

	// =======================================
	// BUTTON LOAD LOGIC

	private void uiDemoButtons()
	{
		final Button toast1Button = (Button) findViewById(R.id.toast1_button);
		toast1Button.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Util.myToast(v, "Simple toast");
			}
		});

		connectButtonToActivity (R.id.list_button, DemoListActivity.class );
		connectButtonToActivity (R.id.tabs_button, DemoTabsActivity.class);
		connectButtonToActivity (R.id.drawables_gradient_button, DrawableDragDropActivity.class);

		Bundle paramsBundle = new Bundle();
		paramsBundle.putBoolean(Util.DRAGDROP_BOOLEAN_KEY, true);
		connectButtonToActivity (R.id.drawables_dragdrop_button, DrawableDragDropActivity.class, paramsBundle);
	}

	private void connectButtonToActivity(int androidResourceId, final Class activityClass)
	{
		connectButtonToActivity(androidResourceId, activityClass, null);
	}

	private void connectButtonToActivity(int androidResourceId, final Class activityClass, final Bundle bundle)
	{
		final Button button = (Button) findViewById(androidResourceId);
		button.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {

				Util.goToActivity(v, activityClass, bundle);
			}
		});

	}

	private void backendDemoButtons()
	{

		final Button readFileButton = (Button) findViewById(R.id.readfile_button);
		readFileButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
			    try
			    {
			    		InputStream inputStream = getAssets().open("input1.txt");
			    		String fileContents = Util.testReadTextFile(inputStream);
			    		String msg = "read file contents = " + fileContents;
			    		Log.d("OK", msg);
			    		Util.myToast(v, msg);
			    }
			    catch (final IOException e)
			    {
			    		e.printStackTrace();
			    		Log.d("ex", e.toString());
			    }
			}
		});
	}
}


