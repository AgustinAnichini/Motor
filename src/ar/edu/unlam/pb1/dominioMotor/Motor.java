package ar.edu.unlam.pb1.dominioMotor;

public class Motor {
	private int tipoBomba;
	private char tipoMotor;
	private char combustible;
	private double autonomia;
	private double litros;
	private double autonomiaNafta;
	private double autonomiaDiesel;
	private double autonomiaGas;
	private double autonomiaNaftaGas;
	private double autonomiaHibrido;
	private double kilometrosTotalesRecorridos;
	private double kilometrosRecorridoNafta;
	private double kilometrosRecorridosDiesel;
	private double kilometrosRecorridosGas;
	private double kilometrosRecorridosNaftaGas;
	private double kilometrosRecorridosHibrido;

	public Motor(char tipoMotor, double litros) {
		this.tipoBomba = obtenerNumeroBomba();
		this.tipoMotor = tipoMotor;
		this.combustible = combustible;
		this.autonomia = calculoAutonomia();
		this.litros = litros;
	}

	private int obtenerNumeroBomba() {
		int tipoBomba = 0;
		switch (tipoMotor) {
		case 'n':
			tipoBomba = 0;
			break;
		case 'd':
			tipoBomba = 1;
			break;
		case 'g':
			tipoBomba = 2;
			break;
		case 'm':
			tipoBomba = 3;
			break;
		case 'h':
			tipoBomba = 4;
			break;

		default:
			break;
		}
		return tipoBomba;
	}

	public String dimeTipoBomba() {
		String tipo = "";
		switch (this.tipoBomba) {
		case 0:
			tipo = "Tiene bomba de combustible y de agua";
			break;
		case 1:
			tipo = "Tiene bomba combustible y calentador";
			break;
		case 2:
			tipo = "Tiene bomba de gas y tanque presurizado";
			break;
		case 3:
			tipo = "Tiene bomba de combustible y de agua";
			break;
		case 4:
			tipo = "Tiene bomba de combustible y conversor dual";
			break;

		default:
			tipo = "ERROR FLACO";
			break;
		}
		return tipo;
	}

	public String dimeTipoMotor() {
		String tipo = "";
		switch (this.tipoMotor) {
		case 'n':
			tipo = "Motor con Combustion por Nafta";
			break;
		case 'd':
			tipo = "Motor con Combustion por Diesel";
			break;

		case 'g':
			tipo = "Motor con Combustion por Gas";
			break;

		case 'm':
			tipo = "Motor con Combustion por Nafta/Gas";
			break;
		case 'h':
			tipo = "Motor hibrido";
			break;

		default:
			break;

		}
		return tipo;
	}

	public void cargarCombustible(double cargarCombustible) {
		this.litros += cargarCombustible;
	}

	public double calculoAutonomia() {
		switch (this.tipoMotor) {
		case 'n':
			obtenerAutonomiaNafta();
			return this.autonomiaNafta;

		case 'd':
			obtenerAutonomiaDiesel();
			return this.autonomiaDiesel;

		case 'g':
			obtenerAutonomiaGas();
			return this.autonomiaGas;

		case 'm':
			obtenerAutonomiaNaftaGas();
			return this.autonomiaNaftaGas;

		case 'h':
			obtenerAutonomiaHibrido();
			return this.autonomiaHibrido;
		default:
			break;

		}
		return 0.0;
	}

	private void obtenerAutonomiaHibrido() {
		this.autonomiaHibrido = litros * 8; // 1km cada 8 litros
	}

	private void obtenerAutonomiaNaftaGas() {
		this.autonomiaNaftaGas = litros * 12; // 1km cada 12 litros
	}

	private void obtenerAutonomiaGas() {
		this.autonomiaGas = litros * 5; // 1km cada 5 litros
	}

	private void obtenerAutonomiaDiesel() {
		this.autonomiaDiesel = litros * 16; // 1km cada 16 litros
	}

	private void obtenerAutonomiaNafta() {
		this.autonomiaNafta = litros * 10; // 1 km cada 10 litros
	}

	public void marchar() {
		if (this.litros > 0) {
			marchar();
		}
	}

	public double getLitros() {
		return this.litros;
	}

	public double kilometrosTotales(double litrosGastados) {
		switch (this.tipoMotor) {
		case 'n':
			return this.kilometrosRecorridoNafta = litrosGastados * 10;

		case 'd':
			return this.kilometrosRecorridosDiesel = litrosGastados * 16;

		case 'g':
			return this.kilometrosRecorridosGas = litrosGastados * 5;

		case 'm':
			return this.kilometrosRecorridosNaftaGas = litrosGastados * 12;

		case 'h':
			return this.kilometrosRecorridosHibrido = litrosGastados * 8;

		default:
			break;
		}
		return 0.0;
	}

}
