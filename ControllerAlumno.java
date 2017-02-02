package org.josemorente.controller;

import java.util.ArrayList;
import org.josemorente.bean.Alumno;

public class ControllerAlumno {
	public static ControllerAlumno instance;
	private ArrayList<Alumno> arrayListAlumno = new ArrayList<>();
	private int idAlumno = 1;
	
	public static ControllerAlumno getInstance() {
		if(instance == null) {
			instance = new ControllerAlumno();
		}
		return instance;
	}
	
	public ControllerAlumno() {
	}
	
	//Agregar Alumnos
	public void addAlumno(String nombres, String apellidos, int carnet) {
		Alumno alumno = new Alumno();
		
		alumno.setIdAlumno(idAlumno);
		alumno.setNombres(nombres);
		alumno.setApellidos(apellidos);
		alumno.setCarnet(carnet);
		arrayListAlumno.add(alumno);
		
		idAlumno++;
	}

	//Mostrar Alumnos
	public void showAlumnos() {
		System.out.println("+_____________________________________________+");
		System.out.println("+____________________ALUMNOS__________________+");
		for(Alumno alumno : arrayListAlumno) {
			System.out.println("ID Alumno: " + alumno.getIdAlumno() );
			System.out.println("Nombres: " + alumno.getNombres() );
			System.out.println("Apellidos: " + alumno.getApellidos() );
			System.out.println("Carnet: " + alumno.getCarnet() );
			System.out.println("+_____________________________________________+");
		}
	}
	
	
	public Alumno search(int idAlumno) {
		for (Alumno alumno : arrayListAlumno) {
			if (alumno.getIdAlumno() == idAlumno) {
				return alumno;
			}
		}
		return null;
	}
}