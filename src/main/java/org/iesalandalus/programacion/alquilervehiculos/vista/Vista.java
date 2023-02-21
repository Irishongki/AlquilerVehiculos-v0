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
		Opcion opcion;
		do {
			Consola.mostrarMenu();
			opcion = Consola.elegirOpcion();
			ejecutar(opcion);
			System.out.printf("%n%n");
		} while (opcion != Opcion.SALIR);
	}

	public void terminar() {
		System.out.print("Adioss!!");
		System.exit(0);
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
			System.out.printf("%n");
			controlador.insertar(Consola.leerCliente());
			System.out.print("El cliente se ha insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void insertarTurismo() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 2-Insertar Turismo");
			System.out.printf("%n");
			controlador.insertar(Consola.leerTurismo());
			System.out.print("El turismo se ha insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void insertarAlquiler() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 3-Insertar Alquiler");
			System.out.printf("%n");
			controlador.insertar(Consola.leerAlquiler());
			System.out.print("El Alquiler se ha insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void buscarCliente() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 4-Buscar Cliente");
			System.out.printf("%n");
			System.out.print(controlador.buscar(Consola.leerClienteDni()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void buscarTurismo() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 5-Buscar Turismo");
			System.out.printf("%n");
			System.out.print(controlador.buscar(Consola.leerTurismoMatricula()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}

	}

	private void buscarAlquiler() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 6-Buscar Alquiler");
			System.out.printf("%n");
			System.out.print(controlador.buscar(Consola.leerAlquiler()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void modificarCliente() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 7-Modificar Cliente");
			System.out.printf("%n");
			controlador.modificar(Consola.leerClienteDni(), Consola.leerNombre(), Consola.leerTelefono());
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void devolverAlquiler() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 8-Devolver Alquiler");
			System.out.printf("%n");
			controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void borrarCliente() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 9-Borrar Cliente");
			System.out.printf("%n");
			controlador.borrar(Consola.leerClienteDni());
			System.out.print("El cliente se ha borrado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void borrarTurismo() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 10-Borrar Turismo");
			System.out.printf("%n");
			controlador.borrar(Consola.leerTurismoMatricula());
			System.out.print("El turismo se ha borrado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void borrarAlquiler() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 11-Borrar Alquiler");
			System.out.printf("%n");
			controlador.borrar(Consola.leerAlquiler());
			System.out.print("El Alquiler se ha borrado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void listarClientes() {
		Consola.mostrarCabecera("Estamos en la opción --> 12-Listar Clientes");
		System.out.printf("%n");
		System.out.print(controlador.getClientes());
	}

	private void listarTurismos() {
		Consola.mostrarCabecera("Estamos en la opción --> 13-Listar Turismos");
		System.out.printf("%n");
		System.out.println(controlador.getTurismos());
	}

	private void listarAlquileres() {
		Consola.mostrarCabecera("Estamos en la opción --> 14-Listar Alquileres");
		System.out.printf("%n");
		System.out.println(controlador.getAlquileres());
	}

	private void listarAlquileresCliente() {

		try {
			Consola.mostrarCabecera("Estamos en la opción --> 15-Listar los Alquileres de un Cliente");
			System.out.printf("%n");
			System.out.println(controlador.getAlquileres(Consola.leerClienteDni()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

	private void listarAlquileresTurismo() {
		try {
			Consola.mostrarCabecera("Estamos en la opción --> 16-Listar los Alquileres de un Turismo");
			System.out.printf("%n");
			System.out.println(controlador.getAlquileres(Consola.leerTurismoMatricula()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.print(e.getMessage());
		}
	}

}
