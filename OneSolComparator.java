import java.io.*;
import java.util.*;

public class OneSolComparator implements Comparator<OneSol> {

   public int compare(OneSol a, OneSol b) {
       if(a.popularity > b.popularity) {
           return 1;
       }
       else if(a.popularity < b.popularity) {
           return -1;
       }
       return 0;
   } 
   
} 
   