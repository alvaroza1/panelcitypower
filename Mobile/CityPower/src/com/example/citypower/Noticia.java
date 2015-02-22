package com.example.citypower;

public class Noticia {
	private int imgRes;
	private String titulo;
	private String descripcion;
	
	public Noticia(){
		
	}
	
	public Noticia(String titulo, String descripcion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	public int getImgRes() {
		return imgRes;
	}
	public void setImgRes(int imgRes) {
		this.imgRes = imgRes;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
