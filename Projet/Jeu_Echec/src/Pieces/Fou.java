package Pieces;

import java.util.ArrayList;

import Echiquier.Echiquier;
import Echiquier.Pieces;
import Echiquier.Positionnement;

public class Fou extends Pieces
{
	public Fou(String couleur)
	{
		super(couleur);
		this.nom="Fou";
		this.couleur=couleur;
	}
	public String toString()
	{
		if (this.couleur=="Blanc") return "\u2657";
		else return "\u265F";
	}
	
	public ArrayList<Positionnement> deplacementOk(Positionnement init,Echiquier echiquier)
	{
		ArrayList<Positionnement> deplacementsPossibles = new ArrayList<Positionnement>();
		

		
		int i = 1; 
		while( echiquier.getCase(init.getLigne()+i , init.getColonne() +i) != null )
		{
			if(echiquier.getCase(init.getLigne()+i , init.getColonne() +i).estVide(this.getCouleur()) == true)
			{
				break;
			}
			if(echiquier.getCase(init.getLigne()+i , init.getColonne() +i).estVide() == false )
				{deplacementsPossibles.add(new Positionnement(init.getLigne()+i,init.getColonne()  +i));}
			if(echiquier.getCase(init.getLigne()+i , init.getColonne() +i).estVide(this.estOppose() ) == true)
				{
				deplacementsPossibles.add(new Positionnement(init.getLigne()+i,init.getColonne()  +i));
				break;
				}
			i++;
			
		}
		i=1;
		while( echiquier.getCase(init.getLigne()-i , init.getColonne()  +i) != null )
		{
			if(echiquier.getCase(init.getLigne()-i , init.getColonne()  +i).estVide(this.getCouleur()) == true)
			{
				break;
			}
			if(echiquier.getCase(init.getLigne()-i , init.getColonne()  +i).estVide() == false)
				{deplacementsPossibles.add(new Positionnement(init.getLigne()-i,init.getColonne()  +i));}
			if(echiquier.getCase(init.getLigne()-i , init.getColonne()  +i).estVide(this.estOppose()) == true)
				{
				deplacementsPossibles.add(new Positionnement(init.getLigne()-i,init.getColonne()  +i));
				break;
				}
			i++;
			
		}
		i=1;
		while(echiquier.getCase(init.getLigne() +i, init.getColonne() -i) != null )
		{
			if(echiquier.getCase(init.getLigne()+i , init.getColonne() -i).estVide(this.getCouleur()) == true)
			{
				break;
			}
			if(echiquier.getCase(init.getLigne() +i, init.getColonne() -i).estVide() == false )
				{deplacementsPossibles.add(new Positionnement(init.getLigne()+i,init.getColonne()-i ));}
			if(echiquier.getCase(init.getLigne()+i , init.getColonne() -i).estVide(this.estOppose()) == true)
			{
				deplacementsPossibles.add(new Positionnement(init.getLigne()+i,init.getColonne()-i ));
				break;
			}
			i++;
			
		}

		i=1;
		while(echiquier.getCase(init.getLigne() -i, init.getColonne() -i) != null )
		{
			if(echiquier.getCase(init.getLigne() -i, init.getColonne() -i).estVide(this.getCouleur()) == true )
			{
				break;
			}
			if(echiquier.getCase(init.getLigne() -i, init.getColonne() -i).estVide() == false)
				{deplacementsPossibles.add(new Positionnement(init.getLigne()-i,init.getColonne()-i ));}
			if(echiquier.getCase(init.getLigne() -i, init.getColonne() -i).estVide(this.estOppose()) == true )
			{
				deplacementsPossibles.add(new Positionnement(init.getLigne()-i,init.getColonne()-i ));
				break;
			}
			i++;
			
		}	
		
		return deplacementsPossibles;
	}
}
