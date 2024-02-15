package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Home extends JDialog {
	public JLabel txtUsuarioLogado;
	public JPanel panelUsuario;
	public JLabel txtData;
	
	
	public Home() {
		
		addWindowListener (new WindowAdapter() {
			public void windowActivated (WindowEvent e) {
				Date dataSistema = new Date();
				DateFormat formatadorData = DateFormat.getDateInstance(DateFormat.FULL);
				txtData.setText(formatadorData.format(dataSistema));
			}
			
		});
		
		
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBounds(new Rectangle(0, 0, 520, 410));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/img/logo.png")));
		setResizable(false);
		setTitle("Home");
		getContentPane().setLayout(null);
		
		JButton btnRoom = new JButton("");
		btnRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRoom.setBorderPainted(false);
		btnRoom.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRoom.setIcon(new ImageIcon(Home.class.getResource("/img/room.png")));
		btnRoom.setBounds(194, 123, 123, 99);
		getContentPane().add(btnRoom);
		
		btnRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Salas salas = new Salas();
			salas.setVisible(true);
			}
		});
		
		JButton bntReserve = new JButton("");
		bntReserve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntReserve.setBorderPainted(false);
		bntReserve.setHorizontalTextPosition(SwingConstants.CENTER);
		bntReserve.setIcon(new ImageIcon(Home.class.getResource("/img/reserve.png")));
		bntReserve.setBounds(349, 123, 129, 100);
		getContentPane().add(bntReserve);
		
		bntReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservas reservas = new Reservas();
				reservas.setVisible(true);
			}
		});
		
		JButton bntUser = new JButton("");
		bntUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntUser.setBorderPainted(false);
		bntUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionarios funcionarios = new Funcionarios();
				funcionarios.setVisible(true);
			}
		});
		bntUser.setIcon(new ImageIcon(Home.class.getResource("/img/user.png")));
		bntUser.setBounds(35, 123, 123, 99);
		getContentPane().add(bntUser);
		
		panelUsuario = new JPanel();
		panelUsuario.setBounds(10, 293, 484, 67);
		getContentPane().add(panelUsuario);
		panelUsuario.setLayout(null);
		
		txtUsuarioLogado = new JLabel("");
		txtUsuarioLogado.setBounds(10, 31, 186, 25);
		panelUsuario.add(txtUsuarioLogado);
		
		txtData = new JLabel("");
		txtData.setBounds(246, 42, 238, 14);
		panelUsuario.add(txtData);
		
	
	}

	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Home dialog = new Home();
						dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			});

		}
}


