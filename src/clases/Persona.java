/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author WINDOWS 10
 */
public class Persona {

    private String nombre;
    private String ID;

    public Persona() {
        nombre = "NN";
        ID = "II";

    }

    public Persona(String nombre, String ID) {
        this.nombre = nombre;
        this.ID = ID;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

     public int getTamaño() {
        return getNombre().length() * 2 + 2 + 4 + 1;
    }


}
