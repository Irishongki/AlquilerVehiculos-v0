package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public class Vista {

	private Controlador controlador;

	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("El controlador no puede ser nulo");
		}
		this.controlador = controlador;
	}

	public void comenzar() throws OperationNotSupportedException {
		do {
			Consola.mostrarMenu();
			ejecutar(Consola.elegirOpcion());
		} while (Consola.elegirOpcion() == null);
	}

	public void terminar() {
		System.out.print("Adioss!!");
	}

	private void ejecutar(Opcion opcion) {
		switch (opcion.ordinal()) {
		case 0:
			terminar();
			break;
		case 1:
			insertarCliente();
			break;
		case 2:
			insertarTurismo();
			break;
		case 3:
			insertarAlquiler();
			break;
		case 4:
			buscarCliente();
			break;
		case 5:
			buscarTurismo();
			break;
		case 6:
			buscarAlquiler();
			break;
		case 7:
			modificarCliente();
			break;
		case 8:
			devolverAlquiler();
			break;
		case 9:
			borrarCliente();
			break;
		case 10:
			borrarTurismo();
			break;
		case 11:
			borrarAlquiler();
			break;
		case 12:
			listarClientes();
			break;
		case 13:
			listarTurismos();
			break;
		case 14:
			listarAlquileres();
			break;
		case 15:
			listarAlquileresCliente();
			break;
		case 16:
			listarAlquileresTurismo();
			break;
		}
	}

	private void insertarCliente() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 1-Insertar Cliente");
			controlador.insertar(Consola.leerCliente());
		} catch (OperationNotSupportedException e) {
			System.out.print(e.getMessage());
		}
	}

	private void insertarTurismo() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 2-Insertar Turismo");
			controlador.insertar(Consola.leerTurismo());
		} catch (OperationNotSupportedException e) {
			System.out.print(e.getMessage());
		}
	}

	private void insertarAlquiler() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 3-Insertar Alquiler");
			controlador.insertar(Consola.leerAlquiler());
		} catch (OperationNotSupportedException e) {
			System.out.print(e.getMessage());
		}
	}

	private void buscarCliente() {
		Consola.mostrarCabecera("Estamos en la opción --> 4-Buscar Cliente");
		controlador.buscar(Consola.leerClienteDni());
	}

	private void buscarTurismo() {
		Consola.mostrarCabecera("Estamos en la opción --> 5-Buscar Turismo");
		controlador.buscar(Consola.leerTurismoMatricula());
	}

	private void buscarAlquiler() {
		Consola.mostrarCabecera("Estamos en la opción --> 6-Buscar Alquiler");
		controlador.buscar(Consola.leerAlquiler());
	}

	private void modificarCliente() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 7-Modificar Cliente");
			controlador.modificar(Consola.leerClienteDni(), Consola.leerNombre(), Consola.leerTelefono());
		} catch (OperationNotSupportedException e) {
			System.out.print(e.getMessage());
		}
	}

	private void devolverAlquiler() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 8-Devolver Alquiler");
			controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
		} catch (OperationNotSupportedException e) {
			System.out.print(e.getMessage());
		}
	}

	private void borrarCliente() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 9-Borrar Cliente");
			controlador.borrar(Consola.leerClienteDni());
		} catch (OperationNotSupportedException e) {
			System.out.print(e.getMessage());
		}
	}

	private void borrarTurismo() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 10-Borrar Turismo");
			controlador.borrar(Consola.leerTurismoMatricula());
		} catch (OperationNotSupportedException e) {
			System.out.print(e.getMessage());
		}
	}

	private void borrarAlquiler() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 11-Borrar Alquiler");
			controlador.borrar(Consola.leerAlquiler());
		} catch (OperationNotSupportedException e) {
			System.out.print(e.getMessage());
		}
	}

	private void listarClientes() {
		Consola.mostrarCabecera("Estamos en la opción --> 12-Listar Clientes");
		controlador.getClientes();
	}

	private void listarTurismos() {
		Consola.mostrarCabecera("Estamos en la opción --> 13-Listar Turismos");
		controlador.getTurismos();
	}

	private void listarAlquileres() {
		Consola.mostrarCabecera("Estamos en la opción --> 14-Listar Alquileres");
		controlador.getAlquileres();
	}

	private void listarAlquileresCliente() {
		Consola.mostrarCabecera("Estamos en la opción --> 15-Listar los Alquileres de un Cliente");
		controlador.getAlquileres(Consola.leerClienteDni());
	}

	private void listarAlquileresTurismo() {
		Consola.mostrarCabecera("Estamos en la opción --> 16-Listar los Alquileres de un Turismo");
		controlador.getAlquileres(Consola.leerTurismoMatricula());
	}

}
