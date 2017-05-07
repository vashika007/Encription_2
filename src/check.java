
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Raja
 */
public class check {
    private String full_path;

    public boolean check(String s3) {
        boolean n = false;
        // boolean n1=false;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
            PreparedStatement ps1 = con.prepareStatement("select * from files");
            ResultSet rs1 = ps1.executeQuery();
            System.out.println(rs1);
            Vector<String> v = new Vector<String>(8);
            //Vector<String>v1=new Vector<String>(8);
            String z = null;
            while (rs1.next()) {
                v.add(rs1.getString(2));
                // v1.add(rs1.getString(6
                z = v.toString();
                // 

            }
            System.out.println(z);
            //jTextArea2.setText(z);
            //jTextArea2.read(new FileReader(v.toString()),null);


            //System.out.println(v);//store file content in string
            //String ob ="raja";
            //  System.out.println(s3);
            //if (ob.equals(s3)) 
            for (int i = 0; i < v.size(); i++) {
                n = s3.equals(v.get(i));
                if (n == true) {
                    break;
                }


//            JOptionPane.showMessageDialog(null, "File allready save", "ERROR MESSAGE", 1);
//            break;}
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        return n;

    }

    public boolean check1(String full_path) {
        boolean n = false;
        try {

            File ob = new File(full_path.trim());
            System.out.print(ob.toString());
           // System.out.println("hllo sir");
            FileInputStream fis = null;
            fis = new FileInputStream(ob);
            String onn = fis.toString();
            String on = onn;
            int i;
            StringBuilder sb = new StringBuilder();
            System.out.println(fis.toString());
            while ((i = fis.read()) != -1) {

                System.out.print((char) i);
                sb.append((char) i);

                System.out.print(sb.toString());
            }
            fis.close();
            System.out.println(ob.toString());
            String b = sb.toString();// file content store



            //File ob = new File();
           // System.out.print(ob.toString());
//            FileInputStream fis = null;
//            fis = new FileInputStream(ob);
//            int i;
//            while ((i = fis.read()) != -1) {
//
//                System.out.println((char) i);
//            }
            fis.close();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
            PreparedStatement ps1 = con.prepareStatement("select * from files ");
            ResultSet rs1 = ps1.executeQuery();
            System.out.println(rs1);
            Vector<String> v = new Vector<String>(8);
            while (rs1.next()) {
                v.add(rs1.getString(3));
                String q = "v";
            }
            System.out.println(v);
            for (int j = 0; j < v.size(); j++) {
                n = b.equals(v.get(j));
                if (n == true) {
                    break;
                }
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return n;

    }
    public String fun(String full_path) throws FileNotFoundException, IOException
    {
        File ob = new File(full_path.trim());
            System.out.print(ob.toString());
           // System.out.println("hllo sir");
            FileInputStream fis = null;
            fis = new FileInputStream(ob);
            String onn = fis.toString();
            String on = onn;
            int i;
            StringBuilder sb = new StringBuilder();
            System.out.println(fis.toString());
            while ((i = fis.read()) != -1) {

                System.out.print((char) i);
                sb.append((char) i);

                System.out.print(sb.toString());
            }
            fis.close();
            System.out.println(ob.toString());
            String b = sb.toString();
            return b;
    }
}