package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entidad.Persona;
import javax.swing.JLabel;

public class PanelEliminarPersona extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnEliminar;
	private JList<Persona> lista;
	private DefaultListModel<Persona> model;
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JList<Persona> getLista() {
		return lista;
	}

	public void setLista(JList<Persona> lista) {
		this.lista = lista;
	}

	public PanelEliminarPersona() {
		setSize(450, 300);
		setLayout(null);
		
		model = new DefaultListModel<Persona>();
		lista = new JList<Persona>();
		lista.setBounds(15, 32, 375, 108);
		//add(lista);
		
		JScrollPane scrollPane = new JScrollPane(lista);
		scrollPane.setBounds(15, 32, 375, 108);
		add(scrollPane);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(182, 165, 89, 23);
		add(btnEliminar);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar Usuarios");
		lblEliminarUsuarios.setBounds(15, 11, 135, 14);
		add(lblEliminarUsuarios);
	}
	
	public DefaultListModel<Persona> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<Persona> model) {
		this.model = model;
		lista.setModel(model);
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
