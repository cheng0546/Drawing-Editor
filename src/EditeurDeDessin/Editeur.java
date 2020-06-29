package EditeurDeDessin;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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



public class Editeur extends JFrame {
	
	ZoneDeDessin zoneDeDessin;
	DessinPrevu dessinPrevu;
	Color color = Color.BLACK;
	CreateurDessin createurDessin = new CreateurRectangle();
	
	public Editeur() {
		setDefaultLookAndFeelDecorated(true);
		setTitle("Editeur de dessin");
		setSize(900, 600);
		setDefaultCloseOperation(Editeur.EXIT_ON_CLOSE);
		
		addZoneDeDessin();  // Creation de zone de dessin
		
		JPanel btnAndMenu = new JPanel();
		btnAndMenu.setLayout(new BorderLayout());
		getContentPane().add(btnAndMenu, BorderLayout.WEST);
		
		addMenu(btnAndMenu);  // Ajoute de menus
		addButton(btnAndMenu);  // Ajoute de bouton	
		
		JPanel dessinPrevuPanel = new JPanel();
		dessinPrevuPanel.setPreferredSize(new Dimension(125, 110));
		btnAndMenu.add(dessinPrevuPanel, BorderLayout.SOUTH);
		dessinPrevu = new DessinPrevu(this.createurDessin, this.color);
		dessinPrevu.setPreferredSize(new Dimension(125, 110));
		dessinPrevuPanel.add(dessinPrevu);
	}
	
	public void addZoneDeDessin() {
		zoneDeDessin = new ZoneDeDessin();
		zoneDeDessin.setBackground(Color.WHITE);
		zoneDeDessin.setLayout(null);
		zoneDeDessin.defineColor(Color.BLACK);  // Init de couleur - noir
		zoneDeDessin.defineShape(new CreateurRectangle());  //  Init de dessin - rectangle
		getContentPane().add(zoneDeDessin, BorderLayout.CENTER);
	}
	
