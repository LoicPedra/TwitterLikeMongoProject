package fr.metz.iut.louis.pedrazzani.TwitterMongo.vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ApplicationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel labelInfoProfil;

	public ApplicationPanel() {
		super();

		this.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		labelInfoProfil = new JLabel("Username");

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 0.15;
		gbc.weighty = 1.;
		gbc.fill = GridBagConstraints.BOTH;

		this.add(labelInfoProfil);

		gbc.gridx = 1;
		gbc.weightx = 0.85;
		gbc.weighty = 1.;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);

		this.add(panel);
	}

}
