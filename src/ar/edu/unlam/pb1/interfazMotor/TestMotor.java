package ar.edu.unlam.pb1.interfazMotor;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominioMotor.Motor;

public class TestMotor {
	static Scanner teclado = new Scanner(System.in);
	private static final int OPCION_COMBUSTIBLE = 1;
	private static final int OPCION_CUANTA_NAFTA = 2;;
	private static final int OPCION_KM_TOTALES = 3;
	private static final int OPCION_CUANTOS_KM = 4;
	private static final int OPCION_SALIR = 9;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char tipoMotor;
		double litros;
		int opcion = OPCION_SALIR;
		String cargarCombustible;
		double cantidadCombustible;

		menuMotor();
		tipoMotor = teclado.next().toLowerCase().charAt(0);
		mostrarMensaje("\nIngrese litros que tiene");
		litros = teclado.nextDouble();

		Motor nuevoMotor = new Motor(tipoMotor, litros);// construyo un nuevo motor segun lo que ingreso por teclado
		mostrarMensaje(nuevoMotor.dimeTipoMotor());
		mostrarMensaje(nuevoMotor.dimeTipoBomba());
		mostrarMensaje("\nLa autonomia es de: " + nuevoMotor.calculoAutonomia() + "Km");

		menuRecorrido();
		do {
			opcion = teclado.nextInt();
			switch (opcion) {
			case OPCION_COMBUSTIBLE:
				mostrarMensaje("Ingrese cantidad de combustible");
				cantidadCombustible = teclado.nextDouble();
				nuevoMotor.cargarCombustible(cantidadCombustible);
				mostrarMensaje("Ahora su autonomia es de: " + nuevoMotor.calculoAutonomia() + "Km");
				break;
			case OPCION_CUANTA_NAFTA:
				mostrarMensaje("Los litros actuales son: " + nuevoMotor.getLitros());
				break;
			case OPCION_KM_TOTALES:
				mostrarMensaje("Ingrese litros gastados");
				double litrosGastados = teclado.nextDouble();
				mostrarMensaje("Los Km recorridos son: " + nuevoMotor.kilometrosTotales(litrosGastados));
				// litros que tengo - litros que gaste= Km recorridos
				break;
			case OPCION_CUANTOS_KM:
				mostrarMensaje("\nLa autonomia es de: " + nuevoMotor.calculoAutonomia() + "Km");
				break;
			case OPCION_SALIR:
				mostrarMensaje("SALIENDO...");
				break;
			default:

				break;
			}
		} while (opcion != OPCION_SALIR);

		// cargarCombustible(nuevoMotor);
		mostrarMensaje("\n----MUCHAS GRACIAS----");
	}

	private static void menuRecorrido() {
		mostrarMensaje("\n----PROBAR MOTOR----");
		mostrarMensaje("Ingrese 1 para cargar combustible");
		mostrarMensaje("Ingrese 2 para saber cuanto me queda de nafta");// mostrarMensaje("Ingrese la distancia
																		// recorrida");
		mostrarMensaje("Ingrese 3 para saber los Km totales recorridos");
		mostrarMensaje("Ingrese 4 para cuantos Km puedo hacer con el combustible disponible");

	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	public static void menuMotor() {
		mostrarMensaje("---¿Que motor queres armar?---");
		mostrarMensaje("\nPulse n si tiene motor a Nafta");
		mostrarMensaje("Pulse d si tiene motor a Diesel");
		mostrarMensaje("Pulse g si tiene motor a Gas");
		mostrarMensaje("Pulse m si tiene motor a Nafta/Gas");
		mostrarMensaje("Pulse h si tiene motor Hibrido");
	}/*
		 * private static void cargarCombustible(Motor nuevoMotor) { String
		 * cargarCombustible; double cantidadCombustible;
		 * mostrarMensaje("\n¿Desea cargar combustible?"); cargarCombustible =
		 * teclado.next(); switch (cargarCombustible) { case "si":
		 * mostrarMensaje("Ingrese cantidad de combustible"); cantidadCombustible =
		 * teclado.nextDouble(); nuevoMotor.cargarCombustible(cantidadCombustible);
		 * mostrarMensaje("Ahora su autonomia es de: " + nuevoMotor.calculoAutonomia() +
		 * "Km"); break; case "no": mostrarMensaje("No se cargo combustible"); default:
		 * break; } }
		 */

}
