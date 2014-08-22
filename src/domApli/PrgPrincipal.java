package domApli;

import biblioteca.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import modulos.Registro;
import modulos.SeleccionarModelo;
import tipos.Usuario;
import tipos.CargadorPruebas;

public class PrgPrincipal extends JFrame implements ActionListener,WindowListener , ItemListener{

	// Vectores y otras cosas...
	int indActual = -1;
	// Declaracion/inicializacion GLOBAL de todo
	JFrame frmVentana = new JFrame();

	// Paneles para intercambiar
	JPanel pnlPrincipal;
	JPanel pnlUsuario;
	JPanel pnlContenedor;
	JPanel pnlBotones;

	// Panel cargador : Pruebas
	String msjPrueba = "";
	int indP = 0;
	JButton btnSiguiente;
	CargadorPruebas cargador;
	JScrollPane jscPanelPruebas;
	JPanel pnlNumPrueba;
	JLabel lblNume;
	JPanel pnlPanelPruebas;

	// Labels y mensajes
	JLabel lblMsj_Usr;
	JLabel lblSaludo;
	JLabel lblCopy;
	JLabel lblLinea;

	// Botones
	JButton btnSesion;
	JButton btnAdmin;
	
	JButton btnRegistrarse;
	JButton btnTest;
	JButton btnModelo;
	JButton btnResultado;
	JButton btnAcercade;
	
	///////////

	///////////
	
	//Admin
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////
	String codigo;
	String contraseña;
	
	JPanel pnlSeguridad;
	JLabel lblSeguridadCodigo;
	JLabel lblContraseña;
	JTextField txtSeguridadCodigo;
	JPasswordField pswContraseña;
	JButton btnAceptarSeguridad;
	JButton btnCancelarSeguridar;
	// /////////////////////////////////////////////////////
	JPanel pnlAdministrador;
	JButton btnVerOcultos;
	JButton btnEliminacionLogica;
	JButton btnMostrarRegistros;
	JButton btnMostrarUnRegistro;
	JButton btnMostrarMayores;
	JButton btnMostrarMenores;
	JButton btnHabilitarUsuario;
	JComboBox cboMostrarPorOcupacion;
	JButton btnSalirAdministrador;
	JButton btnLimpiarAdministrador;
	JTextArea txaMostrarRegistros;
	JScrollPane scpMostrarRegistros;

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////
	

	// Usuario
	Usuario usuario[];

	// Seleccion de modelos
	SeleccionarModelo seleccionarModelo;
	Registro reg = new Registro();

