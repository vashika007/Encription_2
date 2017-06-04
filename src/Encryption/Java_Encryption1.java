/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Encryption;

//import com.mysql.jdbc.*;
import PropertyLoaders.PropertyLoader;
import java.sql.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.servlet.ServletContext;
import java.lang.UnsupportedOperationException;   
import java.security.Key;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import sun.misc.BASE64Decoder;



/**
 *
 * @author jemi java
 */
public class Java_Encryption1 {
  public static void main(String[] args)  {  
   
  }
  
  public void fun(String p,String n,String f,String u,String key)
  {
      //ServletContext s1=setServletContext();
      //String path=(String)s1.getAttribute("FPath");
      //String name=(String)s1.getAttribute("FName");
      
      Statement   st;
       try {
           
                        String path=p;
                        String fname=n;
                        String full_path=path+""+fname;
                         String content=u;
                          String s="Not Set";
                            String ss="Null",usn="Admin";  
//Folder changes 2 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                           
                        //String out_put_path="C:/Cloud_Project/"+n;
                            Properties properties = PropertyLoader.getProperties();
                            String uploadPaaht = properties.getProperty("uploadpath");
                        String out_put_path=uploadPaaht+n;
 //MODIFICATION 1                    
//                        String out_put_path1="C:/uploaded/"+n;
//MODIFICATION 1
//Folder changes 2 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                           
                             
 //MODIFICATION 1...         
                           
		//	String key = "squirrel123"; // needs to be at least 8 characters for DES
//                        FileInputStream fis1 = new FileInputStream(full_path);
//			FileOutputStream fos1 = new FileOutputStream(out_put_path1);
//			encrypt(key, fis1, fos1);
                        
 //MODIFICATION 1 END...                       

			FileInputStream fis = new FileInputStream(full_path);
			FileOutputStream fos = new FileOutputStream(out_put_path);
			encrypt(key, fis, fos);
                        
   
                        //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        //java.sql.Connection con = DriverManager.getConnection("jdbc:odbc:PSE");
//MODIFICATION 1 )...    	
                        Calendar currentDate=Calendar.getInstance();
SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
String das=formatter.format(currentDate.getTime());
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://172.30.96.167:3306/decentralize", "admin", "admin");
 //MODIFICATION 1 (END)...               

                    String qry = "Insert into files values('" + (out_put_path.trim()) + "','"+ (fname.trim()) + "','"+content+"','"+usn+"','"+das+"','"+s+"','"+ss+"','verified')";
                     st =con.createStatement();
                     st.execute(qry);
                       // if(r==0)
                        {
                            
                        }

			//FileInputStream fis2 = new FileInputStream("C:\\Users\\jemi java\\Desktop\\upload\\a1.txt");
			//FileOutputStream fos2 = new FileOutputStream("C:\\Users\\jemi java\\Desktop\\upload\\a2.txt");
			//decrypt(key, fis2, fos2);
		} catch (Throwable e) {
                    System.out.println(e);
			e.printStackTrace();
		}
  }
  	public static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
	}

	public static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
	}
        
//        public static void enryptAES(String keyValue,int mode,InputStream is,OutputStream os) throws Exception{
//              Key key = generateKey(keyValue);
//        Cipher c = Cipher.getInstance("AES");
//        c.init(Cipher.ENCRYPT_MODE, key);
//        byte[] encVal = c.doFinal(is);
//        String encryptedValue = new BASE64Encoder().encode(encVal);
//        return encryptedValue;
//        //return decryptedValue;
//        }
//        
//        private static Key generateKey(String keyValue) throws Exception {
//        Key key = new SecretKeySpec(keyValue.getBytes(), "AES");
//        return key;
//        }

	public static void encryptOrDecrypt(String keyValue, int mode, InputStream is, OutputStream os) throws Throwable {

            System.out.println("key ---------------- "+ keyValue);
//		DESKeySpec dks = new DESKeySpec(key.getBytes());
//		SecretKeyFactory skf = SecretKeyFactory.getInstance("AES");
//		SecretKey desKey = skf.generateSecret(dks);
                Key key = new SecretKeySpec(keyValue.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES"); // DES/ECB/PKCS5Padding for SunJCE

		if (mode == Cipher.ENCRYPT_MODE) {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			CipherInputStream cis = new CipherInputStream(is, cipher);
			doCopy(cis, os);
		} else if (mode == Cipher.DECRYPT_MODE) {
			cipher.init(Cipher.DECRYPT_MODE, key);
			CipherOutputStream cos = new CipherOutputStream(os, cipher);
			doCopy(is, cos);
		}
	}
	public static void doCopy(InputStream is, OutputStream os) throws IOException {
		byte[] bytes = new byte[64];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
		os.flush();
		os.close();
		is.close();
	}

    
}
