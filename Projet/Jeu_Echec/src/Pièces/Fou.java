package Pièces;

import Echiquier.Pieces;

public class Fou extends Pieces
{
	public Fou(String couleur)
	{
		this.nom="Fou";
		this.couleur=couleur;
	}
	public String toString()
	{
		if (this.couleur=="Blanc") return "\u2657";
		else return "\u265F";
	}
}
