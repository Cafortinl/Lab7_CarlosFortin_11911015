package lab7_carlosfortin_11911015;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Carlos Fortin
 */
public class administrarBuses {
    private ArrayList<Autobus> buses=new ArrayList();
    private File archivo=null;

    public administrarBuses(String path) {
        archivo=new File(path);
        this.buses=new ArrayList();
    }

    public ArrayList<Autobus> getBuses() {
        return buses;
    }

    public void setBuses(ArrayList<Autobus> buses) {
        this.buses = buses;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void escribirArchivo() throws IOException{
        FileOutputStream fw=null;
        ObjectOutputStream bw=null;
        try {
            fw=new FileOutputStream(archivo);
            bw=new ObjectOutputStream(fw);
            for (Autobus buse : buses) {
                bw.writeObject(buse);
            }
            bw.flush();
        } catch (Exception e) {
        }finally{
            bw.close();
            fw.close();
        }
    }
    
    public void leerArchivo(){
        try {
            this.buses=new ArrayList();
            Autobus temp;
            if(archivo.exists()){
                FileInputStream fr=new FileInputStream(archivo);
                ObjectInputStream br=new ObjectInputStream(fr);
                try{
                    while((temp=(Autobus)br.readObject())!=null){
                        buses.add(temp);
                    }
                }catch(EOFException e){
                    
                }
                br.close();
                fr.close();
            }
        } catch (Exception e) {
        }
    }
    
}
