package fr.metz.iut.louis.pedrazzani.TwitterMongo.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import fr.metz.iut.louis.pedrazzani.TwitterMongo.controlleur.TwitterControlleur;
import fr.metz.iut.louis.pedrazzani.TwitterMongo.listener.RechercheListener;

public class TwitterVue extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel labelInfoProfil;

	private TwitterControlleur controlleur;
	
	private JList<String> list;
	
	private JTextField jTextFieldTweet;
	
	private JTextField recherche;

	public TwitterVue(String title, TwitterControlleur controlleur) {
		super(title);

		this.controlleur = controlleur;

		UIManager.put("Synthetica.window.decoration", Boolean.FALSE);

		try {
			UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setLocationRelativeTo(null);
		Dimension dimensionApplication = new Dimension(750, 750);
		this.setSize(dimensionApplication);
		this.setPreferredSize(dimensionApplication);
		this.setResizable(true);

		this.setLayout(new GridBagLayout());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridBagConstraints gbc = new GridBagConstraints();

		labelInfoProfil = new JLabel(htmlAvatar());

		this.labelInfoProfil.setHorizontalAlignment(JLabel.CENTER);
		// this.labelInfoProfil.setVerticalAlignment(JLabel.CENTER);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		gbc.weightx = 0.12;
		gbc.weighty = 1.;
		gbc.fill = GridBagConstraints.BOTH;
		
		JPanel profilePanel = new JPanel(new BorderLayout());
		
		profilePanel.add(labelInfoProfil, BorderLayout.CENTER);
		
		
		JButton accueilButton = new JButton("Accueil");
		accueilButton.addActionListener(controlleur);
		accueilButton.setActionCommand("accueil");
		
		JButton tweetsPersoButton = new JButton("Voir mes tweets");
		tweetsPersoButton.addActionListener(controlleur);
		tweetsPersoButton.setActionCommand("mesTweets");
		
		profilePanel.add(accueilButton, BorderLayout.NORTH);
		profilePanel.add(tweetsPersoButton, BorderLayout.SOUTH);
		

		JPanel leftPanel = new JPanel(new BorderLayout());
		leftPanel.setBackground(Color.WHITE);
		//leftPanel.add(labelInfoProfil, BorderLayout.NORTH);
		leftPanel.add(profilePanel, BorderLayout.NORTH);
		recherche = new JTextField("Recherche", 20);
		recherche.addKeyListener(new RechercheListener(controlleur.getUsername(), this.controlleur));
		leftPanel.add(recherche, BorderLayout.SOUTH);

		this.add(leftPanel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 0.88;
		gbc.weighty = 0.01;

		gbc.gridwidth = GridBagConstraints.REMAINDER;

		JPanel panel = new JPanel(new GridLayout(1, 1));
		jTextFieldTweet = new JTextField("Tweetez ici !", 20);
		jTextFieldTweet.addKeyListener(controlleur);
		panel.add(jTextFieldTweet);
		panel.setBackground(Color.WHITE);

		this.add(panel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.88;
		gbc.weighty = 0.99;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		JPanel panelList = new JPanel(new GridLayout(1, 1));
		//panelList.setBackground(Color.decode("#bdc3c7"));

		list = new JList<String>(controlleur.getAllTweets());
		list.setBackground(Color.decode("#bdc3c7"));
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		//renderer.setBackground(Color.decode("#2980b9"));
		
		JScrollPane scrollPane = new JScrollPane(list);

		panelList.add(scrollPane);

		this.add(panelList, gbc);

	}

	private String htmlAvatar() {

		// System.out.println(getClass().getResource("image/avatar.png"
		// ).getPath());

		return "<html><br /><img  height='80' width='100' src='" + "avatar.png" + "' /><h1>"
				+ this.controlleur.getUsername() + "</h1><h3>@" + this.controlleur.getUsername() + "</h3></html>";
	}
	
	public void refreshTweets(String[] twStrings)
	{
		//System.out.println("resfresh");
		
		DefaultListModel<String> listModel=new DefaultListModel<String>();
		for (int i=0; i<twStrings.length; i++) {
		  listModel.addElement(twStrings[i]);
		}
		list.setModel(listModel);
		
	}
	
	public String getTweetContenu()
	{
		return jTextFieldTweet.getText();
	}
	
	public void cleanTweetContenu()
	{
		jTextFieldTweet.setText("");
	}
	
	public String getRechercheContenu()
	{
		return recherche.getText();
	}

}
