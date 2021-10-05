package pe.edu.idat.formularios;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class frmListados {

	private JFrame frame;
	private JTextField txtrepetidor1;
	private JTextField txtrepetidor2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmListados window = new frmListados();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmListados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 382, 334);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ESTRUCTURAS REPETITIVAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 346, 14);
		frame.getContentPane().add(lblNewLabel);

		JList listrepetidor1 = new JList();	
		listrepetidor1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String numero = (String) listrepetidor1.getSelectedValue();
				JOptionPane.showMessageDialog(null, numero);
			}
		});
		JScrollPane jcp1 = new JScrollPane(listrepetidor1);
		jcp1.setBounds(10, 109, 146, 175);
		frame.getContentPane().add(jcp1);
		
		JList listrepetidor2 = new JList();
		JScrollPane scrollPane = new JScrollPane(listrepetidor2);
		scrollPane.setBounds(204, 109, 146, 175);
		frame.getContentPane().add(scrollPane);

		txtrepetidor1 = new JTextField();
		txtrepetidor1.setBounds(10, 49, 146, 20);
		frame.getContentPane().add(txtrepetidor1);
		txtrepetidor1.setColumns(10);

		txtrepetidor2 = new JTextField();
		txtrepetidor2.setColumns(10);
		txtrepetidor2.setBounds(204, 49, 146, 20);
		frame.getContentPane().add(txtrepetidor2);

		JButton btnrepetidor1 = new JButton("COMENZAR");
		btnrepetidor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listrepetidor1.setModel(new DefaultListModel());
				Integer repetir = Integer.parseInt(txtrepetidor1.getText());
				List<String> listaPares = new ArrayList<String>();
				for (int i = 0; i <= repetir; i++) {
					if (i % 2 == 0) {
						listaPares.add(String.valueOf(i));
					}
				}
				listrepetidor1.setListData(listaPares.toArray());
			}
		});
		btnrepetidor1.setBounds(10, 80, 146, 23);
		frame.getContentPane().add(btnrepetidor1);

		JButton btnrepetidor2 = new JButton("COMENZAR");
		btnrepetidor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listrepetidor2.setModel(new DefaultListModel());
				Integer repetir = Integer.parseInt(txtrepetidor2.getText());
				// JOptionPane.showMessageDialog(null, esPrimo(repetir));
				List<String> listaPrimos = new ArrayList<String>();
				int contador = 1;
				int numero = 1;
				do {					
					if (esPrimo(numero)) {
						listaPrimos.add(String.valueOf(numero));
						contador++;
					}
					numero++;
				} while(contador <= repetir);
				listrepetidor2.setListData(listaPrimos.toArray());
			}

		});
		btnrepetidor2.setBounds(204, 80, 146, 23);
		frame.getContentPane().add(btnrepetidor2);
		

	}

	public static boolean esPrimo(int numero) {
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				return false;
		}
		return true;
	}
}