	public PrgPrincipal() {
		pnlPanelPruebas = new JPanel();
		seleccionarModelo = new SeleccionarModelo();
		btnSiguiente = new JButton(">>");
		cargador = new CargadorPruebas();
		// Inicializacion y poblamiento de los vectores

		usuario = new Usuario[5];
		usuario[0] = new Usuario("Javier", "Ramirez", "a20120000", 21.5, 0,
				"No presenta daltonismo", "Medida Perfecta", true, 19,
				"Escolar", "Generico");
		usuario[1] = new Usuario("José", "Quichiz", "a20120001", 10.3, 0,
				"No presenta daltonismo", "Medida Perfecta", true, 19,
				"Arquitecto", "Generico");
		usuario[2] = new Usuario("Yoselin", "Palomino", "a20120002", 20.2, 0,
				"No presenta daltonismo", "Medida Perfecta", true, 19,
				"Abogado", "Generico");
		usuario[3] = new Usuario("Diego", "Echevarria", "a20120003", 14.5, 0,
				"No presenta daltonismo", "Medida Perfecta", true, 18,
				"Universitario", "Generico");
		usuario[4] = new Usuario("Kevin", "Rocha", "a20120004", 3.5, 0,
				"No presenta daltonismo", "Medida Perfecta", true, 19,
				"Profesor", "Generico");
		// Declaracion/Inicializacion de todo lo que es GUI

		String fecha = Utiles.fecha();

		ImageIcon tst = new ImageIcon("btns/tst.png");
		ImageIcon md = new ImageIcon("btns/mod.png");
		ImageIcon en = new ImageIcon("entrar.png");
		ImageIcon rg = new ImageIcon("registro.png");
		ImageIcon rs = new ImageIcon("btns/resu.png");
		ImageIcon ad = new ImageIcon("btns/acerca.png");
		Image icono = new ImageIcon("opti.png").getImage();
		ImageIcon ln = new ImageIcon("linea.png");
		Font f_sal = new Font("Verdana", Font.PLAIN, 32);
		Font f_co = new Font("Verdana", Font.PLAIN, 14);

		// Configuracion de la ventana
		frmVentana.setTitle("Opticas OptiMOA v2.0 - Fecha: " + fecha);
		frmVentana.setSize(500, 280);
		frmVentana.setLocationRelativeTo(null);
		frmVentana.setIconImage(icono);
		frmVentana.setResizable(false);
		frmVentana.setLayout(null);
		frmVentana.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		frmVentana.addWindowListener(this);

		// Configuracion del contenedor general
		pnlContenedor = new JPanel();
		pnlContenedor.setSize(500, 280);
		pnlContenedor.setLayout(null);

		// Configuracion del panel principal
		pnlPrincipal = new JPanel();
		pnlPrincipal.setLayout(new FlowLayout());
		pnlPrincipal.setBounds(0, 0, 500, 280);

		// Poner saludo
		lblSaludo = new JLabel();
		lblSaludo.setText("Bienvenido a OptiMOA v2.0");
		lblSaludo.setFont(f_sal);

		// Panel botones
		pnlBotones = new JPanel();
		pnlBotones.setSize(500, 100);

		// Boton test
		btnTest = new JButton("", tst);
		btnTest.setToolTipText("Iniciar el test de vision");
		btnTest.setMargin(new Insets(1, 1, 1, 1));
		btnTest.setFocusable(false);
		btnTest.addActionListener(this);

		pnlBotones.add(btnTest);

		// Boton modelo
		btnModelo = new JButton("", md);
		btnModelo.setToolTipText("Elegir/Reelegir modelo de los lentes");
		btnModelo.setMargin(new Insets(1, 1, 1, 1));
		btnModelo.setFocusable(false);
		btnModelo.addActionListener(this);
		pnlBotones.add(btnModelo);

		// Boton resultado
		btnResultado = new JButton("", rs);
		btnResultado
				.setToolTipText("Ver resultado del test junto con el modelo de lentes elegido");
		btnResultado.setMargin(new Insets(1, 1, 1, 1));
		btnResultado.setFocusable(false);
		btnResultado.addActionListener(this);
		pnlBotones.add(btnResultado);

		// Boton Acerca de
		btnAcercade = new JButton("", ad);
		btnAcercade.setToolTipText("Acerca de ...");
		btnAcercade.setMargin(new Insets(1, 1, 1, 1));
		btnAcercade.setFocusable(false);
		btnAcercade.addActionListener(this);
		pnlBotones.add(btnAcercade);

		// Linea
		lblLinea = new JLabel("");
		lblLinea.setSize(490, 10);
		lblLinea.setIcon(ln);

		// Copyright
		lblCopy = new JLabel();
		lblCopy.setText("Copyright -  OptiMOA v2.0");
		lblCopy.setFont(f_co);

		// Configuracion del panel usuarios
		pnlUsuario = new JPanel();
		pnlUsuario.setLayout(null);
		pnlUsuario.setPreferredSize(new Dimension(446, 33));
		pnlUsuario.setBorder(BorderFactory.createEtchedBorder());
		pnlUsuario.setBackground(new Color(253, 233, 119));

		// Iniciar/cerrar usuario
		btnSesion = new JButton("", en);
		btnSesion.setToolTipText("Iniciar sesion");
		btnSesion.setMargin(new Insets(1, 1, 1, 1));
		btnSesion.setFocusable(false);
		btnSesion.setActionCommand("aSes");
		btnSesion.addActionListener(this);
		btnSesion.setBounds(397, 7, 20, 20);

		pnlUsuario.add(btnSesion);

		// Iniciar/cerrar usuario
		btnAdmin = new JButton("A");
		btnAdmin.setToolTipText("Administrador");
		btnAdmin.setMargin(new Insets(1, 1, 1, 1));
		btnAdmin.setFocusable(false);
		btnAdmin.addActionListener(this);
		btnAdmin.setBounds(373, 7, 20, 20);

		pnlUsuario.add(btnAdmin);

		
		// Boton para registrarse
		btnRegistrarse = new JButton("", rg);
		btnRegistrarse.setToolTipText("Registrarse");
		btnRegistrarse.setBounds(420, 7, 20, 20);
		btnRegistrarse.setMargin(new Insets(1, 1, 1, 1));
		btnRegistrarse.setFocusable(false);
		btnRegistrarse.addActionListener(this);
		pnlUsuario.add(btnRegistrarse);

		// Mensaje de identificacion
		lblMsj_Usr = new JLabel("No estas identificado");
		lblMsj_Usr.setBounds(10, 4, 400, 25);
		pnlUsuario.add(lblMsj_Usr);

		// Agregamos botones, labels y demas al panel principal
		pnlPrincipal.add(lblSaludo);
		pnlPrincipal.add(pnlUsuario);
		pnlPrincipal.add(pnlBotones);
		pnlPrincipal.add(lblLinea);
		pnlPrincipal.add(lblCopy);

		// Agregamos paneles al contenedor
		pnlContenedor.add(pnlPrincipal);
		
		// Agregamos en contenedor a la ventana
		frmVentana.add(pnlContenedor);

		pnlNumPrueba = new JPanel();
		lblNume = new JLabel("", JLabel.CENTER);
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////////////////////////////////////////////
		codigo = "optimoa";
		contraseña = "123456";
		// panel de seguridad donde se ingresara para colocar el codigo y la
		// contraseña.
		pnlSeguridad = new JPanel();
		pnlSeguridad.setLayout(null);
		pnlSeguridad.setBounds(0, 0, 400, 200);
		pnlSeguridad.setBackground(Color.black.darker());

		lblSeguridadCodigo = new JLabel("Codigo : ");
		lblSeguridadCodigo.setForeground(Color.green.darker());
		lblSeguridadCodigo.setBounds(100, 30, 100, 25);
		pnlSeguridad.add(lblSeguridadCodigo);

		lblContraseña = new JLabel("Contrase�a : ");
		lblContraseña.setForeground(Color.green.darker());
		lblContraseña.setBounds(100, 60, 100, 25);
		pnlSeguridad.add(lblContraseña);

		txtSeguridadCodigo = new JTextField();
		txtSeguridadCodigo.setBounds(200, 30, 100, 25);
		txtSeguridadCodigo.setBackground(Color.black);
		txtSeguridadCodigo.setForeground(Color.green.darker());
		pnlSeguridad.add(txtSeguridadCodigo);

		pswContraseña = new JPasswordField();
		pswContraseña.setBounds(200, 60, 100, 25);
		pswContraseña.setBackground(Color.black);
		pswContraseña.setForeground(Color.green.darker());
		pnlSeguridad.add(pswContraseña);

		btnAceptarSeguridad = new JButton("Aceptar");
		btnAceptarSeguridad.setForeground(Color.green.darker());
		btnAceptarSeguridad.setBackground(Color.black);
		btnAceptarSeguridad.addActionListener(this);
		btnAceptarSeguridad.setBounds(50, 100, 100, 25);
		pnlSeguridad.add(btnAceptarSeguridad);

		btnCancelarSeguridar = new JButton("Cancelar");
		btnCancelarSeguridar.setForeground(Color.green.darker());
		btnCancelarSeguridar.setBackground(Color.black);
		btnCancelarSeguridar.addActionListener(this);
		btnCancelarSeguridar.setBounds(250, 100, 100, 25);
		pnlSeguridad.add(btnCancelarSeguridar);
		// //////////////////////////////////////////////////////////////////////////////////////////////////
		// panel del administrador donde va a realizar los cambios y todo eso
		pnlAdministrador = new JPanel();
		pnlAdministrador.setLayout(null);
		pnlAdministrador.setBounds(0, 0, 500, 600);
		pnlAdministrador.setBackground(Color.black);

		btnVerOcultos = new JButton("Ver Ocultos");
		btnVerOcultos.setForeground(Color.green.darker());
		btnVerOcultos.setBackground(Color.black);
		btnVerOcultos.addActionListener(this);
		btnVerOcultos.setBounds(50, 20, 200, 25);
		pnlAdministrador.add(btnVerOcultos);

		btnEliminacionLogica = new JButton("Ocultar Registro");
		btnEliminacionLogica.setForeground(Color.green.darker());
		btnEliminacionLogica.setBackground(Color.black);
		btnEliminacionLogica.addActionListener(this);
		btnEliminacionLogica.setBounds(50, 50, 200, 25);
		pnlAdministrador.add(btnEliminacionLogica);

		btnMostrarUnRegistro = new JButton("Mostrar Registro por Codigo");
		btnMostrarUnRegistro.setForeground(Color.green.darker());
		btnMostrarUnRegistro.setBackground(Color.black);
		btnMostrarUnRegistro.addActionListener(this);
		btnMostrarUnRegistro.setBounds(50, 80, 200, 25);
		pnlAdministrador.add(btnMostrarUnRegistro);

		btnMostrarRegistros = new JButton("Mostrar Registros");
		btnMostrarRegistros.setForeground(Color.green.darker());
		btnMostrarRegistros.setBackground(Color.black);
		btnMostrarRegistros.addActionListener(this);
		btnMostrarRegistros.setBounds(260, 20, 200, 25);
		pnlAdministrador.add(btnMostrarRegistros);

		btnMostrarMayores = new JButton("Mostrar Mayores de Edad");
		btnMostrarMayores.setForeground(Color.green.darker());
		btnMostrarMayores.setBackground(Color.black);
		btnMostrarMayores.addActionListener(this);
		btnMostrarMayores.setBounds(260, 50, 200, 25);
		pnlAdministrador.add(btnMostrarMayores);

		btnMostrarMenores = new JButton("Mostrar Menores de Edad");
		btnMostrarMenores.setForeground(Color.green.darker());
		btnMostrarMenores.setBackground(Color.black);
		btnMostrarMenores.addActionListener(this);
		btnMostrarMenores.setBounds(260, 80, 200, 25);
		pnlAdministrador.add(btnMostrarMenores);

		btnHabilitarUsuario = new JButton("Habilitar Usuario");
		btnHabilitarUsuario.setForeground(Color.green.darker());
		btnHabilitarUsuario.setBackground(Color.black);
		btnHabilitarUsuario.addActionListener(this);
		btnHabilitarUsuario.setBounds(260, 110, 200, 25);
		pnlAdministrador.add(btnHabilitarUsuario);

		cboMostrarPorOcupacion = new JComboBox();
		for (int i = 0; i < reg.tmpOcupaciones.length; i++) {
			cboMostrarPorOcupacion.addItem(reg.tmpOcupaciones[i]);
		}
		cboMostrarPorOcupacion.setBounds(50, 110, 200, 25);
		cboMostrarPorOcupacion.setBackground(Color.black);
		cboMostrarPorOcupacion.setForeground(Color.green.darker());
		cboMostrarPorOcupacion.setMaximumRowCount(5);
		cboMostrarPorOcupacion.addItemListener(this);
		pnlAdministrador.add(cboMostrarPorOcupacion);

		txaMostrarRegistros = new JTextArea();
		txaMostrarRegistros.setBackground(Color.black);
		txaMostrarRegistros.setForeground(Color.green.darker());
		txaMostrarRegistros.setEditable(false);

		scpMostrarRegistros = new JScrollPane(txaMostrarRegistros);
		scpMostrarRegistros.setBounds(50, 150, 410, 300);
		pnlAdministrador.add(scpMostrarRegistros);

		btnSalirAdministrador = new JButton("Salir");
		btnSalirAdministrador.setBounds(300, 500, 100, 25);
		btnSalirAdministrador.setBackground(Color.black);
		btnSalirAdministrador.setForeground(Color.green);
		btnSalirAdministrador.addActionListener(this);
		pnlAdministrador.add(btnSalirAdministrador);

		btnLimpiarAdministrador = new JButton("Limpiar");
		btnLimpiarAdministrador.setBounds(150, 500, 100, 25);
		btnLimpiarAdministrador.setBackground(Color.black);
		btnLimpiarAdministrador.setForeground(Color.green);
		btnLimpiarAdministrador.addActionListener(this);
		pnlAdministrador.add(btnLimpiarAdministrador);

		// //////////////////////////////////////////////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////////////////////////////////////////////		
		
		
		
		
		
		
		ImageIcon imgNum = new ImageIcon("prueba.png");
		pnlPanelPruebas.setLayout(null);
		JLabel lblImgFondo = new JLabel("");
		lblImgFondo.setIcon(imgNum);
		lblImgFondo.setBounds(0, 0, 172, 106);

		lblNume.setBounds(66, 3, 40, 100);
		pnlNumPrueba.setLayout(null);
		pnlNumPrueba.add(lblNume);
		pnlNumPrueba.add(lblImgFondo);
		jscPanelPruebas = new JScrollPane();

		btnSiguiente.setFocusable(false);
		btnSiguiente.setActionCommand("siguiente");
		btnSiguiente.addActionListener(this);
			
		
		
		
		
		

		// lo hacemos visible al final para que no hayan problemas de
		// "no se ve esto por falta de carga"

		frmVentana.setVisible(true);
		pnlContenedor.setVisible(true);
		pnlUsuario.setVisible(true);

		pnlPrincipal.setVisible(true);

	}

