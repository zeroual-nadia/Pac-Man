package display;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import game.*;
import main.InformationJeu;
import main.*;
import personnage.Fantome;
import personnage.Pacman;

public class MyComponent extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Carte carte;
	private Pacman pacman;
	private ArrayList<Fantome> fantomes;
	private int largeurCase;
	private int longeurCase;
	private long lastOuverte;
	private boolean ouverte; //Bouche Pacman

	
	public MyComponent(Carte carte, ArrayList<Fantome> fantomes, Pacman pacman) {
		super();
		this.carte = carte;
		this.pacman = pacman;
		this.fantomes = fantomes;
		ouverte = false;
	}
	

    
    
    @SuppressWarnings("static-access")
	public static void popMessage(String s) {
    	JOptionPane jp;
    	jp=new JOptionPane();
    	jp.showMessageDialog(null,s, "Information",JOptionPane.INFORMATION_MESSAGE);
    }

	public void paintComponent(Graphics g){
		Cellule cellule;
		int width = getSize().width;
		int height = getSize().height;


		super.paintComponent(g);
		longeurCase = width / carte.getWidth();
		largeurCase = ((height-(height / 20))) / carte.getHeigth();
		
		g.setColor(InformationJeu.CelluleNavigable);
		for (int i = 0; i < carte.getHeigth(); i++) {
			for (int j = 0; j < carte.getWidth() ; j++) {
				cellule = carte.getCarteIJ(i, j);
				if (cellule!=null)
					dessineCellule(g, cellule);
			}
		}
		dessineFantomes(g);
		dessinePacman(g);
		dessineScore(g);
		if (System.currentTimeMillis() - lastOuverte > InformationPacman.tempBoucheOuverte)
		{
			ouverte = !ouverte;
			lastOuverte = System.currentTimeMillis();
		}
		
	}
	
	private void dessineScore(Graphics g) {
		g.setColor(Color.WHITE);
		String str = "Score: " + pacman.getPoint();
		g.drawString(str, 100, Math.min(carte.getHeigth() * largeurCase + 20, getSize().height - 20));
		
		str = "Pv: " + pacman.getPv();
		
		g.drawString(str, 300, Math.min(carte.getHeigth() * largeurCase + 20, getSize().height - 20));
	
		str = "Pacgomme restants " + carte.getPacgommeDisponible();
		
		g.drawString(str, 500, Math.min(carte.getHeigth() * largeurCase + 20, getSize().height - 20));
		
	}

	private int positionBouche()
	{
		
		
		if (pacman.getDirection() == Direction.RIGHT)
			return 20 + 90 * 0;
		if (pacman.getDirection() == Direction.UP)
			return 20 + 90 * 1;
		if (pacman.getDirection() == Direction.LEFT)
			return 20 + 90 * 2;
		if (pacman.getDirection() == Direction.DOWN)
			return 20 + 90 * 3;
		
		return 0;
		
	}
	
	private void dessinePacman(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(getColorPacman());
		if (ouverte)
			g.fillArc(longeurCase * pacman.getPosition().getX() + longeurCase /10 ,
				largeurCase * pacman.getPosition().getY() + largeurCase /10 , 2 * longeurCase / 3, 2 * largeurCase / 3 , positionBouche(), 320);
		else
			g.fillOval(longeurCase * pacman.getPosition().getX() + longeurCase /10 ,
					largeurCase * pacman.getPosition().getY() + largeurCase /10 , 2 * longeurCase / 3, 2 * largeurCase / 3);
		g.setColor(c);
	}
	
	private void dessineFantomes(Graphics g)
	{
		Color c = g.getColor();
		for (Fantome fantome : fantomes) {
			g.setColor(getColorFantome(fantome));
			g.fillOval(fantome.getPosition().getX()*longeurCase  + longeurCase / 10 , fantome.getPosition().getY()*largeurCase + largeurCase / 10, longeurCase * 8 / 10, largeurCase * 8 /10);
			g.setColor(Color.GREEN);
			g.fillOval((fantome.getPosition().getX()*longeurCase + longeurCase / 4 )- (longeurCase / 10), (fantome.getPosition().getY()*largeurCase + largeurCase / 3) - largeurCase / 10, longeurCase / 5, largeurCase /5);
			g.fillOval((fantome.getPosition().getX()*longeurCase + 3 * longeurCase / 4)- (longeurCase / 10), (fantome.getPosition().getY()*largeurCase + largeurCase / 3)- largeurCase / 10, longeurCase / 5, largeurCase /5);
			g.drawString("WWW",fantome.getPosition().getX()*longeurCase  + longeurCase  *2/ 5 , fantome.getPosition().getY()*largeurCase + largeurCase *2/ 3);	
		}
		g.setColor(c);
		
	}

	
	private void dessineCellule(Graphics g, Cellule cellule)
	{
		Color c = g.getColor();
		if (cellule.isNavigable())
		{
			g.fillRect(cellule.getX() * longeurCase, cellule.getY() * largeurCase, longeurCase, largeurCase);
			if (cellule.hasPacgomme())
			{	
				g.setColor(getColorPacgomme(cellule.getPacgomme().getstateId()));
				g.fillOval(((cellule.getX()) * longeurCase + longeurCase / 2) - InformationJeu.RayonPacgomme/2, (cellule.getY()* largeurCase + largeurCase / 2) - InformationJeu.RayonPacgomme/2,  InformationJeu.RayonPacgomme, InformationJeu.RayonPacgomme);
			}
		
		}else
		{
			g.setColor(InformationJeu.Mur);
			g.fillRect(cellule.getX() * longeurCase, cellule.getY() * largeurCase, longeurCase, largeurCase);
		}
		g.setColor(c);
	}

	
	private Color getColorPacgomme(int id)
	{
		if (id == InformationJeu.identifiantPacgommeSuper)
			return InformationJeu.PacbonCourage;
		if (id == InformationJeu.identifiantPacgommeInvisible)
			return InformationJeu.PacbonInvisible;
		if (id == InformationJeu.identifiantPacgommeArchitecte)
			return InformationJeu.PacbonArchitecte;
		return InformationJeu.PacbonStandart;
	}
	private Color getColorPacman()
	{
		if (pacman.getId() == InformationPacman.identifiantEtatPacmanSuper)
			return InformationPacman.couleurPacmanSuper;
		if (pacman.getId() == InformationPacman.identifiantEtatPacmanInvisible)
			return InformationPacman.couleurPacmanInvisible;
		if (pacman.getId() == InformationPacman.identifiantEtatPacmanArchitecte)
			return InformationPacman.couleurPacmanArchitecte;
		return InformationPacman.couleurPacmanStandart;
	}
	private Color getColorFantome(Fantome fantome)
	{
		if (fantome.getId() == InformationFantome.identifiantEtatFantomeCraintif)
			return InformationFantome.couleurFantomeCraintif;
		else
			return InformationFantome.couleurFantomeStandart;
	}

	
	

}