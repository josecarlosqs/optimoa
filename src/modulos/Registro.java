package modulos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import biblioteca.Utiles;
import tipos.Usuario;

public class Registro {

	String tmpNombre;
	String tmpApellido;
	String tmpOcupacion;
	int tmpEdad;

	public JPanel pnlRegistrarse;
	JLabel lblRegistro;
	public String tmpOcupaciones[] = { "Escolar", "Universitario", "Tecnico",
			"Academico", "Ingeniero", "Abogado", "Profesor", "Arquitecto" };
	JLabel lblNombre;
	JLabel lblApellido;
	JLabel lblEdad;
	JLabel lblCodigo;
	JLabel lblNombreError;
	JLabel lblApellidoError;
	JLabel lblEdadError;

	JTextField txtNombre;
	JTextField txtApellido;
	JTextField txtEdad;

	JComboBox cboOcupacion;
	JRadioButton rdbOcupaciones[];
	ButtonGroup bgrEstudiante;
	ButtonGroup bgrTrabajador;

	
	Oyente oyente = new Oyente();

	public Registro() {
		rdbOcupaciones = new JRadioButton[8];
		// creo el panel
		pnlRegistrarse = new JPanel();
		pnlRegistrarse.setBounds(0, 0, 500, 600);
		pnlRegistrarse.setLayout(null);

		lblRegistro = new JLabel("Registro de datos");
		lblRegistro.setFont(new Font("Verdana", 3, 35));
		lblRegistro.setBounds(100, 30, 500, 45);
		pnlRegistrarse.add(lblRegistro);

		lblNombre = new JLabel("Nombre : ");
		lblNombre.setFont(new Font("Verdana", 0, 20));
		lblNombre.setBounds(50, 100, 200, 25);
		pnlRegistrarse.add(lblNombre);

		lblApellido = new JLabel("Apellido : ");
		lblApellido.setFont(new Font("Verdana", 0, 20));
		lblApellido.setBounds(50, 150, 200, 25);
		pnlRegistrarse.add(lblApellido);

		lblEdad = new JLabel("Edad : ");
		lblEdad.setFont(new Font("Verdana", 0, 20));
		lblEdad.setBounds(50, 200, 200, 25);
		pnlRegistrarse.add(lblEdad);

		txtNombre = new JTextField();
		txtNombre.setBounds(200, 100, 150, 25);
		pnlRegistrarse.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setBounds(200, 150, 150, 25);
		pnlRegistrarse.add(txtApellido);

		txtEdad = new JTextField();
		txtEdad.setBounds(200, 200, 150, 25);
		pnlRegistrarse.add(txtEdad);

		lblNombreError = new JLabel("Ingresar de 3 a 20 caracteres");
		lblNombreError.setFont(new Font("Verdana", 0, 10));
		lblNombreError.setBounds(200, 127, 220, 15);
		pnlRegistrarse.add(lblNombreError);

		lblApellidoError = new JLabel("Ingresar de 3 a 20 caracteres");
		lblApellidoError.setFont(new Font("Verdana", 0, 10));
		lblApellidoError.setBounds(200, 175, 220, 15);
		pnlRegistrarse.add(lblApellidoError);

		lblEdadError = new JLabel("La edad debe de estar entre 10-100");
		lblEdadError.setFont(new Font("Verdana", 0, 15));
		lblEdadError.setBounds(200, 230, 220, 15);
		pnlRegistrarse.add(lblEdadError);


		// un item listener para ver si es estudiante o trabajador
		cboOcupacion = new JComboBox();
		cboOcupacion.addItem("< Seleccione una ocupacion >");
		cboOcupacion.addItem("Estudiante");
		cboOcupacion.addItem("Trabajador");
		cboOcupacion.addItemListener(oyente);
		cboOcupacion.setBounds(50, 300, 200, 25);
		cboOcupacion.setFont(new Font("Verdana", 0, 25));
		pnlRegistrarse.add(cboOcupacion);
		for (int i = 0; i < rdbOcupaciones.length; i++) {
			rdbOcupaciones[i] = new JRadioButton(tmpOcupaciones[i]);
		}

		for (int i = 0; i < rdbOcupaciones.length / 2; i++) {
			rdbOcupaciones[i].setBounds(50, 50 * i + 350, 200, 25);
			rdbOcupaciones[i + 4].setBounds(50, 50 * i + 350, 200, 25);
		}
		for (int i = 0; i < rdbOcupaciones.length; i++) {
			rdbOcupaciones[i].addItemListener(oyente);
			rdbOcupaciones[i].setFont(new Font("Verdana", 0, 25));
			rdbOcupaciones[i].setVisible(false);
			pnlRegistrarse.add(rdbOcupaciones[i]);
		}
		bgrEstudiante = new ButtonGroup();
		bgrTrabajador = new ButtonGroup();
		for (int i = 0; i < rdbOcupaciones.length / 2; i++) {
			bgrEstudiante.add(rdbOcupaciones[i]);
			bgrTrabajador.add(rdbOcupaciones[i + 4]);
		}

	}

