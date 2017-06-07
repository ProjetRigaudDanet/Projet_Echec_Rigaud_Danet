package Echiquier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Partie.Partie;
import Pieces.Cavalier;
import Pieces.Dame;
import Pieces.Fou;
import Pieces.Pion;
import Pieces.Roi;
import Pieces.Tour;

public class Echiquier 
{
	private Case[][] echiquier;
	private Partie partie;
	private File f;
	private Affichage affichage = new Affichage();
	
	public Echiquier()
	{
		this.echiquier = new Case[8][8];
		for(int i=0 ; i<8 ; i++)
			for(int j=0; j<8; j++)
			echiquier[i][j] = new Case();
		this.f = new File("../../save.txt");
	}
	
	public Case[][] getEchiquier()
	{
		return this.echiquier;
	}
	
	
	public Echiquier(Partie partie)
	{
		this.partie=partie;
	}
	
	public void initialise()
	{
		
		for(int i = 0 ; i < 8;i++)
		{	
			echiquier[1][i].setPieces(new Pion("Noir"));
			echiquier[6][i].setPieces(new Pion("Blanc"));
		}
	
		echiquier[7][0].setPieces(new Tour("Blanc"));
		echiquier[7][1].setPieces(new Cavalier("Blanc"));
		echiquier[7][2].setPieces(new Fou("Blanc"));
		echiquier[7][3].setPieces(new Roi("Blanc"));
		echiquier[7][4].setPieces(new Dame("Blanc"));
		echiquier[7][5].setPieces(new Fou("Blanc"));
		echiquier[7][6].setPieces(new Cavalier("Blanc"));
		echiquier[7][7].setPieces(new Tour("Blanc"));
		
		echiquier[0][0].setPieces(new Tour("Noir"));
		echiquier[0][1].setPieces(new Cavalier("Noir"));
		echiquier[0][2].setPieces(new Fou("Noir"));
		echiquier[0][3].setPieces(new Roi("Noir"));
		echiquier[0][4].setPieces(new Dame("Noir"));
		echiquier[0][5].setPieces(new Fou("Noir"));
		echiquier[0][6].setPieces(new Cavalier("Noir"));
		echiquier[0][7].setPieces(new Tour("Noir"));
		
	}
	
	
	public Pieces getPieces(Positionnement positionnement)
	{
		return this.echiquier[positionnement.getLigne()][positionnement.getColonne()].getPieces();
	}
		
	public void setPieces(Pieces piece,Positionnement positionnement)
	{
		this.echiquier[positionnement.getLigne()][positionnement.getColonne()].setPieces(piece);
	}
	
	public Case getCase(int ligne,int colonne)
	{
		if(ligne<8 && ligne>=0 && colonne<8 && colonne>=0 )
		{
		return echiquier[ligne][colonne];
		}
		return null;
	}
	
	public void reset(){
		for(int x = 0 ; x < 8;x++)
		{
			for(int y = 0 ; y < 8;y++)
			{
				echiquier[x][y].setPieces(null);
			}
		}
	}
	
	public boolean conditionOk(Positionnement init,Positionnement finale)
	{
		try{
		if(init.getCase(this) != null && finale.getCase(this) != null)
			{
				if(
				(init.getLigne() >= 0 && init.getLigne() <= 7)
				&&
				(init.getColonne() >= 0 && init.getColonne() <= 7)
				&&
				(finale.getLigne() >= 0 && finale.getLigne() <= 7)
				&&
				(finale.getColonne() >= 0 && finale.getColonne() <= 7)
				)
					if(init.getCase(this).getPieces().deplacementOk(init, this).contains(finale))
						return true;
			}
		}
		catch(NullPointerException e ){
			affichage.afficher("\n=La case est vide !\n");
		}
		return false;
	}
	
	public String echecRoi(){
		for(int x = 0 ; x < 8;x++)
		{
			for(int y = 0 ; y < 8;y++)
			{
				if((this.getCase(x, y).estVide()) && (this.getCase(x, y).getPieces().getNom() == "Roi"))
				{
					if (this.getCase(x, y).getPieces().estEchec(new Positionnement(x,y),this))
					{
						String couleur = this.getCase(x, y).getPieces().getCouleur();
						return couleur;
					}
				}
			}
		}
		return null;
	}
	
