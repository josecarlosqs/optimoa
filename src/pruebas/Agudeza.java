package pruebas;

import java.awt.*;

import interfaces.Pruebas;
import javax.swing.*;

import biblioteca.Utiles;

public class Agudeza implements Pruebas {
	JPanel panel = new JPanel();
	JScrollPane panel1;

	// parte principal de programa
	JTextField t1 = new JTextField(8);
	JTextField t2 = new JTextField(8);
	JTextField t3 = new JTextField(8);
	JTextField t4 = new JTextField(8);
	JTextField t5 = new JTextField(8);
	JTextField t6 = new JTextField(8);
	JTextField t7 = new JTextField(8);
	JTextField t8 = new JTextField(8);
	JTextField t9 = new JTextField(8);
	JTextField t0 = new JTextField(8);

	public JPanel Prueba() {
		panel.setPreferredSize(new Dimension(470, 680));

		// Agregando lineas
		JLabel lin1 = new JLabel("");
		JLabel lin2 = new JLabel("");
		JLabel lin3 = new JLabel("");
		JLabel lin4 = new JLabel("");
		JLabel lin5 = new JLabel("");
		JLabel lin6 = new JLabel("");
		JLabel lin7 = new JLabel("");
		JLabel lin8 = new JLabel("");
		JLabel lin9 = new JLabel("");
		JLabel lin0 = new JLabel("");
		ImageIcon im1 = new ImageIcon("pruebas/agVisual/l1.png");
		ImageIcon im2 = new ImageIcon("pruebas/agVisual/l2.png");
		ImageIcon im3 = new ImageIcon("pruebas/agVisual/l3.png");
		ImageIcon im4 = new ImageIcon("pruebas/agVisual/l4.png");
		ImageIcon im5 = new ImageIcon("pruebas/agVisual/l5.png");
		ImageIcon im6 = new ImageIcon("pruebas/agVisual/l6.png");
		ImageIcon im7 = new ImageIcon("pruebas/agVisual/l7.png");
		ImageIcon im8 = new ImageIcon("pruebas/agVisual/l8.png");
		ImageIcon im9 = new ImageIcon("pruebas/agVisual/l9.png");
		ImageIcon im0 = new ImageIcon("pruebas/agVisual/l10.png");

		lin1.setBounds(centrarH(im1, 10));
		t1.setBounds(160, 85, 150, 20);
		lin2.setBounds(centrarH(im2, 125));
		t2.setBounds(160, 178, 150, 20);
		lin3.setBounds(centrarH(im3, 218));
		t3.setBounds(160, 250, 150, 20);
		lin4.setBounds(centrarH(im4, 290));
		t4.setBounds(160, 316, 150, 20);
		lin5.setBounds(centrarH(im5, 356));
		t5.setBounds(160, 377, 150, 20);
		lin6.setBounds(centrarH(im6, 417));
		t6.setBounds(160, 436, 150, 20);
		lin7.setBounds(centrarH(im7, 476));
		t7.setBounds(160, 493, 150, 20);
		lin8.setBounds(centrarH(im8, 533));
		t8.setBounds(160, 548, 150, 20);
		lin9.setBounds(centrarH(im9, 588));
		t9.setBounds(160, 602, 150, 20);
		lin0.setBounds(centrarH(im0, 642));
		t0.setBounds(160, 654, 150, 20);

		// Configurando Imagenes
		lin1.setIcon(im1);
		lin2.setIcon(im2);
		lin3.setIcon(im3);
		lin4.setIcon(im4);
		lin5.setIcon(im5);
		lin6.setIcon(im6);
		lin7.setIcon(im7);
		lin8.setIcon(im8);
		lin9.setIcon(im9);
		lin0.setIcon(im0);
		// configurando panel
		panel.setLayout(null);
		panel.add(lin1);
		panel.add(t1);
		panel.add(lin2);
		panel.add(t2);
		panel.add(lin3);
		panel.add(t3);
		panel.add(lin4);
		panel.add(t4);
		panel.add(lin5);
		panel.add(t5);
		panel.add(lin6);
		panel.add(t6);
		panel.add(lin7);
		panel.add(t7);
		panel.add(lin8);
		panel.add(t8);
		panel.add(lin9);
		panel.add(t9);
		panel.add(lin0);
		panel.add(t0);

		return panel;

	}

