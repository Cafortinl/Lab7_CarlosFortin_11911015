package lab7_carlosfortin_11911015;

import java.io.Serializable;

/**
 *
 * @author Carlos Fortin
 */
public class Estudiante implements Serializable{
    private String nombre;
    private int edad;
    private int no_cuenta;
    private Parada parada;

    public Estudiante() {
    }

    
    public Estudiante(String nombre, int edad, int no_cuenta, Parada parada) {
        this.nombre = nombre;
        this.edad = edad;
        this.no_cuenta = no_cuenta;
        this.parada = parada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNo_cuenta() {
        return no_cuenta;
    }

    public void setNo_cuenta(int no_cuenta) {
        this.no_cuenta = no_cuenta;
    }

    public Parada getParada() {
        return parada;
    }

    public void setParada(Parada parada) {
        this.parada = parada;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", no_cuenta=" + no_cuenta + '}';
    }
    
    
    
}
