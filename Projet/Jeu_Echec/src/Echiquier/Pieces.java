package Echiquier;

import java.util.ArrayList;

public abstract class Pieces {
	
	protected String nom;
	protected String couleur;
	
	public abstract String toString();
	
	public abstract ArrayList<Positionnement> deplacementOk(Positionnement init,Echiquier echiquier);
	
    public Pieces(String couleur)
    {
    	this.couleur = couleur;
    }
	
	public String getNom()
	{	
		return this.nom;
	}
	
	public String getCouleur()
	{
		return this.couleur;
	}
	
	public String estOppose()
	{
		if (this.couleur=="Noir") return "Blanc";
		else return "Noir";
		
	}
}