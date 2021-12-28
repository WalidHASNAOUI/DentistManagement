package denmanegement;

import DB.DBConnection;

public class Consultation 
{
    public static void AddConsultation(int rdv)
    {
        String query = "insert into `consultation` (id_rdv) values ("+rdv+")";
        DBConnection.add(query);
    }
    
    public static void DeleteConsultation(int id_rdv)
    {
        String query = "delete from `consultation` where id_rdv = "+id_rdv;
        DBConnection.delete(query);
    }
}
