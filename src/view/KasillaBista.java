package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Kasila;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;


public class KasillaBista  extends JPanel{
	//Poner labels como atributos y setters y getters para usarlo desde mousepressed
	private JLabel balioa;
	private JLabel hautagaiak;
	private int Koadrante;
    private int err;
    private int zut;

    
	public KasillaBista(int k, int pErr, int pZut) {
		super();
		initialize();
		Koadrante=k;
		err=pErr;
		zut= pZut;
	}
	
	private void initialize() {
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		GridBagLayout panel = new GridBagLayout();
		panel.columnWidths = new int[] {0};
		panel.rowHeights = new int[] {0, 0};
		panel.columnWeights = new double[]{1.0};
		panel.rowWeights = new double[]{Double.MIN_VALUE,0.0};
		this.setLayout(panel);
		
		hautagaiak = new JLabel();
		hautagaiak.setForeground(Color.RED);
		GridBagConstraints gbc_hautagaiak = new GridBagConstraints();
		gbc_hautagaiak.insets = new Insets(0, 0, 5, 0);
		gbc_hautagaiak.weighty = 0.1;
		gbc_hautagaiak.gridx = 0;
		gbc_hautagaiak.gridy = 0;
		this.add(hautagaiak, gbc_hautagaiak);
		
		balioa = new JLabel();
		balioa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_balioa = new GridBagConstraints();
		gbc_balioa.weighty = 0.5;
		gbc_balioa.gridx = 0;
		gbc_balioa.gridy = 1;
		add(balioa, gbc_balioa);
		
	}
	
	public void aukeratu() {
		setBorder(BorderFactory.createLineBorder(Color.black, 3));
	}
	
	public void desaukeratu() {
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
	}
	
	public String getHautagaiak() {
		return hautagaiak.getText();
	}
	
	public int getBalioa() {
		if(balioa.getText()=="") {
			return 0;
		}
		else{
			return  Integer.parseInt(balioa.getText());
		}
	}
	
	public void setHautagaiak(String s) {
		if(s==null) {
			hautagaiak.setText(null);
		}
		else {
			hautagaiak.setText(s);
		}
	}
	
	public void setBalioa(int i) {
		String s= String.valueOf(i);
		if (i==0) {
			balioa.setText(" ");
		}
		else {
			balioa.setText(s);
		}
	}
	
	public int getKoadrante() {
		return Koadrante;
	}
	
	public int getErr() {
		return err;
	}
	
	public int getZut() {
		return zut;
	}
	
    
}