	String generarCodigo() {
		int cd;
		String cod;
		do {
			cd = Utiles.aleatorio(20000, 99999);
			cod = "a201" + cd;
		} while (buscarXCodigo(cod) > -1);
		return cod;
	}

	public JPanel pnlPruebas() {
		pnlPanelPruebas.removeAll();
		
		cargarPrueba();
		
		pnlPanelPruebas.add(jscPanelPruebas);
		pnlPanelPruebas.add(pnlNumPrueba);
		pnlPanelPruebas.add(btnSiguiente);
		return pnlPanelPruebas;
	}

	void mostrarReporte() {
		frmVentana.setTitle("Mostrando reporte de "
				+ usuario[indActual].getCodigo() + " - Opticas OptiMOA v2.0");

		JTextArea txaSalida = new JTextArea();
		txaSalida.setEditable(false);
		txaSalida.setFont(new Font("Verdana", Font.TRUETYPE_FONT, 16));
		txaSalida.setText(usuario[indActual].obtenerDatosUsuario());

		JButton btnRegresar = new JButton("<<");
		btnRegresar.setBounds(10, 10, 100, 25);
		btnRegresar.setActionCommand("repReg");
		btnRegresar.setToolTipText("Regresar a la ventana principal");
		btnRegresar.addActionListener(this);

		JScrollPane scpScroll = new JScrollPane(txaSalida);
		scpScroll.setBounds(10, 35, 480, 330);

		pnlContenedor.removeAll();
		pnlContenedor.setSize(500, 400);
		frmVentana.setSize(500, 400);
		pnlContenedor.add(btnRegresar);
		pnlContenedor.add(scpScroll);
	}

