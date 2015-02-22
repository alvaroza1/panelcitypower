package com.example.citypower;

import java.util.ArrayList;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

public class FragmentHome extends Fragment implements OnClickListener{
	private Spinner spinn;
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<Noticia> arrayNoticia = new ArrayList<Noticia>();
	private ImageButton insert;
	private EditText reporte;
	private ListView listNoticia;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		list.add("Vialidad");
		list.add("Servicios");
		list.add("Emergencias");
		arrayNoticia.add(new Noticia("Trabajo en Colonia americana","Siapa actualmente esta trabajando en la solución de falta de agua en la Col. Americana"));
		arrayNoticia.add(new Noticia("Solución Colonia americana","Siapa se encargo de solucionar el problema en la Col. Americana"));
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        Activity act = (Activity)rootView.getContext();
        spinn = (Spinner)rootView.findViewById(R.id.spinner1);
        insert = (ImageButton)rootView.findViewById(R.id.button1);
        reporte = (EditText)rootView.findViewById(R.id.juan);
        listNoticia = (ListView)rootView.findViewById(R.id.list);
        AdaptadorNoticia adaptador= new AdaptadorNoticia(act,arrayNoticia);
        listNoticia.setAdapter(adaptador);
    	ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(rootView.getContext(), R.layout.spinner_item,list);
    	adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinn.setAdapter(adapterSpinner);
    	insert.setOnClickListener(this);
        return rootView;
    }
	@Override
	public void onClick(View arg0) {
		reporte.setText("");
		spinn.setSelection(0);
	}
}
