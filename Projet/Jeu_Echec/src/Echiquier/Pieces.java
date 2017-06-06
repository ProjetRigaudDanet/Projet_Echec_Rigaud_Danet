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
	
	public boolean estEchec(Positionnement init, Echiquier e){ 
		
		ArrayList<Positionnement> liste = new ArrayList<Positionnement>();
		
		for(int x = 0 ; x < 8;x++)
		{
			for(int y = 0 ; y < 8;y++)
			{
				if(e.getCase(x, y).estVide(this.estOppose()))
				{
					Pieces p = e.getCase(x,y).getPieces();
					Positionnement posP = new Positionnement(x,y);
					
					for (int i =0; i < p.deplacementOk(posP, e).size();i++)
					{
						liste.add(p.deplacementOk(posP, e).get(i));
					}
				}
			}
			
		}
		if (liste.contains(init)) {//System.out.println("Echec");
			return true;}
		
		//System.out.println("Pas Echec");
		return false;
	}

}