package TP5;

import javax.swing.JPanel;

import java.util.TreeSet;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

public class panelListarPeliculas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPeliculas;
	private JList<Pelicula> list;
	private DefaultListModel<Pelicula> model;
	
	/**
	 * Create the panel.
	 */
	public panelListarPeliculas() {
		setLayout(null);
		
		JLabel lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setBounds(25, 134, 60, 20);
		add(lblPeliculas);
		
		list = new JList<Pelicula>();
		
		model = new DefaultListModel<Pelicula>();
		
		list.setBounds(100, 16, 335, 268);
		add(list);

	}

	public DefaultListModel<Pelicula> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<Pelicula> model) {
		this.model = model;
		list.setModel(ordenarPeliculasA_Z(model));
	}
	
	public DefaultListModel<Pelicula> ordenarPeliculasA_Z(DefaultListModel<Pelicula> model){
		TreeSet<Pelicula> peliculas = new TreeSet<Pelicula>();
		int tamanio = model.getSize();
		for (int i = 0; i < tamanio; i++) {
			peliculas.add(model.getElementAt(i));
		}
		model.clear();
		
		for (Pelicula pelicula : peliculas) {
			model.addElement(pelicula);
		}
		
		return model;
	}

	
}
