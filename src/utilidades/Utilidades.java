
package utilidades;

import java.util.Scanner;


public class Utilidades {

    /**
     * Método para pedir un caracter por teclado.
     *
     * @param texto Texto a mostrar para pedir al usuario el caracter
     * @return Retorna el Caracter
     */
    public static char introducirChar(String texto) {
        char caracter;

        Scanner keyboard = new Scanner(System.in);
        System.out.print(texto);
        caracter = keyboard.next().charAt(0);//Elimina espacios inecesarios
        System.out.println();

        return caracter;
    } //Fin introducirChar  

    
    /**
     * pedir numero double por teclado
     *
     * @param texto Texto a mostrar para pedir al usuario el numero
     * @return retorna el número pedido:
     */
    public static double introducirDouble(String texto) {
        double n = -1;
        boolean esNumero;
        Scanner keyboard = new Scanner(System.in);
        
        do {
            System.out.print(texto);
            if (keyboard.hasNextDouble()) {
                n = keyboard.nextDouble();
                esNumero = true;
            } else {
                esNumero = false;
                System.out.print("Valor introducido no válido inténtelo de nuevo.");
                keyboard.next();
            }
            System.out.println();
        } while (!esNumero);
        return n;
    }//Fin pedir double+

    /**
     * pedir numero entero por teclado
     *
     * @param texto Texto a mostrar para pedir al usuario el numero
     * @return retorna el número pedido:
     */
    public static int introducirNumero(String texto) {
        int n = -1;
        boolean esNumero;
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.print(texto);
            if (keyboard.hasNextInt()) {
                n = keyboard.nextInt();
                esNumero = true;
            } else {
                esNumero = false;
                System.out.print("Valor introducido no válido inténtelo de nuevo.");
                keyboard.next();
            }
            System.out.println();
        } while (!esNumero);
        return n;
    }//Fin pedir numero entero

    /**
     * Método para pedir un String por teclado, sin espacios sobrantes.
     *
     * @param texto Texto a mostrar para pedir al usuario el String
     * @return Retorna el String
     */
    public static String introducirString(String texto) {
        String cadena;

        Scanner keyboard = new Scanner(System.in);
        System.out.print(texto);
        cadena = keyboard.nextLine().trim().replaceAll("\\s+", " ");//Elimina espacios inecesarios

        return cadena;
    } //Fin introducirString 
    
    /**
     * Metodo para pedir al usuario que pulse Enter para continuar
     *
     */
    public static void pulsarTeclaPausa() {
        String entrada;
        do {
            System.out.println("\nPulse Enter para continuar...\n");
            entrada = new Scanner(System.in).nextLine();
        } while (!entrada.equals(""));

    } //Fin tecla continuar
    
    /**
     * pedir por teclado un numero entero positivo
     *
     * @param texto Texto a mostrar para pedir al usuario el numero
     * @return retorna el numero entero positivo
     */
    public static int introducirNumeroPositivo(String texto) {
        int numeroPositivo;
        numeroPositivo = introducirNumero(texto); //LLama a el método introducirNumero para verificar que es un entero

        if (numeroPositivo < 0) {
            do {
                System.out.print("El número introducido no es positivo, inténtelo de nuevo.\n");
                numeroPositivo = introducirNumero(texto);
            } while (numeroPositivo < 0);
        } //Fin if 

        return numeroPositivo;
    }//Fin pedir numero positivo
    
    
    /**
     * Método para llenar el Array con numeros aleatorios entre [0-10]
     * 
     * @param array Array 
     */
    public static void llenarArrayRandom(int array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 11);
        }

    }//Fin metodo llenar array aleatorios   
    
    /**
     * Pasa a un String el contenido de un Array de Strings.
     *
     * @param array Array que queremos pasar al String.
     * @return Retorna un string con el contenido del Array.
     */
    public static String pasarArrayEnString(String array[]) {
        String cadena = "";
        for (int i = 0; i < array.length; i++) {
            cadena += array[i] + " ";
        }

        return cadena;
    } //Fin convertirArrayEnString 
    
    
    
} //fin clase Utilidades
