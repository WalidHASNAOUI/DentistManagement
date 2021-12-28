/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package denmanegement;

import DB.DBConnection;

public class Rendez_vous 
{
    public static void addRDV(String[][] data,String Date_nais, String Date_rdv,String Heur_rdv,int serv_id)
    {
        if(!Patient.isPatientExist(Patient.getCIN(data)))
            Patient.addPatient(data, Date_nais);
        String query = "insert into `rendez_vous` (`CIN_patient`,`Date`,`h_rdv`,`id_serv`) values('"+Patient.getCIN(data)+"','"+Date_rdv+"','"+Heur_rdv+"',"+serv_id+")";
        DBConnection.add(query);
        Consultation.AddConsultation(Rendez_vous.getidLastRDV());
    }
    
    public static void deleteRDV(int id_rdv)
    {
        //Deleting Consultation of this <RDV>
        Consultation.DeleteConsultation(id_rdv);
        
        //Deleting <RDV>
        String query = "delete from `rendez_vous` where id_rdv = "+id_rdv;
        DBConnection.delete(query);
    }
    
    public static void modifyRDV(String[][] data, int id_rdv)
    {
        String query = "update `rendez_vous` set ";
        for(int i=0 ; i<data.length ; i++)
        {
            if(i==data.length-1){
                if(!data[i][0].equals("id_serv"))
                    query += "`"+data[i][0]+"`='"+data[i][1]+"' ";
                else   
                    query += "`"+data[i][0]+"`="+Integer.parseInt(data[i][1]);
            }else{
                if(!data[i][0].equals("id_serv"))
                    query += "`"+data[i][0]+"`='"+data[i][1]+"',";
                else
                    query += "`"+data[i][0]+"`="+Integer.parseInt(data[i][1])+",";
            }
        }
        
        query += "where id_rdv="+id_rdv;
        DBConnection.modify(query);
//        System.out.println(query);
    }
    
    public static int getidLastRDV()
    {
        // don't forget the mangement of error it rdv do not exist
        String query = "select max(`id_rdv`) as maxId from `rendez_vous`";
        int maxId = DBConnection.executeIntQuery(query);
        return maxId;
    }
}
