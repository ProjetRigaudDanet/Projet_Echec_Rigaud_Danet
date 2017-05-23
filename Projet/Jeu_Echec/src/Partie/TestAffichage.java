package Partie;

import java.util.Scanner;

import Echiquier.Echiquier;

public class TestAffichage {

	public static void main(String[] args)
	{
		Echiquier echiquier = new Echiquier();
		Partie affichage = new Partie();
		
		echiquier.initialise();

		affichage.afficher(echiquier);
	}
}