package Partie;

import Echiquier.Pieces;

public class Partie 
{
	
	public Partie()
	{
		
	}
	
	public boolean boolplacerPiece(int x, int y) 
	{
		if(x<0 || x>7)
		{
			System.out.println("Erreur dans la coordonnée sur l'axe des abscisses : \n" + "Ligne : " + x + '\n' + "Colonne : " + y + '\n');
			return false;
		}
		if(y<0 || y>7)
		{
			System.out.println("Erreur dans la coordonnée sur l'axe des ordonnée : \n" + "Ligne : " + x + '\n' + "Colonne : " + y + '\n');
			return false;
		}
		return true;
	}
}
