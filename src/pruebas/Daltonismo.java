package pruebas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import interfaces.Pruebas;

public class Daltonismo implements Pruebas {
	JPanel pnlPrincipal;
	JPanel pnlDaltonismo;
	JPanel pnlResultados;

	JLabel lbl1;
	JLabel lblImgResul;

	JButton btnContinuar;
	JButton btnEnviar;

	JSlider js;

	Oyente oyente = new Oyente();
	
	ImageIcon imgTextD[] = new ImageIcon[16];
	ImageIcon imgTextRD[] = new ImageIcon[15];
	JTextField txtNumD;

	JTextArea txaSalida;

	JScrollPane scpScroll;

	int almacenNum[] = new int[15];
	int numOri[] = { 12, 8, 29, 5, 3, 15, 74, 6, 45, 5, 7, 16, 73, 26, 42 };
	String resultado[] = new String[15];
	int cont=0;
	int x = 0;
	boolean terminado=false;
	String resulPrueba;

	public String a() {
		String lista = "";
		for (int i = 0; i < almacenNum.length; i++) {
			lista += almacenNum[i] + "\n";
		}
		return lista;
	}

	public void calcularDaltonismo() {

		for (int i = 0; i < 15; i++) {
			if (almacenNum[i] == numOri[i]) {
				resultado[i] = "correcto";

			} else {
				resultado[i] = "incorrecto";
				cont++;
			}

		}

	}

	public String mostrarResultados() {
		String list = "\t\t    Resultados\n\n\n";
		for (int i = 0; i < 15; i++) {
			list += " " + (i + 1) + "). Usted observo:" + almacenNum[i]
					+ "\tLo correcto era:" + numOri[i]
					+ "\tUsted estuvo en lo " + resultado[i] + "\n\n";
		}
		return list;
	}



	public JPanel Prueba() {
		pnlPrincipal = new JPanel();
		pnlPrincipal.setLayout(null);

		Font text = new Font("Verdana", Font.PLAIN, 14);


		
		pnlResultados = new JPanel();
		pnlResultados.setLayout(null);
		pnlResultados.setBounds(0, 0, 800, 600);
		pnlResultados.setVisible(false);
		pnlPrincipal.add(pnlResultados);

		pnlDaltonismo = new JPanel();
		pnlDaltonismo.setLayout(null);
		pnlDaltonismo.setBackground(Color.white);
		pnlDaltonismo.setBounds(0, 0, 800, 600);
		pnlPrincipal.add(pnlDaltonismo);

		txaSalida = new JTextArea();
		txaSalida.setEditable(false);
		txaSalida.setFont(text);
		txaSalida.setBackground(Color.pink);

		scpScroll = new JScrollPane(txaSalida);
		scpScroll.setBounds(10, 10, 780, 300);
		pnlResultados.add(scpScroll);

		for (int i = 0; i < imgTextRD.length; i++) {
			imgTextD[i] = new ImageIcon("pruebas/prbDaltonismo/" + (i + 1)
					+ ".png");
			imgTextRD[i] = new ImageIcon("pruebas/prbDaltonismo/" + (i + 1)
					+ ".1.png");
		}
		imgTextD[15] = new ImageIcon("pruebas/prbDaltonismo/15.png");

		lbl1 = new JLabel();
		lbl1.setIcon(imgTextD[0]);
		lbl1.setBounds(150, 20, 281, 276);
		pnlDaltonismo.add(lbl1);

		lblImgResul = new JLabel();
		lblImgResul.setIcon(imgTextRD[0]);
		lblImgResul.setBounds(200, 320, 400, 196);
		pnlResultados.add(lblImgResul);

		btnEnviar = new JButton("Siguiente");
		btnEnviar.setBounds(500, 150, 100, 30);
		btnEnviar.addActionListener(oyente);
		pnlDaltonismo.add(btnEnviar);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(470, 250, 150, 30);
		btnContinuar.addActionListener(oyente);
		pnlDaltonismo.add(btnContinuar);
		
		txtNumD = new JTextField();
		txtNumD.addActionListener(oyente);
		txtNumD.setBounds(500, 100, 100, 30);
		pnlDaltonismo.add(txtNumD);

		js = new JSlider();
		js.setBounds(10, 520, 780, 50);
		js.setMinimum(1);
		js.setMaximum(15);
		js.setMinorTickSpacing(1);
		js.setPaintLabels(true);
		js.setMajorTickSpacing(1);
		js.setPaintTicks(true);
		js.setValue(1);
		// registrar componente de escucha de eventos de JSlider
		js.addChangeListener(oyente);
		pnlResultados.add(js);

		btnContinuar.setEnabled(false);
		
		pnlPrincipal.setPreferredSize(new Dimension(800, 786));
		return pnlPrincipal;
	}

