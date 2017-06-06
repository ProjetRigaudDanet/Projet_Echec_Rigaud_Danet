package Pieces;

import java.util.ArrayList;

import Echiquier.Echiquier;
import Echiquier.Pieces;
import Echiquier.Positionnement;

public class Roi extends Pieces
{
	
	public Roi(String couleur)
	{
		super(couleur);
		this.nom="Roi";
		this.couleur=couleur;
	}
	
	public String toString()
	{
		if (this.couleur=="Blanc") return "\u2654";
		else return "\u265A";
	}

	@Override
	public ArrayList<Positionnement> deplacementOk(Positionnement init, Echiquier echiquier) {
		ArrayList<Positionnement> deplacementsPossibles = new ArrayList<Positionnement>();
		if (echiquier.getCase(init.getLigne()+1, init.getColonne()+1) != null && echiquier.getCase(init.getLigne()+1, init.getColonne()+1).estVide(this.couleur)==false)
			deplacementsPossibles.add(new Positionnement(init.getLigne()+1, init.getColonne()+1));
		
		if (echiquier.getCase(init.getLigne()+1, init.getColonne()-1) != null && echiquier.getCase(init.getLigne()+1, init.getColonne()-1).estVide(this.couleur)==false)
			deplacementsPossibles.add(new Positionnement(init.getLigne()+1, init.getColonne()-1));
		
		if (echiquier.getCase(init.getLigne()-1, init.getColonne()+1) != null && echiquier.getCase(init.getLigne()-1, init.getColonne()+1).estVide(this.couleur)==false)
			deplacementsPossibles.add(new Positionnement(init.getLigne()-1, init.getColonne()+1));
		
		if (echiquier.getCase(init.getLigne()-1, init.getColonne()-1) != null && echiquier.getCase(init.getLigne()-1, init.getColonne()-1).estVide(this.couleur)==false)
			deplacementsPossibles.add(new Positionnement(init.getLigne()-1, init.getColonne()-1));
		
		if (echiquier.getCase(init.getLigne()+1, init.getColonne()) != null && echiquier.getCase(init.getLigne()+1, init.getColonne()).estVide(this.couleur)==false)
			deplacementsPossibles.add(new Positionnement(init.getLigne()+1, init.getColonne()));
		
		if (echiquier.getCase(init.getLigne()-1, init.getColonne()) != null && echiquier.getCase(init.getLigne()-1, init.getColonne()).estVide(this.couleur)==false)
			deplacementsPossibles.add(new Positionnement(init.getLigne()-1, init.getColonne()));
		
		if (echiquier.getCase(init.getLigne(), init.getColonne()+1) != null && echiquier.getCase(init.getLigne(), init.getColonne()+1).estVide(this.couleur)==false)
			deplacementsPossibles.add(new Positionnement(init.getLigne(), init.getColonne()+1));
		
		if (echiquier.getCase(init.getLigne(), init.getColonne()-1) != null && echiquier.getCase(init.getLigne(), init.getColonne()-1).estVide(this.couleur)==false)
			deplacementsPossibles.add(new Positionnement(init.getLigne(), init.getColonne()-1));
		
		return deplacementsPossibles;
	}
}
