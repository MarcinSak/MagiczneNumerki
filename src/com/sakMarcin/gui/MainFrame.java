package com.sakMarcin.gui;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sakMarcin.app.ChoosenFile;
import com.sakMarcin.logic.ExtensionChecker;
import com.sakMarcin.logic.PickFile;

public class MainFrame extends JFrame
{
	ChoosenFile file = new ChoosenFile();
	private JPanel contentPane;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 205);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		LABELS
		
		final JLabel labelTitle = new JLabel("Choose your file");
		labelTitle.setBounds(145, 11, 130, 22);
		labelTitle.setFont(new Font("Arial", Font.PLAIN, 18));
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labelTitle);
		
		JTextField textFieldSelectedFile = new JTextField("no selected");
		textFieldSelectedFile.setEditable(false);
		textFieldSelectedFile.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSelectedFile.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldSelectedFile.setBounds(62, 78, 299, 22);
		contentPane.add(textFieldSelectedFile);
		
		JLabel labelAnswer = new JLabel("");
		labelAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		labelAnswer.setFont(new Font("Arial", Font.BOLD, 14));
		labelAnswer.setBounds(10, 116, 394, 22);
		contentPane.add(labelAnswer);
		
//		BUTTONS

		JButton buttonCheck = new JButton("Check");
		buttonCheck.setMnemonic('c');
		buttonCheck.setEnabled(false);
		buttonCheck.setFont(new Font("Arial", Font.PLAIN, 14));
		buttonCheck.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				ExtensionChecker extensionChecker = new ExtensionChecker();
					try
					{
						labelAnswer.setText(extensionChecker.getRealExtension(file.getFile()));
					} catch (IOException e1)
					{
						System.err.println("Failed in change answerLabel");
					}
					buttonCheck.setEnabled(false);
			}
		});
		buttonCheck.setBounds(236, 44, 89, 23);
		contentPane.add(buttonCheck);
		
		JButton buttonSelect = new JButton("Select");
		buttonSelect.setMnemonic('s');
		buttonSelect.setFont(new Font("Arial", Font.PLAIN, 14));
		buttonSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PickFile filePicker = new PickFile();
				try
				{
					file.setFile(filePicker.pickFile());
					textFieldSelectedFile.setText(file.getFile().getName());
					buttonCheck.setEnabled(true);
				} catch (FileNotFoundException e)
				{
					System.err.println("PickFile do not find a file");
				}
			}
		});
		buttonSelect.setBounds(107, 44, 89, 23);
		contentPane.add(buttonSelect);
		
	}
}
