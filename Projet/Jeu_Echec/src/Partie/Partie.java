package Partie;

import Echiquier.Affichage;
import Echiquier.Echiquier;

public class Partie {
	private Echiquier echiquier;
	private Affichage affichage;
	private boolean Tourdesblancs;
	
	public Partie(){
		this.echiquier = new Echiquier();
		this.affichage = new Affichage();
		this.Tourdesblancs = true;
		echiquier.initialise();
		affichage.afficher(echiquier);
	}
	
	public void TourJeu(){
		int verif;
		if (Tourdesblancs)
		{
			do{
				affichage.afficher("\nAu tour des blancs !");
				echiquier.echecRoi();
				verif = echiquier.Deplacement("Blanc",Tourdesblancs);
				if (verif == -2) return;
				else if (verif == -3)
				{
					Tourdesblancs = false;
					return;
				}
			}while (verif != 1);
			Tourdesblancs = false;
		}
		else
		{
			do{
				affichage.afficher("\nAu tour des noirs !");
				echiquier.echecRoi();
				verif = echiquier.Deplacement("Noir",Tourdesblancs);
				if (verif == -3) return;
				else if (verif == -2)
				{
					Tourdesblancs = true;
					return;
				}
			}while (verif != 1);
			Tourdesblancs = true;
		}
	}
	
	public void jeu(){
		do{
			TourJeu();
			affichage.afficher(echiquier);
			if((echiquier.echecRoi() != null)) affichage.afficher("Echec");
		}while (echiquier.Mat() == false);
	}	
	
}