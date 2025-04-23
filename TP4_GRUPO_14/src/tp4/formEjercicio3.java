package tp4;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ListIterator;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class formEjercicio3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList <JCheckBox> especialidades;
	private ButtonGroup grupo;
	private JTextField txtHorasComputador;
	private JDialog_formEjercicio3 ventana;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEjercicio3 frame = new frmEjercicio3();
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
	public formEjercicio3() {
		setTitle("Seleccion Multiple");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 456, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSO = new JPanel();
		panelSO.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelSO.setBounds(10, 11, 414, 48);
		contentPane.add(panelSO);
		panelSO.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elije un sistema operativo");
		lblNewLabel.setBounds(10, 11, 165, 14);
		panelSO.add(lblNewLabel);
		
		JRadioButton rbtnWindows = new JRadioButton("Windows\r\n");
		rbtnWindows.setBounds(181, 7, 79, 23);
		panelSO.add(rbtnWindows);
		
		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setBounds(276, 7, 65, 23);
		panelSO.add(rdbtnLinux);
		
		JRadioButton rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setBounds(343, 7, 65, 23);
		panelSO.add(rdbtnMac);
		
		//button group 
		grupo = new ButtonGroup();
		grupo.add(rbtnWindows);
		grupo.add(rdbtnLinux);
		grupo.add(rdbtnMac);
		
		JPanel panelEspecialidad = new JPanel();
		panelEspecialidad.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelEspecialidad.setBounds(10, 70, 414, 90);
		contentPane.add(panelEspecialidad);
		panelEspecialidad.setLayout(null);
		
		JLabel lblEspecialidad = new JLabel("Elije una especialidad");
		lblEspecialidad.setBounds(10, 37, 150, 14);
		panelEspecialidad.add(lblEspecialidad);
		
		JCheckBox chbProgramacion = new JCheckBox("Programaci\u00F3n");
		chbProgramacion.setBounds(225, 7, 150, 25);
		panelEspecialidad.add(chbProgramacion);
		
		JCheckBox chbAdministracion = new JCheckBox("Administraci\u00F3n");
		chbAdministracion.setBounds(225, 32, 150, 25);
		panelEspecialidad.add(chbAdministracion);
		
		JCheckBox chbDisenoGrafico = new JCheckBox("Dise\u00F1o Gr\u00E1fico");
		chbDisenoGrafico.setBounds(225, 57, 150, 25);
		panelEspecialidad.add(chbDisenoGrafico);
		
		especialidades = new ArrayList<JCheckBox>(); 
		especialidades.add(chbProgramacion);
		especialidades.add(chbAdministracion);
		especialidades.add(chbDisenoGrafico);
		
		JPanel panelCantHs_Aceptar = new JPanel();
		panelCantHs_Aceptar.setBounds(10, 171, 414, 79);
		contentPane.add(panelCantHs_Aceptar);
		panelCantHs_Aceptar.setLayout(null);
		
		txtHorasComputador = new JTextField();
		txtHorasComputador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHorasComputador.setBounds(273, 14, 83, 20);
		panelCantHs_Aceptar.add(txtHorasComputador);
		txtHorasComputador.setColumns(10);
		txtHorasComputador.addKeyListener(new soloNumeros3(txtHorasComputador));
		
		
		JLabel lblHoras = new JLabel("Cantidad de horas en el computador:");
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoras.setBounds(11, 15, 242, 19);
		panelCantHs_Aceptar.add(lblHoras);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String so = SistemaOperativoSeleccionado();
				String esp = checkBoxSeleccionada();
				String hs = cantidadHs();
				
				if(ventana == null) {
					ventana = new JDialog_formEjercicio3();
				}
				ventana.setLocationRelativeTo(null);
				ventana.toFront();
				ventana.cambiarVisibilidad(true);
				if(so.isEmpty() || esp.isEmpty() || hs.isEmpty()) ventana.setMensaje("Complete todos los campos");
				else {
					if(verificarHs(txtHorasComputador)) {
					ventana.setMensaje("Maximo 24 Hs");
					} else {
					ventana.setMensaje(so, esp, hs);
					limpiarControles();
				}}
				
			}
		});
		btnAceptar.setBounds(299, 56, 89, 23);
		panelCantHs_Aceptar.add(btnAceptar);
		
	}
	
	public void cambiarVisibilidad(boolean estado) {
		
		setVisible(estado);
		
	}
	
	private String checkBoxSeleccionada()
	{
		String e="";
		ListIterator<JCheckBox> iterado = especialidades.listIterator();
		while(iterado.hasNext()) 
		{
			JCheckBox jcb = iterado.next();
			if(jcb.isSelected()) e += jcb.getText() + " - ";
		}
		return e;
	}
	
	private String SistemaOperativoSeleccionado() {
		String so = "";
		Enumeration<AbstractButton> botones = grupo.getElements();
		while(botones.hasMoreElements()) {
			AbstractButton boton = botones.nextElement();
			if (boton.isSelected()) {
				so = boton.getText() + " - ";
			}
		}		
		return so;
	}
	
	private String cantidadHs() {
		String hs = "";
		if(!txtHorasComputador.getText().isEmpty()){
			hs = txtHorasComputador.getText() + " Hs";			
		}

		return hs;
	}
	
	private void limpiarControles()
	{
		grupo.clearSelection();
		txtHorasComputador.setText("");
		ListIterator<JCheckBox> iterado = especialidades.listIterator();
		while(iterado.hasNext()) 
		{
			JCheckBox jcb = iterado.next();
			if(jcb.isSelected()) jcb.setSelected(false);
		}
	}
	
	public boolean verificarHs(JTextField txt) {
		try {
		int	x = Integer.parseInt(txt.getText().trim());
		if(x > 24) return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}

class soloNumeros3 extends KeyAdapter
{
	private JTextField txt;
	
	public soloNumeros3(JTextField txt) {
		this.txt = txt;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	
	int key = e.getKeyChar();
	if(!Character.isDigit(key)) e.consume();
	if(txt.getText().trim().length() == 2) e.consume();
	
}
}
