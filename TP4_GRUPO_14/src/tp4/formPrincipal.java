package tp4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class formPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnEjercicio1;
	private JButton btnEjercicio2;
	private JButton btnEjercicio3;
	private formEjercicio1 f; 
	private formEjercicio2 f2;
	private formEjercicio3 f3;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formPrincipal frame = new formPrincipal();
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
	public formPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGrupo = new JLabel("GRUPO NRO:14");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrupo.setBounds(144, 61, 139, 27);
		contentPane.add(lblGrupo);
		
		btnEjercicio1 = new JButton("Ejercicio 1");
		btnEjercicio1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEjercicio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(f == null) {
						f = new formEjercicio1();
					}
					f.setLocationRelativeTo(null);
					f.toFront();
					f.visibilidad(true); 
			}
		});
		btnEjercicio1.setBounds(154, 99, 117, 23);
		contentPane.add(btnEjercicio1);
		
		btnEjercicio2 = new JButton("Ejercicio 2");
		btnEjercicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f2 == null) {
					f2 = new formEjercicio2();
				}
				f2.setLocationRelativeTo(null);
				f2.toFront();
				f2.cambiarVisibilidad(true);
			}
		});
		btnEjercicio2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEjercicio2.setBounds(154, 134, 117, 23);
		contentPane.add(btnEjercicio2);
		
		btnEjercicio3 = new JButton("Ejercicio 3");
		btnEjercicio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f3 == null) {
					f3 = new formEjercicio3();
				}
				f3.setLocationRelativeTo(null);
				f3.toFront();
				f3.cambiarVisibilidad(true);
			}
		});
		btnEjercicio3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEjercicio3.setBounds(154, 168, 116, 23);
		contentPane.add(btnEjercicio3);
	}
	
	public void visibilidad(boolean b)
	{
		setVisible(b);
	}
}
