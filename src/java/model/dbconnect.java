/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author IS Rachinthana
 */
public class dbconnect {
    public static Connection createConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mr_hr_db", "root", "");
        
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
   /* private void autoId()
     {
         try {
         String sql="SELECT id FROM AutoID ORDER BY id DESC LIMIT 1";        
         PreparedStatement  pst=createConnection().prepareStatement(sql);
         ResultSet rs=pst.executeQuery();
       if(rs.next())
       {
            String rnno=rs.getString("id");
            int co=rnno.length();
           String txt= rnno.substring(0, 2);
           String num=rnno.substring(2, co);
           int n=Integer.parseInt(num);
           n++;
           String snum=Integer.toString(n);
           String ftxt=txt+snum;
           txtautoid.setText(ftxt);

       }
       else
       {
           txtautoid.setText("MI1000");
       }


    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, e);
    }

}*/
   
    public boolean regUser(String uname,String email,String password) throws ClassNotFoundException,SQLException
    {
    PreparedStatement ps = createConnection().prepareStatement("insert into clientregistration values(?,?,?)");
    ps.setString(1,uname);
    ps.setString(2,email);
    ps.setString(3,password);
    int i= ps.executeUpdate();
    
    /*PreparedStatement ps1 = createConnection().prepareStatement("insert into userdetails values(?,?,?,?)");
    ps1.setString(1,uname);
    ps1.setString(2,fullname);
    ps1.setString(3,email);
    ps1.setString(4,password);
    int x= ps1.executeUpdate();*/
    
    if((i>0))
        return true;
    else
        return false;
    }
    
    
    
    
    
    
}
