package Pièces;

import Echiquier.Pieces;

public class Pion extends Pieces
{
	public Pion(String couleur)
	{
		this.nom="Pion";
		this.couleur=couleur;
	}
	
	public String toString()
	{
		if (this.couleur=="Blanc") return "\u2659";
		else return "\u265F";
	}
}	