	class Oyente implements ItemListener {
	
		public void itemStateChanged(ItemEvent evento) {
			if (evento.getSource() == cboOcupacion) {
				if (cboOcupacion.getSelectedIndex() == 1) {
					for (int i = 0; i < rdbOcupaciones.length; i++) {
						rdbOcupaciones[i].setVisible(i / 4 == 0);
					}
				} else if (cboOcupacion.getSelectedIndex() == 2) {
					for (int i = 0; i < rdbOcupaciones.length; i++) {
						rdbOcupaciones[i].setVisible(i / 4 > 0);
					}
				} else {
					for (int i = 0; i < rdbOcupaciones.length; i++) {
						rdbOcupaciones[i].setVisible(false);
						rdbOcupaciones[i].setSelected(false);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Registro r = new Registro();
		JFrame f = new JFrame();
		f.setSize(800, 800);
		f.setLayout(null);
		f.add(r.pnlRegistrarse);

		f.setVisible(true);
	}

	public Usuario obtenerUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombre(Utiles.formatoNombre(tmpNombre));
		usuario.setApellido(Utiles.formatoNombre(tmpApellido));
		usuario.setEdad(tmpEdad);
		usuario.setOcupacion(tmpOcupacion);
		return usuario;
	}
	
	public boolean validarCampos(){
		boolean valido = true;

		if (txtNombre.getText().length() < 3) {
			valido = valido && false;
		} else {
			tmpNombre = txtNombre.getText();
		}
		if (txtApellido.toString().length() < 3) {
			valido = valido && false;
		} else {
			tmpApellido = txtApellido.getText();
		}
		try {
				tmpEdad = Integer.parseInt(txtEdad.getText());
				if(tmpEdad<1||tmpEdad>100){
					valido=valido&&false;
				}
		} catch (NumberFormatException ex) {
			valido = valido && false;
		}

		int k;
		for (k = 0; k < rdbOcupaciones.length; k++) {
			if (rdbOcupaciones[k].isSelected()) {
				tmpOcupacion = tmpOcupaciones[k];
				break;
			}
		}
		switch (cboOcupacion.getSelectedIndex()) {
		case 0:
			valido = valido && false;
			break;
		case 1:
			int i;
			for (i = 0; i < rdbOcupaciones.length / 2; i++) {
				if (rdbOcupaciones[i].isSelected()) {
					break;
				}
			}
			if (i == rdbOcupaciones.length / 2) {
				valido = valido && false;
			}
			break;
		default:
			int j;
			for (j = 0; j < rdbOcupaciones.length / 2; j++) {
				if (rdbOcupaciones[j + 4].isSelected()) {
					break;
				}
			}
			if (j == rdbOcupaciones.length / 2) {
				valido = valido && false;
			}
			break;
		}

		if (!valido){
			JOptionPane.showMessageDialog(null,
					"Ingrese los datos correctamente ", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return valido;
	}
	
	public void limpiarCampos(){
		cboOcupacion.setSelectedIndex(0);
		txtApellido.setText("");
		txtNombre.setText("");
		txtEdad.setText("");
	}
}
