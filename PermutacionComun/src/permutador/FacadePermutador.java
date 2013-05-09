/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package permutador;

/**
 *
 * @author wilson
 */
public class FacadePermutador {
    
    
    public static String iniciarPermutacion(String rutaArchivo){
        return new Permutador().procesarEntrada(rutaArchivo);
    }
    
}
