package view;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class Login extends JDialog {
	private JTextField inputLogin;
	private JPasswordField inputSenha;
	public Login() {
		setTitle("Login");
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setResizable(false);
		getContentPane().setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		setBounds(new Rectangle(0, 0, 510, 356));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/logo.png")));
		getContentPane().setLayout(null);
		
		JLabel txtLogin = new JLabel("Login");
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtLogin.setBounds(205, 77, 57, 27);
		getContentPane().add(txtLogin);
		
		JLabel txtSenha = new JLabel("Senha");
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		txtSenha.setBounds(197, 165, 70, 27);
		getContentPane().add(txtSenha);
		
		inputLogin = new JTextField();
		inputLogin.setBackground(new Color(255, 255, 255));
		inputLogin.setBounds(161, 115, 145, 20);
		getContentPane().add(inputLogin);
		inputLogin.setColumns(10);
		
		inputSenha = new JPasswordField();
		inputSenha.setBounds(172, 203, 130, 20);
		getContentPane().add(inputSenha);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(197, 248, 89, 23);
		getContentPane().add(btnLogin);
		
		JLabel tituloLogin = new JLabel("Acessar conta");
		tituloLogin.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLogin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		tituloLogin.setBounds(161, 28, 145, 38);
		getContentPane().add(tituloLogin);
		
		JLabel imgDatabase = new JLabel("");
		imgDatabase.setIcon(new ImageIcon(Login.class.getResource("/img/databaseOff.png")));
		imgDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		imgDatabase.setBounds(0, 248, 78, 59);
		getContentPane().add(imgDatabase);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login dialog = new Login();
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
