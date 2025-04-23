package tp4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.ListIterator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;

public class formEjercicio1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtFecha;
	private JButton btnMostrar;
	private JLabel lblNotificacion = new JLabel("Los datos ingresados fueron: ");

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formEjercicio1 frame = new formEjercicio1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public formEjercicio1() {
		setTitle("Contactos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtApellido.requestFocus();
				}
			}
		});
		txtNombre.addFocusListener(new textFieldFoco(txtNombre));
		txtNombre.setBounds(195, 16, 200, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtTelefono.requestFocus();
				}
			}
		});
		txtApellido.setColumns(10);
		txtApellido.addFocusListener(new textFieldFoco(txtApellido));
		txtApellido.setBounds(195, 58, 200, 26);
		contentPane.add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtFecha.requestFocus();
				}
			}
		});
		txtTelefono.addKeyListener(new soloNumeros(txtTelefono));
		txtTelefono.setColumns(10);
		txtTelefono.addFocusListener(new textFieldFoco(txtTelefono));
		txtTelefono.setBounds(195, 102, 200, 26);
		contentPane.add(txtTelefono);
		
		txtFecha = new JTextField();
		txtFecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnMostrar.doClick();
				}
			}
		});
		txtFecha.setColumns(10);
		txtFecha.addFocusListener(new textFieldFoco(txtFecha));		
		txtFecha.setBounds(195, 146, 200, 26);
		contentPane.add(txtFecha);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(280, 183, 115, 29);
		contentPane.add(btnMostrar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 16, 69, 20);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(15, 58, 69, 20);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(15, 102, 69, 20);
		contentPane.add(lblTelefono);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac.");
		lblFechaNac.setBounds(15, 146, 92, 20);
		contentPane.add(lblFechaNac);
		
		
		lblNotificacion.setBounds(15, 215, 409, 29);
		contentPane.add(lblNotificacion);
		
		JLabel lblFormato = new JLabel("");
		lblFormato.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblFormato.setBounds(195, 134, 200, 14);
		contentPane.add(lblFormato);

		EventoBoton evento = new EventoBoton(txtNombre, txtApellido, txtTelefono, txtFecha, lblNotificacion, lblFormato);
		btnMostrar.addActionListener(evento);
		
		
	}

	public void visibilidad(boolean b)
	{
		setVisible(b);
		lblNotificacion.setText("Los datos ingresados fueron: ");
	}
}

class EventoBoton implements ActionListener{
	private JTextField txtNombre, txtApellido, txtTelefono, txtFecha;
	private JLabel lblNotificacion, lblFormato;
	private final String txt = "Los datos ingresados fueron: " ;
	private final String REGEX_FECHA = "^([0-2][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{2}$";

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

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtFecha() {
		return txtFecha;
	}

	public void setTxtFecha(JTextField txtFecha) {
		this.txtFecha = txtFecha;
	}
	
	public JLabel getLblNotificacion() {
		return lblNotificacion;
	}

	public void setLblNotificacion(JLabel lblNotificacion) {
		this.lblNotificacion = lblNotificacion;
	}
	
	public JLabel getLblFormato() {
		return lblFormato;
	}

	public void setLblFormato(JLabel lblFormato) {
		this.lblFormato = lblFormato;
	}

	public EventoBoton() {}
	
	public EventoBoton(JTextField nombre,JTextField apellido,JTextField telefono,JTextField fecha, JLabel noti, JLabel form) {
		this.txtNombre = nombre;
		this.txtApellido = apellido;
		this.txtTelefono = telefono;
		this.txtFecha = fecha;
		this.lblNotificacion = noti;
		this.lblFormato = form;
	}
	
	private void limpiarColorInputs() {
		txtNombre.setBackground(Color.white);
		txtApellido.setBackground(Color.white);
		txtTelefono.setBackground(Color.white);
		txtFecha.setBackground(Color.white);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		limpiarColorInputs();
		lblFormato.setText("");
		
		ArrayList<JTextField> lista = new ArrayList<JTextField>();
		lista.add(txtNombre);
		lista.add(txtApellido);
		lista.add(txtFecha);
		lista.add(txtTelefono);
		
		boolean boolCampos = true;
		
		ListIterator<JTextField> iterator = lista.listIterator();
		
		while(iterator.hasNext()) {
			JTextField texto = iterator.next();
			if(texto.getText().trim().length() <= 0) {
				texto.setBackground(Color.RED);
				boolCampos = false;}
		}
		
		if (!txtFecha.getText().trim().matches(REGEX_FECHA)) {
			txtFecha.setBackground(Color.RED);
			lblFormato.setText("Formato invalido, ingresar DD/MM/AA");
			boolCampos = false;
		}

		if(boolCampos == true) {
			String datos = txt + txtNombre.getText() + " " + txtApellido.getText() + " " + txtTelefono.getText() + " " + txtFecha.getText(); 
			lblNotificacion.setText(datos);
			limpiarColorInputs();
			
			txtNombre.setText("");
			txtApellido.setText("");
			txtTelefono.setText("");
			txtFecha.setText("");
		} else {lblNotificacion.setText(txt); }
		
		if(lblNotificacion.getText().toString().length() >= 60) {
			lblNotificacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		}
		
	}
}

class textFieldFoco extends FocusAdapter
{
	private JTextField txt;
	
	public textFieldFoco(JTextField txt) 
	{
		this.txt = txt;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		super.focusGained(e);
		txt.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent e) {
		
		if(txt.getText().isEmpty()) txt.setBackground(Color.RED);
		super.focusLost(e);
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
	if(!Character.isDigit(key)) e.consume();

	if(texto.getText().trim().length() == 10) e.consume();
}
	
	}



