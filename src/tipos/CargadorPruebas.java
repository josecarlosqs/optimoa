package tipos;
import java.awt.Dimension;

import javax.swing.*;
import interfaces.Pruebas;
import pruebas.*;

public class CargadorPruebas {
	
	Pruebas x;
	public CargadorPruebas(){
	}

	public JPanel contenedor(int m){
	//public Component contenedor(int m){
JPanel modulo;
		
		switch (m) {
		case 1:
			x = new Agudeza();
			break;
		case 2:
			x = new Direccion();
			break;
		case 3:
			x = new Dominante();
			break;
		case 4:
			x = new Daltonismo();
			break;
		default:
				x = new Blanco();
		}
	
		modulo = x.Prueba();
		
		return modulo;
	
		
	}
	
	public void getInstrucciones(){
		x.instruccionesPrueba();
	}

	public String getResultado(){
		return x.devolverResultado();		
	}
	public boolean getEstado(){
		return x.devolverEstado();		
	}
	public Dimension getDimensiones(){
		return x.devolverDimensiones();
	}
	public String getNombre(){
		return x.nombrePrueba();
	}
	

}
