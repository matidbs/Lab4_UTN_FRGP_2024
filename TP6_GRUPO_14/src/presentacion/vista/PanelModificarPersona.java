package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import entidad.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class PanelModificarPersona extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<Persona> model;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JList<Persona> listPersonas;
	private JButton btnModificar;

	/**
	 * Create the panel.
	 */
	public PanelModificarPersona() {
		inicializar();
	}
	
	public void inicializar() {
		setSize(400,300);
		setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(15, 151, 70, 26);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(100, 151, 70, 26);
		add(txtApellido);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(185, 151, 70, 26);
		add(txtDNI);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(267, 150, 118, 27);
		add(btnModificar);
		
		JLabel lblTexto = new JLabel("Seleccione la persona que desea modificar");
		lblTexto.setBounds(15, 16, 346, 20);
		add(lblTexto);
		
		listPersonas = new JList<Persona>();
		listPersonas.setVisibleRowCount(6);
		listPersonas.setBounds(15, 32, 375, 108);
		JScrollPane scrollPane = new JScrollPane(listPersonas);
		scrollPane.setBounds(15, 32, 375, 108);
		//add(listPersonas);
		add(scrollPane);		
		
		

	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void show() {
		this.setVisible(true);
	}
	
	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDNI() {
		return txtDNI;
	}

	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
	}

	public JList<Persona> getListPersonas() {
		return listPersonas;
	}

	public void setListPersonas(JList<Persona> listPersonas) {
		this.listPersonas = listPersonas;
	}

	public DefaultListModel<Persona> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<Persona> model) {
		this.model = model;
		listPersonas.setModel(model);
	}
}
