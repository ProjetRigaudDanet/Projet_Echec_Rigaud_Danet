package Echiquier;

public abstract class Pieces {
	
	protected String nom;
	protected String couleur;

	public abstract String toString();
	
	public String getNom()
	{	
		return this.nom;
	}

	public String getCouleur()
	{
		return this.couleur;
	}
}