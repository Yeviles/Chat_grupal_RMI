/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Utilidades para gestión de archivos.
 *
 * @author YENNYFER, YEFERSON
 */
public class UtilidadesArchivosTxt {

    /**
     * Lee el archivo que lleva por nombre "nombreArchivo"
     *
     * @param nombreArchivo archivo a leer
     * @return Contenido del archivo
     */
    public static String leerArchivo(String nombreArchivo) {
        String varLinea;
        String varLineas = "";
        File varArchivo = new File(nombreArchivo);
        if (varArchivo.exists() == false) {
            try {
                varArchivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileReader varLector = new FileReader(nombreArchivo);
            BufferedReader varAlmacenamiento = new BufferedReader(varLector);

            while ((varLinea = varAlmacenamiento.readLine()) != null) {
                varLineas += varLinea;
            }

            varAlmacenamiento.close();
            varLector.close();
        } catch (FileNotFoundException e) {

            System.out.println("\nThe file is empty or doesn't exist. Check your content.");
        } catch (IOException e) {
            System.out.println("\nThe file is empty or doesn't exist. Check your content.");
        }
        if (varLineas.isEmpty()) {
            System.out.println("\nThe file is empty or doesn't exist. Check your content.");
        }
        return varLineas;
    }

    /**
     * Lee una linea del archivo file.txt
     *
     * @return Linea leida
     */
    public static String leerLinea() {
        String varLinea = "";
        try {
            FileReader varLector = new FileReader("file.txt");
            BufferedReader varAlmacenamiento = new BufferedReader(varLector);

            varLinea = varAlmacenamiento.readLine();

            varAlmacenamiento.close();
            varLector.close();
        } catch (FileNotFoundException e) {
            System.out.println("\nEl archivo esta vacio o no existe. Revise su contenido.");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return varLinea;
    }

    /**
     * Escribe en el archivo cuyo nombre está dado por "nombreArchivo" el texto
     * dado por "prmTexto". Si el archivo no existe, se crea.
     *
     * @param nombreArchivo archivo sobre el que se va a escribir
     * @param prmTexto texto a escribir
     */
    public static void escribirArchivo(String nombreArchivo, String prmTexto) {
        File varArchivo = new File(nombreArchivo);
        FileWriter varEscritor;
        BufferedWriter varBufferEscritor;
        if (varArchivo.exists() == false) {
            try {
                varArchivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            varEscritor = new FileWriter(varArchivo.getAbsoluteFile(), true);
            varBufferEscritor = new BufferedWriter(varEscritor);
            varBufferEscritor.write(prmTexto);
            varBufferEscritor.flush();
            varBufferEscritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
