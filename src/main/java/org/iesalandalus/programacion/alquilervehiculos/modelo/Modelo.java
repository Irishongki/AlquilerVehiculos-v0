package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {

	private Clientes clientes;
	private Alquileres alquileres;
	private Turismos turismos;

	public Modelo() {

	}

	public void comenzar() {
		clientes = new Clientes();
		alquileres = new Alquileres();
		turismos = new Turismos();
	}

	public void terminar() {
		System.out.print("El modelo ha terminado :)");
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		clientes.insertar(new Cliente(cliente));
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		turismos.insertar(new Turismo(turismo));
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		Cliente clienteBuscado = clientes.buscar(alquiler.getCliente());
		Turismo turismoBuscado = turismos.buscar(alquiler.getTurismo());
		if (clienteBuscado == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}
		if (turismoBuscado == null) {
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}
		alquileres.insertar(
				new Alquiler(clienteBuscado, turismoBuscado, alquiler.getFechaAlquiler()));
	}

	public Cliente buscar(Cliente cliente) {
		return new Cliente(clientes.buscar(cliente));
	}

	public Turismo buscar(Turismo turismo) {
		return new Turismo(turismos.buscar(turismo));
	}

	public Alquiler buscar(Alquiler alquiler) {
		return new Alquiler(alquileres.buscar(alquiler));
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		Alquiler alquilerBuscado = alquileres.buscar(alquiler);
		if (alquilerBuscado == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}
		alquiler.devolver(fechaDevolucion);
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get(cliente)) {
			borrar(alquiler);
		}
		clientes.borrar(cliente);
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get(turismo)) {
			borrar(alquiler);
		}
		turismos.borrar(turismo);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.borrar(alquiler);
	}

	public List<Cliente> getClientes() {
		List<Cliente> listaNueva = new ArrayList<>();
		for (Cliente cliente : clientes.get()) {
			listaNueva.add(new Cliente(cliente));
		}
		return listaNueva;
	}

	public List<Turismo> getTurismos() {
		List<Turismo> listaNueva = new ArrayList<>();
		for (Turismo turismo : turismos.get()) {
			listaNueva.add(new Turismo(turismo));
		}
		return listaNueva;
	}

	public List<Alquiler> getAlquileres() {
		List<Alquiler> listaNueva = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			listaNueva.add(new Alquiler(alquiler));
		}
		return listaNueva;
	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		List<Alquiler> listaNueva = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get(cliente)) {
			listaNueva.add(new Alquiler(alquiler));
		}
		return listaNueva;
	}

	public List<Alquiler> getAlquileres(Turismo turismo) {
		List<Alquiler> listaNueva = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get(turismo)) {
			listaNueva.add(new Alquiler(alquiler));
		}
		return listaNueva;
	}

}
