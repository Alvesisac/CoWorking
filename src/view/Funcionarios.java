package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.Color;

public class Funcionarios extends JDialog {
	public Funcionarios() {
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setForeground(new Color(255, 255, 255));
		setForeground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 520, 410));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Funcionarios.class.getResource("/img/logo.png")));
		setTitle("Funcionarios");
		getContentPane().setLayout(null);
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
