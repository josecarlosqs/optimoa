package interfaces;

import java.awt.Dimension;

import javax.swing.*;

public interface Pruebas {
	public String nombrePrueba();
	public void instruccionesPrueba();
	//corregir
	public JPanel Prueba();
	public boolean devolverEstado();
	public String devolverResultado();
	public Dimension devolverDimensiones();
}