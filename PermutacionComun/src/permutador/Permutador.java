/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package permutador;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.GestionarFicheros;
import util.QuickSort;

/**
 *
 * @author wilson
 */
public class Permutador {
    
    
    
    
    /**
     * Este método inico el procesamiento del archivo y toma cada dos líneas y le aplica permutación
     * @param rutaArchivo String ruta del archivo que contiene los datos de entrada
     * @return String con el resultado de la permutación
     */
    public String procesarEntrada(String rutaArchivo){
        
        String resultadoPermutacion="";
        try{
            List<String> lineas=GestionarFicheros.leerArchivo(rutaArchivo);
            if(!lineas.isEmpty()){
                
                int i=0;
                while(i<lineas.size()){
                    
                    String cadena1=lineas.get(i++);
                    String cadena2=lineas.get(i++);
                    String expRegular="^[a-z]{1,1000}$";//alfabeto español minúsculas hasta 1000 caracteres
                    
                    if(this.validarExpresionRegular(expRegular, cadena1)&&this.validarExpresionRegular(expRegular, cadena2)){
                        resultadoPermutacion+=this.permutadorCadenas(cadena1, cadena2)+"\n";
                    }else{
                        resultadoPermutacion+="Las cadenas: "+cadena1+" y "+cadena2+" tienen que ser minúsculas y no exceder 1000 caracteres\n\n";
                    }                    
                }//end while                
            }else{
                resultadoPermutacion+="El contenido del archivo está vacío\n\n";
            }
        }catch(Exception e){
            resultadoPermutacion+=e.getMessage()+"\n\n";
        }
        
        return resultadoPermutacion;
        
    }//end method procesarEntrada
    
    
    private String permutadorCadenas(String cadena1,String cadena2){
        
        String salida="";
        cadena1=this.factorizarComunCadena(cadena1);
        cadena2=this.factorizarComunCadena(cadena2);
        char[]cad1=cadena1.toCharArray();
        char[]cad2=cadena2.toCharArray();
        QuickSort.quickSort(cad1, 0, cad1.length-1);
        QuickSort.quickSort(cad2, 0, cad2.length-1);
        
        
        for(char caracter:cad1){
            if(cadena2.indexOf(caracter)>=0){
                salida+=caracter;
            }
        }
        
        return salida;
    }//end method permutadorCadenas
    
    /**
     * Este método factoriza una cadena. Por ejemplo aassdeef quedaría asdef
     * @param cadena String cadena para factoizar
     * @return String cadena factorizada.
     */
    private String factorizarComunCadena(String cadena){
        
        int i=0;
        while(i<cadena.length()){
            
            char caracter=cadena.charAt(i);
            String parteFinal=cadena.substring(i+1, cadena.length());
            parteFinal=parteFinal.replaceAll(""+caracter, "");
            String parteInicial="";
            if(i>0){
                parteInicial=cadena.substring(0, i);
            }
            cadena=parteInicial+""+caracter+parteFinal;
            i++;
        }
        return cadena;
    }//end method factorizarComunCadena
    
     /**
     * Este método permite verificar una cadena respecto a una expresión regular
     * @param expresion String expresion regular a evaluar
     * @param cadena String cadena a evaluar
     * @return 
     */
    private boolean validarExpresionRegular(String expresion, String cadena){
        
        boolean evaluacion=false;
        Matcher matcher = Pattern.compile(expresion).matcher(cadena);
        
        if(matcher.find()) {
            evaluacion=true;
        }
        
        return evaluacion;
        
    }//end method validarExpresionRegular
    
    
    
    
}
