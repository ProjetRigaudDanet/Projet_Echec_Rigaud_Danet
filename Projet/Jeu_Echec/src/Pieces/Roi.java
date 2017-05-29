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
		// TODO Auto-generated method stub
		return null;
	}
}
