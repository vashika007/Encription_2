package PropertyLoaders;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SUNIL
 */
public class PropertyLoader {
    
    public static Properties getProperties(){
        
        Properties properties = null;
        try{
ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
InputStream input = classLoader.getResourceAsStream("application.properties");
// ...
 properties = new Properties();
properties.load(input);
        }catch(Exception e){
            e.printStackTrace();
        }
        return properties;
    }
    
    
   
    
}