	boolean comprobarCampos() {
		boolean correcto;
		if (t1.getText() == null
				|| Utiles.superTrim(t1.getText()).length() != 1
				&& !t1.getText().equals("-")) {
			JOptionPane.showMessageDialog(null,
					"Error en la linea 1, comprueba lo ingresado porfavor.",
					"Error", JOptionPane.ERROR_MESSAGE);
			correcto = false;
		} else if (t2.getText() == null
				|| Utiles.superTrim(t2.getText()).length() != 2
				&& !t2.getText().equals("-")) {
			JOptionPane.showMessageDialog(null,
					"Error en la linea 2, comprueba lo ingresado porfavor.",
					"Error", JOptionPane.ERROR_MESSAGE);
			correcto = false;
		} else if (t3.getText() == null
				|| Utiles.superTrim(t3.getText()).length() != 3
				&& !t3.getText().equals("-")) {
			JOptionPane.showMessageDialog(null,
					"Error en la linea 3, comprueba lo ingresado porfavor.",
					"Error", JOptionPane.ERROR_MESSAGE);
			correcto = false;
		} else if (t4.getText() == null
				|| Utiles.superTrim(t4.getText()).length() != 4
				&& !t4.getText().equals("-")) {
			JOptionPane.showMessageDialog(null,
					"Error en la linea 4, comprueba lo ingresado porfavor.",
					"Error", JOptionPane.ERROR_MESSAGE);
			correcto = false;
		} else if (t5.getText() == null
				|| Utiles.superTrim(t5.getText()).length() != 5
				&& !t5.getText().equals("-")) {
			JOptionPane.showMessageDialog(null,
					"Error en la linea 5, comprueba lo ingresado porfavor.",
					"Error", JOptionPane.ERROR_MESSAGE);
			correcto = false;
		} else if (t6.getText() == null
				|| Utiles.superTrim(t6.getText()).length() != 6
				&& !t6.getText().equals("-")) {
			JOptionPane.showMessageDialog(null,
					"Error en la linea 6, comprueba lo ingresado porfavor.",
					"Error", JOptionPane.ERROR_MESSAGE);
			correcto = false;
		} else if (t7.getText() == null
				|| Utiles.superTrim(t7.getText()).length() != 7
				&& !t7.getText().equals("-")) {
			JOptionPane.showMessageDialog(null,
					"Error en la linea 7, comprueba lo ingresado porfavor.",
					"Error", JOptionPane.ERROR_MESSAGE);
			correcto = false;
		} else if (t8.getText() == null
				|| Utiles.superTrim(t8.getText()).length() != 8
				&& !t8.getText().equals("-")) {
			JOptionPane.showMessageDialog(null,
					"Error en la linea 8, comprueba lo ingresado porfavor.",
					"Error", JOptionPane.ERROR_MESSAGE);
			correcto = false;
		} else if (t9.getText() == null
				|| Utiles.superTrim(t9.getText()).length() != 8
				&& !t9.getText().equals("-")) {
			JOptionPane.showMessageDialog(null,
					"Error en la linea 9, comprueba lo ingresado porfavor.",
					"Error", JOptionPane.ERROR_MESSAGE);
			correcto = false;
		} else if (t0.getText() == null
				|| Utiles.superTrim(t0.getText()).length() != 8
				&& !t0.getText().equals("-")) {
			JOptionPane.showMessageDialog(null,
					"Error en la linea 10, comprueba lo ingresado porfavor.",
					"Error", JOptionPane.ERROR_MESSAGE);
			correcto = false;
		} else {
			correcto = true;
		}

		return correcto;
	}

