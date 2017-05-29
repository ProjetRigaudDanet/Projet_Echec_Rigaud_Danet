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
	
	public Pieces getPiece(Positionnement position,Echiquier echiquier)
	{
		return echiquier.getPieces(position);
	}
	
	public boolean equals(Object o)
	
	{
		Positionnement c = (Positionnement) o;
	
			return (this.ligne==c.ligne && this.colonne==c.colonne);

	}
	
	public Case getCase(Echiquier echiquier)
	{
		if(ligne<8 && ligne>=0 && colonne<8 && colonne>=0)
		{
		return echiquier.getCase(this.ligne,this.colonne);
		}
		else return null;
	}
	
	public String toString()
	{
		return "" + this.ligne + this.colonne;
	}
}