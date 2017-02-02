package org.josemorente.menu;

import org.josemorente.datos.IngresoDatos;
import org.josemorente.controller.ControllerAlumno;
import org.josemorente.controller.ControllerMateria;
import org.josemorente.controller.ControllerAsignacion;
import org.josemorente.resources.LectorArchivo;

public class Menu {
	public static Menu instance;
	private String eleccion;
	private String nombres = "";
	private String apellidos = "";
	private int carnet = 0;
	private String nombre = "";
	private String horario = "";
	private int idMateria = 0;
	private int idAlumno = 0;
	private String ruta = "";
	
	public Menu() {	
		ControllerAlumno.getInstance().addAlumno("Jose Rafael", "Morente Gonzalez", 2015032);
		ControllerMateria.getInstance().addMateria("Matematicas", "7:00-8:00");
		ControllerMateria.getInstance().addMateria("Sociales", "8:00-8:30");
		ControllerMateria.getInstance().addMateria("Estadistica", "8:30-9:00");
		ControllerMateria.getInstance().addMateria("Ingles", "9:00-9:30");
		ControllerMateria.getInstance().addMateria("Psicologia", "10:00-11:00");
		ControllerMateria.getInstance().addMateria("Biologia", "11:00-12:00");
		ControllerAsignacion.getInstance().addAsignacion(1, 1);
		ControllerAsignacion.getInstance().addAsignacion(1, 2);
		ControllerAsignacion.getInstance().addAsignacion(1, 3);
		ControllerAsignacion.getInstance().addAsignacion(1, 4);
		ControllerAsignacion.getInstance().addAsignacion(1, 5);
		ControllerAsignacion.getInstance().addAsignacion(1, 6);
	}

	public static Menu getInstance() {
		if (instance == null) {
			instance = new Menu();
		}
		return instance;
	}
	
	public void showMenu() {
		
		System.out.println("+_____________________________________________+");
		System.out.println("+_________________MENÚ COLEGIO________________+");
		System.out.println("¦ Escriba EXIT para finalizar                 ¦");
		System.out.println("¦ 1) Alumnos                                  ¦");
		System.out.println("¦ 2) Materias                                 ¦");
		System.out.println("¦ 3) Asignaciones                             ¦");
		System.out.println("¦ 4) Generar Reporte                          ¦");
		System.out.println("¦ 5) Leer Reporte                             ¦");
		System.out.println("+_____________________________________________+");
		eleccion = IngresoDatos.getInstance().texto();
		switch(eleccion.toUpperCase()) {
			case "1":
				showMenuAlumno();
			break;
			case "2":
				showMenuMateria();
			break;			
			case "3":
				showMenuAsignacion();
			break;
			case "4":
				ControllerAsignacion.getInstance().generateXml();
				showMenu();
			break;
			case "5":
				showLeerArchivo();
			break;
			case "SALIR":
			System.exit(1);
			default:
			System.out.println("Ingrese 1, 2, 3 o SALIR");
			showMenu();
		}
	}
	
	public void showMenuAlumno() {
		System.out.println("+_____________________________________________+");
		System.out.println("+____________________ALUMNOS__________________+");
		System.out.println("¦ Escriba EXIT para regresar                  ¦");
		System.out.println("¦ 1) Ingresar Alumnos                         ¦");
		System.out.println("¦ 2) Mostrar Alumnos                          ¦");
		System.out.println("+_____________________________________________+");
		eleccion = IngresoDatos.getInstance().texto();
		switch(eleccion.toUpperCase()) {
			case "1":
				showMenuAgregarAlumno();
			break;
			case "2":
				ControllerAlumno.getInstance().showAlumnos();
				showMenuAlumno();
			break;
			case "EXIT":
			showMenu();
			default:
			System.out.println("Escriba 1, 2 o SALIR");
			showMenuAlumno();
		}
	}
	
