package org.josemorente.controller;

import java.util.ArrayList;
import org.josemorente.bean.Materia;

public class ControllerMateria {
	public static ControllerMateria instance;
	private ArrayList<Materia> arrayListMateria = new ArrayList<>();
	private int idMateria = 1;
	
	public static ControllerMateria getInstance() {
		if(instance == null) {
			instance = new ControllerMateria();
		}
		return instance;
	}
	
	public ControllerMateria() {
	}
	
	public void addMateria(String nombre, String horario) {
		Materia materia = new Materia();
		
		materia.setIdMateria(idMateria);
		materia.setNombre(nombre);
		materia.setHorario(horario);
		arrayListMateria.add(materia);
		
		idMateria++;
	}

	public void showMaterias() {
		System.out.println("+_____________________________________________+");
		System.out.println("+___________________MATERIAS__________________+");
		for(Materia materia : arrayListMateria) {
			System.out.println("ID Materia: " + materia.getIdMateria() );
			System.out.println("Nombre: " + materia.getNombre() );
			System.out.println("Horario: " + materia.getHorario() );
			System.out.println("+_____________________________________________+");
		}
	}
	
	public Materia search(int idMateria) {
		for (Materia materia : arrayListMateria) {
			if (materia.getIdMateria() == idMateria) {
				return materia;
			}
		}
		return null;
	}

}