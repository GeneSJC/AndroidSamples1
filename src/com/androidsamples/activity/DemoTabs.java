package com.androidsamples.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class DemoTabs extends TabActivity
{

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs_demo);

		loadTabs();
	}

	private void loadTabs()
	{
		tabHelper("DemoButtons", R.drawable.tab_android, DemoButtonsActivity.class);
		tabHelper("List", ExampleListActivity.class);
		tabHelper("DragDropActivity", DragDropActivity.class);

		// set some tab as default (zero based)
		getTabHost().setCurrentTab(2);
	}


	private void tabHelper(String label, final Class activityClass)
	{
		tabHelper(label, -99, activityClass);
	}

	private void tabHelper(String label, int andResourceId, final Class activityClass)
	{
		Resources resources = getResources();
		TabHost tabHost = getTabHost();

		Intent intentAndroid = new Intent().setClass(this, activityClass);
		TabSpec tabSpec = null;

		if ( andResourceId > 0)
		{
			tabSpec = tabHost.newTabSpec(label)
					.setIndicator("", resources.getDrawable(andResourceId))
					.setContent(intentAndroid);
		}
		else
		{
			tabSpec = tabHost.newTabSpec(label)
					.setIndicator(label)
					.setContent(intentAndroid);
		}

		tabHost.addTab(tabSpec);

	}


}