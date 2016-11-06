/*
 * This app is intentend to create a weka dataset given a custom header file. 
 * The user has to create a text file with a valid weka header.
 * This app will return a randomly generated Train Set file with values 
 * for all attributes. It will lacks the info of one chosen field, using 
 * the symbol "?" instead
 * 
 * The algorithm will create a dataset with a pattern of 90-95% fiability.
 * 
 */
package wekadsgenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RadW
 */
public class WekaDSGenerator {
    // Porcentaje de filas con uno o dos campos incompletos
    final double ROWS_INCOMPLETED = 0.1;
    // numero de lineas que se desea generar
    final int NUMBER_OF_ROWS_TRAIN_SET = 500;
    // Boolean de control para si es siempre el mismo campo el que falta o no
    final boolean LACK_OF_SAME_FIELDS = true;
    
    static StringBuilder outPut;
    //Nombre del archivo con el Weka header en la raiz del proyecto de Netbeans
    static String headerFileName = "archivoWekaCustomHeader.txt";
    
    
    /**
     * This method read a header file and return 
     * @param headerFileName 
     */
    public void readHeaderFile(String headerFileName){
        File file = new File(headerFileName);
        //this.headerFile = headerFile;
        String line;
        InputStream fis;
        try {
            fis = new FileInputStream(file);
        
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);
        
        while ( (line = br.readLine() ) != null ){
            outPut.append(line + "\n");
            String[] words = line.split(" ");
            
            switch ( words[0].toLowerCase() ){
                case ("@relation"):
                    //nombre del dataset a titulo informativo
                    // no hacemos nada
                    break;
                case ("@attribute "):
                    
                    break;
                case ("@data"):
                    System.err.println("Wring header file. It contains data.");
                    System.exit(1);
                    break;
                case ("%"):
                    //comentarios en el header.
                    // no hacemos nada
                    break;
                    
                default:
                    break;
                    
            }
        }    
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WekaDSGenerator.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException ex) {
            Logger.getLogger(WekaDSGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //FileReader fr = new FileReader(file);
        //Path path = Paths.get(file);
        //Charset charset = StandardCharsets.UTF_8;
        
        
            
        
        
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WekaDSGenerator instancia = new WekaDSGenerator();
        
        // Stringbuild para ir añadiendo lo que se va leyendo y generando
        instancia.outPut.append("Archivo generado con WekaDSGenerator\n\n*****\n\n by RadW2020\n\n***\n\n");
        instancia.readHeaderFile(headerFileName);
        
        
    }
    
}
