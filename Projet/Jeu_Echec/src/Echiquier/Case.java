package Echiquier;

public class Case 
{
	private Pieces pieces;
	
	public Case()
	{
		this.pieces=null;
	}
	
	public Case(Pieces pieces)
	{
		this.pieces=pieces;
	}
	
	public Pieces getPieces()
	{
		return this.pieces;
	}
	
	public void setPieces(Pieces pieces)
	{
		this.pieces = pieces;
	}
	
	public boolean estVide()
	{
		if(this.pieces==null)
		{
			return false;
		}
		return true;
	}
	
	public boolean occupé(String couleur)
	{
		if (this.pieces == null) return false;
		return(this.pieces.getCouleur() == couleur);
	}
	
	public String toString()
	{
		if (estVide()) return "0";
		return this.getPieces().toString();
	}
}
