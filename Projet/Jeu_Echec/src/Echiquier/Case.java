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
		return (this.pieces==null);
	}
	
	public boolean estVide(String couleur)
	{
		if (this.pieces == null) return false;
		return(this.pieces.getCouleur() == couleur);
	}
	
	public String toString()
	{
		if (estVide()) return "_";
		return this.getPieces().toString();
	}
}
