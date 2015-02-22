package com.example.citypower;

import java.util.ArrayList;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentReporte extends Fragment{
	private ListView yusocute;
	private ArrayList<String> reportes = new ArrayList<String>();
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		reportes.add("(21-02-2015 23:00:00) Carencia de agua colonia Americana");
		reportes.add("(21-02-2015 23:45:00) Carencia de agua colonia Americana");
        View rootView = inflater.inflate(R.layout.fragment_reporte, container, false);
        yusocute = (ListView)rootView.findViewById(R.id.yusocute);
        

        yusocute.setAdapter(new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, reportes) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                //v.setBackgroundColor(0xffff0000);  // COLOR
                TextView text = (TextView) v.findViewById(android.R.id.text1);
                text.setTextColor(Color.WHITE);
                v.setBackgroundResource(R.drawable.reporteapp); // IMAGE
                return v;
            }
        });
        return rootView;
    }
}
