import java.util.*;
import java.io.*;

public class OneSol {
   List<String> sol;
   int popularity;
   
   public OneSol() {
      sol = new ArrayList<String>();
      popularity = 0;
   }   
   
   public OneSol(String s) {
       sol = new ArrayList<String>();
       popularity = 0;
       sol.add(s);
   }
   
   public OneSol(OneSol a) {
      sol = new ArrayList<String>();
      for(int i = 0; i < a.sol.size(); i++) {
         String currVal = a.sol.get(i);
         sol.add(currVal);
      }
      popularity = a.popularity;
   }
   
   public void add(String word, int pop) {
      sol.add(word);
      popularity += pop;
   }
   
     
   public void print() {
      for(int i = 0; i < sol.size(); i++) {
         System.out.print(sol.get(i) + " ");
      }
      System.out.println(": popularity = " + popularity);
   }

   public void print(String fileName) {
         try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            String strSpace = " ";
            byte[] space = strSpace.getBytes();
            for(int i = 0; i < sol.size(); i++) {
               String str = sol.get(i);
               byte[] strToBytes = str.getBytes();
               outputStream.write(strToBytes);
               outputStream.write(space);
            }
            outputStream.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
   }

}