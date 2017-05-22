package Pièces;

import Echiquier.Pieces;

public class Tour extends Pieces
{
	public Tour(String couleur)
	{
		this.nom="Tour";
		this.couleur=couleur;
	}
	
	public String toString()
	{
		if (this.couleur=="Blanc") return "\u265C";
		else return "\u2656";
	}
}
