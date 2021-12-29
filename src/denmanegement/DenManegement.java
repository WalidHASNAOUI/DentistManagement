
package denmanegement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DenManegement {

    public static void main(String[] args) 
    {
//        ResultSet rst = Patient.listPatient();
            String[][] data= {{"CIN","PA567888"},{"Nom","GOUMGHAR"},{"Prenom","SAID"},{"Email","said.goumghare@gmail.com"},{"Tel","0512999863"},{"Adresse","Agadir"},{"Sexe","Homme"}};
//            String[][] data1= {{"Date","2022-02-25"},{"id_serv","2"},{"h_rdv","11:20"}};
//        System.out.println(Patient.getAge(data));
//            Rendez_vous.addRDV(data,"2011-01-25","2022-12-25","19:30",1);
//               DossierMed.addDossierMed("PB333333");
//           Consultation.AddConsultation(1);
//           System.out.println(Rendez_vous.getidLastRDV());
//            Rendez_vous.deleteRDV(10);
//          Rendez_vous.modifyRDV(data1, 2);
//            Fournisseur.addFrn(data);
//                System.out.println(Fournisseur.isFournExist("PA567888"));
               Produit.addPrd("PA567888", "test", "5520.00", "5000.0");
//               System.out.println(Fournisseur.getIdByCinFourni("PA567888"));

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
