package copiaDeSeguridad;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.StandardCopyOption;

/**
 *
 * @author brandon barroso garcia
 */
public class CopiaSeguridad {

    private final String rutaClonar;
    private final String rutaDestino;
    private final File src;
    private final File dest;

    /**
     * Constructor CopiaSeguridad
     *
     * @param rutaDirectorio ruta del directorio a realizar una copia de
     * seguridad.
     * @param rutaDestino ruta destino para almacenar la copia de seguridad.
     */
    public CopiaSeguridad(String rutaDirectorio, String rutaDestino) {
        this.rutaClonar = rutaDirectorio;
        this.rutaDestino = rutaDestino;
        this.src = new File(rutaDirectorio);
        this.dest = new File(rutaDestino);
    }

    /**
     * Verifica la ruta a clonar y la rutaDestino
     *
     * @return retorna true si las rutas son correctas
     */
    public boolean verificarRutas() {
        boolean correcto;

        if (!this.src.exists()) {
            System.out.println("Error, la ruta del directorio a clonar no existe.");
            correcto = false;
        } else if (!this.src.isDirectory()) {
            System.out.println("Error, la ruta del directorio a clonar no es un directorio.");
            correcto = false;
        } else {
            correcto = true;
        }

        return correcto;
    }

    /**
     * Copia los directorios
     *
     * @param src File con la ruta del directorio a realizar la copia
     * @param dest File con la ruta de destino de la copia
     */
    public void copiarDirectorio(File src, File dest) {
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
                System.out.println("* Creado directorio : " + dest);
            }

            String files[] = src.list();

            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);

                copiarDirectorio(srcFile, destFile);
            }
        } else {

            try {
                Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }

            System.out.println("\t - Fichero copiado " + dest);
        }

    }

    /**
     * Realiza la copia de seguridad
     */
    public void realizarCopia() {
        System.out.println("\n\t     CREANDO COPIA DE SEGURIDAD ");
        System.out.println("\t|===================================|\n");

        if (verificarRutas()) {
            copiarDirectorio(this.src, this.dest);
        }

    }

    public static void main(String[] args) {

    } //fin main
} //fin clase
