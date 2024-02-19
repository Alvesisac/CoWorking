package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import model.DAO;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class Funcionarios extends JDialog {
	private JTextField inputLogin;
	private JTextField inputEmail;
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
		emailFunc.setBounds(265, 200, 46, 14);
		getContentPane().add(emailFunc);

		JLabel loginFunc = new JLabel("Login:");
		loginFunc.setHorizontalAlignment(SwingConstants.CENTER);
		loginFunc.setBounds(26, 136, 46, 14);
		getContentPane().add(loginFunc);

		JLabel perfilFunc = new JLabel("Perfil:");
		perfilFunc.setHorizontalAlignment(SwingConstants.CENTER);
		perfilFunc.setBounds(26, 197, 46, 20);
		getContentPane().add(perfilFunc);

		JLabel senhaFunc = new JLabel("Senha:");
		senhaFunc.setHorizontalAlignment(SwingConstants.CENTER);
		senhaFunc.setBounds(265, 136, 40, 14);
		getContentPane().add(senhaFunc);

		inputLogin = new JTextField();
		inputLogin.setBounds(82, 133, 179, 20);
		getContentPane().add(inputLogin);
		inputLogin.setColumns(10);

		inputEmail = new JTextField();
		inputEmail.setBounds(312, 197, 149, 20);
		getContentPane().add(inputEmail);
		inputEmail.setColumns(10);

		inputNome = new JTextField();
		inputNome.setBounds(82, 60, 379, 20);
		getContentPane().add(inputNome);
		inputNome.setColumns(10);

		inputSenha = new JPasswordField();
		inputSenha.setBounds(312, 133, 149, 20);
		getContentPane().add(inputSenha);

		inputPerfil = new JComboBox();
		inputPerfil.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Gerência", "Atendimento", "Suporte"}));
		inputPerfil.setBounds(82, 196, 110, 22);
		getContentPane().add(inputPerfil);

		btnCreate = new JButton("");
		btnCreate.setIcon(new ImageIcon(Funcionarios.class.getResource("/img/create.png")));
		btnCreate.setBounds(265, 301, 68, 59);
		getContentPane().add(btnCreate);
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adicionarFuncionario();
				
			}
		});
		

		btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(Funcionarios.class.getResource("/img/update.png")));
		btnUpdate.setBounds(343, 301, 68, 59);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(Funcionarios.class.getResource("/img/delete.png")));
		btnDelete.setBounds(421, 301, 68, 59);
		getContentPane().add(btnDelete);
		setForeground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 520, 410));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Funcionarios.class.getResource("/img/logo.png")));
		setTitle("Funcionarios");
	}

	DAO dao = new DAO();
	private JComboBox inputPerfil;
	public JButton btnCreate;
	public JButton btnUpdate;
	public JButton btnDelete;

	private void adicionarFuncionario() {
		String create = "insert into funcionario (nomeFunc, login, senha, Perfil, email) values (?, ?, md5(?),?, ?);";

		try {
			
			// Estabelecer a conexão
			Connection conexaoBanco = dao.conectar();

			// Preparar a execusão do script SQL
			PreparedStatement executarSQL = conexaoBanco.prepareStatement(create);

			// Substituir os pontos de interrogação pelo conteúdo das caixas de texto
			// (inputs)
			executarSQL.setString(1, inputNome.getText());
			executarSQL.setString(2, inputLogin.getText());
			executarSQL.setString(3, inputSenha.getText());

			executarSQL.setString(4, inputPerfil.getSelectedItem().toString());

			executarSQL.setString(5, inputEmail.getText());
			
			executarSQL.executeUpdate();

		}

		catch (SQLIntegrityConstraintViolationException error) {
			JOptionPane.showMessageDialog(null, "Login em uso. \nEscolha outro nome de usuário.");

		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionarios dialog = new Funcionarios();
					dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

	}
}
