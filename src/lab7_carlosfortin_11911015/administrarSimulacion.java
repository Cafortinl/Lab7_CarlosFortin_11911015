package lab7_carlosfortin_11911015;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        this.distancia.setValue(0);
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
        actualizarTabla();
        while(vive){
            if(bus.getEstudiantes().isEmpty()){
                Parada unitec=new Parada();
                unitec.setCx(0);
                unitec.setCy(0);
                distancia.setMaximum(calcularDistancia(unitec));
                distancia.setString("Tiempo restante: "+calcularDistancia(unitec)/bus.getVelocidad()+" horas");
                distancia.setValue(distancia.getValue()+(distancia.getValue()*calcularDistancia(unitec)/bus.getVelocidad()));
                System.out.println(calcularDistancia(unitec));
                System.out.println(unitec);
                vive=false;
            }else{
                int dmin=100000;
                Parada cercana=null;
                Estudiante t=null;
                for (Estudiante p : bus.getEstudiantes()) {
                    Parada temp=p.getParada();
                    if(calcularDistancia(temp)<dmin){
                        dmin=calcularDistancia(temp);
                        cercana=temp;
                        t=p;
                    }
                }
                int tiempo=dmin/bus.getVelocidad();
                System.out.println(tiempo);
                System.out.println(bus.getVelocidad());
                String[] info={cercana.getNombre(),Integer.toString(tiempo)+"horas",t.getNombre()};
                agregarATabla(info);
                distancia.setMaximum(dmin);
                distancia.setString("Tiempo restante: "+dmin/bus.getVelocidad()+" horas");
                distancia.setValue((int) Math.round(distancia.getValue()+(distancia.getValue()*tiempo)));
                if(distancia.getValue()==distancia.getMaximum())
                    distancia.setValue(0);
                
                bus.getEstudiantes().remove(t);
                //System.out.println(cercana+" "+calcularDistancia(cercana));
                cxact=cercana.getCx();
                cyact=cercana.getCy();
            }
            try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
        }
    }
    
    public int calcularDistancia(Parada p){
        int dist;
        double px=p.getCx();
        double py=p.getCy();
        dist=(int) Math.round(Math.sqrt((Math.pow((px-cxact), 2))+(Math.pow((py-cyact), 2))));
        System.out.println(dist);
        return dist;
    }
    
    public void actualizarTabla(){
        historial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parada", "Tiempo", "Estudiantes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    
    public void agregarATabla(String[] info){
        DefaultTableModel m=(DefaultTableModel)historial.getModel();
        m.addRow(info);
        historial.setModel(m);
    }
}
