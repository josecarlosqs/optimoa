package modulos;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class SeleccionarModelo implements ListSelectionListener{
	private String tmpLentes[]={"Arnette-marron","Arnette-verde","Arnette-rojo","Bulgari-rojo","Bulgari-negro","Bulgari-dorado","Chanel-rojo","Chanel-negro","Chanel-marron","Chanel-negro","Dolce-rojo","Dolce-plateado","Dolce-rosa","Dolce-naranja","Dolce-negro","Dolce-caramelo"};
	private Icon icnModelos[]=new ImageIcon[16];
	public JPanel pnlModelo;
	private JLabel lblImagenLentes;
	private JRadioButton rdbReflex;
	private JRadioButton rdbAntireflex;
	private ButtonGroup bgrX;
	private JList lstTipo;


	public SeleccionarModelo(){
		pnlModelo=new JPanel();
		pnlModelo.setBounds(0,0,500,600);
		pnlModelo.setLayout(new BoxLayout(pnlModelo,BoxLayout.Y_AXIS));
		
		//agregando las imagenes
		for(int i=0;i<icnModelos.length;i++){
			icnModelos[i]=new ImageIcon("galeriaLentes/"+(i+1)+".png");
		}		
		lstTipo=new JList(tmpLentes);
		lstTipo.setVisibleRowCount(5);
		lstTipo.addListSelectionListener(this);
		lstTipo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		pnlModelo.add(new JScrollPane(lstTipo));
		lblImagenLentes=new JLabel(new ImageIcon("galeriaLentes/0.png"));
		lblImagenLentes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Modelo"));
		pnlModelo.add(lblImagenLentes);
		

		
		rdbAntireflex=new JRadioButton("Antireflex");
		pnlModelo.add(rdbAntireflex);
		
		rdbReflex=new JRadioButton("Reflex");
		pnlModelo.add(rdbReflex);
		
		bgrX=new ButtonGroup();
		bgrX.add(rdbAntireflex);
		bgrX.add(rdbReflex);

		lstTipo.setSelectedIndex(0);
		rdbAntireflex.setSelected(true);
		
	}

	public boolean devolverAntireflex() {
			if(rdbReflex.isSelected()){
				return false;
			}else{
				return true;
			}
	}

	public void valueChanged(ListSelectionEvent evento) {
		lblImagenLentes.setIcon(icnModelos[lstTipo.getSelectedIndex()]);
	}
	
	public String devolverModelo(){
		return tmpLentes[lstTipo.getSelectedIndex()];
	}
	
	public static void main(String[] args) {
		SeleccionarModelo x = new SeleccionarModelo();
		biblioteca.Utiles.probarGUI(x.pnlModelo);
	}
}
