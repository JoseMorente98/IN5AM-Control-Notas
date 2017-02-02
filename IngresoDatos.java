package org.josemorente.datos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class IngresoDatos{
	public static IngresoDatos instance;
	
	public IngresoDatos() {
	}
	
	public static IngresoDatos getInstance() {
		if (instance == null) {
			instance = new IngresoDatos();
		}
		return instance;
	}

	public String texto() {
		String ingreso = null;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			ingreso = bufferedReader.readLine();
		} catch (IOException io) {
			System.out.println("Error Input / Output");
			System.exit(1);
		}
		return ingreso;		
	}


}