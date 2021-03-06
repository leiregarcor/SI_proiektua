package view;

import model.SesioKudeatzaile;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class PartidaJarraituBista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton baiBotoia;
	private JRadioButton ezBotoia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PartidaJarraituBista dialog = new PartidaJarraituBista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PartidaJarraituBista() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		setLocationRelativeTo(null);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblJolastenJarraituNahi = new JLabel("Jolasten jarraitu nahi duzu?");
			lblJolastenJarraituNahi.setBounds(65, 10, 304, 31);
			lblJolastenJarraituNahi.setFont(new Font("Tahoma", Font.PLAIN, 25));
			contentPanel.add(lblJolastenJarraituNahi);
		}
		{
			JButton okButton = new JButton("OK");
			okButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
			okButton.setBounds(166, 207, 75, 31);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			okButton.addActionListener(e -> {
				if(baiBotoia.isSelected()){
					SesioKudeatzaile.getInstance().partidaBukatu();
					setVisible(false);
				}
				else {
					if(ezBotoia.isSelected()){
						System.exit(0);
					}
				}
			});
			getRootPane().setDefaultButton(okButton);
		}
		
		baiBotoia = new JRadioButton("Bai");
		buttonGroup.add(baiBotoia);
		baiBotoia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		baiBotoia.setBounds(105, 106, 75, 31);
		contentPanel.add(baiBotoia);
		
		ezBotoia = new JRadioButton("Ez");
		buttonGroup.add(ezBotoia);
		ezBotoia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ezBotoia.setBounds(266, 106, 66, 31);
		contentPanel.add(ezBotoia);
	}
}
