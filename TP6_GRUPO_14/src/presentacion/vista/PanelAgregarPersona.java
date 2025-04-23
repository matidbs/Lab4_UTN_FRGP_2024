package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAgregarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JButton btnAceptar;

	/**
	 * Create the panel.
	 */
	public PanelAgregarPersona() {
		inicializar();
	}
	
	public void inicializar() {
		
		setLayout(null);
		setSize(400, 300);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(117, 44, 72, 14);
		add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(117, 85, 72, 14);
		add(lblApellido);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(117, 128, 72, 14);
		add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(225, 41, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(225, 82, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(225, 125, 86, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(117, 167, 112, 23);
		add(btnAceptar);
		
	}
	
	public void show() {
		this.setVisible(true);
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

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}
