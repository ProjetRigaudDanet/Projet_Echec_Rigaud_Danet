package Pieces;

import Echiquier.Pieces;
import Echiquier.Positionnement;

import java.util.ArrayList;

import Echiquier.Echiquier;

public class Tour extends Pieces
{
    
	public Tour(String couleur)
	{
		super(couleur);
		this.nom="Tour";
	}

    
	public String toString()
	{
		if (this.couleur=="Blanc") return "\u2656";
		else return "\u265C";
	}


	public ArrayList<Positionnement> deplacementOk(Positionnement init,Echiquier echiquier)
	{
		ArrayList<Positionnement> deplacementsPossibles = new ArrayList<Positionnement>();
		
		int i = 1; 
		while( echiquier.getCase(init.getLigne()+i , init.getColonne()) != null )
		{
			if(echiquier.getCase(init.getLigne()+i , init.getColonne()).estVide(this.getCouleur()) == true)
			{
				break;
			}
			if(echiquier.getCase(init.getLigne()+i , init.getColonne()).estVide() == false )
				{deplacementsPossibles.add(new Positionnement(init.getLigne()+i,init.getColonne() ));}
			if(echiquier.getCase(init.getLigne()+i , init.getColonne()).estVide(this.estOppose()) == true)
				{
				deplacementsPossibles.add(new Positionnement(init.getLigne()+i,init.getColonne() ));
				break;
				}
			
			i++;
			
		}
		i=1;
		while( echiquier.getCase(init.getLigne()-i , init.getColonne()) != null )
		{
			if(echiquier.getCase(init.getLigne()-i , init.getColonne()).estVide(this.getCouleur()) == true)
			{
				break;
			}
			if(echiquier.getCase(init.getLigne()-i , init.getColonne()).estVide() == false)
				{deplacementsPossibles.add(new Positionnement(init.getLigne()-i,init.getColonne() ));}
			if(echiquier.getCase(init.getLigne()-i , init.getColonne()).estVide(this.estOppose()) == true)
				{
				deplacementsPossibles.add(new Positionnement(init.getLigne()-i,init.getColonne() ));
				break;
				}
		
			i++;
			
		}
		i=1;
		while( echiquier.getCase(init.getLigne() , init.getColonne() +i) != null )
		{
			if(echiquier.getCase(init.getLigne(), init.getColonne()+i).estVide(this.getCouleur()) == true)
			{
				break;
			}
			if(echiquier.getCase(init.getLigne() , init.getColonne() +i).estVide() == false )
				{deplacementsPossibles.add(new Positionnement(init.getLigne(),init.getColonne()+i ));}
			if(echiquier.getCase(init.getLigne() , init.getColonne() +i).estVide(this.estOppose()) == true)
			{
				deplacementsPossibles.add(new Positionnement(init.getLigne(),init.getColonne()+i ));
				break;
			}
		
			i++;
			
		}

		i=1;
		while( echiquier.getCase(init.getLigne() , init.getColonne() -i) != null )
		{
			if(echiquier.getCase(init.getLigne() , init.getColonne() -i).estVide(this.getCouleur()) == true)
			{
				break;
			}
			if(echiquier.getCase(init.getLigne() , init.getColonne() -i).estVide() == false)
				{deplacementsPossibles.add(new Positionnement(init.getLigne(),init.getColonne()-i ));}
			if(echiquier.getCase(init.getLigne() , init.getColonne() -i).estVide(this.estOppose()) == true )
			{
				deplacementsPossibles.add(new Positionnement(init.getLigne(),init.getColonne()-i ));
				break;
			}
			i++;
			
		}
		
		return deplacementsPossibles;
	}
}
