package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Funcionarios extends JDialog {
	private JTextField inputLogin;
	private JTextField inputEmail;
	private JTextField inputPerfil;
	private JTextField inputNome;
	private JPasswordField inputSenha;
	public Funcionarios() {
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel nomeFunc = new JLabel("Nome:");
		nomeFunc.setHorizontalAlignment(SwingConstants.CENTER);
		nomeFunc.setBounds(10, 60, 82, 20);
		getContentPane().add(nomeFunc);
		
		JLabel emailFunc = new JLabel("Email:");
		emailFunc.setHorizontalAlignment(SwingConstants.CENTER);
		emailFunc.setBounds(26, 159, 46, 14);
		getContentPane().add(emailFunc);
		
		JLabel loginFunc = new JLabel("Login:");
		loginFunc.setHorizontalAlignment(SwingConstants.CENTER);
		loginFunc.setBounds(26, 113, 46, 14);
		getContentPane().add(loginFunc);
		
		JLabel perfilFunc = new JLabel("Perfil:");
		perfilFunc.setHorizontalAlignment(SwingConstants.CENTER);
		perfilFunc.setBounds(26, 224, 46, 20);
		getContentPane().add(perfilFunc);
		
		JLabel senhaFunc = new JLabel("Senha:");
		senhaFunc.setHorizontalAlignment(SwingConstants.CENTER);
		senhaFunc.setBounds(257, 159, 40, 14);
		getContentPane().add(senhaFunc);
		
		inputLogin = new JTextField();
		inputLogin.setBounds(82, 110, 360, 20);
		getContentPane().add(inputLogin);
		inputLogin.setColumns(10);
		
		inputEmail = new JTextField();
		inputEmail.setBounds(82, 159, 165, 20);
		getContentPane().add(inputEmail);
		inputEmail.setColumns(10);
		
		inputPerfil = new JTextField();
		inputPerfil.setBounds(82, 224, 360, 20);
		getContentPane().add(inputPerfil);
		inputPerfil.setColumns(10);
		
		inputNome = new JTextField();
		inputNome.setBounds(82, 60, 360, 20);
		getContentPane().add(inputNome);
		inputNome.setColumns(10);
		
		inputSenha = new JPasswordField();
		inputSenha.setBounds(299, 156, 143, 20);
		getContentPane().add(inputSenha);
		
		JLabel imgCreate = new JLabel("");
		imgCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgCreate.setHorizontalAlignment(SwingConstants.CENTER);
		imgCreate.setIcon(new ImageIcon(Funcionarios.class.getResource("/img/create.png")));
		imgCreate.setBounds(271, 301, 69, 59);
		getContentPane().add(imgCreate);
		
		JLabel imgUpdate = new JLabel("");
		imgUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		imgUpdate.setIcon(new ImageIcon(Funcionarios.class.getResource("/img/update.png")));
		imgUpdate.setBounds(338, 301, 69, 59);
		getContentPane().add(imgUpdate);
		
		JLabel imgDelete = new JLabel("");
		imgDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgDelete.setHorizontalAlignment(SwingConstants.CENTER);
		imgDelete.setIcon(new ImageIcon(Funcionarios.class.getResource("/img/delete.png")));
		imgDelete.setBounds(397, 301, 82, 59);
		getContentPane().add(imgDelete);
		setForeground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 520, 410));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Funcionarios.class.getResource("/img/logo.png")));
		setTitle("Funcionarios");
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionarios dialog = new Funcionarios ();
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
