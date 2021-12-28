/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package denmanegement;

import DB.DBConnection;

public class Personne 
{
    public static void addPersonne(String[][] data)
    {
        //create query
        String query = "insert into `personne` (";
        for(int i=0 ; i<data.length ; i++)
        {
            if(i == 0)
                query += data[0][0];
            else if (i == data.length-1)
                query += "," + data[i][0] + ")";
            else 
                query += "," + data[i][0];
        }
        
        query += " values(";
        for(int i=0 ; i<data.length ; i++)
        {
            if(i == data.length-1)
            {
                if(data[i][0] == "Tel")
                       query += Integer.parseInt(data[i][1])+")";
                else 
                    query += "'"+data[i][1]+"')";
            }
            else{
                if(data[i][0] == "Tel")
                       query += Integer.parseInt(data[i][1])+",";
                else 
                    query += "'"+data[i][1]+"',";
            }   
        }
        
        //execute query by calling add method of DBConnection class
        DBConnection.add(query);
      System.out.println(query);
    }
}
