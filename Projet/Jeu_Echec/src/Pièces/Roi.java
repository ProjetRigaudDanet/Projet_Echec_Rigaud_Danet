package Pièces;

import Echiquier.Pieces;

public class Roi extends Pieces
{
	
	public Roi(String couleur)
	{
		this.nom="Roi";
		this.couleur=couleur;
	}
	
	public String toString()
	{
		if (this.couleur=="Blanc") return "\u2654";
		else return "\u265A";
	}
}