	void mostrarSeleccionDeModelo() {
		frmVentana.setTitle("Elecci�n de modelo de lentes - "
				+ frmVentana.getTitle());
		JPanel pnlPanel = seleccionarModelo.pnlModelo;
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(10, 592, 100, 70);
		btnAceptar.setActionCommand("mdlAcep");
		btnAceptar.addActionListener(this);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(120, 592, 100, 70);
		btnCancelar.setActionCommand("btnsCanc");
		btnCancelar.addActionListener(this);

		pnlPanel.setBounds(15, 2, 670, 570);

		pnlContenedor.removeAll();
		pnlContenedor.setSize(700, 700);
		frmVentana.setSize(700, 700);
		pnlContenedor.add(btnAceptar);
		pnlContenedor.add(btnCancelar);
		pnlContenedor.add(pnlPanel);
	}

	private void llenarResultados(String resultado) {
		switch (indP) {
		case 1:
			usuario[indActual].setResulAgVisual(resultado);
			break;
		case 2:
			usuario[indActual].setResulPorcentajeDeficiencia(Double
					.parseDouble(resultado));
			break;
		case 3:
			usuario[indActual]
					.setResulOjoDominante(Integer.parseInt(resultado));
			break;

		default:
			usuario[indActual].setResulDaltonismo(resultado);
		}
	}

