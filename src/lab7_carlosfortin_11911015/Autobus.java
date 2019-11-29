package lab7_carlosfortin_11911015;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Carlos Fortin
 */
public class Autobus implements Serializable{
    private int numero;
    private String placa;
    private int velocidad;
    private ArrayList<Estudiante> estudiantes=new ArrayList();

    public Autobus() {
    }

    public Autobus(int numero, String placa, int velocidad) {
        this.numero = numero;
        this.placa = placa;
        this.velocidad = velocidad;
        estudiantes=new ArrayList();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Autobus{" + "numero=" + numero + ", placa=" + placa + '}';
    }
    
    
    
}
