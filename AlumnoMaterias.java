package org.josemorente.bean;

import java.util.ArrayList;

public class AlumnoMaterias {
	private int idAsignacion;
	private ArrayList<Alumno> arrayListAlumno;
	private ArrayList<Materia> arrayListMateria;
	
    public AlumnoMaterias() {
		arrayListAlumno = new ArrayList<>();
		arrayListMateria = new ArrayList<>();
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public ArrayList<Alumno> getArrayListAlumno() {
		return arrayListAlumno;
	}
	
	public void setAlumno(Alumno alumno) {
		arrayListAlumno.add(alumno);
	}
	
	public ArrayList<Materia> getArrayListMateria() {
		return arrayListMateria;
	}
    
	public void setMateria(Materia materia) {
		arrayListMateria.add(materia);
	}
	
}