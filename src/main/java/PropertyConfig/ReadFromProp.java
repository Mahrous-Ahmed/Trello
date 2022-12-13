package PropertyConfig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProp {
    static Properties props = new Properties();
    static FileInputStream FIS;

    public static void setUp (){
        try {

            FIS = new FileInputStream(System.getProperty("user.dir") + "/Properties/Trello.property");
            props.load(FIS);
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    public static String getProperty(String key) {
        try{
            setUp();
            return props.getProperty(key).trim();

        }catch (Exception e){
            System.out.println("No such element contain that key");
        }


        return null;
    }

    public static void setProperty(String key , String value) {
        try{
            FIS = new FileInputStream(System.getProperty("user.dir") + "/Properties/Trello.property");
            FileOutputStream FOS = new FileOutputStream(System.getProperty("user.dir") + "/Properties/Trello.property");
            props.load(FIS);
            props.setProperty(key , value);
            props.store(FOS , "Saved");
        }catch (Exception e){
            System.out.println(e);
        }



    }

}
