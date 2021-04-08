package view;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Sudoku;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HasieraPanela extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField levelField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HasieraPanela dialog = new HasieraPanela();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HasieraPanela() {
		setTitle("Hasiera Panela");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		setLocationRelativeTo(null) ;
		
		contentPanel.setBounds(0, 0, 434, 217);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);		
		contentPanel.setLayout(null);
		
		levelField = new JTextField();
		levelField.setBounds(165, 130, 147, 20);
		contentPanel.add(levelField);
		
		textField = new JTextField();
		textField.setBounds(165, 88, 147, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Izena");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(123, 91, 32, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Zailtasuna");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(96, 133, 59, 14);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 217, 434, 33);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String s = levelField.getText();
						if (s.equals("1")||s.equals("2") || s.equals("3")) {
							setVisible(false);
							//sudokua kargatu.
							SudokuBista.main(null);													 
						}
						else {
							Component controllingFrame = null;
							JOptionPane.showMessageDialog(controllingFrame,
					                "Zailtasun maila ez da egokia. Saiatu berriro",
					                "Errore mezua",
					                JOptionPane.ERROR_MESSAGE);
							levelField.setText(null);
							levelField.requestFocus();
						}
						
					}
				});
				okButton.setBounds(132, 5, 65, 23);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						levelField.setText(null);
						textField.setText(null);
					}
				});
				cancelButton.setBounds(228, 5, 84, 23);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
