
package denmanegement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DenManegement {

    public static void main(String[] args) 
    {
//        ResultSet rst = Patient.listPatient();
            String[][] data= {{"CIN","Q195349"},{"Nom","HASNAOUI"},{"Prenom","YAHYA"},{"Email","yahya@gmail.com"},{"Tel","0712099863"},{"Adresse","zagora, Rue tanger7"},{"Sexe","Homme"}};
            String[][] data1= {{"Date","2022-02-25"},{"id_serv","2"},{"h_rdv","11:20"}};
//        System.out.println(Patient.getAge(data));
//            Rendez_vous.addRDV(data,"2008-01-25","2022-01-25","16:30",1);
//               DossierMed.addDossierMed("PB333333");
//           Consultation.AddConsultation(1);
//           System.out.println(Rendez_vous.getidLastRDV());
//            Rendez_vous.deleteRDV(10);
          Rendez_vous.modifyRDV(data1, 2);

    }
    
//    public static void displayPatient(ResultSet temp)
//    {
//       try{
//           while(temp.next())
//               System.out.println("-->" + temp.getString("CIN") + " - " + temp.getString("Nom") + " - "+temp.getString("Prenom") + "\t|");
//       }catch(SQLException e){
//           System.out.println("Not data found !!");
//       }
//               
//    }
}
