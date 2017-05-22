package Pièces;

import Echiquier.Pieces;

public class Cavalier extends Pieces
{
	public Cavalier(String couleur)
	{
		this.nom="Cavalier";
		this.couleur=couleur;
	}
	
	public String toString()
	{
		if (this.couleur=="Blanc") return "\u265E";
		else return "\u2658";
	}
}
