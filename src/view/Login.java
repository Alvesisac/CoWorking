package view;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

import javax.swing.JPasswordField;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class Login extends JDialog {
	private JTextField inputLogin;
	private JPasswordField inputSenha;
	private JLabel imgDatabase;
	public Login() {
		
		addWindowListener(new WindowAdapter(){
			public void windowActivated(WindowEvent e) {
				statusConexaoBanco();
			}
		});
		
		
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
			public void actionPerformed(ActionEvent e){
				logar();
			}
		});
		
		btnLogin.setBounds(197, 248, 89, 23);
		getContentPane().add(btnLogin);
		
		JLabel tituloLogin = new JLabel("Acessar conta");
		tituloLogin.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLogin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		tituloLogin.setBounds(161, 28, 145, 38);
		getContentPane().add(tituloLogin);
		
		
		imgDatabase = new JLabel("");
		imgDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		imgDatabase.setIcon(new ImageIcon(Login.class.getResource("/img/databaseOff.png")));
		imgDatabase.setBounds(25, 252, 46, 55);
		getContentPane().add(imgDatabase);
		
		//Acessar o botão "Entrar" com a tecla "Enter"
		getRootPane().setDefaultButton(btnLogin);
		
		//Validação dos campos utilizando a biblioteca Atxy2k
	
		
		//Validação do campo inputLogin
		RestrictedTextField validarLogin = new RestrictedTextField(inputLogin,"abcdefghijklmnopqrstuvwxyz0123456789_-.");
		
	
		//Determinar o uso de alguns caracteres especiais (_ - .) e alfanúmericos
		validarLogin.setOnlyCustomCharacters(true);
		
		
		

		//Restringir a caracteres alfanuméricos no campo login
		validarLogin.setLimit(20);
		
		//Validação do campo inputSenha
		RestrictedTextField validarSenha = new RestrictedTextField(inputSenha);
		
		//Limpitar a somente 15 caracteres no campo senha
		validarSenha.setLimit(15);
		
		//Desativar a tecla espaço no campo senha
	}
	

	DAO dao = new DAO();
	
	
	
	private void statusConexaoBanco() {
		
		try {
			Connection conexaoBanco = dao.conectar();
			
			if (conexaoBanco == null) {
				imgDatabase.setIcon(new ImageIcon (Login.class.getResource("/img/databaseOff.png")));
			}
			
			else {
				//Trocar a imagem se houver conexão
				imgDatabase.setIcon(new ImageIcon(Login.class.getResource("/img/databaseOn.png")));
			}
			conexaoBanco.close();
			
		}
		
		catch (Exception e) {
			System.out.println(e);
		}	
		
		
	}
	
	private void logar() {
		String read = "select * from funcionario where login=? and senha=md5(?)";

		if (inputLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Login do usuário obrigatório!");
			inputSenha.requestFocus();
		}
		
		else if (inputSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Senha ou usuario obrigatória!");
			inputSenha.requestFocus();
		}
		
		
		
		else {
		
		try {

			// Estabelecer a conexão
			Connection conexaoBanco = dao.conectar();

			// Preparar a execução do script SQL
			PreparedStatement executarSQL = conexaoBanco.prepareStatement(read);

			// Atribuir valores de login e senha
			// Substituir as interrogações pelo conteúdo da caixa de texto (input)
			executarSQL.setString(1, inputLogin.getText());
			executarSQL.setString(2, inputSenha.getText());

			// Executar os comandos SQL e de acordo com resultado liberar os recursos na
			// tela
			ResultSet resultadoExecucao = executarSQL.executeQuery();

			// Validação do funcionário (autenticação)
			// resultadoExecucao.next() significa que o login e a senha existem, ou seja,
			// correspondem

			if (resultadoExecucao.next()) {
				
				Home home = new Home();
				home.setVisible(true);
				home.txtUsuarioLogado.setText("Usuário: " + resultadoExecucao.getString(2));
				dispose();
			}
			
			else {
				
				JOptionPane.showMessageDialog(null,"Login e/ou senha invalido(s)!");
				inputLogin.setText(null);
				inputSenha.setText(null);
				inputLogin.requestFocus();
			}
			
			conexaoBanco.close();
			
		}

		catch (Exception e) {
			System.out.println(e);
		}
		}
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
