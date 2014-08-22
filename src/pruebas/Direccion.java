package pruebas;
import interfaces.Pruebas;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Direccion implements Pruebas {

	int xr, yr;
	int xl, yl;
	int xu, yu;
	int xd, yd;
	int cont = 0;
	int good = 0;
	double porcentaje=-1;
	int direccion[] = new int[28];
	int respuesta[] = { 39, 37, 39, 39, 37, 40, 40, 38, 37, 40, 37, 40, 39, 38,	39, 39, 37, 39, 38, 39, 40, 37, 40, 39, 37, 38, 39, 38 };
	ImageIcon icono[] = new ImageIcon[28];
	JLabel lblIcono[] = new JLabel[28];
	JLabel lblInstrucciones;
	JPanel pnlPrincipalDirDefOc;
	JPanel pnlDirDefOc;
	JButton btnIzq;
	JButton btnDer;
	JButton btnArr;
	JButton btnAba;
	ImageIcon iconArr;
	ImageIcon iconAba;
	ImageIcon iconIzq;
	ImageIcon iconDer;
	ImageIcon iconArrOsc;
	ImageIcon iconAbaOsc;
	ImageIcon iconIzqOsc;
	ImageIcon iconDerOsc;
	
	public JPanel Prueba() {

		Oyente capturar = new Oyente();
		for (int i = 0; i < icono.length; i++) {

			if (i < 15) {
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/" + ""
						+ (i + 1) + ".png");
			}
			if (i == 9) {
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/7.png");
			}
			if (i == 14) {
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/13.png");
			}

			switch (i) {
			case 15:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/15.png");
				break;
			case 16:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/16.png");
				break;
			case 17:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/15.png");
				break;
			case 18:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/17.png");
				break;
			case 19:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/15.png");
				break;
			case 20:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/18.png");
				break;
			case 21:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/19.png");
				break;
			case 22:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/20.png");
				break;
			case 23:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/21.png");
				break;
			case 24:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/19.png");
				break;
			case 25:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/22.png");
				break;
			case 26:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/21.png");
				break;
			case 27:
				icono[i] = new ImageIcon("pruebas/dirDeficiencia/22.png");
				break;
			}
			lblIcono[i] = new JLabel(icono[i]);
		}

		lblIcono[0].setBounds(50, 5, 300, 300);

		lblIcono[1].setBounds(45, 310, 150, 150);
		lblIcono[2].setBounds(210, 310, 150, 150);

		lblIcono[3].setBounds(40, 470, 75, 75);
		lblIcono[4].setBounds(162, 470, 75, 75);
		lblIcono[5].setBounds(284, 470, 75, 75);

		lblIcono[6].setBounds(35, 550, 50, 50);
		lblIcono[7].setBounds(130, 550, 50, 50);
		lblIcono[8].setBounds(220, 550, 50, 50);
		lblIcono[9].setBounds(315, 550, 50, 50);

		lblIcono[10].setBounds(30, 610, 25, 25);
		lblIcono[11].setBounds(118, 610, 25, 25);
		lblIcono[12].setBounds(185, 610, 25, 25);
		lblIcono[13].setBounds(263, 610, 25, 25);
		lblIcono[14].setBounds(335, 610, 25, 25);

		lblIcono[15].setBounds(25, 650, 13, 13);
		lblIcono[16].setBounds(95, 650, 13, 13);
		lblIcono[17].setBounds(170, 650, 13, 13);
		lblIcono[18].setBounds(230, 650, 13, 13);
		lblIcono[19].setBounds(300, 650, 13, 13);
		lblIcono[20].setBounds(370, 650, 13, 13);

		lblIcono[21].setBounds(30, 670, 7, 7);
		lblIcono[22].setBounds(70, 670, 7, 7);
		lblIcono[23].setBounds(130, 670, 7, 7);
		lblIcono[24].setBounds(193, 670, 7, 7);
		lblIcono[25].setBounds(270, 670, 7, 7);
		lblIcono[26].setBounds(330, 670, 7, 7);
		lblIcono[27].setBounds(370, 670, 7, 7);

		iconAba = new ImageIcon("pruebas/dirDeficiencia/abajo.png");
		iconAbaOsc = new ImageIcon("pruebas/dirDeficiencia/abajo_osc.png");
		btnAba = new JButton(iconAba);
		btnAba.addKeyListener(capturar);
		btnAba.setBounds(485, 90, 80, 80);

		iconArr = new ImageIcon("pruebas/dirDeficiencia/arriba.png");
		iconArrOsc = new ImageIcon("pruebas/dirDeficiencia/arriba_osc.png");
		btnArr = new JButton(iconArr);
		btnArr.addKeyListener(capturar);
		btnArr.setBounds(485, 10, 80, 80);

		iconIzq = new ImageIcon("pruebas/dirDeficiencia/izquierda.png");
		iconIzqOsc = new ImageIcon("pruebas/dirDeficiencia/"
				+ "izquierda_osc.png");
		btnIzq = new JButton(iconIzq);
		btnIzq.addKeyListener(capturar);
		btnIzq.setBounds(405, 90, 80, 80);

		iconDer = new ImageIcon("pruebas/dirDeficiencia/derecha.png");
		iconDerOsc = new ImageIcon("pruebas/dirDeficiencia/derecha_osc.png");
		btnDer = new JButton(iconDer);
		btnDer.addKeyListener(capturar);
		btnDer.setBounds(565, 90, 80, 80);

		pnlDirDefOc = new JPanel();
		pnlDirDefOc.setLayout(null);
		pnlDirDefOc.setBackground(new Color(255, 233, 233));
		pnlDirDefOc.setBounds(0, 0, 400, 700);

		for (int i = 0; i < icono.length; i++) {
			pnlDirDefOc.add(lblIcono[i]);
		}

		pnlPrincipalDirDefOc = new JPanel();
		pnlPrincipalDirDefOc.setLayout(null);

		pnlPrincipalDirDefOc.setPreferredSize(new Dimension(650, 720));
		pnlPrincipalDirDefOc.add(pnlDirDefOc);
		pnlPrincipalDirDefOc.add(btnDer);
		pnlPrincipalDirDefOc.add(btnIzq);
		pnlPrincipalDirDefOc.add(btnArr);
		pnlPrincipalDirDefOc.add(btnAba);
		
		return pnlPrincipalDirDefOc;
		}

	

	
	
	class Oyente  implements KeyListener {
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			direccion[cont] = 39;
			break;
		case KeyEvent.VK_LEFT:
			direccion[cont] = 37;
			break;
		case KeyEvent.VK_UP:
			direccion[cont] = 38;
			break;
		case KeyEvent.VK_DOWN:
			direccion[cont] = 40;
			break;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			btnDer.setIcon(iconDerOsc);
			lblIcono[cont].setEnabled(false);

			if (direccion[cont] == respuesta[cont]) {
				good++;
			}
			cont++;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			btnIzq.setIcon(iconIzqOsc);
			lblIcono[cont].setEnabled(false);
			if (direccion[cont] == respuesta[cont]) {
				good++;
			}
			cont++;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			btnArr.setIcon(iconArrOsc);
			lblIcono[cont].setEnabled(false);

			if (direccion[cont] == respuesta[cont]) {
				good++;
			}
			cont++;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			btnAba.setIcon(iconAbaOsc);
			lblIcono[cont].setEnabled(false);
			if (direccion[cont] == respuesta[cont]) {
				good++;
			}
			cont++;
		}

		if (cont == 28) {
			porcentaje = good / 28.0;
			porcentaje = Math.rint(porcentaje * 100);
			
			pnlPrincipalDirDefOc.setVisible(false);
		}

	}

	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			btnDer.setIcon(iconDer);
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			btnIzq.setIcon(iconIzq);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			btnArr.setIcon(iconArr);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			btnAba.setIcon(iconAba);
		}
	}

	public void keyTyped(KeyEvent e) {
	}
	}

	public Dimension devolverDimensiones() {
		return new Dimension(700, 600);
	}

	public boolean devolverEstado() {
		boolean f=false;
		if(porcentaje >= 0.0){
			f=true;
		}
		return f;
	}

	public String devolverResultado() {
		return porcentaje+"";
	}

	public void instruccionesPrueba() {
		JOptionPane.showMessageDialog(null, "PRUEBA DE DIRECCION DE DEFICIENCIA OCULAR" +
				"\nSe le mostrará una serie de circulos, use las teclas direccionales (MIRAR IMAGEN)"
						+ "\npara marcar la ubicacion de la abertura de cada circulo comenzando de\n" +
								"arriba a abajo y de izquierda a derecha.");
	}

	public String nombrePrueba() {
		return "Direccion de la deficiencia";
	}
}