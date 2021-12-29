
package denmanegement;

import DB.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fournisseur 
{    
    public static void addFrn(String[][] data)
    {
        //add supliere as person
        Personne.addPersonne(data);
        
        //Adding this person as supliere (Fournisseur)
        String query = "insert into `fournisseur` (CIN_fourni) values ('"+Patient.getCIN(data)+"')";
        DBConnection.add(query);
    }
    
    public static boolean isFournExist(String cin_four)
    { 
       boolean isExiste = false;
       String query = "select `CIN_fourni` from `fournisseur`";
       ResultSet rst = DBConnection.search(query);
        try {
            while(rst.next())
                if(rst.getString("CIN_fourni").equals(cin_four)){
                    isExiste = true;
                    break;
                }
        }catch(SQLException ex) {
           System.out.println("Errror isFournExiste !!" + ex.getMessage());
        }
       return isExiste;
    }
    
    public static int getIdByCinFourni(String cin_fourn)
    {
        String query = "select `id_fourni` from `fournisseur` where `CIN_fourni`='"+cin_fourn+"'";
        ResultSet rst = DBConnection.search(query);
        int id_fourni = 0;
        try{
            rst.next();
            id_fourni = rst.getInt("id_fourni");
        }catch(SQLException e) {
            System.err.println("Error to get id_fourni by cin_fourni !! ::>" + e.getMessage());
        }
        return id_fourni;
    }
}