	public void instruccionesPrueba() {
		JOptionPane
				.showMessageDialog(
						null,
						"\n\nEsta prueba consiste en lo siguiente:\nTienes 10 lineas de letras, cada linea tiene debajo\nun campo de texto, le diras a tu companero lo que leas en cada linea y el lo digitara\nen los campos debajo de su respectiva linea.\n\nSi llegas a un campo que no llegas a leer, entonces dile a tu companero que digite un guion desde esa linea hasta el final",
						"Instrucciones", JOptionPane.INFORMATION_MESSAGE);
	}

	private Rectangle centrarH(ImageIcon elemCentrar, int y) {
		int ancho, alto, ancho1, ancho2;
		Rectangle posFinal;
		ancho = elemCentrar.getIconWidth();
		alto = elemCentrar.getIconHeight();
		ancho1 = 470;
		ancho2 = elemCentrar.getIconWidth();
		posFinal = new Rectangle((ancho1 - ancho2) / 2, y, ancho, alto);
		return posFinal;
	}

	private String resuPrueba() {
		String tot = "", ec = "";
		int indice;
		String comparativo, medida[] = new String[10];

		medida[0] = "20/200";
		medida[1] = "20/100";
		medida[2] = "20/70";
		medida[3] = "20/50";
		medida[4] = "20/40";
		medida[5] = "20/30";
		medida[6] = "20/25";
		medida[7] = "20/20";
		medida[8] = "20/15";
		medida[9] = "20/10";
		comparativo = "efptozlpedpecfdedfczpfelopzddefpoteclefodpctfdpltceo";
		tot = t1.getText() + t2.getText() + t3.getText() + t4.getText()
				+ t5.getText() + t6.getText() + t7.getText() + t8.getText()
				+ t9.getText() + t0.getText();
		tot = tot.toLowerCase();
		tot = Utiles.superTrim(tot);

		if (comparativo.length() > tot.length()) {
			comparativo = comparativo.substring(0, tot.length());
		}

		indice = -1;
		for (int i = 0; i < comparativo.length(); i++) {
			if (comparativo.charAt(i) != tot.charAt(i)) {
				indice = i;
				break;
			}
		}

		if (indice == -1) {

		} else if (indice == 0) {
			indice = 0;
		} else if (indice < 3) {
			indice = 1;
		} else if (indice < 6) {
			indice = 2;
		} else if (indice < 10) {
			indice = 3;
		} else if (indice < 15) {
			indice = 4;
		} else if (indice < 21) {
			indice = 5;
		} else if (indice < 28) {
			indice = 6;
		} else if (indice < 36) {
			indice = 7;
		} else if (indice < 44) {
			indice = 8;
		} else {
			indice = 9;
		}

		if (indice == -1) {
			ec = "Medida perfecta";
		} else {
			ec = medida[indice];
		}
		System.out.println(tot);
		System.out.println(comparativo);
		return ec;

	}

	public String devolverResultado() {
		String res = null;
		if (comprobarCampos()) {
			res = resuPrueba();
		}
		
		return res;
		
	}

	public boolean devolverEstado() {
		boolean estado=false;
		if((t1.getText()).length()==0 || (t2.getText()).length()==0 || (t3.getText()).length()==0 || (t4.getText()).length()==0 || (t5.getText()).length()==0 || (t6.getText()).length()==0 || (t7.getText()).length()==0 || (t8.getText()).length()==0 || (t9.getText()).length()==0 || (t0.getText()).length()==0){
			estado = false;
		}else{
			estado = true;
		}
		return estado;
	}

	public Dimension devolverDimensiones() {
		Dimension tamPrueba = new Dimension(700, 500);
		return tamPrueba;
	}

	public String nombrePrueba() {
		return "Agudeza visual";
	}

}
