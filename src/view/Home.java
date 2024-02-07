package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JDialog {
	public Home() {
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBounds(new Rectangle(0, 0, 520, 410));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/img/logo.png")));
		setResizable(false);
		setTitle("Home");
		getContentPane().setLayout(null);
		
		JButton btnRoom = new JButton("");
		btnRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRoom.setBorderPainted(false);
		btnRoom.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRoom.setIcon(new ImageIcon(Home.class.getResource("/img/room.png")));
		btnRoom.setBounds(194, 123, 123, 99);
		getContentPane().add(btnRoom);
		
		JButton bntReserve = new JButton("");
		bntReserve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntReserve.setBorderPainted(false);
		bntReserve.setHorizontalTextPosition(SwingConstants.CENTER);
		bntReserve.setIcon(new ImageIcon(Home.class.getResource("/img/reserve.png")));
		bntReserve.setBounds(349, 123, 129, 100);
		getContentPane().add(bntReserve);
		
		JButton bntUser = new JButton("");
		bntUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntUser.setBorderPainted(false);
		bntUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bntUser.setIcon(new ImageIcon(Home.class.getResource("/img/user.png")));
		bntUser.setBounds(35, 123, 123, 99);
		getContentPane().add(bntUser);
	}

	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Home dialog = new Home();
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