	public void showMenuAgregarAlumno() {		
		do {
		System.out.println("+_____________________________________________+");
		System.out.println("+____________________ALUMNOS__________________+");
		System.out.println("Ingrese los nombres del Alumno");
		nombres = IngresoDatos.getInstance().texto();
		System.out.println("Ingrese los apellidos del Alumno");
		apellidos = IngresoDatos.getInstance().texto();
		System.out.println("Ingrese el carnet del Alumno");
		carnet = Integer.parseInt(IngresoDatos.getInstance().texto());
		ControllerAlumno.getInstance().addAlumno(nombres, apellidos, carnet);
		System.out.println("Desea Continuar S/N                ");
		System.out.println("+_____________________________________________+");		
		eleccion = IngresoDatos.getInstance().texto();		
		}while(eleccion.toUpperCase().equals("S"));		
		if(eleccion.equals("N")) {
			showMenuAlumno();
		}
	}
	
	public void showMenuMateria() {
		System.out.println("+_____________________________________________+");
		System.out.println("+___________________MATERIAS__________________+");
		System.out.println("¦ Escriba EXIT para regresar                  ¦");
		System.out.println("¦ 1) Ingresar Materias                        ¦");
		System.out.println("¦ 2) Mostrar Materias                         ¦");
		System.out.println("+_____________________________________________+");
		eleccion = IngresoDatos.getInstance().texto();
		switch(eleccion.toUpperCase()) {
			case "1":
				showMenuAgregarMateria();
			break;
			case "2":
				ControllerMateria.getInstance().showMaterias();
				showMenuMateria();
			break;
			case "EXIT":
			showMenu();
			default:
			System.out.println("Escriba 1, 2 o SALIR");
			showMenuMateria();
		}
	}
	
	public void showMenuAgregarMateria() {		
		do {
		System.out.println("+_____________________________________________+");
		System.out.println("+___________________MATERIAS__________________+");
		System.out.println("Ingrese el nombre de la Materia");
		nombre = IngresoDatos.getInstance().texto();
		System.out.println("Ingrese el horario en que se impartira");
		horario = IngresoDatos.getInstance().texto();
		ControllerMateria.getInstance().addMateria(nombre, horario);
		System.out.println("Desea Continuar S/N                ");
		System.out.println("+_____________________________________________+");		
		eleccion = IngresoDatos.getInstance().texto();		
		}while(eleccion.toUpperCase().equals("S"));		
		if(eleccion.equals("N")) {
			showMenuMateria();
		}
	}
	
	public void showMenuAsignacion() {
		System.out.println("+_____________________________________________+");
		System.out.println("+__________________ASIGNACIÓN_________________+");
		System.out.println("¦ Escriba EXIT para regresar                  ¦");
		System.out.println("¦ 1) Ingresar Asignaciones                    ¦");
		System.out.println("¦ 2) Mostrar Asignaciones                     ¦");
		System.out.println("+_____________________________________________+");
		eleccion = IngresoDatos.getInstance().texto();
		switch(eleccion.toUpperCase()) {
			case "1":
				showMenuAgregarAsignacion();
			break;
			case "2":
				ControllerAsignacion.getInstance().showAsignacion();
				showMenuAsignacion();
			break;
			case "EXIT":
			showMenu();
			default:
			System.out.println("Escriba 1, 2 o SALIR");
			showMenuAsignacion();
		}
	}
	
	public void showMenuAgregarAsignacion() {		
		do {
		System.out.println("+_____________________________________________+");
		System.out.println("+__________________ASIGNACIÓN_________________+");
		System.out.println("Ingrese el ID del Alumno");
		idAlumno = Integer.parseInt(IngresoDatos.getInstance().texto());
		System.out.println("Ingrese el ID de la Materia");
		idMateria = Integer.parseInt(IngresoDatos.getInstance().texto());
		ControllerAsignacion.getInstance().addAsignacion(idAlumno, idMateria);
		System.out.println("Desea Continuar S/N                ");
		System.out.println("+_____________________________________________+");		
		eleccion = IngresoDatos.getInstance().texto();		
		}while(eleccion.toUpperCase().equals("S"));		
		if(eleccion.equals("N")) {
			showMenuAsignacion();
		}
	}
	
	public void showLeerArchivo() {
		System.out.println("+_____________________________________________+");
		System.out.println("+___________________ARCHIVO___________________+");
		System.out.println("Escriba la ruta");
		ruta = IngresoDatos.getInstance().texto();
		LectorArchivo.getInstance().leerRuta(ruta);
		showMenu();
	}
}