	void volverAlInicio() {
		pnlContenedor.removeAll();
		pnlContenedor.add(pnlPrincipal);
		frmVentana.setTitle("Opticas OptiMOA v2.0 - Fecha: " + Utiles.fecha());
		pnlContenedor.setSize(500, 280);
		frmVentana.setSize(500, 280);
		pnlPanelPruebas.removeAll();
	}

	public void cargarPrueba() {
		indP++;
		jscPanelPruebas.setViewportView(cargador.contenedor(indP));
		frmVentana.setTitle("Prueba: " + cargador.getNombre()
				+ " - OptiMOA v2.0 - Fecha: " + Utiles.fecha());
		frmVentana.setSize(cargador.getDimensiones());
		pnlContenedor.setSize(cargador.getDimensiones());
		pnlPanelPruebas.setSize(cargador.getDimensiones());
		mantenerAspecto();
		if (indP == 4) {
			btnSiguiente.setText("Finalizar >");
		}
		cargador.getInstrucciones();
		msjPrueba = indP + " / 4";
	}

	public void mantenerAspecto() {

		jscPanelPruebas.setBounds(2, 2, pnlPanelPruebas.getWidth() - 10,
				pnlPanelPruebas.getHeight() - 140);
		pnlNumPrueba.setBounds(2, pnlPanelPruebas.getHeight() - 136, 172, 106);
		lblNume.setText(indP + " / 4");
		btnSiguiente.setBounds(pnlPanelPruebas.getWidth() - 110,
				pnlPanelPruebas.getHeight() - 136, 100, 106);

	}

	public Dimension getDimensiones() {
		return new Dimension(pnlPanelPruebas.getWidth(), pnlPanelPruebas
				.getHeight());
	}


	public int buscarXCodigo(String codigo) {
		for (int i = 0; i < usuario.length; i++) {
			if (codigo.equals(usuario[i].getCodigo())&&usuario[i].isVisible()) {
				return i;
			}
		}
		return -1;
	}

	public int validarIngreso(String varTxt, int lng) {
		int f = 0;
		if (varTxt != null) {
			varTxt = varTxt.trim();
		}
		if (varTxt == null) {
			f = 1;
		}  else if (varTxt.length() != lng) {
			f = 2;
		}
		return f;
	}

	public boolean comprobarSesion() {
		boolean sAbierta;
		if (indActual == -1) {
			sAbierta = false;
		} else {
			sAbierta = true;
		}
		return sAbierta;
	}

	public static void main(String[] args) {
		new PrgPrincipal();
	}

	public void abrirPrueba() {
		pnlContenedor.removeAll();
		pnlContenedor.add(pnlPruebas());
		pnlContenedor.setSize(getDimensiones());
		frmVentana.setSize(getDimensiones());
		// Revisualizar el GUI
		pnlContenedor.updateUI();

	}

