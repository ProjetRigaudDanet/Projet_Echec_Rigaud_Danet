package Echiquier;

import Partie.Partie;
import Pieces.Cavalier;
import Pieces.Dame;
import Pieces.Fou;
import Pieces.Pion;
import Pieces.Roi;
import Pieces.Tour;

public class Echiquier 
{
	private Case[][] echiquier;
	private Partie partie;
	
	public Echiquier()
	{
		echiquier = new Case[8][8];
		for(int i=0;i<echiquier.length;i++)
		{
			for(int j=0; j<8; j++)
			{
				echiquier[i][j] = new Case();
			}
		}
	}
	
	public Case[][] getEchiquier()
	{
		return this.echiquier;
	}
	
	
	public Echiquier(Partie partie)
	{
		this.partie=partie;
	}
	
	public void initialise()
	{
		
		for(int i = 0 ; i < 8;i++)
		{	
			echiquier[1][i].setPieces(new Pion("Noir"));
			echiquier[6][i].setPieces(new Pion("Blanc"));
		}
	
		echiquier[7][0].setPieces(new Tour("Blanc"));
		echiquier[7][1].setPieces(new Cavalier("Blanc"));
		echiquier[7][2].setPieces(new Fou("Blanc"));
		echiquier[7][3].setPieces(new Roi("Blanc"));
		echiquier[7][4].setPieces(new Dame("Blanc"));
		echiquier[7][5].setPieces(new Fou("Blanc"));
		echiquier[7][6].setPieces(new Cavalier("Blanc"));
		echiquier[7][7].setPieces(new Tour("Blanc"));
		
		echiquier[0][0].setPieces(new Tour("Noir"));
		echiquier[0][1].setPieces(new Cavalier("Noir"));
		echiquier[0][2].setPieces(new Fou("Noir"));
		echiquier[0][3].setPieces(new Roi("Noir"));
		echiquier[0][4].setPieces(new Dame("Noir"));
		echiquier[0][5].setPieces(new Fou("Noir"));
		echiquier[0][6].setPieces(new Cavalier("Noir"));
		echiquier[0][7].setPieces(new Tour("Noir"));
		
	}
	
	
	public Pieces getPieces(Positionnement positionnement)
	{
		return this.echiquier[positionnement.getLigne()][positionnement.getColonne()].getPieces();
	}
		
	public void setPieces(Pieces piece,Positionnement positionnement)
	{
		this.echiquier[positionnement.getLigne()][positionnement.getColonne()].setPieces(piece);
	}
	
	public Case getCase(int ligne,int colonne)
	{
		if(ligne<8 && ligne>=0 && colonne<8 && colonne>=0 )
		{
		return echiquier[ligne][colonne];
		}
		return null;
	}
	
	public boolean conditionOk(Positionnement init,Positionnement finale)
	{
		if(init.getCase(this) != null && finale.getCase(this) != null)
				if(
				(init.getLigne() >= 0 && init.getLigne() <= 7)
				&&
				(init.getColonne() >= 0 && init.getColonne() <= 7)
				&&
				(finale.getLigne() >= 0 && finale.getLigne() <= 7)
				&&
				(finale.getColonne() >= 0 && finale.getColonne() <= 7)
				)
					if(init.getCase(this).getPieces().deplacementOk(init, this).contains(finale))
						return true;
		
		return false;
	}
	
	public void Deplacement()
	{
		
		Positionnement posInit;
		Positionnement posFinal;
		Partie  s;
		do{
		s = new Partie();
		 posInit = s.PositionInit();
		 posFinal = s.PositionFinale();
		
		}while(!conditionOk(posInit,posFinal));
		
		
		this.setPieces(getPieces(posInit),posFinal);
		this.setPieces(null, posInit);
	}
	
}
