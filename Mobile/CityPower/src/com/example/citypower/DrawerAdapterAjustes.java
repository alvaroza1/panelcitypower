package com.example.citypower;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerAdapterAjustes extends ArrayAdapter<DrawerItem>{
	Context context;
	List<DrawerItem> drawerItemList;
	ArrayList<String> campos = new ArrayList<String>();
	
	int layoutResID;

	public DrawerAdapterAjustes(Context context, int layoutResourceID,
			List<DrawerItem> listItems) {
		super(context, layoutResourceID, listItems);
		this.context = context;
		this.drawerItemList = listItems;
		this.layoutResID = layoutResourceID;
		campos.add("Vialidad");
		campos.add("Servicios");
		campos.add("Emergencia");

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		DrawerItemHolder drawerHolder;
		View view = convertView;

		if (view == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			drawerHolder = new DrawerItemHolder();

			view = inflater.inflate(layoutResID, parent, false);
			drawerHolder.ItemName = (CheckBox) view.findViewById(R.id.drawer_check);
			drawerHolder.ItemName.setChecked(true);
			view.setTag(drawerHolder);

		} else {
			drawerHolder = (DrawerItemHolder) view.getTag();

		}

		DrawerItem dItem = (DrawerItem) this.drawerItemList.get(position);
		if(position < campos.size())
			drawerHolder.ItemName.setText(campos.get(position));
		
		
		

		return view;
	}

	private static class DrawerItemHolder {
		CheckBox ItemName;
		ImageView icon;
	}
}
