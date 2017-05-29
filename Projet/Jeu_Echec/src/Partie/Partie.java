package Partie;

import java.util.Scanner;

import Echiquier.Echiquier;
import Echiquier.Pieces;
import Echiquier.Positionnement;
import Pieces.Tour;

public class Partie 
{
	private Echiquier echiquier;
	
	public Partie()
	{
		
	}
	
	public Partie(Echiquier ech)
	{
		this.echiquier=ech;
	}
	
	public Echiquier getEchiquier()
	{
		return this.echiquier;
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
	
	public Positionnement PositionInit()
	{
		Scanner sc = new Scanner(System.in);
		String str;
		int i,j;
	
		System.out.println("Saisir une position départ:");
		str = sc.nextLine();
	
		i = ((int) str.charAt(0)) - 65;
	
		j = (int) str.charAt(1)-49; 

		
		return new Positionnement(i,j);
		
	}
	
	public Positionnement PositionFinale() 
	{
		Scanner sc = new Scanner(System.in);
		String str;
		int i,j;
			
				System.out.println("Saisir une position d'arrivés:");
				str = sc.nextLine();
			
				i = ((int) str.charAt(0)) - 65;
				j = (int) str.charAt(1)-49; 
			
			return new Positionnement(i,j);
	
		 		
	}
	
	public static void main(String[] args)
	{
		Echiquier echiquier = new Echiquier();
		Partie affichage = new Partie();
		int i = 0;

		echiquier.initialise();
		
		while(i<7)
		{
				affichage.afficher(echiquier);
				echiquier.Deplacement();
				i++;
				
		}
		
	}
	
}
