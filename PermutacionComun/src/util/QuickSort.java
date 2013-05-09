/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author wilson
 */
public class QuickSort {
    
    /**
     * M[etodo de ordenamiento
     * @param array
     * @param izq
     * @param der 
     */
    public static void quickSort(char[] array, int izq, int der){
        
        int i=izq, j=der;
        char tmp;
        char pivote=array[(izq+der)/2];
        
        while(i<=j){
            while(array[i]<pivote) {
                i++;
            }
            while(array[j]>pivote) {
                j--;
            }
            if(i<=j){
                tmp=array[i];
                array[i]=array[j];
                array[j]=tmp;
                i++;
                j--;
            }
        }//end while
        
        if(izq<j){
            quickSort(array, izq, j);
        }
        if(i<der){
            quickSort(array, i, der);
        }       
    }//end method quicksort
    
    
    public static void main(String args[]){
        
        String c="resdqasweijkdmcsmcoeijvfnldvnlskcvepoferoidflkokoijoinlsndsncoeoekvlndvkeovlkdnvoeofknvoefnvlsknvkneoivnvasded";
        System.out.println(c);
        char[]e=c.toCharArray();        
        QuickSort.quickSort(e, 0, e.length-1);
        String o="";
        for(char d:e){
            o+=d;
        }
        System.out.println(o);
        
        
    }
    
}
