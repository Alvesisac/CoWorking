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

public class Salas extends JDialog {
	private JTextField inputOcup;

	public Salas() {
		setTitle("Salas");
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		JLabel tipoSala = new JLabel("Categoria:");
		tipoSala.setHorizontalAlignment(SwingConstants.CENTER);
		tipoSala.setBounds(44, 60, 84, 20);
		getContentPane().add(tipoSala);

		JLabel ocupSala = new JLabel("Ocupação Máxima:\t\r\n");
		ocupSala.setHorizontalAlignment(SwingConstants.CENTER);
		ocupSala.setBounds(303, 248, 111, 14);
		getContentPane().add(ocupSala);

		JLabel codSala = new JLabel("Codígo:");
		codSala.setHorizontalAlignment(SwingConstants.CENTER);
		codSala.setBounds(44, 233, 53, 21);
		getContentPane().add(codSala);

		JLabel numSala = new JLabel("Número:\r\n");
		numSala.setHorizontalAlignment(SwingConstants.CENTER);
		numSala.setBounds(44, 269, 53, 20);
		getContentPane().add(numSala);

		JLabel andarSala = new JLabel("Andar:");
		andarSala.setHorizontalAlignment(SwingConstants.CENTER);
		andarSala.setBounds(360, 212, 40, 14);
		getContentPane().add(andarSala);

		inputOcup = new JTextField();
		inputOcup.setHorizontalAlignment(SwingConstants.CENTER);
		inputOcup.setBounds(417, 245, 151, 20);
		getContentPane().add(inputOcup);
		inputOcup.setColumns(10);

		btnCreate = new JButton("");
		btnCreate.setBackground(new Color(192, 192, 192));
		btnCreate.setBorder(null);
		btnCreate.setIcon(new ImageIcon(Salas.class.getResource("/img/create.png")));
		btnCreate.setBounds(346, 316, 68, 59);
		getContentPane().add(btnCreate);
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//adicionarFuncionario();
				
			}
		});
		

		btnUpdate = new JButton("");
		btnUpdate.setBackground(new Color(192, 192, 192));
		btnUpdate.setBorder(null);
		btnUpdate.setIcon(new ImageIcon(Salas.class.getResource("/img/update.png")));
		btnUpdate.setBounds(408, 316, 68, 59);
		getContentPane().add(btnUpdate);
	

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//updateFuncionario();
				
				
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
		btnDelete.setIcon(new ImageIcon(Salas.class.getResource("/img/delete.png")));
		btnDelete.setBounds(474, 316, 68, 59);
		getContentPane().add(btnDelete);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//deletarFuncionario();
				
			}
		});
				
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 91, 389, 59);
		getContentPane().add(scrollPane);
		
		tblSalas = new JTable();
		scrollPane.setColumnHeaderView(tblSalas);
		
		JButton btnPesquisar = new JButton("\t");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setBackground(new Color(192, 192, 192));
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setBorder(null);
		btnPesquisar.setIcon(new ImageIcon(Salas.class.getResource("/img/search.png")));
		btnPesquisar.setBounds(172, 191, 40, 20);
		getContentPane().add(btnPesquisar);
		
		btnPesquisar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			//	Pesquisar();
				
			}
		});
			
		
		inputID = new JTextField();
		inputID.setEnabled(false);
		inputID.setBounds(94, 187, 58, 29);
		getContentPane().add(inputID);
		inputID.setColumns(10);
		
		JLabel idFunc = new JLabel("ID:");
		idFunc.setHorizontalAlignment(SwingConstants.CENTER);
		idFunc.setBounds(57, 190, 40, 17);
		getContentPane().add(idFunc);
		
		inputCategoria = new JComboBox();
		inputCategoria.setModel(new DefaultComboBoxModel(new String[] {"", "Sala de Reunião\t", "Sala de Conferência\t", "Espaço de Eventos", "Escritório privado"}));
		inputCategoria.setBounds(117, 59, 157, 22);
		getContentPane().add(inputCategoria);
		
		JComboBox inputCod = new JComboBox();
		inputCod.setModel(new DefaultComboBoxModel(new String[] {"", "REU", "CONF", "EVENT", "PRIV"}));
		inputCod.setBounds(101, 229, 111, 29);
		getContentPane().add(inputCod);
		
		JComboBox inputAndar = new JComboBox();
		inputAndar.setModel(new DefaultComboBoxModel(new String[] {"", "Subsolo", "Térreo", "1ª andar", "2ª andar", "3ª andar\t"}));
		inputAndar.setBounds(416, 205, 152, 29);
		getContentPane().add(inputAndar);
		
		inputNum = new JTextField();
		inputNum.setBounds(101, 269, 111, 20);
		getContentPane().add(inputNum);
		inputNum.setColumns(10);
		setForeground(new Color(255, 255, 255));
		setBounds(new Rectangle(100, 100, 624, 437));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Salas.class.getResource("/img/logo.png")));
		setTitle("Salas");
		tblSalas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		//Pesquisar();

			}
			});
		
		tblSalas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//setarCaixasTexto();
			}
		});
			
	} //Fim do construtor

	DAO dao = new DAO();
	public JButton btnCreate;
	public JButton btnUpdate;
	public JButton btnDelete;
	private JTable tblSalas;
	private JTextField inputID;
	private JComboBox inputCategoria;
	private JTextField inputNum;

	/*private void adicionarFuncionario() {
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
		
		else if (inputOcup.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Email do usuário obrigatório!");
			inputOcup.requestFocus();
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

			executarSQL.setString(5, inputOcup.getText());
			
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
		
		else if (inputOcup.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Email do usuário obrigatório!");
			inputOcup.requestFocus();
		}
		
		else {
		
		try {
			Connection conexaoBanco = dao.conectar();
			
			PreparedStatement executarSQL = conexaoBanco.prepareStatement(update);
			
			executarSQL.setString(1, inputNome.getText());
			executarSQL.setString(2, inputLogin.getText());
			executarSQL.setString(3, inputSenha.getText()); 
			executarSQL.setString(4, inputPerfil.getSelectedItem().toString());
			executarSQL.setString(5, inputOcup.getText());
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
	
	private void setarCaixasTexto(){
		//Criar uma variavel para receber a linha da tabela
		int setarLinha = tblSalas.getSelectedRow();
		
		inputNome.setText(tblSalas.getModel().getValueAt(setarLinha, 1).toString());
		//inputEmail.setText(tblSalas.getModel().getValueAt(setarLinha, 2).toString());
		inputID.setText(tblSalas.getModel().getValueAt(setarLinha, 0).toString());
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
				int setarLinha = tblSalas.getSelectedRow();
			
				inputLogin.setText(resultadoExecucao.getString(3));
				inputSenha.setText(resultadoExecucao.getString(4));
				inputPerfil.setSelectedItem(resultadoExecucao.getString(5));
				inputOcup.setText(resultadoExecucao.getString(6));
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
		inputOcup.setText(null);
		inputNome.setText(null);
		// Para limpar componente JComboBox
		inputPerfil.setSelectedIndex(-1);
		// Posicionar o cursor de volta no campo Nome
		inputNome.requestFocus();
		

	}
	
	*/

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salas dialog = new Salas();
					dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

	}
}
