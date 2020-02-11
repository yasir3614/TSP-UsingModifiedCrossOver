/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cx;

import java.util.Arrays;


public  class CX {
       int[] p1 ;
        int[] p2;
        int[] c1 = new int[8];
        int[] c2 = new int[8];
        int temp=0;
        int i = 0;
        boolean cycle = false;

        public CX(int[] P1,int[] P2){
            int[] p1 = P1;
            int[] p2 = P2;
            Arrays.fill(c1,0);
            Arrays.fill(c2,0);
            
         
        while(!cycle){
            c1[i] = p1[i];
            temp = p2[i];
            i = search(p1,temp);
            cycle = check(c1,i,temp);
        }
        
        for(int j = 0; j < 8; j++)
        {
            if(c1[j] == 0)
            {
                c1[j] = p2[j];
            }
        }
        
         for(int k = 0; k < 8; k++)
        {
            System.out.print(c1[k]+" ");
        }
         cycle = false;
         
        while(cycle == false)
        {
            c2[i] = p2[i];
            temp = p1[i];
            i = search(p2, temp);

            cycle = check(c2, i, temp);
        }
        
        
        for(int j = 0; j < 8; j++)
        {
            if(c2[j]== 0)
            {
                c2[j] = p1[j];
            }
        }
        System.out.println("");
        for(int k = 0; k < 8; k++)
        {
            System.out.print(c2[k]+ " ");
        }
        System.out.println("");
        
    }
    public boolean check(int[] a,int b,int c){
    
    return a[b]==c;
    }
    
   
    public int search(int[] a,int b){
        for(int i=0;i<8;i++){
            if(a[i] == b){
             return i;
            }
        }
        return 0;
    }
   
    public static void main(String[] args) {
          int[] p1 = {1, 2, 3, 4, 5, 6, 7, 8};
          int[] p2 = {8, 5, 2, 1, 3, 6, 4, 7};
          
          
       long start = System.nanoTime();
        CX myobj = new CX(p1,p2);
       long stop = System.nanoTime();
       
       long totalTime = stop-start;
        System.out.println("Total Time to run (ns) : "+totalTime+"ns");
    }
    
}
