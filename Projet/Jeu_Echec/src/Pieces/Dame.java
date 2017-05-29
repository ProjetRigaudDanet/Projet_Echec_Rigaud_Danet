package Pieces;

import java.util.ArrayList;

import Echiquier.Echiquier;
import Echiquier.Pieces;
import Echiquier.Positionnement;

public class Dame extends Pieces
{
	public Dame(String couleur)
	{
		super(couleur);
		this.nom="Dame";
		this.couleur=couleur;
	}
	
	public String toString()
	{
		if (this.couleur=="Blanc") return "\u2655";
		else return "\u265B";
	}

	public ArrayList<Positionnement> deplacementOk(Positionnement init,Echiquier echiquier)
	{
		ArrayList<Positionnement> deplacementsPossibles = new ArrayList<Positionnement>();
		int i = 1; 
		while(echiquier.getCase(init.getLigne()+i , init.getColonne() +i) != null )
		{
			if(echiquier.getCase(init.getLigne()+i , init.getColonne() +i).estVide(this.getCouleur() ) == true)
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
		while(echiquier.getCase(init.getLigne()-i , init.getColonne()  +i) != null )
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
		
		i = 1; 
		while(echiquier.getCase(init.getLigne()+i , init.getColonne()) != null )
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
		while(echiquier.getCase(init.getLigne()-i , init.getColonne()) != null )
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
		while(echiquier.getCase(init.getLigne() , init.getColonne() +i) != null )
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
		while(echiquier.getCase(init.getLigne() , init.getColonne() -i) != null )
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
		System.out.println(deplacementsPossibles.toString());

		
		return deplacementsPossibles;
	}
}
