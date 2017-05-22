package Pièces;

import Echiquier.Pieces;

public class Dame extends Pieces
{
	public Dame(String couleur)
	{
		this.nom="Dame";
		this.couleur=couleur;
	}
	
	public String toString()
	{
		if (this.couleur=="Blanc") return "\u2655";
		else return "\u265B";
	}
}
