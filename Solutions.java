import java.util.*;
import java.io.*;

public class Solutions {
      
   List<OneSol> mySols;   
   
   public Solutions(boolean emptyString) {
      mySols = new ArrayList<OneSol>();
      if(emptyString) {
         String empty = "";
         OneSol val = new OneSol(empty);
         mySols.add(val);
      }
   } 
   
   public Solutions() {
      mySols = new ArrayList<OneSol>();
   }  
   

   public boolean isEmpty() {
      return (mySols.size() == 0);
   }
   
     
   public void addString(Solutions a, String word, int popularity) {
       for(int i = 0; i < a.mySols.size(); i++) {
         OneSol val = new OneSol(a.mySols.get(i));
         val.add(word, popularity); 
         mySols.add(val);

        }
   }
   
   
   public void print (String prefix) {
      for(int i = 0; i < mySols.size(); i++) {
         String fileName = prefix +  Integer.toString(i + 1) + ".txt";
         OneSol sol = mySols.get(i);
         sol.print(fileName);
       }
      
   }

   public void print () {
      for(int i = 0; i < mySols.size(); i++) {
         OneSol sol = mySols.get(i);
         sol.print();
      }
   }
      
      
   public void sort() {
     Collections.sort(mySols, new OneSolComparator());
   }
   
}









