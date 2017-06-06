package Pieces;

import java.util.ArrayList;

import Echiquier.Echiquier;
import Echiquier.Pieces;
import Echiquier.Positionnement;

public class Cavalier extends Pieces
{
	public Cavalier(String couleur)
	{
		super(couleur);
		this.nom="Cavalier";
		this.couleur=couleur;
	}
	
	public String toString()
	{
		if (this.couleur=="Blanc") return "\u2658";
		else return "\u265E";
	}

	public ArrayList<Positionnement> deplacementOk(Positionnement init,Echiquier echiquier)
	{
		ArrayList<Positionnement> deplacementsPossibles = new ArrayList<Positionnement>();
		if (echiquier.getCase(init.getLigne()+2, init.getColonne()+1) != null)
			deplacementsPossibles.add(new Positionnement(init.getLigne()+2, init.getColonne()+1));
		
		if (echiquier.getCase(init.getLigne()+2, init.getColonne()-1) != null)
			deplacementsPossibles.add(new Positionnement(init.getLigne()+2, init.getColonne()-1));
		
		if (echiquier.getCase(init.getLigne()-2, init.getColonne()+1) != null)
			deplacementsPossibles.add(new Positionnement(init.getLigne()-2, init.getColonne()+1));
		
		if (echiquier.getCase(init.getLigne()-2, init.getColonne()-1) != null)
			deplacementsPossibles.add(new Positionnement(init.getLigne()-2, init.getColonne()-1));
		
		if (echiquier.getCase(init.getLigne()+1, init.getColonne()+2) != null)
			deplacementsPossibles.add(new Positionnement(init.getLigne()+1, init.getColonne()+2));
		
		if (echiquier.getCase(init.getLigne()-1, init.getColonne()+2) != null)
			deplacementsPossibles.add(new Positionnement(init.getLigne()-1, init.getColonne()+2));
		
		if (echiquier.getCase(init.getLigne()+1, init.getColonne()-2) != null)
			deplacementsPossibles.add(new Positionnement(init.getLigne()+1, init.getColonne()-2));
		
		if (echiquier.getCase(init.getLigne()-1, init.getColonne()-2) != null)
			deplacementsPossibles.add(new Positionnement(init.getLigne()-1, init.getColonne()-2));
		
		for (int i =0; i<deplacementsPossibles.size();i++)
		{
			if(echiquier.getCase(deplacementsPossibles.get(i).getLigne(), deplacementsPossibles.get(i).getColonne()).estVide(this.getCouleur())) deplacementsPossibles.remove(i);
		}
		return deplacementsPossibles;
	}
}
