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
public class administrarEstudiantes {
    private ArrayList<Estudiante> estudiantes=new ArrayList();
    private File archivo=null;

    public administrarEstudiantes(String path) {
        archivo=new File(path);
        estudiantes=new ArrayList();
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
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
            for (Estudiante est : estudiantes) {
                bw.writeObject(est);
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
            this.estudiantes=new ArrayList();
            Estudiante temp;
            if(archivo.exists()){
                FileInputStream fr=new FileInputStream(archivo);
                ObjectInputStream br=new ObjectInputStream(fr);
                try{
                    while((temp=(Estudiante)br.readObject())!=null){
                        estudiantes.add(temp);
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
