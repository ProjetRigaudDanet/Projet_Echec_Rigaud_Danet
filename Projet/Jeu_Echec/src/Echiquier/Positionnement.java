package Echiquier;

public class Positionnement {
	
	private int ligne;
	private int colonne;
	
	public Positionnement()
	{
	}
	
	public Positionnement(int ligne,int colonne)
	{
		this.setLigne(ligne);
		this.setColonne(colonne);
	}

	public int getColonne() {
		return this.colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public int getLigne() {
		return this.ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}
	
	public Pieces getPieces(Positionnement positionnement,Echiquier echiquier)
	{
		return echiquier.getPieces(positionnement);
	}
	
	public String toString()
	{
		return "" + this.ligne + this.colonne;
	}
}