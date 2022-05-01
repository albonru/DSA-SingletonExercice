package upc.edu.dsa;

import org.apache.log4j.Logger;

public class I18NManager {

    static final Logger logger = Logger.getLogger(I18NManager.class.getName());
    private static I18NManager manager;

    //Singleton
    public static I18NManager getInstance(){
        if(manager==null){
            manager= new I18NManager();
        }
        return manager;
    }

    private I18NManager() {}

    public String getText(String p1, String p2) {
        switch(p1) {
            case "ca":
                if(p2.equals("l1")) {
                    return "hola";
                }
                else if(p2.equals("l2")) {
                    return "adéu";
                }
                break;
            case "es":
                if (p2.equals("l2")) {
                    return "adós";
                }
                break;
            case "it":
                if (p2.equals("l1")) {
                    return "Chao";
                }
                break;
            case "pt":
                if(p2.equals("l2")) {
                    return "obrigado";
                }
            default:
                logger.info("Error en los datos");
        }
        return null;
    }

    public void clear() {

    }
}
