package lab7_carlosfortin_11911015;

import javax.swing.JProgressBar;
import javax.swing.JTable;

/**
 *
 * @author Carlos Fortin
 */
public class administrarSimulacion extends Thread{
    private JProgressBar distancia;
    private Autobus bus;
    private JTable historial;
    private boolean vive;
    private double cxact;
    private double cyact;

    public administrarSimulacion(JProgressBar distancia, Autobus bus, JTable historial) {
        this.distancia = distancia;
        this.bus = bus;
        this.historial = historial;
        vive=true;
        cxact=0;
        cyact=0;
    }

    public JProgressBar getDistancia() {
        return distancia;
    }

    public void setDistancia(JProgressBar distancia) {
        this.distancia = distancia;
    }

    public Autobus getBus() {
        return bus;
    }

    public void setBus(Autobus bus) {
        this.bus = bus;
    }

    public JTable getHistorial() {
        return historial;
    }

    public void setHistorial(JTable historial) {
        this.historial = historial;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }
    
    @Override
    public void run(){
        while(vive){
            if(bus.getEstudiantes().isEmpty()){
                Parada unitec=new Parada();
                unitec.setCx(0);
                unitec.setCy(0);
                distancia.setMaximum(calcularDistancia(unitec));
                distancia.setString("Tiempo restante: "+calcularDistancia(unitec)/bus.getVelocidad()+" horas");
                distancia.setValue(distancia.getValue()+(distancia.getValue()*calcularDistancia(unitec)/bus.getVelocidad()));
            }else{
                int d=100000;
                Parada cercana=null;
                Estudiante t=null;
                for (Estudiante p : bus.getEstudiantes()) {
                    Parada temp=p.getParada();
                    if(calcularDistancia(temp)<d){
                        d=calcularDistancia(temp);
                        cercana=temp;
                        t=p;
                    }
                }
                bus.getEstudiantes().remove(t);
                System.out.println(cercana);
                cxact=cercana.getCx();
                cyact=cercana.getCy();
                System.out.println(cercana.getCx()+" "+cercana.getCy()+" "+cxact+" "+cyact);
                System.out.println(calcularDistancia(cercana));
                distancia.setMaximum(d);
                distancia.setString("Tiempo restante: "+d/bus.getVelocidad()+" horas");
                distancia.setValue(distancia.getValue()+(distancia.getValue()*d/bus.getVelocidad()));
            }
            try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                }
        }
    }
    
    public int calcularDistancia(Parada p){
        int distancia;
        double px=p.getCx();
        double py=p.getCy();
        distancia=(int) Math.round(Math.sqrt((Math.pow((px-cxact), 2))+(Math.pow((py-cyact), 2))));
       // System.out.println(distancia);
        return distancia;
    }
    
}
