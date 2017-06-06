package Pieces;

import java.util.ArrayList;

import Echiquier.Echiquier;
import Echiquier.Pieces;
import Echiquier.Positionnement;

public class Pion extends Pieces
{
	
	public Pion(String couleur)
	{
		super(couleur);
		this.nom="Pion";
		this.couleur=couleur;
	}
	
	public String toString()
	{
		if (this.couleur=="Blanc") return "\u2659";
		else return "\u265F";
	}
	
	public ArrayList<Positionnement> deplacementOk(Positionnement init,Echiquier echiquier)
	{
		ArrayList<Positionnement> deplacementsPossibles = new ArrayList<Positionnement>();
		
		
		if (this.couleur == "Noir")
		{
			if(init.getLigne()+1<8)
			{
				if(echiquier.getCase(init.getLigne()+1,init.getColonne()).estVide() == false)
				{
					deplacementsPossibles.add( new Positionnement(init.getLigne()+1,init.getColonne()) );
					
					if (init.getLigne() == 1 && (echiquier.getCase(init.getLigne()+2,init.getColonne()).estVide() != true))
					{
						Positionnement pos2=new Positionnement(init.getLigne()+2,init.getColonne());
						deplacementsPossibles.add(pos2);
					}
				}
			}
			if(init.getLigne()+1<8 && init.getColonne()-1>=0)
			{
				if(echiquier.getCase(init.getLigne()+1,init.getColonne()-1).estVide("Blanc")) 
				{
					Positionnement pos3 = (new Positionnement(init.getLigne()+1,init.getColonne()-1));
					deplacementsPossibles.add(pos3);
				}
			}
			if(init.getLigne() + 1 <7 && init .getColonne()+1 <8)
				if( (echiquier.getCase(init.getLigne()+1,init.getColonne()+1).estVide("Blanc")) )
				{
					Positionnement pos4 = (new Positionnement(init.getLigne()+1,init.getColonne()+1));
					deplacementsPossibles.add(pos4);
				}

		}
		
		if (this.couleur == "Blanc")
		{
			if(init.getLigne()-1>=0)
			{
				if(echiquier.getCase(init.getLigne()-1,init.getColonne()).estVide() == false)
				{
					deplacementsPossibles.add( new Positionnement(init.getLigne()-1,init.getColonne()) );
					
					if (init.getLigne() == 6 && (echiquier.getCase(init.getLigne()-2,init.getColonne()).estVide() != true))
					{
						Positionnement pos2=new Positionnement(init.getLigne()-2,init.getColonne());
						deplacementsPossibles.add(pos2);
					}
				}
			}
			if(init.getLigne()-1>=0 && init.getColonne()-1>=0)
			{
				if(echiquier.getCase(init.getLigne()-1,init.getColonne()-1).estVide("Noir")) 
				{
					Positionnement pos3 = (new Positionnement(init.getLigne()-1,init.getColonne()-1));
					deplacementsPossibles.add(pos3);
				}
			}
			if(init.getLigne() - 1 >=0 && init .getColonne()+1 <8)
				if( (echiquier.getCase(init.getLigne()-1,init.getColonne()+1).estVide("Noir")) )
				{
					Positionnement pos4 = (new Positionnement(init.getLigne()-1,init.getColonne()+1));
					deplacementsPossibles.add(pos4);
				}

		}
	
		return deplacementsPossibles;
	}
}	
