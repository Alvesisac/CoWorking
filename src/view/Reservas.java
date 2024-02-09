package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Reservas extends JDialog {
	public Reservas() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setTitle("Reservas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reservas.class.getResource("/img/logo.png")));
		setBounds(new Rectangle(0, 0, 520, 410));
		setBackground(new Color(192, 192, 192));
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservas dialog = new Reservas ();
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
