package view;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextPane;

public class SudokuBista extends JFrame implements Observer {

	private JPanel contentPane;
	private JPanel panelGridLayout;
	private JTextField HautagaiakText;
	private JTextField BalioaText;
	private KasillaBista unekoa;
	private KasillaBista[][] matrizea = new KasillaBista[9][9];
	private JTextPane txtpnEstrategia;
	private static long hasieraOrdua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				SudokuBista frame = new SudokuBista();
				frame.setVisible(true);
				SesioKudeatzaile.getInstance().tableroaKargatu();
				setHasieraOrdua();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	public static void setHasieraOrdua(){
		hasieraOrdua= System.nanoTime();
	}

	/**
	 * Create the frame.
	 */
	public SudokuBista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
		setTitle("Sudoku");
		Sudoku.getNireSudoku().addObserver(this);
	}

	private void initialize() {
		setBounds(100, 100, 800, 664);
		// setBounds(100, 100, 450, 300);
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
		// panel_2.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 129, 0 };
		gbl_panel_4.rowHeights = new int[] { 34, 34, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JLabel lblNewLabel = new JLabel("Hautagaiak");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);

		HautagaiakText = new JTextField();
		GridBagConstraints gbc_HautagaiakText = new GridBagConstraints();
		// gbc_label_textF.fill = GridBagConstraints.BOTH;
		gbc_HautagaiakText.gridx = 0;
		gbc_HautagaiakText.gridy = 1;
		panel_4.add(HautagaiakText, gbc_HautagaiakText);
		HautagaiakText.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 129, 0 };
		gbl_panel_5.rowHeights = new int[] { 34, 34, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		JLabel lblNewLabel_1 = new JLabel("Balioa");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_5.add(lblNewLabel_1, gbc_lblNewLabel_1);

		BalioaText = new JTextField();
		GridBagConstraints gbc_BalioaText = new GridBagConstraints();
		// gbc_tField_textF.fill = GridBagConstraints.BOTH;
		gbc_BalioaText.gridx = 0;
		gbc_BalioaText.gridy = 1;
		panel_5.add(BalioaText, gbc_BalioaText);
		BalioaText.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(null);

		JButton btnOK = new JButton("Ok");
		btnOK.addActionListener(e -> {
			if (unekoa == null) {
				JOptionPane.showMessageDialog(null, "Ez duzu kasilarik aukeratu. Aukeratu kasila bat.", "Adi!",
						JOptionPane.ERROR_MESSAGE);
				HautagaiakText.setText(" ");
				BalioaText.setText(" ");
			}
			try {// egokiena ereduari pasatu zer sartu den eta ereduak ikustea ea egokiak diren
					// balioak eta update-ak esango dio erabiltzaileari ea balioak egokiak diren
				int balio;
				if(BalioaText.getText().equals("")){
					balio=0;
				}
				else{
					balio = Integer.parseInt(BalioaText.getText());
				}
				if(balio < 0 || balio > 9){
					throw new NumberFormatException();
				}
				Boolean aldatuB=false;
				if(balio!=0){
					aldatuB=true;
				}
				Boolean[] haut = new Boolean[10];
				for(int i=0; i< haut.length;i++){ //false-ra hasieratzen ditugu true bistan dauden hautagaiak izango direlako
					haut[i]=false;
				}
				String s = HautagaiakText.getText();
				String[] arrayS = s.split(" ");
				int hautagaia=0;
				for (String x : arrayS) {
					// Begiratuko dugu exceptionen bat botatzen duen.
					hautagaia=Integer.parseInt(x);
					if(hautagaia<0 || hautagaia>9){
						throw new NumberFormatException();
					}
					haut[hautagaia]=true;
				}
				// Momentu honetan ez badu exceptionik eman badakigu erabiltzaileak dena ondo
				// sartu duela.
				// Balioak eguneratu
				Sudoku.getNireSudoku().kasilaEguneratu(unekoa.getErr(), unekoa.getZut(), balio, haut, aldatuB);
				Tablero t = Sudoku.getNireSudoku().getTablero();
				if (t.partidaBukatu()) {
					if (t.zuzenaDa()) {
						//Erabiltzaileak sudokua ondo egin badu, bere denbora gordeko dugu, horretarako lehenengo zenbat denbora behar izan duen kalkulatuko dugu
						long denboraTotala= System.nanoTime()-hasieraOrdua;
						SesioKudeatzaile.getInstance().setDenbora(denboraTotala);
						SesioKudeatzaile.getInstance().puntuazioaKalkulatu();
						//mezua
						JOptionPane.showMessageDialog(null, "Sudokua asmatu duzu! :) ", "Zorionak!",
								JOptionPane.PLAIN_MESSAGE);
						if(SesioKudeatzaile.getInstance().getLvl()==3){
							JOptionPane.showMessageDialog(null, "Sudokuak bukatu dituzu! :) ", "Bukaera panela",
									JOptionPane.PLAIN_MESSAGE);
							System.exit(0);
						}
						else{
							setVisible(false);
							SesioKudeatzaile.getInstance().partidaBukatu();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Sudokua gaizki dago :( ", "Adi!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}


			} catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Sartu duzun Balioa okerra da. Sartu zenbaki bat", "Errore mezua",
						JOptionPane.ERROR_MESSAGE);

				if (unekoa != null) {
					unekoa.desaukeratu();
				}
				unekoa = null;
				HautagaiakText.setText(" ");
				BalioaText.setText(" ");

			}

		});
		btnOK.setBounds(10, 11, 103, 21);
		btnOK.setHorizontalAlignment(SwingConstants.CENTER);
		btnOK.setVerticalAlignment(SwingConstants.CENTER);
		panel_6.add(btnOK);

		JButton btnLaguntza = new JButton("Laguntza");
		btnLaguntza.addActionListener(e -> {
			Sudoku.getNireSudoku().laguntzaKudeatu();
			Tablero t = Sudoku.getNireSudoku().getTablero();
			if (t.partidaBukatu()) {
				if (t.zuzenaDa()) {
					JOptionPane.showMessageDialog(null, "Sudokua asmatu duzu! :) ", "Zorionak!",
							JOptionPane.PLAIN_MESSAGE);
					if(SesioKudeatzaile.getInstance().getLvl()==3){
						JOptionPane.showMessageDialog(null, "Sudokuak bukatu dituzu! :) ", "Bukaera panela",
								JOptionPane.PLAIN_MESSAGE);
						System.exit(0);
					}
					else{
						setVisible(false);
						SesioKudeatzaile.getInstance().partidaBukatu();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Sudokua gaizki dago :( ", "Adi!",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
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
		btnExit.addActionListener(e -> System.exit(0));
		panel_3.setLayout(null);
		panel_3.add(btnExit);

		txtpnEstrategia = new JTextPane();
		txtpnEstrategia.setBounds(10, 11, 109, 110);
		panel_3.add(txtpnEstrategia);
		setLocationRelativeTo(null);

	}

	private JPanel getPanelGridLayout() {
		if (panelGridLayout == null) {
			panelGridLayout = new JPanel();
			panelGridLayout.setBorder(BorderFactory.createLineBorder(Color.black, 2));
			panelGridLayout.setLayout(new GridLayout(3, 3, 0, 0));
			// gridLayoutPane.add(getGbl_panel());
			this.koadranteMatrizeaSortu();
		}
		return panelGridLayout;
	}

	private void koadranteMatrizeaSortu() {
		int k = 0;
		for (int l = 0; l < 3; l++) {
			for (int z = 0; z < 3; z++) {
				panelGridLayout.add(getKoadrante_panel(k));
				k++;
			}
		}
	}

	private JPanel getKoadrante_panel(int koad) {
		JPanel koadrantePanel = new JPanel();
		koadrantePanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		koadrantePanel.setLayout(new GridLayout(3, 3, 0, 0));
		int kas = 0;
		for (int l = 0; l < 3; l++) {
			for (int z = 0; z < 3; z++) {
				KasillaBista k = kasilaSortu(koad, kas);
				k.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						if (unekoa != null) {
							unekoa.desaukeratu();
						}
						// JComponent p = (JComponent) e.getSource();
						k.aukeratu();
						unekoa = k;
						HautagaiakText.setText(k.getHautagaiak());
						if (k.getBalioa() == 0) {
							BalioaText.setText("");
						} else {
							BalioaText.setText(String.valueOf(k.getBalioa()));
						}
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
						/**
						 * JLabel aJLabel = (JLabel) gbl_panel.getComponent(0); //label
						 * aJLabel.setText("a");
						 */
					}
				});
				koadrantePanel.add(k);
				kas++;
			}
		}
		return koadrantePanel;
	}

	public KasillaBista kasilaSortu(int koad, int kas) {
		int zut = kas % 3;
		int err = kas / 3;
		int gehizut;
		int gehierr;
		int koadzut = koad % 3;
		int koaderr = koad / 3;
		if (koadzut == 0) {
			gehizut = 0;
		} else if (koadzut == 1) {
			gehizut = 3;
		} else {
			gehizut = 6;
		}

		if (koaderr == 0) {
			gehierr = 0;
		} else if (koaderr == 1) {
			gehierr = 3;
		} else {
			gehierr = 6;
		}
		KasillaBista k = new KasillaBista(koad, err + gehierr, zut + gehizut);
		matrizea[err + gehierr][zut + gehizut] = k;
		return k;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(arg==null){
			Sudoku s = Sudoku.getNireSudoku();
			// matrize osoa eguneratu
			for (int err = 0; err < matrizea.length; err++) {
				for (int zut = 0; zut < matrizea[0].length; zut++) {
					int i = s.getTablero().getMatrizea()[err][zut].getBista();
					if(s.getTablero().getMatrizea()[err][zut] instanceof KasilaAldakorra){
						KasilaAldakorra k= (KasilaAldakorra) s.getTablero().getMatrizea()[err][zut];
						String h= k.hautagaiakToString();
						matrizea[err][zut].setHautagaiak(h);
						matrizea[err][zut].setBalioaKargatu(i,false);
					}
					else {
						matrizea[err][zut].setBalioaKargatu(i,true);
					}
				}
			}
		}
		else {
			int[]mezu= (int[]) arg;
			if(mezu[0]==0){
				JOptionPane.showMessageDialog(null, "Laguntzak ez du soluziorik aurkitu.", "Errore mezua",
						JOptionPane.ERROR_MESSAGE);
			}
			else {
				String laguntza="";
				if(mezu[0]==1){
					laguntza="Sole";
				}
				if (mezu[0]==2){
					laguntza="Unique";
				}
				int balioa=mezu[1];
				int err=mezu[2];
				int zut=mezu[3];
				txtpnEstrategia.setText("Estrategia->"+laguntza+"\r\nKasila->("+err+","+zut+")\r\nBalioa->"+balioa);
			}
		}
	}
}
