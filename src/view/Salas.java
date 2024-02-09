package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Rectangle;

public class Salas extends JDialog {
	public Salas() {
		setBounds(new Rectangle(0, 0, 520, 410));
		setBackground(new Color(240, 240, 240));
		setTitle("Salas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Salas.class.getResource("/img/logo.png")));
		getContentPane().setBackground(new Color(192, 192, 192));
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salas dialog = new Salas ();
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
