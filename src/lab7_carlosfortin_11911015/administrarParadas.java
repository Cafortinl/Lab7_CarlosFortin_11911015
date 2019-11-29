package lab7_carlosfortin_11911015;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Carlos Fortin
 */
public class administrarParadas {
    private ArrayList<Parada> paradas=new ArrayList();
    private File archivo=null;

    public administrarParadas(String path) {
        archivo=new File(path);
        paradas=new ArrayList();
    }

    public ArrayList<Parada> getParadas() {
        return paradas;
    }

    public void setParadas(ArrayList<Parada> paradas) {
        this.paradas = paradas;
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
            for (Parada p : paradas) {
                bw.writeObject(p);
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
            this.paradas=new ArrayList();
            Parada temp;
            if(archivo.exists()){
                FileInputStream fr=new FileInputStream(archivo);
                ObjectInputStream br=new ObjectInputStream(fr);
                try{
                    while((temp=(Parada)br.readObject())!=null){
                        paradas.add(temp);
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
