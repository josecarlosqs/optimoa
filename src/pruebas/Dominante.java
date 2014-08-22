package pruebas;

import interfaces.Pruebas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dominante implements Pruebas {

	JSlider regla;
	int contEnter = 0;
	int primeraPosicion;
	JLabel lblindicador;
	JPanel pnlOjoDom;
	JLabel lblinstrucciones;
	String ojo;

	public JPanel Prueba() {

		pnlOjoDom = new JPanel();
		pnlOjoDom.setLayout(null);

		regla = new JSlider();
		regla.setBounds(10, 40, 800, 50);
		regla.setMinorTickSpacing(1);
		regla.setPaintLabels(true);
		regla.setMajorTickSpacing(5);
		regla.setPaintTicks(true);

		lblindicador = new JLabel("Medida tomada", JLabel.CENTER);
		lblindicador.setForeground(Color.red);
		lblindicador.setVisible(false);
		lblindicador.setBounds(150, 2, 500, 30);
		pnlOjoDom.add(lblindicador);

		
		
		regla.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER && contEnter == 1) {
					lblindicador.setForeground(Color.green);
					lblindicador.setVisible(true);
					if (Math.abs(primeraPosicion - 50) < Math.abs(regla
							.getValue() - 50)) {
						ojo = "1";
					} else {
						ojo = "2";
					}

					//pnlOjoDom.setVisible(false);
					regla.setEnabled(false);
					lblindicador.setText("Prueba terminada, haz click en el boton siguiente para ir a la siguiente prueba.");
					lblindicador.setForeground(new Color(0, 122, 0));
					lblindicador.setVisible(true);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					primeraPosicion = regla.getValue();
					regla.setValue(50);
					lblindicador.setVisible(true);
					contEnter++;
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT
						|| e.getKeyCode() == KeyEvent.VK_LEFT) {
					lblindicador.setVisible(false);
				}
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		
		
		
		pnlOjoDom.add(regla, BorderLayout.NORTH);
		pnlOjoDom.setPreferredSize(new Dimension(800, 100));
		return pnlOjoDom;
	}

	public String devolverResultado() {
		return ojo;
	}

	public void instruccionesPrueba() {
		JOptionPane
				.showMessageDialog(
						null,
						"1. Coloquese a 1 paso de la pantalla, teniendo a esta siempre al frente.\n"
								+ "2. Haga una O con los dedos pulgar e indice y coloquehos al frente de su rostro, de tal modo que\n" +
										"  tenga el señalador de la prueba al centro de la O.\n"
								+ "3. Cierre el ojo izquierdo y , si se movio el indicador, digame a su compañero que lo mueva\n" +
										"  hasta que denuevo este ubicado en el centro de la O, una vez hecho presione [ENTER], el marcador se centrara denuevo. \n"
								+ "4. Sin moverse de su posición, ciere el ojo izquierdo, abra el derecho y repita.\n"
								+ "5. Una vez culminado presione [ENTER].");

	}

	public boolean devolverEstado() {
		boolean estado;
		if (ojo == null) {
			estado = false;
		} else {
			estado = true;
		}
		return estado;
	}

	public Dimension devolverDimensiones() {
		Dimension tamPrueba = new Dimension(830, 400);
		return tamPrueba;
	}

	public String nombrePrueba() {
		return "Ojo dominante";
	}

}