	public void addShapeActionListenerForButton(JRadioButton bouton, CreateurDessin selectedCreateurDessin) {
		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				zoneDeDessin.defineShape(selectedCreateurDessin);
				dessinPrevu.setShape(selectedCreateurDessin);
				dessinPrevu.repaint();
			}
		});
	}
	
	public void addColorActionListenerForButton(JButton bouton, Color selectedColor) {
		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				zoneDeDessin.defineColor(selectedColor);
				dessinPrevu.setColor(selectedColor);
				dessinPrevu.repaint();
			}
		});
	}
	
	public void addShapeActionListenerForMenu(JMenuItem menu, CreateurDessin selectedCreateurDessin) {
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				zoneDeDessin.defineShape(selectedCreateurDessin);
				dessinPrevu.setShape(selectedCreateurDessin);
				dessinPrevu.repaint();
			}
		});
	}
	
	public void addColorActionListenerForMenu(JMenuItem menu, Color selectedColor) {
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				zoneDeDessin.defineColor(selectedColor);
				dessinPrevu.setColor(selectedColor);
				dessinPrevu.repaint();
			}
		});
	}
	
	public void addMenu(JPanel btnAndMenu) {
		
		// Creation de menu bar
		
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(1, 3, 10, 10));
		getContentPane().add(menu, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(600,50));
		menuBar.setBackground(Color.lightGray);
		menu.add(menuBar);
		
		// Creation de menu de type
		
		JMenu shapeMenu = new JMenu("Type");
		shapeMenu.setPreferredSize(new Dimension(200,50));
		menuBar.add(shapeMenu);
		
		JMenuItem mnRectangle = new JMenuItem("Rectangle");
		mnRectangle.setPreferredSize(new Dimension(200,50));
		addShapeActionListenerForMenu(mnRectangle, new CreateurRectangle());
		shapeMenu.add(mnRectangle);
		
		JMenuItem mnElipse = new JMenuItem("Elipse");
		mnElipse.setPreferredSize(new Dimension(200,50));
		addShapeActionListenerForMenu(mnElipse, new CreateurElipse());
		shapeMenu.add(mnElipse);
		
		JMenuItem mnRectangleCreux = new JMenuItem("Rectangle creux");
		mnRectangleCreux.setPreferredSize(new Dimension(200,50));
		addShapeActionListenerForMenu(mnRectangleCreux, new CreateurRectangleCreux());
		shapeMenu.add(mnRectangleCreux);
		
		JMenuItem mnElipseCreuse = new JMenuItem("Elipse creuse");
		mnElipseCreuse.setPreferredSize(new Dimension(200,50));
		addShapeActionListenerForMenu(mnElipseCreuse, new CreateurElipseCreuse());
		shapeMenu.add(mnElipseCreuse);
		
		// Creation de menu de couleur
		
		JMenu colorMenu = new JMenu("Couleur");
		colorMenu.setPreferredSize(new Dimension(200,50));
		menuBar.add(colorMenu);
		
		JMenuItem mnYellow = new JMenuItem("Jaune");
		mnYellow.setPreferredSize(new Dimension(200,50));
		addColorActionListenerForMenu(mnYellow, Color.YELLOW);
		colorMenu.add(mnYellow);
		
		JMenuItem mnBlue = new JMenuItem("Bleu");
		mnBlue.setPreferredSize(new Dimension(200,50));
		addColorActionListenerForMenu(mnBlue, Color.BLUE);
		colorMenu.add(mnBlue);
		
		JMenuItem mnGreen = new JMenuItem("Vert");
		mnGreen.setPreferredSize(new Dimension(200,50));
		addColorActionListenerForMenu(mnGreen, Color.GREEN);
		colorMenu.add(mnGreen);
		
		JMenuItem mnRed = new JMenuItem("Rough");
		mnRed.setPreferredSize(new Dimension(200,50));
		addColorActionListenerForMenu(mnRed, Color.RED);
		colorMenu.add(mnRed);
		
		JMenuItem mnOther = new JMenuItem("Autre");
		mnOther.setPreferredSize(new Dimension(200,50));
		mnOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color selectedColor = JColorChooser.showDialog(getContentPane(), "Others color", null);
				if(selectedColor == null) {
                    return;
                }
                zoneDeDessin.defineColor(selectedColor);
                dessinPrevu.setColor(selectedColor);
				dessinPrevu.repaint();
			}
		});
		colorMenu.add(mnOther);
	}
	
	public void addButton(JPanel btnAndMenu) {
		
		// Creation de boutons de couleur
		
		JPanel colorGroup = new JPanel();
		colorGroup.setLayout(new GridLayout(5, 1, 10, 5));
		btnAndMenu.add(colorGroup, BorderLayout.EAST);
		
		JButton btnYellow= new JButton();
		btnYellow.setBackground(Color.YELLOW);
		addColorActionListenerForButton(btnYellow, Color.YELLOW);
		colorGroup.add(btnYellow);
		
		JButton btnBlue= new JButton();
		btnBlue.setBackground(Color.BLUE);
		addColorActionListenerForButton(btnBlue, Color.BLUE);
		colorGroup.add(btnBlue);
		
		JButton btnGreen= new JButton();
		btnGreen.setBackground(Color.GREEN);
		addColorActionListenerForButton(btnGreen, Color.GREEN);
		colorGroup.add(btnGreen);
		
		JButton btnRed= new JButton();
		btnRed.setBackground(Color.RED);
		addColorActionListenerForButton(btnRed, Color.RED);
		colorGroup.add(btnRed);
		
		JButton btnOther= new JButton("Autre");
		btnOther.setBackground(Color.WHITE);
		btnOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color selectedColor = JColorChooser.showDialog(getContentPane(), "Others color", null);
				if(selectedColor == null) {
                    return;
                }
                zoneDeDessin.defineColor(selectedColor);
                dessinPrevu.setColor(selectedColor);
				dessinPrevu.repaint();
			}
		});
		colorGroup.add(btnOther);	
		
		// Creation de boutons de type de dessin
		
		JPanel btnGroup = new JPanel();
		btnGroup.setLayout(new GridLayout(4, 1, 10, 5));
		btnAndMenu.add(btnGroup, BorderLayout.WEST);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton btnRectangle= new JRadioButton("Rectangle", true);
		addShapeActionListenerForButton(btnRectangle, new CreateurRectangle());
		btnGroup.add(btnRectangle);
		buttonGroup.add(btnRectangle);
		
		JRadioButton btnElipse= new JRadioButton("Elipse");
		addShapeActionListenerForButton(btnElipse, new CreateurElipse());
		btnGroup.add(btnElipse);
		buttonGroup.add(btnElipse);
		
		JRadioButton btnRectangleCreux= new JRadioButton("Rectangle Creux");
		addShapeActionListenerForButton(btnRectangleCreux, new CreateurRectangleCreux());
		btnGroup.add(btnRectangleCreux);
		buttonGroup.add(btnRectangleCreux);
		
		JRadioButton btnElipseCreuse= new JRadioButton("Elipse Creuse");
		addShapeActionListenerForButton(btnElipseCreuse, new CreateurElipseCreuse());
		btnGroup.add(btnElipseCreuse);
		buttonGroup.add(btnElipseCreuse);
	}
	
	public static void main(String[] args) {
		
		// Creation d'editeur
		Editeur editeur = new Editeur();
		editeur.setVisible(true);

	}
		
}