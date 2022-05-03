package upc.edu.dsa;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.ResourceBundle;

public class I18NManager {

    HashMap<String, ResourceBundle> datos;

    static final Logger logger = Logger.getLogger(I18NManager.class.getName());
    private static I18NManager manager;

    //Singleton
    public static I18NManager getInstance(){
        if(manager==null){
            manager= new I18NManager();
        }
        return manager;
    }

    private I18NManager() {
        this.datos = new HashMap<String, ResourceBundle>();
    }

    public String getText(String language, String line) {
        logger.info("Language: " + language + ", line: " + line);
        ResourceBundle rb = this.datos.get(language);
        if (rb == null) {
            logger.warn("Bundle '" + language + ".properties' does not exist");
            rb = ResourceBundle.getBundle(language);
            this.datos.put(language, rb);
            logger.info("Language bundle added");
        }
        else
            logger.info("Bundle already exists");
        return rb.getString(line);
    }

    public void clear() {
        this.datos.clear();
    }
}