	public Dimension devolverDimensiones() {
		return new Dimension(800, 480);
	}

	public boolean devolverEstado() {
		return terminado;
	}

	public String devolverResultado() {
		double rs =  cont*100.0/15;
		return rs+"% de daltonismo";
	}

	public void instruccionesPrueba() {

		JOptionPane
				.showMessageDialog(
						null,
						"Prueba de Ishihara\n\n"
								+ "Instrucciones:\n"
								+ "   1. Sentarse alrededor de 75cm de su monitor, con cada círculo fijado en el nivel del ojo.\n"
								+ "   2. Escribir los números que persibe en la imagen en el cuadro de texto.\n"
								+ "   3. Una vez terminado el ingreso de todos los numeros pulsar el boton continuear para poder observar sus resultados.",
						"Prueba de daltonismo  Instruccioes",
						JOptionPane.INFORMATION_MESSAGE);

	}

	public String nombrePrueba() {
		return "Test de daltonismo";
	}
	
	
	class Oyente implements ActionListener, ChangeListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnContinuar) {
					calcularDaltonismo();
					pnlDaltonismo.setVisible(false);
					txaSalida.setText(mostrarResultados());
					pnlResultados.setVisible(true);
					terminado=true;
			}
			if (e.getSource() == btnEnviar || e.getSource()==txtNumD) {
				if (x < 15) {
					if ((txtNumD.getText().matches("[0-9]{1,2}"))) {

						almacenNum[x] = Integer.parseInt(txtNumD.getText());
						lbl1.setIcon(imgTextD[x + 1]);
						x++;
						txtNumD.setText("");
						txtNumD.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe ingresar un numero");
					}

					if (x == 15) {
						txtNumD.setText("");
						txtNumD.setEnabled(false);
						btnEnviar.setEnabled(false);
						btnContinuar.setEnabled(true);
						x = 2;
					}
				}

			}
		}

		public void stateChanged(ChangeEvent e) {

			int y = js.getValue();

			if (y == 1) {
				lblImgResul.setIcon(imgTextRD[0]);
			}
			if (y == 2) {
				lblImgResul.setIcon(imgTextRD[1]);
			}
			if (y == 3) {
				lblImgResul.setIcon(imgTextRD[2]);
			}
			if (y == 4) {
				lblImgResul.setIcon(imgTextRD[3]);
			}
			if (y == 5) {
				lblImgResul.setIcon(imgTextRD[4]);
			}
			if (y == 6) {
				lblImgResul.setIcon(imgTextRD[5]);
			}
			if (y == 7) {
				lblImgResul.setIcon(imgTextRD[6]);
			}
			if (y == 8) {
				lblImgResul.setIcon(imgTextRD[7]);
			}
			if (y == 9) {
				lblImgResul.setIcon(imgTextRD[8]);
			}
			if (y == 10) {
				lblImgResul.setIcon(imgTextRD[9]);
			}
			if (y == 11) {
				lblImgResul.setIcon(imgTextRD[10]);
			}
			if (y == 12) {
				lblImgResul.setIcon(imgTextRD[11]);
			}
			if (y == 13) {
				lblImgResul.setIcon(imgTextRD[12]);
			}
			if (y == 14) {
				lblImgResul.setIcon(imgTextRD[13]);
			}
			if (y == 15) {
				lblImgResul.setIcon(imgTextRD[14]);
			}

		}
	}

}
