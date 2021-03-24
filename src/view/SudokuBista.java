package view;

import java.awt.BorderLayout;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class SudokuBista extends JFrame {

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
		setBounds(100, 100, 450, 300);
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
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("Label");
		panel_4.add(lblNewLabel);
		
		label_textF = new JTextField();
		panel_4.add(label_textF);
		label_textF.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("TField");
		panel_5.add(lblNewLabel_1);
		
		tField_textF = new JTextField();
		panel_5.add(tField_textF);
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
		btnOK.setBounds(51, 3, 68, 21);
		btnOK.setHorizontalAlignment(SwingConstants.CENTER);
		btnOK.setVerticalAlignment(SwingConstants.CENTER);
		panel_6.add(btnOK);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(53, 30, 66, 23);
		btnExit.setHorizontalAlignment(SwingConstants.CENTER);
		btnExit.setVerticalAlignment(SwingConstants.CENTER);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_3.setLayout(null);
		panel_3.add(btnExit);
		setLocationRelativeTo(null) ;
	}

	private JPanel getPanelGridLayout() {
		if (panelGridLayout == null) {
			panelGridLayout = new JPanel();
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
			koadrantePanel.setLayout(new GridLayout(3, 3, 0, 0));
			for(int l=0;l<3;l++) {
				for(int z=0;z<3;z++) {
					koadrantePanel.add(getGbl_panel(l, z));
				}
			}
			return koadrantePanel;
	}
	
	private JPanel getGbl_panel(int pL, int pZ) {

		 //JLabel lblNewLabel;
		// JTextField textField;
		
		//if (gbl_panel == null) {
			JPanel gbl_panel = new JPanel();
			GridBagLayout gbl_gbl_panel = new GridBagLayout();
			gbl_gbl_panel.columnWidths = new int[] {0};
			gbl_gbl_panel.rowHeights = new int[] {0, 0, 0};
			gbl_gbl_panel.columnWeights = new double[]{1.0};
			gbl_gbl_panel.rowWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0};
			gbl_panel.setLayout(gbl_gbl_panel);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.weighty = 0.33;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			gbl_panel.add(getLblNewLabel(), gbc_lblNewLabel);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.gridheight = 2;
			gbc_textField.gridwidth = 1;
			gbc_textField.weightx = 0.76;
			gbc_textField.weighty = 0.75;
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.gridx = 0;
			gbc_textField.gridy = 1;
			gbc_textField.fill = GridBagConstraints.BOTH;
			gbl_panel.add(getTextField(), gbc_textField);
			gbl_panel.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					unekoJPanel =  gbl_panel;
					//unekoJPanel.setBorder(new LineBorder(Color.blue,2));
					
					//JLabel aJLabel = (JLabel) gbl_panel.getComponent(0); //label
					
					JLabel aJLabel = (JLabel) unekoJPanel.getComponent(0); //label EZ DU FUNTZIONATZEN
					
					
					label_textF.setText(aJLabel.getText()); //label textField-ean agertuko da aukeratutako GridBagLayout-eko label-aren balioa
					aJLabel.setText("a"); //  aukeratutako GridBagLayout-eko label-aren balioa "a" izatera aldatu
					
					JTextField aJTextField = (JTextField) gbl_panel.getComponent(1); // JTextField
					
					tField_textF.setText(aJTextField.getText());
					aJTextField.setText("holi");
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					/**JLabel aJLabel = (JLabel) gbl_panel.getComponent(0); //label
					aJLabel.setText("a");*/
					
				}
			});
//		}
		return gbl_panel;
	}

	
	private JLabel getLblNewLabel() {
		JLabel label = new JLabel();		
		return	label ;		
	}
	
	private JTextField getTextField() {
		JTextField textField = new JTextField();
		textField.setColumns(10);		
		return textField;
	}
}
