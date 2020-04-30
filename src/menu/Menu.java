
package menu;

import copiaDeSeguridad.CopiaSeguridad;
import java.io.File;


public class Menu {
    
    
    
    public static void main(String[] args) {
        
        String usuario = System.getProperty("user.name"); //consigo el nombre de usuario mediante una variable del sistema
        String rutaCopia =  "C:"+ File.separator+ "Users" + File.separator +usuario + File.separator + "Pictures";
        String rutaDestino = "C:"+ File.separator+ "Users" + File.separator +usuario + File.separator + "Desktop" + File.separator +" BackupImagenes";             
        
        CopiaSeguridad copia = new CopiaSeguridad(rutaCopia,rutaDestino);
        copia.realizarCopia();
        
        
        
    } //fin main
} //fin clase
