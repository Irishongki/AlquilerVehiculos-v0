package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private Consola() {

	}

	public static void mostrarCabecera(String mensaje) {
		StringBuilder subrayado = new StringBuilder(mensaje.length());
		for (int i = 0; i < mensaje.length(); i++) {
			subrayado.append("-");
		}
		System.out.printf("%s %n", mensaje);
		System.out.print(subrayado);
	}

	public static void mostrarMenu() {
		String mensaje1 = "Vamos a modelar la gestión de un negocio de alquiler de vehículos:";
		System.out.printf("%s %n", mensaje1);
		for (Opcion opcion : Opcion.values()) {
			System.out.printf("%s %n", opcion);
		}
	}

	private static String leerCadena(String mensaje) {
		System.out.print(mensaje);
		String cadena = Entrada.cadena();
		return cadena;
	}

	private static Integer leerEntero(String mensaje) {
		System.out.print(mensaje);
		int entero = Entrada.entero();
		return entero;
	}

	private static LocalDate leerFecha(String mensaje) {
		LocalDate fecha = null;
		System.out.print(mensaje);
		try {
			fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
		} catch (DateTimeException e) {
			System.out.printf("%s", e.getMessage());
		}
		return fecha;
	}

	public static Opcion elegirOpcion()  {
		Opcion opcion = null;
		do {
			try {
				int entero = leerEntero("Introduce la opción:");
				opcion = Opcion.get(entero);
			} catch (OperationNotSupportedException e) {
				System.out.printf("%s %n",e.getMessage());
				opcion = null;
			}
		} while (opcion == null);
		return opcion;
	}

	public static Cliente leerCliente() {
		String nombre = leerCadena("Introduce el nombre:");
		String dni = leerCadena("Introduce el dni:");
		String telefono = leerCadena("Introduce el telefono:");
		return new Cliente(nombre, dni, telefono);
	}

	public static Cliente leerClienteDni() {
		String dni = leerCadena("Introduce el dni:");
		Cliente cliente = Cliente.getClienteConDni(dni);
		return cliente;
	}

	public static String leerNombre() {
		String nombre = leerCadena("Introduce el nombre:");
		return nombre;
	}

	public static String leerTelefono() {
		String telefono = leerCadena("Introduce el telefono:");
		return telefono;
	}

	public static Turismo leerTurismo() {
		String marca = leerCadena("Introduce la marca:");
		String modelo = leerCadena("Introduce el modelo:");
		int cilindrada = leerEntero("Indroduce la cilindrada:");
		String matricula = leerCadena("Introduce la matricula:");
		return new Turismo(marca, modelo, cilindrada, matricula);
	}

	public static Turismo leerTurismoMatricula() {
		String matricula = leerCadena("Introduce la matricula:");
		Turismo turismo = Turismo.getTurismoConMatricula(matricula);
		return turismo;
	}

	public static Alquiler leerAlquiler() {
		Cliente cliente = leerClienteDni();
		Turismo turismo = leerTurismoMatricula();
		LocalDate fechaAlquiler = leerFecha("Introduce la fecha de Alquiler:");
		return new Alquiler(cliente, turismo, fechaAlquiler);
	}

	public static LocalDate leerFechaDevolucion() {
		LocalDate fechaDevolucion = leerFecha("Introduce la fecha de Devolucion:");
		return fechaDevolucion;
	}

}
