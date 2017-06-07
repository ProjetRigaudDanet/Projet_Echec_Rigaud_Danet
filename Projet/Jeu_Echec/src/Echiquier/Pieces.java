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
	
	public boolean estEchec(Positionnement init, Echiquier echiquier){ 
		
		ArrayList<Positionnement> liste = new ArrayList<Positionnement>();
		
		for(int x = 0 ; x < 8;x++)
		{
			for(int y = 0 ; y < 8;y++)
			{
				if(echiquier.getCase(x, y).estVide(this.estOppose()))
				{
					Pieces p = echiquier.getCase(x,y).getPieces();
					Positionnement posP = new Positionnement(x,y);
					
					for (int i =0; i < p.deplacementOk(posP, echiquier).size();i++)
					{
						liste.add(p.deplacementOk(posP, echiquier).get(i));
					}
				}
			}
			
		}
		if (liste.contains(init)) {
			return true;}
		return false;
	}

}