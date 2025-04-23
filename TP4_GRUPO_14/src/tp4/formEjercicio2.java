package tp4;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class formEjercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtPromedio;
	private JTextField txtCondicion;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					formEjercicio2 frame = new formEjercicio2();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public formEjercicio2() {
		setTitle("Promedio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 468, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 128, 192)));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelNotas = new JPanel();
		panelNotas.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 192)), "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNotas.setBounds(42, 25, 279, 182);
		contentPane.add(panelNotas);
		panelNotas.setLayout(null);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setBounds(20, 26, 46, 14);
		panelNotas.add(lblNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setBounds(20, 62, 46, 14);
		panelNotas.add(lblNota2);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
		lblNota3.setBounds(20, 99, 46, 14);
		panelNotas.add(lblNota3);
		
		JLabel lblTPS = new JLabel("TPS");
		lblTPS.setBounds(20, 137, 46, 14);
		panelNotas.add(lblTPS);
		
		txtNota1 = new JTextField();
		txtNota1.addKeyListener(new soloNumeros2(txtNota1));
		txtNota1.setBounds(103, 23, 134, 20);
		panelNotas.add(txtNota1);
		txtNota1.setColumns(10);
		
		txtNota2 = new JTextField();
		txtNota2.addKeyListener(new soloNumeros2(txtNota2));
		txtNota2.setBounds(103, 59, 134, 20);
		panelNotas.add(txtNota2);
		txtNota2.setColumns(10);
		
		txtNota3 = new JTextField();
		txtNota3.addKeyListener(new soloNumeros2(txtNota3));
		txtNota3.setBounds(103, 96, 134, 20);
		panelNotas.add(txtNota3);
		txtNota3.setColumns(10);
		
		JComboBox<String> cbxAprobado_Desaprobado = new JComboBox<String>();
		cbxAprobado_Desaprobado.setBorder(new LineBorder(new Color(0, 128, 192)));
		cbxAprobado_Desaprobado.setModel(new DefaultComboBoxModel<String>(new String[] {"Aprobado", "Desaprobado"}));
		cbxAprobado_Desaprobado.setBounds(103, 133, 134, 22);
		panelNotas.add(cbxAprobado_Desaprobado);
		
		JPanel panelPromedio_y_Condicion = new JPanel();
		panelPromedio_y_Condicion.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 192)), "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPromedio_y_Condicion.setBounds(42, 225, 279, 109);
		contentPane.add(panelPromedio_y_Condicion);
		panelPromedio_y_Condicion.setLayout(null);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setBounds(22, 41, 68, 14);
		panelPromedio_y_Condicion.add(lblPromedio);
		
		JLabel lblCondicion = new JLabel("Condicion:");
		lblCondicion.setBounds(22, 66, 68, 14);
		panelPromedio_y_Condicion.add(lblCondicion);
		
		txtPromedio = new JTextField();
		txtPromedio.setCaretColor(new Color(255, 255, 255));
		txtPromedio.setBounds(109, 38, 125, 20);
		panelPromedio_y_Condicion.add(txtPromedio);
		txtPromedio.setColumns(10);
		
		txtCondicion = new JTextField();
		txtCondicion.setCaretColor(new Color(255, 255, 255));
		txtCondicion.setBounds(109, 66, 125, 20);
		panelPromedio_y_Condicion.add(txtCondicion);
		txtCondicion.setColumns(10);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(331, 83, 111, 36);
		contentPane.add(btnCalcular);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(331, 120, 111, 36);
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(331, 157, 111, 36);
		contentPane.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {dispose();}
		});
		
		EventoCalcularPromedio eventoCalcular = new EventoCalcularPromedio(txtNota1, txtNota2, txtNota3, txtPromedio, txtCondicion, cbxAprobado_Desaprobado);
		btnCalcular.addActionListener(eventoCalcular);
		
		EventoNuevo eventoNuevo = new EventoNuevo (txtNota1, txtNota2, txtNota3, txtPromedio, txtCondicion, cbxAprobado_Desaprobado);
		btnNuevo.addActionListener(eventoNuevo);

		//txtPromedio.addKeyListener(new prohibirTipeo());
		//txtCondicion.addKeyListener(new prohibirTipeo());
		
		txtNota1.addFocusListener(new eventoFocoTxt(txtNota1));
		txtNota2.addFocusListener(new eventoFocoTxt(txtNota2));
		txtNota3.addFocusListener(new eventoFocoTxt(txtNota3));
		
	}
	
	public void cambiarVisibilidad(boolean estado) {
		
		setVisible(estado);
		
	}
}

class EventoCalcularPromedio implements ActionListener{
	private JTextField txtNota1, txtNota2, txtNota3, txtCondicion, txtPromedio;
	private JComboBox<String> cbxCondicion;
	
	public EventoCalcularPromedio() {}
	
	public EventoCalcularPromedio(JTextField nota1, JTextField nota2, JTextField nota3, JTextField promedio, JTextField condicion,JComboBox<String> cbxCondicion ) {
		this.txtNota1 = nota1;
		this.txtNota2 = nota2;
		this.txtNota3 = nota3;
		this.txtPromedio = promedio;
		this.txtCondicion = condicion;
		this.cbxCondicion = cbxCondicion;
	}
	
	public JTextField getTxtNota1() {
		return txtNota1;
	}

