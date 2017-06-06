package Echiquier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Echiquier.Echiquier;
import Echiquier.Pieces;
import Echiquier.Positionnement;
import Pieces.Tour;

public class Affichage 
{
	private Echiquier echiquier;
	private Affichage afficher;
	
	public Affichage()
	{
		
	}
	
	public Affichage(Echiquier ech)
	{
		this.echiquier=ech;
	}
	
	public Echiquier getEchiquier()
	{
		return this.echiquier;
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
		
		System.out.println('\n');
	}
	
	public void afficher(String message)
	{
		System.out.println(message);
	}
	
	
	public boolean boolplacerPiece(int init, int finale) 
	{
		if(init>7)
		{
			System.out.println("Erreur dans la coordonnée sur l'axe des abscisses : \n" + "Ligne : " + init + '\n');
			return false;
		}
		if(finale>7)
		{
			System.out.println("Erreur dans la coordonnée sur l'axe des ordonnée : \n" + "Colonne : " + finale + '\n');
			return false;
		}
		return true;
	}
	
	public Positionnement PositionInit()
	{
		Scanner sc = new Scanner(System.in);
		String str;
		String sa = "sa";
		int i=0,j=0;
		do{
			afficher("Saisir une position départ:");
			str = sc.nextLine();
	
			i = ((int) str.charAt(0)) - 65;
	
			j = (int) str.charAt(1)-49; 
		}while(str.length()>2);
		
		if (i == 50 && j == 48) return new Positionnement(-1,-1); // sa = sauvegarder
		else if (i == 34 && j == 55) return new Positionnement(-2,-2); // ch = charger
		else return new Positionnement(i,j);
		
	}
	
	public Positionnement PositionFinale() 
	{
		Scanner sc = new Scanner(System.in);
		String str;
		int i,j;

			do{
				afficher("Saisir une position d'arrivée:");
				str = sc.nextLine();
			
				i = ((int) str.charAt(0)) - 65;
				j = (int) str.charAt(1)-49; 
			}while(str.length()>2);
			return new Positionnement(i,j); 		
	}
}