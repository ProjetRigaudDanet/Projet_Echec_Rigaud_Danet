package Partie;

import Echiquier.Echiquier;
import Echiquier.Pieces;

public class Partie 
{
	private Echiquier echiquier;
	
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
	
	public void afficher(Echiquier echiquier)
	{
		System.out.print(" ");
		for(int i = 0; i<8;i++)
		{
			System.out.print(" "+(i+1));
		}
		System.out.print('\n');
		for(int i = 0; i<8;i++)
		{
			System.out.print((char)(i+65));
			for(int j=0;j<8;j++)
			{
				System.out.print("|");
				System.out.print(echiquier.getEchiquier()[i][j].toString());
			}
			System.out.print("|" + '\n');
		}
	}
	
	public void afficher(String message)
	{
		System.out.println(message);
	}
}
