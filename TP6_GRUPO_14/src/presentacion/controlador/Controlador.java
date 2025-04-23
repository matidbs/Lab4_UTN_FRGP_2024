package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersona;
import presentacion.vista.PanelEliminarPersona;
import presentacion.vista.PanelListarPersona;
import presentacion.vista.PanelModificarPersona;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal; 
	private PersonaNegocio personaNegocio;
	private PanelAgregarPersona pnlAgregarPersona;
	private PanelModificarPersona pnlModificarPersona;
	private PanelEliminarPersona pnlEliminarPersona;
	private PanelListarPersona pnlListarPersona;
	private static DefaultListModel<Persona> model;
	private ArrayList<Persona> lista;
	
	public Controlador(VentanaPrincipal ventanaPrincipal, PersonaNegocio personaNegocio){
		//Guardo las instancias
		this.ventanaPrincipal = ventanaPrincipal;
		this.personaNegocio = personaNegocio;
		
		//Instancia del model
		model = new DefaultListModel<Persona>();

		//Instancia de paneles
		this.pnlAgregarPersona = new PanelAgregarPersona();
		this.pnlModificarPersona = new PanelModificarPersona();
		this.pnlEliminarPersona = new PanelEliminarPersona();
		this.pnlListarPersona = new PanelListarPersona();
		this.actualizarModel();
		
		//Eventos abrir menu
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a -> EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMntmModificar().addActionListener(a -> EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(a -> EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMntmListar().addActionListener(a -> EventoClickMenu_AbrirPanel_ListarPersona(a));
		
		//Eventos PanelAgregarPersona
		this.pnlAgregarPersona.getBtnAceptar().addActionListener(x->EventoClickBoton_PanelAgregar_btnAceptar(x));
		this.pnlAgregarPersona.getTxtNombre().addKeyListener(new soloLetras());
		this.pnlAgregarPersona.getTxtApellido().addKeyListener(new soloLetras());
		this.pnlAgregarPersona.getTxtDni().addKeyListener(new soloNumeros(pnlAgregarPersona.getTxtDni()));
		
		//Eventos PanelModificarPersona
		this.pnlModificarPersona.getListPersonas().addListSelectionListener(a -> getSelectedValueJList_ModificarPersona(a));
		this.pnlModificarPersona.getBtnModificar().addActionListener(a -> EventoClickBoton_PanelModificar_btnModificar(a));
		this.pnlModificarPersona.getTxtNombre().addKeyListener(new soloLetras());
		this.pnlModificarPersona.getTxtApellido().addKeyListener(new soloLetras());;
		
		//Eventos PanelEliminarPersona
		this.pnlEliminarPersona.getBtnEliminar().addActionListener(a -> EventoClickBoton_PanelEliminar_btnEliminar(a));

	}
	
	
	public void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(pnlAgregarPersona);
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a) {
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(pnlModificarPersona);
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a) {
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(pnlEliminarPersona);
		this.pnlEliminarPersona.setModel(cargarModel());
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent a) {
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(pnlListarPersona);
		this.pnlListarPersona.cargarModelTablaPersonas(personaNegocio.listar());
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickBoton_PanelAgregar_btnAceptar(ActionEvent A) {
		
		String Dni = this.pnlAgregarPersona.getTxtDni().getText().trim();
		String Nombre = this.pnlAgregarPersona.getTxtNombre().getText().trim();
		String Apellido = this.pnlAgregarPersona.getTxtApellido().getText().trim();
		Persona p = new Persona(Dni, Nombre, Apellido);
		String resultado;
		
		if(!Nombre.isEmpty() && !Apellido.isEmpty() && !Dni.isEmpty()) {
			if(personaNegocio.insert(p)) 
			{
				resultado =  "Persona agregada con exito";
				pnlAgregarPersona.getTxtNombre().setText("");
				pnlAgregarPersona.getTxtApellido().setText("");
				pnlAgregarPersona.getTxtDni().setText("");
				this.actualizarModel();
			}
			else resultado= "Hubo un error, el dni ya existe en los registros";
		} else resultado = "Es necesario completar todos los campos";
		
		pnlAgregarPersona.mostrarMensaje(resultado);
	}
	
	public void EventoClickBoton_PanelEliminar_btnEliminar(ActionEvent a) {
		Persona p = this.pnlEliminarPersona.getLista().getSelectedValue();
		String resultado;
		
		if (p == null) {
			resultado = "Seleccione una persona";
		}else {
			if(personaNegocio.delete(p)) resultado = "Persona eliminada con exito";
			else resultado = "No se pudo eliminar el registro";			
		}
		
		this.pnlEliminarPersona.mostrarMensaje(resultado);
		// Actualiza el listModel
		this.pnlEliminarPersona.setModel(cargarModel());
	}	
	
	public void getSelectedValueJList_ModificarPersona(ListSelectionEvent e) {
		this.pnlModificarPersona.getListPersonas().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if(!e.getValueIsAdjusting()) {
			Persona p = this.pnlModificarPersona.getListPersonas().getSelectedValue();
			if( p != null) {				
				this.pnlModificarPersona.getTxtNombre().setText(p.getNombre());
				this.pnlModificarPersona.getTxtApellido().setText(p.getApellido());
				this.pnlModificarPersona.getTxtDNI().setText(p.getDni());
				this.pnlModificarPersona.getTxtDNI().setEditable(false);
			}else {
				this.pnlModificarPersona.getTxtNombre().setText("");
				this.pnlModificarPersona.getTxtApellido().setText("");
				this.pnlModificarPersona.getTxtDNI().setText("");
				this.pnlModificarPersona.getTxtDNI().setEditable(true);
			}
		}
	}
	
	public void EventoClickBoton_PanelModificar_btnModificar(ActionEvent a) {
		String Dni = this.pnlModificarPersona.getTxtDNI().getText();
		String Nombre = this.pnlModificarPersona.getTxtNombre().getText();
		String Apellido = this.pnlModificarPersona.getTxtApellido().getText();
		String mensaje;
		Persona p = new Persona(Dni, Nombre, Apellido);
		if(!(Nombre.isEmpty() || Apellido.isEmpty())) {
			if(personaNegocio.update(p))  {
					
					mensaje = "Datos modificados con exito";
					pnlModificarPersona.getTxtNombre().setText("");
					pnlModificarPersona.getTxtApellido().setText("");
					pnlModificarPersona.getTxtDNI().setText("");
					pnlModificarPersona.getTxtDNI().setEditable(true);
					
			}
			else mensaje = "No se pudo modificar los datos";
		
			
		
		}else {
		mensaje = "Es necesario completar los campos";
		}
		this.pnlModificarPersona.mostrarMensaje(mensaje);
		//Se actualiza el model
		this.actualizarModel();
	}

	public void actualizarModel() {
		model.removeAllElements();
		this.lista = (ArrayList<Persona>) personaNegocio.listar();
		for (Persona persona : lista) {
			model.addElement(persona);
		}
		this.pnlModificarPersona.setModel(model);
	}
	
	private DefaultListModel<Persona> cargarModel() {
		model.clear();
		this.lista = (ArrayList<Persona>) personaNegocio.listar();
		for (Persona x : lista) {
			model.addElement(x);
		}
		return model;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);
	}

}

class soloLetras extends KeyAdapter
{	
	@Override
	public void keyTyped(KeyEvent e) {
		
		int key = e.getKeyChar();
		
		if(!(Character.isAlphabetic(key) || Character.isWhitespace(key)))
				e.consume();
		}	
}
class soloNumeros extends KeyAdapter
{	
	private JTextField texto;
	public soloNumeros(JTextField texto)
	{
		this.texto = texto;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		int key = e.getKeyChar();		
		if(!(Character.isDigit(key))) e.consume();
		if(texto.getText().trim().length() == 8) e.consume();
		}
	
}

