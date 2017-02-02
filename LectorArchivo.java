package org.josemorente.resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivo {
	public static LectorArchivo instance;
	
	public static LectorArchivo getInstance() {
		if(instance == null) {
			instance = new LectorArchivo();
		}
		return instance;
	}
	
	public LectorArchivo() {
	}
	
	public void leerRuta(String ruta) {
		String cadena;
		try {
			FileReader fileReader = new FileReader(ruta);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((cadena = bufferedReader.readLine())!=null) {
			  System.out.println(cadena);
			}
			bufferedReader.close();
		} catch(FileNotFoundException fne) {
			System.out.println("ERROR: Archivo No encontrado!");
		} catch(IOException io) {
			System.out.println("ERROR: Entrada/Salida");
		}
		
	}
	
}