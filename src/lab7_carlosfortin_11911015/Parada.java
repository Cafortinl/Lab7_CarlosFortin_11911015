package lab7_carlosfortin_11911015;

import java.io.Serializable;

/**
 *
 * @author Carlos Fortin
 */
public class Parada implements Serializable{
    private String nombre;
    private int distancia;
    private int angulo;
    private double cx;
    private double cy;

    public Parada() {
    }

    public Parada(String nombre, int distancia, int angulo) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.angulo = angulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public double getCx() {
        return cx;
    }

    public void setCx(double cx) {
        this.cx = cx;
    }

    public double getCy() {
        return cy;
    }

    public void setCy(double cy) {
        this.cy = cy;
    }

    @Override
    public String toString() {
        return "Parada{" + "nombre=" + nombre + '}';
    }
    
    
    
}
