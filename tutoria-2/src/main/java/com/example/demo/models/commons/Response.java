package com.example.demo.models.commons;

public class Response<T> {

	private String mensaje;
	private T object;
	
	
	public Response(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	public Response(String mensaje, T object) {
		this.mensaje = mensaje;
		this.object = object;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public T getObject() {
		return object;
	}


	public void setObject(T object) {
		this.object = object;
	}
	
	
	
	
}
