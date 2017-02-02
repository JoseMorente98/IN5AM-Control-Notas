package org.josemorente.controller;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.josemorente.bean.Alumno;
import org.josemorente.bean.Materia;
import org.josemorente.bean.AlumnoMaterias;
import org.josemorente.controller.ControllerMateria;
import org.josemorente.controller.ControllerAlumno;

public class ControllerAsignacion {
	public static ControllerAsignacion instance;
	private ArrayList<AlumnoMaterias> arrayListAsignacion = new ArrayList<>();
	private int idAsignacion = 1;
	
	public static ControllerAsignacion getInstance() {
		if(instance == null) {
			instance = new ControllerAsignacion();
		}
		return instance;
	}
	
	public ControllerAsignacion() {
	}
	
	//Agregar Asignación
	public void addAsignacion(int idAlumno, int idMateria) {
		AlumnoMaterias asignacion = new AlumnoMaterias();
		
		asignacion.setIdAsignacion(idAsignacion);
		arrayListAsignacion.add(asignacion);
		setAlumno(idAsignacion, idAlumno);
		setMateria(idAsignacion, idMateria);
		idAsignacion++;
	}

	//Buscar ID Alumno
	public void setAlumno(int idAsignacion, int idAlumno) {
		AlumnoMaterias asignacion = search(idAsignacion);
		if (asignacion != null) {
			asignacion.setAlumno(ControllerAlumno.getInstance().search(idAlumno));
		} else {
			System.out.println("No se encontro al alumno con ID: " + idAlumno);	
		}
	}
	
	//Buscar ID Materia
	public void setMateria(int idAsignacion, int idMateria) {
		AlumnoMaterias asignacion = search(idAsignacion);
		if (asignacion != null) {
			asignacion.setMateria(ControllerMateria.getInstance().search(idMateria));
		} else {
			System.out.println("No se encontro la materia con ID: " + idMateria);	
		}
	}
	
	//Buscar Asignación
	public AlumnoMaterias search(int idAsignacion) {
		for (AlumnoMaterias asignacion : arrayListAsignacion) {
			if (asignacion.getIdAsignacion() == idAsignacion) {
				return asignacion;
			}
		}
		return null;
	}
	
	//Mostrar Asignación
	public void showAsignacion() {
		System.out.println("+_____________________________________________+");
		System.out.println("+__________________ASIGNACIÓN_________________+");
		for(AlumnoMaterias asignacion : arrayListAsignacion) {
			System.out.println("ID Asignación: " + asignacion.getIdAsignacion() );
			for (Alumno alumno : asignacion.getArrayListAlumno()) {
				System.out.println("Alumno: " + alumno.getNombres() + " " + alumno.getApellidos());
			}
			for(Materia materia : asignacion.getArrayListMateria()) {
				System.out.println("Materia & Horario: " + materia.getNombre() + " " + materia.getHorario());
			}
			System.out.println("+_____________________________________________+");
		}
	}
	
	public void generateXml() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("company");
			doc.appendChild(rootElement);

			Element staff = doc.createElement("Staff");
			rootElement.appendChild(staff);

			Attr attr = doc.createAttribute("id");
			attr.setValue("1");
			staff.setAttributeNode(attr);
			
			for(AlumnoMaterias asignacion : arrayListAsignacion) {
				Element idAsignacion = doc.createElement("ID_Asignacion");
				idAsignacion.appendChild(doc.createTextNode(String.valueOf(asignacion.getIdAsignacion())));
				staff.appendChild(idAsignacion);
				for (Alumno alumno : asignacion.getArrayListAlumno()) {
					Element nameAlumno = doc.createElement("NombreCompleto");
					nameAlumno.appendChild(doc.createTextNode(alumno.getNombres() + " " + alumno.getApellidos()));
					staff.appendChild(nameAlumno);
				}
				for(Materia materia : asignacion.getArrayListMateria()) {
					Element nameMateria = doc.createElement("Materias");
					nameMateria.appendChild(doc.createTextNode(materia.getNombre()));
					staff.appendChild(nameMateria);
					Element horarioMateria = doc.createElement("Horario");
					horarioMateria.appendChild(doc.createTextNode(materia.getHorario()));
					staff.appendChild(horarioMateria);
				}
			}	
			
		File folder = new File("C:/Reporte");
		folder.mkdirs();
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:/Reporte/Reporte.xml"));

		transformer.transform(source, result);
		System.out.println("+_____________________________________________+");
		System.out.println("Archivo guardado!");
		System.out.println("+_____________________________________________+");
		} catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	
}