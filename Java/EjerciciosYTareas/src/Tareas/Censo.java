package Tareas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;





public class Censo {


	public static void main(String[] args) throws FileNotFoundException, ParseException {
            JSONObject obj;
            int tam = 10000;
    
            String fileName = "business10k.json";

            // This will reference one line at a time
            String line = null;
            Business[] json = new Business[tam];    
            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader = new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                int i = 0;
                while((line = bufferedReader.readLine()) != null && i < tam) {
                    obj = (JSONObject) new JSONParser().parse(line);
                    json[i] = new Business(obj);
                    i++;
                }
                // Always close files.
                bufferedReader.close();         
            }
            catch(FileNotFoundException ex) {
                System.out.println("Unable to open file '" + fileName + "'");                
            }
            catch(IOException ex) {
                System.out.println("Error reading file '" + fileName + "'");
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }            
            long start, end;// se usan estas variables para determinar cuanto tarda cada metodo
            double tot;
            ord.ordenaMergeSort(json);//se asegura que el arreglo este ordenado
            
            System.out.println("---------------Tiempos con arreglo ordenado:-------------");
            
            start = System.nanoTime();
            ord.ordenaSelectSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (selection sort): "+tot+" ns");
            
            start = System.nanoTime();
            ord.ordenaInsertSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (insertion sort): "+tot+" ns");
            
            start = System.nanoTime();
            ord.ordenaBubbleSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (bubble sort): "+tot+" ns");
            
            start = System.nanoTime();
            ord.ordenaQuickSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (quick sort): "+tot+" ns");
            
            start = System.nanoTime();
            ord.ordenaMergeSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (merge sort): "+tot+" ns");
            
            
            
            
            
            System.out.println("---------------Tiempos con arreglo invertido:-------------");
            
            ord.invierteArreglo(json);
            start = System.nanoTime();
            ord.ordenaSelectSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (selection sort): "+tot+" ns");
            
            ord.invierteArreglo(json);
            start = System.nanoTime();
            ord.ordenaInsertSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (insertion sort): "+tot+" ns");
            
            ord.invierteArreglo(json);
            start = System.nanoTime();
            ord.ordenaBubbleSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (bubble sort): "+tot+" ns");
            
            ord.invierteArreglo(json);
            start = System.nanoTime();
            ord.ordenaQuickSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (quick sort): "+tot+" ns");
            
            ord.invierteArreglo(json);
            start = System.nanoTime();
            ord.ordenaMergeSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (merge sort): "+tot+" ns");
            
            
            
            System.out.println("---------------Tiempos con arreglo aleatorio:-------------");
            
            ord.randomizerArreglo(json);
            start = System.nanoTime();
            ord.ordenaSelectSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (selection sort): "+tot+" ns");
            
            ord.randomizerArreglo(json);
            start = System.nanoTime();
            ord.ordenaInsertSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (insertion sort): "+tot+" ns");
            
            ord.randomizerArreglo(json);
            start = System.nanoTime();
            ord.ordenaBubbleSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (bubble sort): "+tot+" ns");
            
            ord.randomizerArreglo(json);
            start = System.nanoTime();
            ord.ordenaQuickSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (quick sort): "+tot+" ns");
            
            ord.randomizerArreglo(json);
            start = System.nanoTime();
            ord.ordenaMergeSort(json);
            end = System.nanoTime();
            tot = ((end - start));
            System.out.println("Tiempo en (merge sort): "+tot+" ns");
	}//main



}//class
