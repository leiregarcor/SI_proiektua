package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;


public class KasillaBista  extends JPanel{
	//Poner labels como atributos y setters y getters para usarlo desde mousepressed
	public KasillaBista() {
		super();
		initialize();
	}
	
	private void initialize() {
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		GridBagLayout panel = new GridBagLayout();
		panel.columnWidths = new int[] {0};
		panel.rowHeights = new int[] {0, 0};
		panel.columnWeights = new double[]{1.0};
		panel.rowWeights = new double[]{Double.MIN_VALUE,0.0};
		this.setLayout(panel);
		GridBagConstraints gbc_hautagaiak = new GridBagConstraints();
		gbc_hautagaiak.insets = new Insets(0, 0, 5, 0);
		gbc_hautagaiak.weighty = 0.1;
		gbc_hautagaiak.gridx = 0;
		gbc_hautagaiak.gridy = 0;
		this.add(getLbl(), gbc_hautagaiak);
		
		JLabel balioa = new JLabel();
		GridBagConstraints gbc_balioa = new GridBagConstraints();
		gbc_balioa.weighty = 0.5;
		gbc_balioa.gridx = 0;
		gbc_balioa.gridy = 1;
		add(balioa, gbc_balioa);
		
	}
	
	private JLabel getLbl() {
		JLabel hautagaiak = new JLabel();		
		return	hautagaiak ;		
	}
	
	public void aukeratu() {
		setBorder(BorderFactory.createLineBorder(Color.black, 3));
	}
	
	public void desaukeratu() {
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
	}
	
	
	
	
	
	
	
}
