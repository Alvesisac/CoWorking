package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import model.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Funcionarios extends JDialog {
	private JTextField inputLogin;
	private JTextField inputEmail;
	private JTextField inputNome;
	private JPasswordField inputSenha;

	public Funcionarios() {
		setTitle("Funcionarios");
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		JLabel nomeFunc = new JLabel("Nome:");
		nomeFunc.setHorizontalAlignment(SwingConstants.CENTER);
		nomeFunc.setBounds(44, 60, 53, 20);
		getContentPane().add(nomeFunc);

		JLabel emailFunc = new JLabel("Email:");
		emailFunc.setHorizontalAlignment(SwingConstants.CENTER);
		emailFunc.setBounds(330, 260, 40, 14);
		getContentPane().add(emailFunc);

		JLabel loginFunc = new JLabel("Login:");
		loginFunc.setHorizontalAlignment(SwingConstants.CENTER);
		loginFunc.setBounds(44, 218, 53, 21);
		getContentPane().add(loginFunc);

		JLabel perfilFunc = new JLabel("Perfil:");
		perfilFunc.setHorizontalAlignment(SwingConstants.CENTER);
		perfilFunc.setBounds(44, 257, 53, 20);
		getContentPane().add(perfilFunc);

		JLabel senhaFunc = new JLabel("Senha:");
		senhaFunc.setHorizontalAlignment(SwingConstants.CENTER);
		senhaFunc.setBounds(330, 218, 40, 14);
		getContentPane().add(senhaFunc);

		inputLogin = new JTextField();
		inputLogin.setHorizontalAlignment(SwingConstants.CENTER);
		inputLogin.setBounds(94, 218, 179, 20);
		getContentPane().add(inputLogin);
		inputLogin.setColumns(10);

		inputEmail = new JTextField();
		inputEmail.setHorizontalAlignment(SwingConstants.CENTER);
		inputEmail.setBounds(380, 257, 164, 20);
		getContentPane().add(inputEmail);
		inputEmail.setColumns(10);

		inputNome = new JTextField();
		inputNome.setBounds(107, 60, 379, 20);
		getContentPane().add(inputNome);
		inputNome.setColumns(10);
		
		inputNome.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				buscarFuncionariosNaTabela();
			}
			
		});

		inputSenha = new JPasswordField();
		inputSenha.setHorizontalAlignment(SwingConstants.CENTER);
		inputSenha.setBounds(380, 215, 164, 20);
		getContentPane().add(inputSenha);

		inputPerfil = new JComboBox();
		inputPerfil.setModel(new DefaultComboBoxModel(new String[] {"", "Administrador", "Gerência", "Atendimento", "Suporte"}));
		inputPerfil.setBounds(94, 256, 179, 22);
		getContentPane().add(inputPerfil);

		btnCreate = new JButton("");
		btnCreate.setBackground(new Color(192, 192, 192));
		btnCreate.setBorder(null);
		btnCreate.setIcon(new ImageIcon(Funcionarios.class.getResource("/img/create.png")));
		btnCreate.setBounds(343, 301, 68, 59);
		getContentPane().add(btnCreate);
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adicionarFuncionario();
				
			}
		});
		

		btnUpdate = new JButton("");
		btnUpdate.setBackground(new Color(192, 192, 192));
		btnUpdate.setBorder(null);
		btnUpdate.setIcon(new ImageIcon(Funcionarios.class.getResource("/img/update.png")));
		btnUpdate.setBounds(408, 301, 68, 59);
		getContentPane().add(btnUpdate);
	

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateFuncionario();
				
				
				// Validação do login do usuário
				if (inputLogin.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Login do usuário obrigatório!");
					inputLogin.requestFocus();
				}

				// Validação da senha do usuário
				else if (inputSenha.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Senha do usuário obrigatória!");
					inputSenha.requestFocus();
				}

				
			}
		});
		

		btnDelete = new JButton("");
		btnDelete.setBackground(new Color(192, 192, 192));
		btnDelete.setBorder(null);
		btnDelete.setIcon(new ImageIcon(Funcionarios.class.getResource("/img/delete.png")));
		btnDelete.setBounds(476, 301, 68, 59);
		getContentPane().add(btnDelete);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deletarFuncionario();
				
			}
		});
				
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 77, 379, 59);
		getContentPane().add(scrollPane);
		
		tblFuncionarios = new JTable();
		scrollPane.setColumnHeaderView(tblFuncionarios);
		
		JButton btnPesquisar = new JButton("\t");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setBackground(new Color(192, 192, 192));
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setBorder(null);
		btnPesquisar.setIcon(new ImageIcon(Funcionarios.class.getResource("/img/search.png")));
		btnPesquisar.setBounds(277, 166, 40, 20);
		getContentPane().add(btnPesquisar);
		
		btnPesquisar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				Pesquisar();
				
			}
		});
			
		
		inputID = new JTextField();
		inputID.setEnabled(false);
		inputID.setBounds(533, 60, 34, 20);
		getContentPane().add(inputID);
		inputID.setColumns(10);
		
		JLabel idFunc = new JLabel("ID:");
		idFunc.setBounds(513, 60, 22, 17);
		getContentPane().add(idFunc);
		setForeground(new Color(255, 255, 255));
		setBounds(new Rectangle(100, 100, 650, 410));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Funcionarios.class.getResource("/img/logo.png")));
		setTitle("Funcionarios");
		tblFuncionarios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		Pesquisar();

			}
			});
		
		tblFuncionarios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setarCaixasTexto();
			}
		});
			
	} //Fim do construtor

	DAO dao = new DAO();
	private JComboBox inputPerfil;
	public JButton btnCreate;
	public JButton btnUpdate;
	public JButton btnDelete;
	private JTable tblFuncionarios;
	private JTextField inputID;

	private void adicionarFuncionario() {
		String create = "insert into funcionario (nomeFunc, login, senha, Perfil, email) values (?, ?, md5(?),?, ?);";

		if (inputNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nome do usuário obrigatório!");
			inputLogin.requestFocus();
		}
		
		else if (inputLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Login do usuário obrigatório!");
			inputLogin.requestFocus();
		}
		
		else if (inputSenha.getPassword().length ==0) {
			JOptionPane.showMessageDialog(null, "Senha do usuário obrigatório!");
			inputSenha.requestFocus();
		}
		
		else if (inputEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Email do usuário obrigatório!");
			inputEmail.requestFocus();
		}
		
		else {
		
		
		
		
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
			
			JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
			
			
			// Validação do login do usuário
			if (inputLogin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Login do usuário obrigatório!");
				inputLogin.requestFocus();
			}

			// Validação da senha do usuário
			else if (inputSenha.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, "Senha do usuário obrigatória!");
				inputSenha.requestFocus();
			}

			limparCampos();
			conexaoBanco.close();

		}

		catch (SQLIntegrityConstraintViolationException error) {
			JOptionPane.showMessageDialog(null, "Login em uso. \nEscolha outro nome de usuário.");
			limparCampos();

		}

		catch (Exception e) {
			System.out.println(e);
		}	
		
		}
		
	}
	
	private void updateFuncionario() {
		String update = "update funcionario set nomeFunc = ?, login = ?, senha = md5(?), perfil = ?, email = ? where idFuncionario = ?";
		
		if (inputNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nome do usuário obrigatório!");
			inputNome.requestFocus();
		}
		
		else if (inputLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Login do usuário obrigatório!");
			inputLogin.requestFocus();
		}
		
		else if (inputSenha.getPassword().length ==0) {
			JOptionPane.showMessageDialog(null, "Senha do usuário obrigatório!");
			inputSenha.requestFocus();
		}
		
		else if (inputEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Email do usuário obrigatório!");
			inputEmail.requestFocus();
		}
		
		else {
		
		try {
			Connection conexaoBanco = dao.conectar();
			
			PreparedStatement executarSQL = conexaoBanco.prepareStatement(update);
			
			executarSQL.setString(1, inputNome.getText());
			executarSQL.setString(2, inputLogin.getText());
			executarSQL.setString(3, inputSenha.getText()); 
			executarSQL.setString(4, inputPerfil.getSelectedItem().toString());
			executarSQL.setString(5, inputEmail.getText());
			executarSQL.setString(6, inputID.getText());
			
			executarSQL.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso.");
			
			limparCampos();
			
			conexaoBanco.close();
		}
		
		catch (Exception e) {
			System.out.print(e);
	
		}
		
		}
	}
	
	
	private void deletarFuncionario() {
		String delete = "delete from funcionario where idFuncionario = ?;";
		
		try {
			Connection conexaoBanco = dao.conectar();
			
			PreparedStatement executarSQL = conexaoBanco.prepareStatement(delete);
			
			executarSQL.setString(1, inputID.getText());
			
			executarSQL.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso.");
			
			limparCampos();
			
			
			conexaoBanco.close();
		}
		
		catch (Exception e) {
			System.out.print(e);
	
		}
	}

	
	
	private void buscarFuncionariosNaTabela() {
	String readTabela = "select idFuncionario as ID, nomeFunc as Nome, email as Email from funcionario where nomeFunc like ?;";
	
	try {
		//Estabelecer a conexão
		Connection conexaoBanco = dao.conectar();
		
		//Preparar a execução dos comandos SQL
		PreparedStatement executarSQL = conexaoBanco.prepareStatement(readTabela);
		
		//Substituir o ? pelo conteúdo da caixa de texto
		executarSQL.setString(1, inputNome.getText() + "%");
		
		//Executar o comando SQL
		
		ResultSet resultadoExecucao = executarSQL.executeQuery();
		
		//Exibir o resultado na tabela, utilização da biblioteca rs2xml para "popular"
		//tabela
		tblFuncionarios.setModel(DbUtils.resultSetToTableModel(resultadoExecucao));
		
		conexaoBanco.close();
	}
	
	
	catch (Exception e) {
		System.out.println(e);
	}	
	
	
	
	}
	
	private void setarCaixasTexto(){
		//Criar uma variavel para receber a linha da tabela
		int setarLinha = tblFuncionarios.getSelectedRow();
		
		inputNome.setText(tblFuncionarios.getModel().getValueAt(setarLinha, 1).toString());
		//inputEmail.setText(tblFuncionarios.getModel().getValueAt(setarLinha, 2).toString());
		inputID.setText(tblFuncionarios.getModel().getValueAt(setarLinha, 0).toString());
	}

	private void Pesquisar() {
		
		String readBtn = "select * from funcionario where idFuncionario = ?;";
		
		try {
			
			Connection conexaoBanco = dao.conectar();
			
			//Preparar execução do comando MySQL
			PreparedStatement executarSQL = conexaoBanco.prepareStatement(readBtn);
			
			//Substituir o ponto de interrogação pelo conteúdo da caixa de texto (nome)
			executarSQL.setString(1, inputID.getText());
			
			ResultSet resultadoExecucao = executarSQL.executeQuery();
			
			if(resultadoExecucao.next()){
				//preencher os campos do formulario
				int setarLinha = tblFuncionarios.getSelectedRow();
			
				inputLogin.setText(resultadoExecucao.getString(3));
				inputSenha.setText(resultadoExecucao.getString(4));
				inputPerfil.setSelectedItem(resultadoExecucao.getString(5));
				inputEmail.setText(resultadoExecucao.getString(6));
				//Propositalmente a professora dee vocês não colocou o e-mail
				

			}
		}
		
		catch (Exception e) {
			System.out.println(e);
		}	
		
	}
	
	
	
	private void limparCampos() {

		inputLogin.setText(null);
		inputSenha.setText(null);
		inputEmail.setText(null);
		inputNome.setText(null);
		// Para limpar componente JComboBox
		inputPerfil.setSelectedIndex(-1);
		// Posicionar o cursor de volta no campo Nome
		inputNome.requestFocus();
		

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
