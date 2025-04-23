package TP5;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import TP5.Genero;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class panelAgregarPelicula extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JLabel lblIDPelicula;
	private JLabel lblNombrePelicula;
	private JLabel lblGPelicula;
	private JLabel lblID;
	private JComboBox<Genero> cbxGenero;
	private DefaultListModel<Pelicula> model;

	/**
	 * Create the panel.
	 */
	public panelAgregarPelicula() {
		setSize(400, 300);
		setLayout(null);
		
		lblIDPelicula = new JLabel("ID");
		lblIDPelicula.setBounds(75, 11, 93, 14);
		add(lblIDPelicula);
		
		lblNombrePelicula = new JLabel("Nombre");
		lblNombrePelicula.setBounds(75, 42, 93, 14);
		add(lblNombrePelicula);
		
		lblGPelicula = new JLabel("Genero");
		lblGPelicula.setBounds(75, 77, 93, 14);
		add(lblGPelicula);
		
		lblID = new JLabel("");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblID.setBounds(205, 11, 114, 14);
		lblID.setText(Integer.toString(Pelicula.getContador()));
		add(lblID);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(205, 36, 114, 26);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		cbxGenero = new JComboBox<Genero>();
		cbxGenero.setBounds(205, 69, 114, 22);
		add(cbxGenero);
		cbxGenero.addItem(new Genero("Seleccione un genero"));
		cbxGenero.addItem(new Genero("Terror"));
		cbxGenero.addItem(new Genero("Accion"));
		cbxGenero.addItem(new Genero("Suspenso"));
		cbxGenero.addItem(new Genero("Romantica"));
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cbxGenero.getSelectedIndex() != 0 && !txtNombre.getText().isEmpty()) {
					String nombre = txtNombre.getText();
					Genero genero = new Genero(cbxGenero.getSelectedItem().toString());
					Pelicula pelicula = new Pelicula(nombre, genero);
					
					if(!existePelicula(model, pelicula)) model.addElement(pelicula);
					else {
						JOptionPane.showMessageDialog(null, "Pelicula ya ingresada");
						Pelicula.decreaseContador();
					}
					
					cbxGenero.setSelectedIndex(0);
					txtNombre.setText("");
					lblID.setText(Integer.toString(Pelicula.getContador()));
				}else {
					JOptionPane.showMessageDialog(null, "Complete todos los campos");
				}
			}
		});
		btnAceptar.setBounds(79, 130, 89, 23);
		add(btnAceptar);

	}

	public DefaultListModel<Pelicula> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<Pelicula> model) {
		this.model = model;
	}
	
	public boolean existePelicula(DefaultListModel<Pelicula> model, Pelicula pelicula) {
		for(int i = 0; i < model.getSize() ; i++) {
			if(model.getElementAt(i).compareTo(pelicula) == 0) return true;
		}
		return false;
	}
	
}
