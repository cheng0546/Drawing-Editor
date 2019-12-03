package EditeurDeDessin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.Object;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;


public class Editeur extends JFrame {
	
	ZoneDeDessin zoneDeDessin;
	Dessin dessin;
	
	public void addZoneDeDessin (Editeur editeur) {
		zoneDeDessin = new ZoneDeDessin();
		zoneDeDessin.setBackground(Color.WHITE);
		zoneDeDessin.setLayout(null);
		editeur.getContentPane().add(zoneDeDessin, BorderLayout.CENTER);
	}
	
	public void addShapeActionListenerForButton (Editeur editeur, JButton bouton, CreateurDessin createurDessin) {
		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editeur.zoneDeDessin.defineShape(createurDessin);
			}
		});
	}
	
	public void addColorActionListenerForButton (Editeur editeur, JButton bouton, int r, int g, int b) {
		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editeur.zoneDeDessin.defineColor(r, g, b);
			}
		});
	}
	
	public void addShapeActionListenerForMenu (Editeur editeur, JMenuItem menu, CreateurDessin createurDessin) {
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editeur.zoneDeDessin.defineShape(createurDessin);
			}
		});
	}
	
	public void addColorActionListenerForMenu (Editeur editeur, JMenuItem menu, int r, int g, int b) {
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editeur.zoneDeDessin.defineColor(r, g, b);
			}
		});
	}
	
	public static void main (String[] args) {
		
		// Creation d'editeur
		
		Editeur editeur = new Editeur();
		Editeur.setDefaultLookAndFeelDecorated(true);
		editeur.setTitle("Editeur de dessin");
		editeur.setSize(900, 600);
		editeur.setDefaultCloseOperation(Editeur.EXIT_ON_CLOSE);
		
		// Creation de zone de dessin
		
		editeur.addZoneDeDessin(editeur);		
		
		// Creation de menu bar
		
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(1, 3, 10, 10));
		editeur.getContentPane().add(menu, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(600,50));
		menuBar.setBackground(Color.WHITE);
		menu.add(menuBar);
		
		// Creation de menu de type
		
		JMenu shapeMenu = new JMenu("Type");
		shapeMenu.setPreferredSize(new Dimension(200,50));
		menuBar.add(shapeMenu);
		JMenuItem mnRectangle = new JMenuItem("Rectangle");
		mnRectangle.setPreferredSize(new Dimension(200,50));
		editeur.addShapeActionListenerForMenu(editeur, mnRectangle, new CreateurRectangle());
		shapeMenu.add(mnRectangle);
		JMenuItem mnElipse = new JMenuItem("Elipse");
		mnElipse.setPreferredSize(new Dimension(200,50));
		editeur.addShapeActionListenerForMenu(editeur, mnElipse, new CreateurElipse());
		shapeMenu.add(mnElipse);
		JMenuItem mnRectangleCreux = new JMenuItem("Rectangle creux");
		mnRectangleCreux.setPreferredSize(new Dimension(200,50));
		editeur.addShapeActionListenerForMenu(editeur, mnRectangleCreux, new CreateurRectangleCreux());
		shapeMenu.add(mnRectangleCreux);
		JMenuItem mnElipseCreuse = new JMenuItem("Elipse creuse");
		mnElipseCreuse.setPreferredSize(new Dimension(200,50));
		editeur.addShapeActionListenerForMenu(editeur, mnElipseCreuse, new CreateurElipseCreuse());
		shapeMenu.add(mnElipseCreuse);
		
		// Creation de menu de couleur
		
		JMenu colorMenu = new JMenu("Couleur");
		colorMenu.setPreferredSize(new Dimension(200,50));
		menuBar.add(colorMenu);
		JMenuItem mnYellow = new JMenuItem("Jaune");
		mnYellow.setPreferredSize(new Dimension(200,50));
		editeur.addColorActionListenerForMenu(editeur, mnYellow, 255, 255, 0);
		colorMenu.add(mnYellow);
		JMenuItem mnBlue = new JMenuItem("Bleu");
		mnBlue.setPreferredSize(new Dimension(200,50));
		editeur.addColorActionListenerForMenu(editeur, mnBlue, 0, 0, 255);
		colorMenu.add(mnBlue);
		JMenuItem mnGreen = new JMenuItem("Vert");
		mnGreen.setPreferredSize(new Dimension(200,50));
		editeur.addColorActionListenerForMenu(editeur, mnGreen, 0, 255, 0);
		colorMenu.add(mnGreen);
		JMenuItem mnRed = new JMenuItem("Rough");
		mnRed.setPreferredSize(new Dimension(200,50));
		editeur.addColorActionListenerForMenu(editeur, mnRed, 255, 0, 0);
		colorMenu.add(mnRed);
		JMenuItem mnOther = new JMenuItem("Autre");
		mnOther.setPreferredSize(new Dimension(200,50));
		mnOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color selectedColor = JColorChooser.showDialog(editeur, "Others color", null);
				if (selectedColor == null) {
                    return;
                }
				int r = selectedColor.getRed();
                int g = selectedColor.getGreen();
                int b = selectedColor.getBlue();
                editeur.zoneDeDessin.defineColor(r, g, b);
			}
		});
		colorMenu.add(mnOther);
				
		// Creation de boutons de couleur
		
		JPanel colorGroup = new JPanel();
		colorGroup.setLayout(new GridLayout(5, 1, 10, 5));
		editeur.getContentPane().add(colorGroup, BorderLayout.EAST);
		
		JButton btnYellow= new JButton("Jaune");
		editeur.addColorActionListenerForButton(editeur, btnYellow, 255, 255, 0);
		colorGroup.add(btnYellow);
		JButton btnBlue= new JButton("Bleu");
		editeur.addColorActionListenerForButton(editeur, btnBlue, 0, 0, 255);
		colorGroup.add(btnBlue);
		JButton btnGreen= new JButton("Vert");
		editeur.addColorActionListenerForButton(editeur, btnGreen, 0, 255, 0);
		colorGroup.add(btnGreen);
		JButton btnRed= new JButton("Rough");
		editeur.addColorActionListenerForButton(editeur, btnRed, 255, 0, 0);
		colorGroup.add(btnRed);
		JButton btnOther= new JButton("Autre");
		btnOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color selectedColor = JColorChooser.showDialog(editeur, "Others color", null);
				if (selectedColor == null) {
                    return;
                }
				int r = selectedColor.getRed();
                int g = selectedColor.getGreen();
                int b = selectedColor.getBlue();
                editeur.zoneDeDessin.defineColor(r, g, b);
			}
		});
		colorGroup.add(btnOther);	
		
		// Creation de boutons de type de dessin
		
		JPanel btnGroup = new JPanel();
		btnGroup.setLayout(new GridLayout(4, 1, 10, 5));
		editeur.getContentPane().add(btnGroup, BorderLayout.WEST);
		
		JButton btnRectangle= new JButton("Rectangle");
		editeur.addShapeActionListenerForButton(editeur, btnRectangle, new CreateurRectangle());
		btnGroup.add(btnRectangle);
		JButton btnElipse= new JButton("Elipse");
		editeur.addShapeActionListenerForButton(editeur, btnElipse, new CreateurElipse());
		btnGroup.add(btnElipse);
		JButton btnRectangleCreux= new JButton("Rectangle Creux");
		editeur.addShapeActionListenerForButton(editeur, btnRectangleCreux, new CreateurRectangleCreux());
		btnGroup.add(btnRectangleCreux);
		JButton btnElipseCreuse= new JButton("Elipse Creuse");
		editeur.addShapeActionListenerForButton(editeur, btnElipseCreuse, new CreateurElipseCreuse());
		btnGroup.add(btnElipseCreuse);
		
		editeur.setVisible(true);

	}
		
}