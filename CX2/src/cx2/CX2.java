/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cx2;

public class CX2 {
int searchIndex(int a, int b[])
{   
	for (int i = 0; i < 8; i++)
	{
		if (b[i] == a)
		{
			return i;
		}
	}
	return -1;
}
int check(boolean flag[])
{
	for (int i = 0; i < 8; i++)
	{
		if (flag[i] == false)
		{
			return i;
		}
	}
	return -1;
}

 public CX2(int[] p1_,int[] p2_){
     int s1,s2;
     int c1[] = new int[8];
     int c2[] = new int [8];
     int k=0;
     int p2[] = p2_;
     int p1[] = p1_;
     boolean flag[] = new boolean[8];
     flag[0] = true;
     c1[k] = p2[0];
     int search;
     while(true){
         s1 = searchIndex(c1[k],p1);
         s2 = searchIndex(p2[s1],p2);
         c2[k]=p2[s2];
         search  = c2[k];
         if(k==8-1){
             break;
         }else{
             k++;
         }
         s1=searchIndex(search,p1);
         if(flag[s1]==false){
             flag[s1]=true;
             c1[k]=p2[s1];
         }else{
             s1=check(flag);
             flag[s1] = true;
             c1[k] = p2[s1];
         }
     }
     System.out.println("C1");
     for(int i=0;i<8;i++){
         System.out.print(c1[i]+" ");
     }
     System.out.println("C2");
     for(int i=0;i<8;i++)
           System.out.print(c2[i]+" ");
     System.out.println("");
 }
    public static void main(String[] args) {
        
       int p1[] = {1, 2, 3, 4, 5, 6, 7, 8};
       int p2[] = {2, 7, 5, 8, 4, 1, 6, 3};
       
        long start = System.nanoTime();
        CX2 myobj = new CX2(p1,p2);
        long stop = System.nanoTime();
        long totalTime = stop-start;
        
     System.out.println("Total Time to run (ns) : "+totalTime+"ns");
    }
    
}