	public void mostrarRegistro() {
		frmVentana.setTitle("Registro de usuario - " + frmVentana.getTitle());
		JPanel pnlPanel = reg.pnlRegistrarse;
		JButton btnAceptar = new JButton("Registrar");
		btnAceptar.setBounds(10, 572, 100, 70);
		btnAceptar.setActionCommand("rgReg");
		btnAceptar.addActionListener(this);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(120, 572, 100, 70);
		btnCancelar.setActionCommand("btnsCanc");
		btnCancelar.addActionListener(this);

		pnlPanel.setBounds(15, 2, 670, 560);

		pnlContenedor.removeAll();
		pnlContenedor.setSize(550, 670);
		frmVentana.setSize(550, 670);
		pnlContenedor.add(btnAceptar);
		pnlContenedor.add(btnCancelar);
		pnlContenedor.add(pnlPanel);
	}
	
	public void crearNuevoUsuario() {
		Usuario tmpUsuario[] = new Usuario[usuario.length + 1];
		String nombres[]=new String [20];
		for (int i = 0; i < usuario.length; i++) {
			tmpUsuario[i] = usuario[i];
		}
		usuario = tmpUsuario;
		usuario[usuario.length - 1] = new Usuario();
	}
	

	public void actionPerformed(ActionEvent evento) {
		String ses;
		Object fuenteEvento = evento.getActionCommand();
		ImageIcon x = new ImageIcon("x.png");
		ImageIcon en = new ImageIcon("entrar.png");

		if (evento.getSource() == btnTest) {
			if (comprobarSesion()) {
				JOptionPane
						.showMessageDialog(
								null,
								"Antes de empezar los test:\n\nUsted debera estar acompa�ado de una persona\nque le guie a traves de las pruebas, usted\ndebe estar alejado aproximadamente a un brazo de distancia\ncon respecto a su monitor/pantalla.",
								"    !ATENCI�N�",
								JOptionPane.INFORMATION_MESSAGE);
				abrirPrueba();
			} else {
				JOptionPane
						.showMessageDialog(
								null,
								"Tienes que haber iniciado sesion para usar esta opcion",
								"Oops", JOptionPane.ERROR_MESSAGE);
			}
		} else if (evento.getSource() == btnModelo) {
			if (comprobarSesion()) {
				mostrarSeleccionDeModelo();
			} else {
				JOptionPane
						.showMessageDialog(
								null,
								"Tienes que haber iniciado sesion para usar esta opcion",
								"Oops", JOptionPane.ERROR_MESSAGE);
			}
		} else if (evento.getSource() == btnResultado) {
			if (comprobarSesion()) {
				mostrarReporte();
			} else {
				JOptionPane
						.showMessageDialog(
								null,
								"Tienes que haber iniciado sesion para usar esta opcion",
								"Oops", JOptionPane.ERROR_MESSAGE);

			}
		} else if (evento.getSource() == btnAcercade) {
			JOptionPane.showMessageDialog(null,
					"OptiMOA v2.0\n\n" +
					"Equipo de desarrollo:\n" +
					" 1)Javier Ramirez Veliz\n" +
					" 2)Jos� Carlos Quichiz Santome\n" +
					" 3)Diego Echevarria Ortiz\n" +
					" 4)Yoselin Palomino Velasquez\n" +
					" 5)Kevin Rocha Adriano\n\n" +
					"OptiMOA v2.0 es un programa enfocado a\n" +
					"devolver aproximaci�n de sus problemas visuales,\n" +
					"simulando el trabajo de un oftalmologo.",
					"Acerca de ...", JOptionPane.INFORMATION_MESSAGE);
		} else if (fuenteEvento == "aSes") {
			
			do {
				ses = JOptionPane.showInputDialog(
						"Ingresa tu codigo (Formato: a201xxxxx)", "a201");
				if (validarIngreso(ses, 9) == 2) {
					JOptionPane.showMessageDialog(null, "Codigo invalido!",
							"Error!", JOptionPane.ERROR_MESSAGE);
				}
				
				
			} while (validarIngreso(ses, 9) == 2);
			if (validarIngreso(ses, 9) == 0) {
				indActual = buscarXCodigo(ses);
				if (indActual != -1) {
					btnAdmin.setVisible(false);
					btnSesion.setIcon(x);
					btnSesion.setLocation(420, 7);
					btnSesion.setActionCommand("cSes");
					pnlUsuario.setBackground(new Color(127, 217, 109));
					lblMsj_Usr.setText("Bienvenid@ "
							+ usuario[indActual].getNombre() + " "
							+ usuario[indActual].getApellido());
					btnSesion.setToolTipText("Cerrar sesion");
				
				}else{
					JOptionPane.showMessageDialog(null,
							"Este codigo no existe", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		} else if (fuenteEvento == "cSes") {
			btnAdmin.setVisible(true);
			btnSesion.setIcon(en);
			btnSesion.setActionCommand("aSes");
			btnSesion.setLocation(397, 7);
			pnlUsuario.setBackground(new Color(253, 233, 119));
			btnSesion.setToolTipText("Iniciar sesion");
			lblMsj_Usr.setText("No estas identificado");
			JOptionPane.showMessageDialog(null, "Acabas de cerrar tu sesion",
					"Informacion", JOptionPane.INFORMATION_MESSAGE);
			indActual = -1;
		} else if (evento.getSource() == btnRegistrarse) {
			
			mostrarRegistro();
			

		} else if (evento.getSource() == btnSiguiente) {

			if (!cargador.getEstado()) {
				JOptionPane.showMessageDialog(null,
						"Aun no ha terminado esta prueba", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				if (cargador.getResultado() == null) {
				} else {
					llenarResultados(cargador.getResultado());
					if (indP < 4) {
						cargarPrueba();
					} else {
						usuario[indActual].setFechayhora(Utiles.fecha()
								+ " a las " + Utiles.hora());
						indP = 0;
						btnSiguiente.setText(">>");
						volverAlInicio();
					}
				}
			}
		} else if (fuenteEvento == "repReg") {
			volverAlInicio();
		} else if (fuenteEvento == "rgReg") {
			if (reg.validarCampos()) {
				crearNuevoUsuario();

				int indice = usuario.length-1;
				usuario[indice] = reg.obtenerUsuario();
				usuario[indice].setCodigo(generarCodigo());
				JOptionPane.showMessageDialog(null,
						"Usuario creado con exito!\n" + "Su codigo es: "
								+ usuario[indice].getCodigo(), "Exito!",
						JOptionPane.INFORMATION_MESSAGE);
				volverAlInicio();
				System.out.print(usuario[indice].getCodigo());
				reg.limpiarCampos();
			}
		} else if (fuenteEvento == "mdlAcep") {
			usuario[indActual].setModelo(seleccionarModelo.devolverModelo());
			usuario[indActual].setAntiReflex(seleccionarModelo.devolverAntireflex());
			JOptionPane.showMessageDialog(null,
					"Elecci�n guardada satisfactoriamente", "Exito!",
					JOptionPane.INFORMATION_MESSAGE);
			volverAlInicio();
		} else if (fuenteEvento == "btnsCanc") {
			reg.limpiarCampos();
			volverAlInicio();
		} else if(evento.getSource()==btnAdmin){
			int ancho=400;
			int alto=200;
			pnlContenedor.removeAll();
			pnlSeguridad.setBounds(0, 0, ancho, alto);
			frmVentana.setSize(ancho, alto);
			pnlContenedor.setSize(ancho, alto);
			pnlContenedor.add(pnlSeguridad);
		}
		
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////
		if (evento.getSource() == btnAceptarSeguridad) {
			String tmpCodigo = txtSeguridadCodigo.getText();
			String tmpContraseña = pswContraseña.getText();
			if (tmpCodigo.equals(codigo) && tmpContraseña.equals(contraseña)) {
				apagarPaneles(pnlAdministrador, 500, 600);
			} else {
				JOptionPane.showMessageDialog(null,
						"Ingrese los datos correctamente");
			}
		}
		// ////////////////////////////////////////////////////////////////////////////
		if (evento.getSource() == btnCancelarSeguridar) {
			txtSeguridadCodigo.setText("");
			pswContraseña.setText("");
			apagarPaneles(pnlPrincipal, 500, 280);
		}
		// ////////////////////////////////////////////////////////////////////////////
		if (evento.getSource() == btnEliminacionLogica) {
			String codigo="";
			do{
				codigo=JOptionPane.showInputDialog("Ingrese el codigo que desea habilitar");
				if(codigo==null)
					JOptionPane.showMessageDialog(null, "Error... no se ha ingresado valor");
			}while(codigo==null);			
			int i = buscarXCodigo(codigo);
			if (i != -1) {
				if (!usuario[i].isVisible()) {
					JOptionPane
							.showMessageDialog(
									null,
									"El dato que usted busca se oculto, Hacer click en MOSTRAR OCULTOS, si desea ver el registro");
				} else {
					usuario[i].setVisible(false);
					JOptionPane.showMessageDialog(null,
							"El registro fue ocultado con exito.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El codigo no existe.");
			}
		}
		// ////////////////////////////////////////////////////////////////////////////
		if (evento.getSource() == btnMostrarMayores) {
			String lista = "\n\nLos mayores de edad son : ";
			for (int i = 0; i < usuario.length; i++) {
				if (usuario[i].getEdad() >= 18 && usuario[i].isVisible()) {
					lista += usuario[i].obtenerDatosUsuario();
				}
			}
			txaMostrarRegistros.append(lista);
		}
		// ////////////////////////////////////////////////////////////////////////////
		if (evento.getSource() == btnMostrarMenores) {
			String lista = "\n\nLos menores de edad son : ";
			for (int i = 0; i < usuario.length; i++) {
				if (usuario[i].getEdad() < 18 && usuario[i].isVisible()) {
					lista += usuario[i].obtenerDatosUsuario();
				}
			}
			txaMostrarRegistros.append(lista);

		}
		// ////////////////////////////////////////////////////////////////////////////
		if (evento.getSource() == btnMostrarUnRegistro) {
			String lista = "\n\nRegistro : ";
			String codigo="";
			do{
				codigo=JOptionPane.showInputDialog("Ingrese el codigo que desea mostrar");
				if(codigo==null)
					JOptionPane.showMessageDialog(null, "Error... no se ha ingresado valor");
			}while(codigo==null);
			if (buscarXCodigo(codigo) != -1) {
				if (usuario[buscarXCodigo(codigo)] != null) {
					lista += usuario[buscarXCodigo(codigo)]
							.obtenerDatosUsuario();
					txaMostrarRegistros.append(lista);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"El dato que usted busca se oculto, Hacer click en MOSTRAR OCULTOS, si desea ver el registro");
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"El codigo ingresado no existe.");
			}
		}
		// ////////////////////////////////////////////////////////////////////////////
		if (evento.getSource() == btnMostrarRegistros) {
			String lista = "\n\nLos datos registrados son : : ";
			for (int i = 0; i < usuario.length; i++) {
				if (usuario[i].isVisible()) {
					lista += usuario[i].obtenerDatosUsuario();
				}
			}
			txaMostrarRegistros.append(lista);
		}
		// ////////////////////////////////////////////////////////////////////////////
		if (evento.getSource() == btnVerOcultos) {
			String lista = "\n\nLos datos ocultos son : ";
			for (int i = 0; i < usuario.length; i++) {
				if (!usuario[i].isVisible()) {
					lista += usuario[i].obtenerDatosUsuario();
				}
			}
			txaMostrarRegistros.append(lista);
		}
		
		
		// ////////////////////////////////////////////////////////////////////////////
		if (evento.getSource() == btnSalirAdministrador) {
			txtSeguridadCodigo.setText("");
			pswContraseña.setText("");
			apagarPaneles(pnlPrincipal, 500, 280);
		}
		// ////////////////////////////////////////////////////////////////////////////
		if (evento.getSource() == btnLimpiarAdministrador) {
			txaMostrarRegistros.setText("");
		}
		/////////////
		if(evento.getSource()==btnHabilitarUsuario){
			String codigo="";
			do{
				codigo=JOptionPane.showInputDialog("Ingrese el codigo que desea habilitar");
				if(codigo==null)
					JOptionPane.showMessageDialog(null, "Error... no se ha ingresado valor");
			}while(codigo==null);
			for(int i=0;i<usuario.length;i++){
				if(codigo.equals(usuario[i].getCodigo())){
					if(!usuario[i].isVisible()){
						usuario[i].setVisible(true);
						JOptionPane.showMessageDialog(null, "Se habilito con exito al usuario.");
						break;
					}else{
						JOptionPane.showMessageDialog(null, "El usuario ya se encuentra habilitado");
					}
					
				}
			}
		}
		////////////////////
	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowClosed(WindowEvent arg0) {
	}

	public void windowClosing(WindowEvent arg0) {
		int cierre = JOptionPane.showOptionDialog(null,
				"�Segur@ deseas salir el sistema?", "Saliendo de OptiMOA v2.0",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				null, null);
		if (cierre == JOptionPane.OK_OPTION) {
			System.exit(0);
		} else {

		}

	}

	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void itemStateChanged(ItemEvent arg0) {
		String tmpOcupacion = cboMostrarPorOcupacion.getSelectedItem().toString();
		String lista = "\n\nLos " + tmpOcupacion + "s son : \n";
		for (int i = 0; i < usuario.length; i++) {
			if (tmpOcupacion.equals(usuario[i].getOcupacion())) {
				lista += usuario[i].obtenerDatosUsuario();
			}
		}
		txaMostrarRegistros.setText(lista);		
	}
	

	public void apagarPaneles(JPanel pnlPanel, int ancho, int alto) {
		pnlContenedor.removeAll();
		pnlPanel.setBounds(0, 0, ancho, alto);
		frmVentana.setSize(ancho, alto);
		pnlContenedor.setSize(ancho, alto);
		pnlContenedor.add(pnlPanel);
	}
	
}// fin de la clase