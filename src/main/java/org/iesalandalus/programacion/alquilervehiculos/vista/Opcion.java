package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

public enum Opcion {
	SALIR("Salir"), INSERTAR_CLIENTE("Insertar_Cliente"), INSERTAR_TURISMO("Insertar_Turismo"),
	INSERTAR_ALQUILER("Insertar_Alquiler"), BUSCAR_CLIENTE("Buscar_Cliente"), BUSCAR_TURISMO("Buscar_Turismo"),
	BUSCAR_ALQUILER("Buscar_Alquiler"), MODIFICAR_CLIENTE("Modificar_Cliente"), DEVOLVER_ALQUILER("Devolver_Alquiler"),
	BORRAR_CLIENTE("Borrar_Cliente"), BORRAR_TURISMO("Borrar_Turismo"), BORRAR_ALQUILER("Borrar_Alquiler"),
	LISTAR_CLIENTES("Listar_Clientes"), LISTAR_TURISMOS("Listar_Turismos"), LISTAR_ALQUILERES("Listar_Alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar_Alquileres_Cliente"), LISTAR_ALQUILERES_TURISMO("Listar_Alquileres_Turismo");

	private String texto;

	private Opcion(String texto) {
		this.texto = texto;
	}

	private static boolean esOrdinalValido(int ordinal) {
		boolean ordinalCorrecto = true;
		if (ordinal < 0 || ordinal >= values().length) {
			ordinalCorrecto = false;
		}
		return ordinalCorrecto;
	}

	public static Opcion get(int ordinal) throws OperationNotSupportedException {
		if (!esOrdinalValido(ordinal)) {
			throw new OperationNotSupportedException("El ordinal pasado no es correcto");
		}
		return values()[ordinal];
	}

	@Override
	public String toString() {
		return String.format("%d-%s", ordinal(), texto);
	}
}
