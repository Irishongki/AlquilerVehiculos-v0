package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class Clientes {

	private List<Cliente> coleccionClientes;

	public Clientes() {
		coleccionClientes = new ArrayList<>();
	}

	public List<Cliente> get() {
		return new ArrayList<>(coleccionClientes);
	}

	public int getCantidad() {
		return coleccionClientes.size();
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		if (coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}
		coleccionClientes.add(cliente);
	}

	public Cliente buscar(Cliente cliente) {
		Cliente clienteEncontrado;
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		int indice = coleccionClientes.indexOf(cliente);
		if (coleccionClientes.contains(cliente)) {
			clienteEncontrado = coleccionClientes.get(indice);
		} else {
			clienteEncontrado = null;
		}
		return clienteEncontrado;
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		if (!coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
		coleccionClientes.remove(cliente);
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		if (!coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
		if (nombre != null && !nombre.isBlank()) {
			cliente.setNombre(nombre);
		}
		if (telefono != null && !telefono.isBlank()) {
			cliente.setTelefono(telefono);
		}

	}
}
