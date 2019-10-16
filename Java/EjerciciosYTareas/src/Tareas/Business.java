/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Tareas;

import org.json.simple.JSONObject;

public class Business implements Comparable<Business>{
    private String business_id;
    public Business(JSONObject objeto){
        business_id = (String) objeto.get("business_id");
    }//builder

    @Override
    public int compareTo(Business o) {
       return business_id.compareToIgnoreCase(o.business_id); 
    }//method
    
    public String toString(){
        return business_id;
    }//method
    
    
}//class
