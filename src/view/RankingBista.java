package view;

import model.Erabiltzaile;
import model.RankingKud;
import model.SesioKudeatzaile;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class RankingBista extends JFrame {

	private JPanel contentPane;
	private JTextPane textPane;

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

		setLocationRelativeTo(null);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textPane = new JTextPane();
		ordenatuLehen10();
		contentPane.add(textPane, BorderLayout.CENTER);
		
		JPanel goikoPanela = new JPanel();
		contentPane.add(goikoPanela, BorderLayout.NORTH);
		goikoPanela.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton lehen10 = new JButton("Lehen 10");
		lehen10.addActionListener(e -> {
			ordenatuLehen10();
		});
		goikoPanela.add(lehen10);
		
		JButton mailaka = new JButton("Mailaka");
		mailaka.addActionListener(e -> {
			ArrayList<Erabiltzaile> lista = RankingKud.getNireRankingKud().rankingOrdenatuLvl();
			String ema= "";
			String unekoa = " ";
			for (int i=0; i<lista.size();i++){
				unekoa= (i+1) + " " + lista.get(i).getIzena() + " " + lista.get(i).getPuntuazioa() + " " + lista.get(i).getLvl()+"\r\n";
				ema= ema+unekoa;
			}
			textPane.setText(ema);
		});

		goikoPanela.add(mailaka);
		
		JButton mailaMax = new JButton("Maila max");
		mailaMax.addActionListener(e -> {
			Map<Integer, Erabiltzaile> lista = RankingKud.getNireRankingKud().rankingOrdenatuMaxLvl();
			AtomicReference<String> ema= new AtomicReference<>("");
			String unekoa = " ";
			lista.forEach((key,value)-> ema.set(ema.get() + value.getIzena() + " " + value.getPuntuazioa() + " " + value.getLvl() + "\r\n"));
			textPane.setText(ema.get());
		});
		goikoPanela.add(mailaMax);
		
		JPanel behekoPanela = new JPanel();
		contentPane.add(behekoPanela, BorderLayout.SOUTH);
		behekoPanela.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel = new JPanel();
		behekoPanela.add(panel);
		
		JPanel panel_1 = new JPanel();
		behekoPanela.add(panel_1);
		
		JButton exitBotoia = new JButton("Exit");
		exitBotoia.addActionListener(e -> {
			if(SesioKudeatzaile.getInstance().getLvl()==3){
				System.exit(0);
			}
			else {
				setVisible(false);
				PartidaJarraituBista.main(null);
			}
		});
		behekoPanela.add(exitBotoia);
	}
	public void ordenatuLehen10(){
		ArrayList<Erabiltzaile> lista = RankingKud.getNireRankingKud().rankingOrdenatu10();
		boolean hamar=false;
		int i=0;
		String ema= "";
		String unekoa = " ";
		while (!hamar && i<lista.size()){
			unekoa= (i+1) + " " + lista.get(i).getIzena() + " " + lista.get(i).getPuntuazioa() + " " + lista.get(i).getLvl()+"\r\n";
			ema= ema+unekoa;
			i++;
			if(i==10){
				hamar=true;
			}
		}
		textPane.setText(ema);
	}
}
