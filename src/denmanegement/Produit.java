
package denmanegement;

import DB.DBConnection;

public class Produit 
{
    public static void addPrd(String cin_four, String Design, String prix_ttc, String prix_ht)
    {
        if(Fournisseur.isFournExist(cin_four))
        {
            String query = "insert into `produit` (`id_fourni`,`Designation`,`Prix_ttc`,`Prix_ht`) values('"+Fournisseur.getIdByCinFourni(cin_four)+"','"+Design+"',"+Double.parseDouble(prix_ttc)+","+Double.parseDouble(prix_ht)+")";         
            System.out.println(query);
            DBConnection.add(query);
        }else {
            System.err.println("Error Supplier do not existe !!");
        }
    }
}
