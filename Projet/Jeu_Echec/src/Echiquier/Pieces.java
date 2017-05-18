package Echiquier;

/*
	L'echiquier sera sous forme de tableau[x][y] donc les colonnes seront noté de A à H et les lignes de 1 à 8




*/
public abstract class Pieces {
	protected int x; //La coordonnée de la piece, num case/pos..
	protected int y;
	protected Joueur joueur; //Le jour dont a qui est le tour
	protected boolean coul_piece;//Blanc(1) ou noir(0)
	protected Piece p;

	public Pieces(type p, Joueur joueur)
	{
		this.p=p;
		this.joueur=joueur;
	} 
	public void setP(int x,int y)
	{


	}

	public type getP(type p)
	{
		return this.p;
	}

	public void setJoueur(Joueur joueur)
	{

	}

	public Joueur getJoueur(Joueur joueur)
	{
		return this.joueur;
	}

	public void setCoul_piece(boolean coul_piece)
	{
		if(/*si J1*/)
		{
			coul_piece:=1;
		}
		if(/*si J2*/)
		{
			coul_piece:=0;
		}
	}

	public boolean getCoul_piece(boolean coul_piece)
	{
		return this.coul_piece;
	}

}

public class Pion extends Pieces { 
	Pieces pion;

	public Pion{

		//Constructeur
	}

	/*

		appel de la methode de deplacement



	*/

 }
public class Tour extends Piece { ... } 
public class Cavalier extends Piece { ... }
public class Fou extends Piece { ... }
public class Reine extends Piece { ... }
public class Roi extends Piece { ... }

public class DeplacementPiece(Joueur joueur, type p,/*la piece a vouloir bouger */){

	if(getCoul_piece())
	{
		if(/*tester le type de la piece*/)
		{
			if(/*si la piece est un pion tester si elle est sur sa ligne depart*/)
			{
				setPos_pion(/*si x=abscisse l'augmenter de 1 ou 2 en fonction de la position de la piece (ligne de depart ou non) et de l'envie du joueur*/);
			}

			/*
				Si c'est un fou, tester sur la diagonale ciblé si la case choisie est libre et si il n'y a pas d'autre piece sur la diagonale bloquant la ligne de vue
				
				/*
				 *  
				 *  
				 *  
				 * //Methode de deplacement d'une piece :
				 * 		string nc;
				 * 		int nl;
				 * 		{	
					 * 		while(!estVide(nc,nl))
					 * 		{
					 * 			nc=scanf(Nom_colonne);
				 * 				nl=scanf(Num_ligne);
					 * 		}
					 * 		//Appel de la methode de deplacement 
					 * 		Exemple : setPos_fou(nc,nl);
				 * 						{
					 * 						if(//Il faut verifier que le deplacement est bien en diagonale(que l'on deplace autant en ligne quand colonne)
					 * 							{if(Tester que les cases avant soit vide (sur la variable globale (methode estVide ?)
					 * 								{fou1.pos(nc,nl);}
					 * 							}
					 * 					}
						}
				 * 
				 * 
				 * 
				 * 
				 * 
				 * /
				
				Si c'est une tour, tester sur la ligne horizontale ou verticale selon le choix si la case ciblée est vide et si il n'y a pas d'obstacle

				Si c'est un cavalier tester si la case ciblé est vide et si elle respecte la règle s'appliquant aux cavaliers

				Si c'est un roi, tester la case choisie est vide et si elle fait bien partie des 8 autour de lui

				Si c'est une Reine utiliser la methode de deplacement de la tour combiné a la methode de deplacement du fou 

				


			*/
				
		}
	}



}
//Une des deux methodes ci-dessous
/*test si la case est vide*/public boolean estVide(nc,nl)
				{	
					/*
					 * Crée une variable (globale ?) pour les cases (une par case ?) qui sera initialisé a 0 la ou il n'y aura
					 * pas de pièce et 1 la ou il y en a une
					 * 
					 *	/!\ Ici il faudra tester la valeur de cette variable, renvoyer 1 si elle est != 0 sinon renvoyez 0
					 * 
					 * */
					
				}
public boolean class valeur_case(int x,int y)
{
	if(echiquier(x,y)/*tester si la valeur de la case non nul*/)
	{
		return 1;
	}
	return 0;
}