package presentacion.vista;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

public class PanelListarPersona extends JPanel {

	private JTable tablaPersonas;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre","Apellido","Dni"};

	public PanelListarPersona() {
setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(26, 56, 394, 149);
		add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		
		tablaPersonas = new JTable(modelPersonas);
		tablaPersonas.setRowSelectionAllowed(true);
		tablaPersonas.setDefaultEditor(Object.class, null);
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(2).setResizable(false);
		spPersonas.setViewportView(tablaPersonas);
		
		
	}
	public void cargarModelTablaPersonas(List<Persona> personasEnTabla)
	{
		modelPersonas.setRowCount(0);
		modelPersonas.setColumnCount(0);
		modelPersonas.setColumnIdentifiers(nombreColumnas);
		
		for (Persona p : personasEnTabla)
		{
			String nombre = p.getNombre();
			String apellido = p.getApellido();
			String dni = p.getDni();
			Object[] fila = {nombre, apellido,dni};
			modelPersonas.addRow(fila);
		}
	}

}
