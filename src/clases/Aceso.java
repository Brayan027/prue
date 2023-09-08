/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author WINDOWS 10
 */
public class Aceso {

    private static RandomAccessFile flujo;
    private static int numeroRegistros=5;
    private static final int tamañoRegistro = 90;

    public static void crearFileAlumno(File archivo) throws IOException {
        if (archivo.exists() && !archivo.isFile()) {
            throw new IOException(archivo.getName() + " no es un archivo.");
        }
        flujo = new RandomAccessFile(archivo, "rw");
        numeroRegistros = (int) Math.ceil(
                (double) flujo.length() / (double) tamañoRegistro);
    }

    public static void cerrar() throws IOException {
        flujo.close();
    }

    public static boolean setPersona(int i, Persona persona) throws IOException {
        if (i >= 0 && i <= getNumeroRegistros()) {
            if (persona.getTamaño() > tamañoRegistro) {
                System.out.println("\nTamaño de registro excedido.");
            } else {
                flujo.seek(i * tamañoRegistro);
                flujo.writeUTF(persona.getNombre());
                flujo.writeUTF(persona.getID());

                return true;
            }
        } else {
            System.out.println("\nNúmero de registro fuera de límites.");
        }
        return false;
    }

    public static int getNumeroRegistros() {
        return numeroRegistros;
    }

    public static Persona getPersona(int i) throws IOException {
        if (i >= 0 && i <= getNumeroRegistros()) {
            flujo.seek(i * tamañoRegistro);
            return new Persona(flujo.readUTF(), flujo.readUTF());
        } else {
            System.out.println("\nNúmero de registro fuera de límites.");
            return null;
        }
    }

}
