package denmanegement;

import DB.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Patient 
{
    public static void addPatient(String[][] data, String Date_nais)
    {
        Personne.addPersonne(data);
        String query = "insert into `patient` (CIN_pat,age,Date_Naiss) values('"+Patient.getCIN(data)+"',TIMESTAMPDIFF(YEAR, STR_TO_DATE('"+Date_nais+"','%Y-%m-%d'),CURDATE()),'"+Date_nais+"')";       
        DBConnection.add(query);
        System.out.println(query);
        DossierMed.addDossierMed(Patient.getCIN(data));
    }
    
    public static void deletePatient(String query)
    {
        DBConnection.delete(query);
    }
    
    public static ResultSet listPatient()
    {
        return DBConnection.list("personne");
    }
    
    public static ResultSet searchPatient(String[][] data)
    {
        //Construction du requete
         String query = "SELECT * FROM `personne` WHERE ";
         
         for(int i=0 ; i<data.length ; ++i)
         {
             if(i == 0)
                 query += data[0][0] + "=" + "'"+data[0][1]+"'";
             else {
                 query += " AND " + data[i][0] + "=" + "'"+data[i][1]+"'";
             }
         }
         //Appler la fonction <DBConnection> 
         return DBConnection.search(query);
    }
    
    
    //getters
    public static String getCIN(String[][] data)
    {
        String cin = "";
        for(String[] e : data)
           if(e[0].equals("CIN")){
               cin = e[1];
               break;
           }
        
        return cin;
    }
    
    public static int getAge(String[][] data)
    {
        int age = 0; 
        for(String[]e : data)
        {
            if(e[0].equals("age"))
            {
                age = Integer.parseInt(e[1]); // because age strored as string in data <array>
                break;
            }
        }
        return age;
    }
    
    //Checking if patient exist or not 
    public static boolean isPatientExist(String CIN)
    {
        boolean status = false;
        //list all patient cin exists on db
        String query = "select CIN_pat from `patient`";
        ResultSet rst = DBConnection.search(query);
        
        try{
            while(rst.next())
                if(rst.getString("CIN_pat").equals(CIN))
                {
                    status = true;
                    break;
                }
        }catch(SQLException e){
            System.out.println("Error !!!");
        }
        return status;
    }
}
