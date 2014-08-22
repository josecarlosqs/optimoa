package biblioteca;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

/**
 * <strong>Biblioteca de clases para usar en JAVA.</strong><br>
 * 
 * @author Jose Carlos Quichiz Santome
 * @version
 * 
 */
public class Utiles {

	/**
	 * Devuelve un numero aleatorio tipo entero en base a un rango asignado.<br>
	 * PD:(Si sirviera: La formula de los aleatorios es: (MAYOR-MENOR+1)+MENOR )
	 * 
	 * @param de
	 *            Inicio del rango
	 * @param a
	 *            Final del rango
	 */
	public static int aleatorio(int de, int a) {
		int al;
		if (de != a) {
			de = Math.min(de, a);
			a = Math.max(de, a);
			al = (int) (Math.random() * (a - de + 1) + de);
		} else {
			al = a;
		}
		return al;
	}

	/**
	 * Devuelve hora actual en hora:minutos:segundos<br>
	 * <strong>No lleva ningun parametro</strong>
	 */
	public static String hora() {
		String fhora, h, m, s;
		int hora, minutos, segundos;
		Calendar calendario = new GregorianCalendar();

		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		if (hora < 10) {
			h = "" + 0 + "" + hora;
		} else {
			h = hora + "";
		}

		if (minutos < 10) {
			m = "" + 0 + "" + minutos;
		} else {
			m = minutos + "";
		}

		if (segundos < 10) {
			s = "" + 0 + "" + segundos;
		} else {
			s = segundos + "";
		}
		fhora = h + ":" + m + ":" + s;

		return fhora;
	}

	/**
	 * Devuelve fecha actual en Dia/Mes/Año<br>
	 * <strong>No lleva ningun parametro</strong>
	 */
	public static String fecha() {
		int dia, mes, anio;
		String fecha, d, me, a;
		Calendar calendario = new GregorianCalendar();

		dia = calendario.get(Calendar.DAY_OF_MONTH);
		mes = calendario.get(Calendar.MONTH);
		anio = calendario.get(Calendar.YEAR);
		if (dia < 10) {
			d = "" + 0 + "" + dia;
		} else {
			d = dia + "";
		}

		if (mes < 10) {
			me = "" + 0 + "" + mes;
		} else {
			me = mes + 1 + "";
		}

		if (anio < 10) {
			a = "" + 0 + "" + anio;
		} else {
			a = anio + "";
		}
		fecha = d + "/" + me + "/" + a;

		return fecha;

	}

	/**
	 * Devuelve una cadena sin ningun espacio.
	 * 
	 * @param varTxt
	 */
	public static String superTrim(String varTxt) {
		char c;
		String nom = "";
		varTxt = varTxt.trim();
		for (int i = 0; i < varTxt.length(); i++) {
			c = varTxt.charAt(i);
			if (c != ' ') {
				nom = nom + c;
			}
		}
		return nom;
	}

	/**
	 * 
	 * Devuelve un string con capitalización, por lo general usado en nombres
	 * propios.
	 * 
	 * @param varTxt
	 * @return
	 */
	public static String formatoNombre(String varTxt) {
		String res = "", nm[] = new String[varTxt.length()];
		boolean sp = false;
		varTxt = varTxt.trim();
		for (int i = 0; i < varTxt.length(); i++) {
			nm[i] = varTxt.charAt(i) + "";
		}
		nm[0] = nm[0].toUpperCase();
		for (int i = 1; i < nm.length; i++) {
			if (nm[i].equals(" ")) {
				sp = true;
			} else if (sp) {
				nm[i] = nm[i].toUpperCase();
				sp = false;
			}
		}

		for (int i = 0; i < nm.length; i++) {
			res += nm[i];
		}
		return res;
	}

	/**
	 * 
	 * Con este metodo probamos como queda algun JPanel que creemos, solo
	 * llamamos al metodo y le ponemos de parametro el JPanel
	 * 
	 * @param componente
	 */

	public static void probarGUI(JPanel componente) {
		JFrame formu = new JFrame();
		formu.setSize(new Dimension(800, 800));
		formu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formu.setLayout(new FlowLayout());
		formu.add(componente);

		Icon icon = new ImageIcon("cand.png");
		UIDefaults defaults = UIManager.getDefaults();
		defaults.put("Slider.horizontalThumbIcon", icon);
		formu.setVisible(true);
	}
}