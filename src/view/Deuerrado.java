package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.SwingConstants;

public class Deuerrado extends JDialog {
	public Deuerrado() {
		
		JLabel lblNewLabel = new JLabel("ERRO cabaço");
		setBounds(new Rectangle(0, 0, 510, 356));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						 Deuerrado dialog = new Deuerrado();
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
