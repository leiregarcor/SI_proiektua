package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class SudokuBista extends JFrame implements Observer {

	private JPanel contentPane;
	private JPanel panelGridLayout;
	private JTextField label_textF;
	private JTextField tField_textF;
	private JPanel unekoJPanel;
	//private JPanel gbl_panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuBista frame = new SudokuBista();
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
	public SudokuBista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 664);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelGridLayout(), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		//panel_2.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{129, 0};
		gbl_panel_4.rowHeights = new int[]{34, 34, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel = new JLabel("Hautagaiak");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);
		
		label_textF = new JTextField();
		GridBagConstraints gbc_label_textF = new GridBagConstraints();
		//gbc_label_textF.fill = GridBagConstraints.BOTH;
		gbc_label_textF.gridx = 0;
		gbc_label_textF.gridy = 1;
		panel_4.add(label_textF, gbc_label_textF);
		label_textF.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{129, 0};
		gbl_panel_5.rowHeights = new int[]{34, 34, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Balioa");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_5.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tField_textF = new JTextField();
		GridBagConstraints gbc_tField_textF = new GridBagConstraints();
		//gbc_tField_textF.fill = GridBagConstraints.BOTH;
		gbc_tField_textF.gridx = 0;
		gbc_tField_textF.gridy = 1;
		panel_5.add(tField_textF, gbc_tField_textF);
		tField_textF.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnOK = new JButton("Ok");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean a = true;
				if(a) {

					JTextField aJTextField = (JTextField) unekoJPanel.getComponent(1); // JTextField
					
					//tField_textF.setText(aJTextField.getText());
					
					//label.setText(label_textF.getText());
					//textField.setText(tField_textF.getText());
					
					
				}
				else {
					Component controllingFrame = null;
					JOptionPane.showMessageDialog(controllingFrame ,
			                "Sartu duzun Labela okerra da. Saiatu berriro",
			                "Errore mezua",
			                JOptionPane.ERROR_MESSAGE);
					label_textF.setText(null);
					tField_textF.setText(null);	
					label_textF.requestFocus();
					
				}
			}
		});
		btnOK.setBounds(10, 11, 103, 21);
		btnOK.setHorizontalAlignment(SwingConstants.CENTER);
		btnOK.setVerticalAlignment(SwingConstants.CENTER);
		panel_6.add(btnOK);
		
		JButton btnLaguntza = new JButton("Laguntza");
		btnLaguntza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLaguntza.setVerticalAlignment(SwingConstants.CENTER);
		btnLaguntza.setHorizontalAlignment(SwingConstants.CENTER);
		btnLaguntza.setBounds(10, 36, 103, 21);
		panel_6.add(btnLaguntza);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(34, 144, 66, 23);
		btnExit.setHorizontalAlignment(SwingConstants.CENTER);
		btnExit.setVerticalAlignment(SwingConstants.CENTER);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_3.setLayout(null);
		panel_3.add(btnExit);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 11, 109, 110);
		panel_3.add(textPane);
		setLocationRelativeTo(null) ;
	}

	private JPanel getPanelGridLayout() {
		if (panelGridLayout == null) {
			panelGridLayout = new JPanel();
			panelGridLayout.setBorder(BorderFactory.createLineBorder(Color.black, 2));
			panelGridLayout.setLayout(new GridLayout(3, 3, 0, 0));
			//gridLayoutPane.add(getGbl_panel());
			this.koadranteMatrizeaSortu();
			
		}
		return panelGridLayout;
	}
	
	
	private void koadranteMatrizeaSortu() {
		for(int l=0;l<3;l++) {
			for(int z=0;z<3;z++) {
				panelGridLayout.add(getKoadrante_panel());
			}
		}
	}

	private JPanel getKoadrante_panel() {
			JPanel koadrantePanel = new JPanel();
			koadrantePanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
			koadrantePanel.setLayout(new GridLayout(3, 3, 0, 0));
			for(int l=0;l<3;l++) {
				for(int z=0;z<3;z++) {
					koadrantePanel.add(getKasillaBista());
				}
			}
			return koadrantePanel;
	}
	
	private KasillaBista getKasillaBista() {
		KasillaBista kasila= new KasillaBista();
		return kasila;
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
