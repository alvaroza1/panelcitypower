package com.example.citypower;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdaptadorNoticia extends ArrayAdapter<Noticia>{
	private Activity context;
	private AlertDialog.Builder dialog;
	private ArrayList<Noticia> mlista;
	private ImageButton estrella;
	private int[] estrellaEstado;
	private int id;
	private String tipo;

	public AdaptadorNoticia (Activity context, ArrayList<Noticia> lista)
	{
		super(context, R.layout.activity_detail_noticia,lista);		
		this.context= context;		
		this.mlista = lista;
		this.estrellaEstado = new int[lista.size()];
	}	
	
	public View getView(int position, View convertView, ViewGroup parent){
		LayoutInflater inflater  = context.getLayoutInflater();
		View item = inflater.inflate(R.layout.activity_detail_noticia, null);
		
		TextView textRow = (TextView) item.findViewById(R.id.nameFav);
		TextView textRow3 = (TextView) item.findViewById(R.id.compa);
		ImageButton estrella = (ImageButton)item.findViewById(R.id.estrella);
		estrella.setImageResource(R.drawable.siap);
		estrella.setFocusable(false);
		estrella.setTag(position);
		System.out.println(estrella.getTag());
		textRow.setText(mlista.get(position).getTitulo());
		textRow3.setText(mlista.get(position).getDescripcion());
		return (item);

	}
	
	@Override
	public int getCount() {
		if (mlista != null)
			return mlista.size();
		else
			return 0;	
	}

		
}