	public boolean Mat(){
		if (echecRoi() == "Blanc" || echecRoi() == "Noir"){
			if (echecRoi() == "Blanc"){
				int compteur = 0;
				int compteurTotal =0;
				for(int x = 0 ; x < 8;x++)
				{
					for(int y = 0 ; y < 8;y++)
					{
						if ((this.getCase(x, y).estVide("Blanc"))) {
							Pieces roi = this.getCase(x, y).getPieces();
							Positionnement p = new Positionnement(x,y);
							
							for (int i = 0; i < roi.deplacementOk(p, this).size();i++)
							{
								compteurTotal++;
								Positionnement posFinal = roi.deplacementOk(p, this).get(i);
								Pieces tmp = null;
								if (posFinal.getCase(this).getPieces() != null) tmp = posFinal.getCase(this).getPieces();
								this.setPieces(getPieces(p),posFinal);
								this.setPieces(null, p);
								if (echecRoi() == "Blanc")
								{
									this.setPieces(getPieces(posFinal),p);
									this.setPieces(null, posFinal);
									compteur++;
								}
								else
								{
									this.setPieces(getPieces(posFinal),p);
									this.setPieces(null, posFinal);
								}
								if (tmp != null){
									this.setPieces(tmp, posFinal);
								}
							}
						}	
					}
				}
				if (compteur == compteurTotal){
					affichage.afficher("Mat ! Noir a gagné !");
					return true;
				}
			}
			else if (echecRoi() == "Noir"){
				int compteur = 0;
				int compteurTotal =0;
				for(int x = 0 ; x < 8;x++)
				{
					for(int y = 0 ; y < 8;y++)
					{
						if ((this.getCase(x, y).estVide("Noir"))) {
							Pieces roi = this.getCase(x, y).getPieces();
							Positionnement p = new Positionnement(x,y);
							
							for (int i = 0; i < roi.deplacementOk(p, this).size();i++)
							{
								compteurTotal++;
								Positionnement posFinal = roi.deplacementOk(p, this).get(i);
								Pieces tmp = null;
								if (posFinal.getCase(this).getPieces() != null) tmp = posFinal.getCase(this).getPieces();
								this.setPieces(getPieces(p),posFinal);
								this.setPieces(null, p);
								if (echecRoi() == "Noir")
								{
									this.setPieces(getPieces(posFinal),p);
									this.setPieces(null, posFinal);
									compteur++;
								}
								else
								{
									this.setPieces(getPieces(posFinal),p);
									this.setPieces(null, posFinal);
								}
								if (tmp != null){
									this.setPieces(tmp, posFinal);
								}
							}
							
						}
							
					}
				}
				if (compteur == compteurTotal){
					affichage.afficher("Mat ! Blanc a gagné !");
					return true;
				}
			}
		}
		return false;
	}
	
	public void sauvegarder(File f, Boolean tourBlanc){
		try
		{
			FileWriter fw = new FileWriter(f);
			String s = "";
			for(int x = 0 ; x < 8;x++)
			{
				for(int y = 0 ; y < 8;y++)
				{
					s += this.getCase(x, y).toString();
				}
			}
			if (tourBlanc) s += "1";
			else s += "0";
			fw.write(s);
			fw.close();
			
		}
		catch (IOException e)
		{
			affichage.afficher("Erreur lors de la lecture : " + e.getMessage());
		}
	}
	
	public int charger(File f){
		try
		{
		    FileReader fr = new FileReader (f);
		    int c = fr.read();
		    this.reset();
		    for(int x = 0 ; x < 8;x++)
			{
				for(int y = 0 ; y < 8;y++)
				{
					if((char) c == '\u2659') echiquier[x][y].setPieces(new Pion("Blanc")); 				
					else if((char) c == '\u265F') echiquier[x][y].setPieces(new Pion("Noir")); 	
					
					else if((char) c == '\u2656') echiquier[x][y].setPieces(new Tour("Blanc"));		
					else if((char) c == '\u265C') echiquier[x][y].setPieces(new Tour("Noir"));		
					
					else if((char) c == '\u2658') echiquier[x][y].setPieces(new Cavalier("Blanc"));		
					else if((char) c == '\u265E') echiquier[x][y].setPieces(new Cavalier("Noir"));
					
					else if((char) c == '\u2657') echiquier[x][y].setPieces(new Fou("Blanc"));			
					else if((char) c == '\u265F') echiquier[x][y].setPieces(new Fou("Noir"));			
					
					else if((char) c == '\u2654') echiquier[x][y].setPieces(new Roi("Blanc"));		
					else if((char) c == '\u265A') echiquier[x][y].setPieces(new Roi("Noir"));			
					
					else if((char) c == '\u2655') echiquier[x][y].setPieces(new Dame("Blanc"));	
					else if((char) c == '\u265B') echiquier[x][y].setPieces(new Dame("Noir"));	
					
					c = fr.read();
				}
			}
		    fr.close();
		    return c - 48;
		}
		catch (FileNotFoundException e)
		{
			affichage.afficher("Le fichier n'a pas été trouvé" + e.getMessage());
			return -1;
		}
		catch (IOException e)
		{
			affichage.afficher("Erreur lors de la lecture : " + e.getMessage());
			return -1;
		}
	}

	
	public int Deplacement(String couleur, Boolean tourBlanc)
	{
		Positionnement Init;
		Positionnement Final;
		do{

			Init = affichage.PositionInit();
			if (Init.getColonne() == -1 && Init.getLigne() == -1)
			{
				this.sauvegarder(f,tourBlanc);
				affichage.afficher("\nLa partie vient d'être sauvegardé\n");
				return -1;
			}
			
			if (Init.getColonne() == -2 && Init.getLigne() == -2)
			{
				int tour = this.charger(f);
				affichage.afficher("\nPartie chargé correctement !\n");
				return (tour - 3);
			}
				
			Final = affichage.PositionFinale();

		}while(!conditionOk(Init,Final) );

		if ((getPieces(Init).getCouleur()) != couleur) return 0;
		
		this.setPieces(getPieces(Init),Final);
		this.setPieces(null, Init);
		if (echecRoi() == couleur)
		{
			this.setPieces(getPieces(Final),Init);
			this.setPieces(null, Final);
			return 0;
		}
		
		return 1;
		
	}
	
	
}
