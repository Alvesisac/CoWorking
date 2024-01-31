package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Sobre extends JDialog {
	
	public Sobre() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/logo.png")));
		getContentPane().setBackground(new Color(128, 128, 128));
		getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("Sobre o software");
		titulo.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 14));
		titulo.setBounds(0, 24, 623, 43);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(titulo);
		
		JLabel descricao1 = new JLabel("O software CoWorking trata-se de um protótipo cujo objetivo é");
		descricao1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		descricao1.setHorizontalAlignment(SwingConstants.CENTER);
		descricao1.setBounds(10, 80, 623, 43);
		getContentPane().add(descricao1);
		
		JLabel descricao2 = new JLabel(" possibilitar o gerenciamento de reserva de salas em um espaço colaborativo.");
		descricao2.setHorizontalAlignment(SwingConstants.CENTER);
		descricao2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		descricao2.setBounds(0, 114, 623, 43);
		getContentPane().add(descricao2);
		
		JLabel versao = new JLabel("Versão 1.0.0\r\n\r\n");
		versao.setHorizontalAlignment(SwingConstants.CENTER);
		versao.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
		versao.setBounds(0, 190, 623, 32);
		getContentPane().add(versao);
		
		JLabel atualizacao = new JLabel("Última atualização: 31/01/2024");
		atualizacao.setHorizontalAlignment(SwingConstants.CENTER);
		atualizacao.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		atualizacao.setBounds(0, 225, 623, 32);
		getContentPane().add(atualizacao);
		
		JLabel imgMIT = new JLabel("");
		imgMIT.setIcon(new ImageIcon(Sobre.class.getResource("/img/mitLicense.png")));
		imgMIT.setHorizontalAlignment(SwingConstants.CENTER);
		imgMIT.setBounds(504, 242, 80, 92);
		getContentPane().add(imgMIT);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
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
