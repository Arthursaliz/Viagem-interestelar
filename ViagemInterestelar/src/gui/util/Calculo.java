package gui.util;

import java.lang.Math;

public class Calculo {

	public double CalculoTempo(double t0, double v) {
		double c = 299792458.0;
		double t0_seconds;
		double fator;

		// Converter o tempo decorrido na espaçonave de dias para segundos
		t0_seconds = t0 * 86400.0;

		// Calcular o fator de Lorentz (gama)
		fator = Math.pow(v, 2.0) / Math.pow(c, 2.0);

		double gama = 1 / Math.sqrt(1 - fator);

		// Calcular o tempo decorrido na Terra em segundos
		double t_seconds = gama * t0_seconds;
		double tempoTerra = t_seconds / 86400.0;
		// Converter o tempo decorrido na Terra de segundos para dias
		return tempoTerra;

	}

}
