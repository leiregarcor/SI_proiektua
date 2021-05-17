package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class RankingBista extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingBista frame = new RankingBista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RankingBista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane, BorderLayout.CENTER);
		
		JPanel goikoPanela = new JPanel();
		contentPane.add(goikoPanela, BorderLayout.NORTH);
		goikoPanela.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton lehen10 = new JButton("Lehen 10");
		goikoPanela.add(lehen10);
		
		JButton mailaka = new JButton("Mailaka");
		goikoPanela.add(mailaka);
		
		JButton mailaMax = new JButton("Maila max");
		goikoPanela.add(mailaMax);
		
		JPanel behekoPanela = new JPanel();
		contentPane.add(behekoPanela, BorderLayout.SOUTH);
		behekoPanela.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel = new JPanel();
		behekoPanela.add(panel);
		
		JPanel panel_1 = new JPanel();
		behekoPanela.add(panel_1);
		
		JButton exitBotoia = new JButton("Exit");
		behekoPanela.add(exitBotoia);
	}
}
