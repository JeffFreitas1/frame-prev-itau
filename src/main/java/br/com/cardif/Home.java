package br.com.cardif;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import br.com.cardif.services.faker.FakerService;
import br.com.cardif.testrules.TestRule;
import br.com.cardif.utils.Utils;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Label;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

import java.awt.GridLayout;
import java.awt.Toolkit;

@SpringBootApplication
public class Home {

	private static JFrame Projeto;
	private JTextField txtCtempevidencias;
	private JTextField txtCtempfeatures;
	private static String txtLog = "";
	private static JTextArea txtrTest = new JTextArea();


	private static FakerService fakerService;

	@Autowired
	public Home( FakerService fakerService) {

		
		this.fakerService = fakerService;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Home.class, args);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					SingletonStepDefinition config = SingletonStepDefinition.getInstance();
					config.setFakerService(fakerService);
					
				
					window.Projeto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {

		initialize();
	}

	/**
	 * Metodos .
	 */

	public static void logar(String texto) {
		txtrTest.append(texto + "\n");
		// txtrTest.setText(txtLog);
	}

	public static void limpar() {
		txtrTest.setText("");
	}

	public static void restore() {
		Projeto.setState(Projeto.NORMAL);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Projeto = new JFrame();
		//Projeto.setTitle("Portal Servico-Estoque");
		Projeto.setTitle("Portal Servico-Venda");
		Projeto.setBounds(100, 100, 573, 528);
		Projeto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnNewButton = new JButton("Iniciar teste");
		btnNewButton.setBounds(159, 167, 127, 26);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				Projeto.setState(Projeto.ICONIFIED);
				//Result result = JUnitCore.runClasses(PortalParceiroTest.class);
				TestRule.finishTest();

			}
		});

		JLabel lblEvidencia = new JLabel("Evidencia");
		lblEvidencia.setBounds(27, 12, 81, 41);
		lblEvidencia.setFont(new Font("Arial", Font.BOLD, 16));

		txtCtempevidencias = new JTextField();
		txtCtempevidencias.setEditable(false);
		txtCtempevidencias.setText("C:\\temp\\Evidencias");
		txtCtempevidencias.setBounds(27, 44, 259, 20);
		txtCtempevidencias.setColumns(10);

		txtCtempfeatures = new JTextField();
		txtCtempfeatures.setEditable(false);
		txtCtempfeatures.setText("C:\\temp\\Features");
		txtCtempfeatures.setBounds(27, 108, 259, 20);
		txtCtempfeatures.setColumns(10);

		JLabel lblFeature = new JLabel("Feature");
		lblFeature.setBounds(27, 76, 65, 41);
		lblFeature.setFont(new Font("Arial", Font.BOLD, 16));

		JButton btnNewButton_1 = new JButton("Abrir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File(txtCtempevidencias.getText());
					Utils.createTempFolder(txtCtempevidencias.getText());
					Desktop desktop = Desktop.getDesktop();
					desktop.open(file);
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
					JOptionPane.showMessageDialog(null, "Pasta nao existe!!!", " ERRO!!!!!!!", 2);
				}
			}
		});
		btnNewButton_1.setBounds(311, 44, 140, 20);
		Projeto.getContentPane().setLayout(null);
		Projeto.getContentPane().add(btnNewButton);
		Projeto.getContentPane().add(lblEvidencia);
		Projeto.getContentPane().add(txtCtempevidencias);
		Projeto.getContentPane().add(txtCtempfeatures);
		Projeto.getContentPane().add(lblFeature);
		Projeto.getContentPane().add(btnNewButton_1);

		txtrTest.setText(txtLog);
		txtrTest.setBounds(27, 244, 522, 184);

		Projeto.getContentPane().add(txtrTest);

		JLabel lblLog = new JLabel("Log");
		lblLog.setFont(new Font("Arial", Font.BOLD, 16));
		lblLog.setBounds(27, 205, 67, 41);
		Projeto.getContentPane().add(lblLog);

		JButton btnNewButton_2 = new JButton("Abrir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File(txtCtempfeatures.getText());
					Utils.createTempFolder(txtCtempfeatures.getText());
					Desktop desktop = Desktop.getDesktop();
					desktop.open(file);
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
					JOptionPane.showMessageDialog(null, "Pasta nao existe!!!", " ERRO!!!!!!!", 1);
				}
			}
		});
		btnNewButton_2.setBounds(311, 108, 140, 20);
		Projeto.getContentPane().add(btnNewButton_2);
	}
}