	public void setTxtNota1(JTextField txtNota1) {
		this.txtNota1 = txtNota1;
	}

	public JTextField getTxtNota2() {
		return txtNota2;
	}

	public void setTxtNota2(JTextField txtNota2) {
		this.txtNota2 = txtNota2;
	}

	public JTextField getTxtNota3() {
		return txtNota3;
	}

	public void setTxtNota3(JTextField txtNota3) {
		this.txtNota3 = txtNota3;
	}
	

	public JTextField getTxtCondicion() {
		return txtCondicion;
	}

	public void setTxtCondicion(JTextField txtCondicion) {
		this.txtCondicion = txtCondicion;
	}

	public JTextField getTxtPromedio() {
		return txtPromedio;
	}

	public void setTxtPromedio(JTextField txtPromedio) {
		this.txtPromedio = txtPromedio;
	}

	public JComboBox<String> getCbxCondicion() {
		return cbxCondicion;
	}

	public void setCbxCondicion(JComboBox<String> cbxCondicion) {
		this.cbxCondicion = cbxCondicion;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean calcularPromedio = true;
		
		ArrayList<JTextField> listaTxt = new ArrayList<JTextField>();
		listaTxt.add(txtNota1);
		listaTxt.add(txtNota2);
		listaTxt.add(txtNota3);
		ListIterator<JTextField> it = listaTxt.listIterator();
		
		while(it.hasNext()) {
			JTextField txt = it.next();
			if(txt.getText().isEmpty() || verificarNota(txt)) {
			txt.setBackground(Color.RED);
			calcularPromedio = false;
			}
		}
		
//		if (txtNota1.getText().isEmpty()) {txtNota1.setBackground(Color.RED); calcularPromedio = false;}
//		if (txtNota2.getText().isEmpty()) {txtNota2.setBackground(Color.RED); calcularPromedio = false;}
//		if (txtNota3.getText().isEmpty()) {txtNota3.setBackground(Color.RED); calcularPromedio = false;}
		
		if (calcularPromedio) {
			try {
				establecerPromedioYCondicion();
			} catch(NumberFormatException e) {
			}
		}
	}
	
	private void establecerPromedioYCondicion()
	{
		float nota1 = Float.parseFloat(txtNota1.getText());
		float nota2 = Float.parseFloat(txtNota2.getText());
		float nota3 = Float.parseFloat(txtNota3.getText());
		float promedio = (nota1 + nota2 + nota3) / 3;
		txtPromedio.setText(Float.toString(promedio));
		
		ArrayList<Float> notas = new ArrayList<Float>();
		notas.add(nota1);
		notas.add(nota2);
		notas.add(nota3);
		ListIterator<Float> it = notas.listIterator();

		boolean promocionado = true;
		boolean libre = false;
		
		while(it.hasNext()) {
			float nota = it.next();
			if(nota < 8) {
				promocionado = false;
				if(nota < 6) libre = true;
			}
		}
		
		if(cbxCondicion.getSelectedItem().equals("Desaprobado") || libre) txtCondicion.setText("Libre");
		else if (promocionado) txtCondicion.setText("Promocionado");
		else txtCondicion.setText("Regular");
		
		
		txtPromedio.setEditable(false);
		txtCondicion.setEditable(false);
	}
	
	private boolean verificarNota(JTextField txtNota) {
		float nota = Float.parseFloat(txtNota.getText());
		return nota > 10 || nota < 1;
	}
}

class soloNumeros2 extends KeyAdapter
{
	private JTextField texto;
	public soloNumeros2(JTextField texto)
	{
		this.texto = texto;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	int key = e.getKeyChar();
	
	if((key<'0' || key>'9') && key!='.') e.consume();
	if(key =='.' && texto.getText().contains(".")) e.consume();
	if(texto.getText().trim().length() == 5) e.consume();
}
	
}

/*class prohibirTipeo implements KeyListener{

	public prohibirTipeo() {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		e.consume();	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}*/

class EventoNuevo implements ActionListener{

	private JTextField txtNota1, txtNota2, txtNota3, txtCondicion, txtPromedio;
	private JComboBox<String> cbxCondicion;
	
	public EventoNuevo(JTextField nota1, JTextField nota2, JTextField nota3, JTextField promedio, JTextField condicion,JComboBox<String> cbxCondicion){
		this.txtNota1 = nota1;
		this.txtNota2 = nota2;
		this.txtNota3 = nota3;
		this.txtPromedio = promedio;
		this.txtCondicion = condicion;
		this.cbxCondicion = cbxCondicion;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		limpiarEntradas();
	}
	
	public void limpiarEntradas() {
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
		txtPromedio.setText("");
		txtCondicion.setText("");
		txtCondicion.setEditable(true);
		txtPromedio.setEditable(true);
		cbxCondicion.setSelectedIndex(0);
		txtNota1.setBackground(Color.WHITE);
		txtNota2.setBackground(Color.WHITE);
		txtNota3.setBackground(Color.WHITE);
	}
	
}

class eventoFocoTxt implements FocusListener{

	JTextField nota;
	
	public eventoFocoTxt(JTextField nota) {
		
		this.nota = nota;
		
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		nota.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(nota.getText().isEmpty()) nota.setBackground(Color.RED);
	}
	
}

