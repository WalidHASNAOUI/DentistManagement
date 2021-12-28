
package denmanegement;

import DB.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DossierMed 
{
    public static void addDossierMed(String CIN)
    {
        String query = "insert into `dossier_medical` (CIN_patient) values('"+CIN+"')";
        System.out.println(query);
        DBConnection.add(query);
    }
    
    public static int addDossierMedReturn(String CIN)
    {
        int noDossier = 0;
        String query = "insert into `dossier_medical` (CIN_patient) values('"+CIN+"')";
        DBConnection.add(query);
        query = "select `Num_Dossier` from dossier_medical where CIN_patient ='"+CIN+"'";
        ResultSet rst = DBConnection.search(query);
        try{
            noDossier = rst.getInt("Num_Dossier");
        }catch(SQLException e){
            e.getMessage();
        }
        return noDossier;
    }
}
