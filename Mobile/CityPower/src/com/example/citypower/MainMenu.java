package com.example.citypower;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

public class MainMenu extends Activity  {	private DrawerLayout mDrawerLayout;
private ListView mDrawerList;
private ListView mDrawerListRight;
private ActionBarDrawerToggle mDrawerToggle;
private ImageButton openMenu;
private ImageButton openSocial;
private Spinner spinn;
private ImageButton insert;
private EditText reporte;
private CharSequence mDrawerTitle;
private CharSequence mTitle;
DrawerAdapter adapter;
DrawerAdapterAjustes adapter2;
ArrayList<String> list = new ArrayList<String>();
List<DrawerItem> dataList;
List<DrawerItem> dataList2;
private ListView listNoticia;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_navigation);
	list.add("Vialidad");
	list.add("Servicios");
	list.add("Emergencias");

	// Initializing
	dataList = new ArrayList<DrawerItem>();
	dataList2 = new ArrayList<DrawerItem>();
	mTitle = mDrawerTitle = getTitle();
	mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	mDrawerList = (ListView) findViewById(R.id.left_drawer);
	mDrawerListRight = (ListView) findViewById(R.id.right_drawer);
	insert = (ImageButton)findViewById(R.id.button1);
	reporte = (EditText)findViewById(R.id.juan);
	mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,	GravityCompat.START);
	
	// Add Drawer Item to dataList
	dataList.add(new DrawerItem("Home"));
	dataList.add(new DrawerItem("Mis Reportes"));
	dataList.add(new DrawerItem("Estadistica"));
	
	spinn = (Spinner)findViewById(R.id.spinner1);
	ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, R.layout.spinner_item,list);
	adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinn.setAdapter(adapterSpinner);
	dataList2.add(new DrawerItem("Menu"));
	dataList2.add(new DrawerItem("twitter", R.drawable.ic_drawer));
	dataList2.add(new DrawerItem("facebook", R.drawable.ic_drawer));

	adapter = new DrawerAdapter(this, R.layout.activity_items_menu,dataList);
	adapter2 = new DrawerAdapterAjustes(this, R.layout.activity_items_ajuste,dataList2);
	mDrawerList.setAdapter(adapter);
	mDrawerListRight.setAdapter(adapter2);
	
	mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

	getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
	getActionBar().setCustomView(R.layout.activity_headers_menu);
	
	getActionBar().setDisplayHomeAsUpEnabled(true);
	getActionBar().setHomeButtonEnabled(true);
	ColorDrawable cd = new ColorDrawable(0x2f344f);
	getActionBar().setBackgroundDrawable(cd);
	

	
	insert.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			reporte.setText("");
			spinn.setSelection(0);
		}
		
	});
	
	
	mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
			R.drawable.ic_drawer, R.string.drawer_open,
			R.string.drawer_close) {
		public void onDrawerClosed(View view) {
			//getActionBar().setTitle(mTitle);
			//invalidateOptionsMenu(); // creates call to
										// onPrepareOptionsMenu()
		}

		public void onDrawerOpened(View drawerView) {
			getActionBar().setTitle(mDrawerTitle);
			invalidateOptionsMenu(); // creates call to
										// onPrepareOptionsMenu()
		}
	};

	mDrawerLayout.setDrawerListener(mDrawerToggle);
	
	if (savedInstanceState == null) {
		SelectItem(0);
	}
	
	openMenu = (ImageButton) findViewById(R.id.openMenu);
	openSocial = (ImageButton)findViewById(R.id.openSocial);
	mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	
	openMenu.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {

			if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
				mDrawerLayout.closeDrawer(Gravity.LEFT);
			}else if(mDrawerLayout.isDrawerOpen(Gravity.RIGHT)){
				mDrawerLayout.openDrawer(Gravity.LEFT);
				mDrawerLayout.closeDrawer(Gravity.RIGHT);
				
			}
			else
				mDrawerLayout.openDrawer(Gravity.LEFT);
			
		}
	});
	openSocial.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
				mDrawerLayout.closeDrawer(Gravity.RIGHT);
			}else if(mDrawerLayout.isDrawerOpen(Gravity.LEFT)){
				mDrawerLayout.openDrawer(Gravity.RIGHT);
				mDrawerLayout.closeDrawer(Gravity.LEFT);
				
			}
			else
				mDrawerLayout.openDrawer(Gravity.RIGHT);
			
		}
	});
	

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}

public void SelectItem(int possition) {
	Fragment fragment = null;
	Bundle args = new Bundle();
	switch (possition) {
	case 0:
		fragment = new FragmentHome();
		break;
	case 1:
		fragment = new FragmentReporte();
		break;
	case 2:
		fragment = new FragmentStats();
		break;
	case 3:
		fragment = new FragmentCentral();
		args.putString(FragmentCentral.ITEM_NAME, dataList.get(possition)
				.getItemName());
		args.putInt(FragmentCentral.IMAGE_RESOURCE_ID, dataList.get(possition)
				.getImgResID());
		break;
	case 4:
		fragment = new FragmentCentral();
		args.putString(FragmentCentral.ITEM_NAME, dataList.get(possition)
				.getItemName());
		args.putInt(FragmentCentral.IMAGE_RESOURCE_ID, dataList.get(possition)
				.getImgResID());
		break;
	case 5:
		fragment = new FragmentCentral();
		args.putString(FragmentCentral.ITEM_NAME, dataList.get(possition)
				.getItemName());
		args.putInt(FragmentCentral.IMAGE_RESOURCE_ID, dataList.get(possition)
				.getImgResID());
		break;
	case 6:
		fragment = new FragmentCentral();
		args.putString(FragmentCentral.ITEM_NAME, dataList.get(possition)
				.getItemName());
		args.putInt(FragmentCentral.IMAGE_RESOURCE_ID, dataList.get(possition)
				.getImgResID());
		break;
	
	default:
		break;
	}
	 if (fragment != null) {
	        FragmentManager fragmentManager = getFragmentManager();
	        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
	 
	        mDrawerList.setItemChecked(possition, true);
	        mDrawerList.setSelection(possition);
	        mDrawerLayout.closeDrawer(mDrawerList);
	        
	    }
	mDrawerList.setItemChecked(possition, true);
	setTitle(dataList.get(possition).getItemName());
	mDrawerLayout.closeDrawer(mDrawerList);

}

@Override
public void setTitle(CharSequence title) {
	mTitle = title;
	getActionBar().setTitle(mTitle);
}

@Override
protected void onPostCreate(Bundle savedInstanceState) {
	super.onPostCreate(savedInstanceState);
	// Sync the toggle state after onRestoreInstanceState has occurred.
	mDrawerToggle.syncState();
}

@Override
public void onConfigurationChanged(Configuration newConfig) {
	super.onConfigurationChanged(newConfig);
	// Pass any configuration change to the drawer toggles
	mDrawerToggle.onConfigurationChanged(newConfig);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// The action bar home/up action should open or close the drawer.
	// ActionBarDrawerToggle will take care of this.
	if (mDrawerToggle.onOptionsItemSelected(item)) {
		return true;
	}

	return false;
}

private class DrawerItemClickListener implements
		ListView.OnItemClickListener {
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		SelectItem(position);

	}
}

}