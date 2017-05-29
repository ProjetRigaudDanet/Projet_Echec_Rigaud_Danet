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

	@Override
	public ArrayList<Positionnement> deplacementOk(Positionnement init, Echiquier echiquier) {
		// TODO Auto-generated method stub
		return null;
	}
}
