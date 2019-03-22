import java.util.*;
import java.io.*;

public class DynamicProgramming {
      private Map<String, Integer> dictionary;
      private Set<Character> punctuation;
      
      // main method of class
      public static void main(String[]args)throws FileNotFoundException {
         Scanner console = new Scanner(System.in);
         DynamicProgramming program = new DynamicProgramming();
         String inputFileName = findInputFile(console);
         String outputFileName = makeOutputFile(console);
          String doc = program.getPhrase(inputFileName);
         Solutions sol = program.fileCompression(doc);
         sol.print();
         sol.print(outputFileName);
       }

      
      /*
      Input: Scanner console
      Output: String inputFileName
      asks user for input file name and returns it
      */
       public static String findInputFile(Scanner console) throws FileNotFoundException {
         System.out.print("Enter your input file name. Remember that the string should end with .txt: ");
         String inputFileName = console.nextLine();
         File f = new File(inputFileName);
         while(!f.exists()) {
            System.out.print("File not found. Try again: ");
            inputFileName = console.nextLine();
            f = new File(inputFileName);
         }
         return inputFileName;
      }
      
       /*
      Input: Scanner console
      Output: String outputFileName
      asks user for output file name and returns it
      */
       public static String makeOutputFile(Scanner console){
         String outputFileName;
         System.out.print("Output file prefix (do not end with .txt) ");
         outputFileName = console.nextLine();
         return outputFileName;
      }
        
      // class constructor
      public DynamicProgramming() {
         dictionary = new HashMap<String, Integer>();
         punctuation = new HashSet<Character>();
         addPunctuation();
         File file1 = new File("dictionary.txt");
         createDictionary(file1);
      }
      
      // adds punctuations to the punctuation set
      public void addPunctuation() {
         punctuation.add('.');
         punctuation.add('?');
         punctuation.add(',');
         punctuation.add(';'); 
         punctuation.add('!');
         punctuation.add(':');
      }
      
      /*
      Input: File dictionary1
      Adds to the dictionary map the words from the dictionary 1 along with
      popularity classes.
      */
      public void createDictionary(File dictionary1) {  
         try {
            Scanner file1 = new Scanner(dictionary1);
            int count = 0;
            int popularity = 0;
            while(file1.hasNextLine()) {
                  String currWord = file1.nextLine();
                  if(currWord.charAt(0) == '#') {
                     popularity++;
                  } else {
                      if((currWord.length() != 1) || 
                        ((currWord.equals("I")) || (currWord.equals("A")) 
                        || (currWord.equals("a")) || (currWord.equals("i")))) { 
                             dictionary.put(currWord, popularity);
                      }
                     count++;
                  }
               }
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           }   
       } 
      
      /* 
      Input: String fileName (name of file)
      Output: String of the contents of the file with given 
      input file name
      function gets contents of file with the given file name
      and returns
      */        
      public String getPhrase(String fileName) {
         File file = new File(fileName);
         try {
            Scanner input = new Scanner(file);
            return input.next(); 
         }
         catch (FileNotFoundException e) {
               e.printStackTrace();
          }
          return "not correct file name";
      }
      
      /*
     Input:
     Output: 
     Main dynammic programming algorithm methology in this
     method. Updates the dynammic programming table accordingly with looking
     at each substring using two pointers (pos and upto)
      */   
      public Solutions fileCompression(String doc) {
         Solutions[] dynammicProgTable = new Solutions[doc.length() + 1];
         dynammicProgTable[0] = new Solutions(true);  // Special initialization
         int start = 0;
         for(int pos = 1; pos <= doc.length(); pos++) { 
            dynammicProgTable[pos] = new Solutions(); 
            char first = doc.charAt(pos - 1);
            if(isPunctuation(first)) {
               String substring = Character.toString(first);
               dynammicProgTable[pos].addString(dynammicProgTable[pos - 1], substring, 0);
               dynammicProgTable[pos].print();
               start = pos;
            } else {
               for(int upto = start; upto < pos; upto++) {
                  if(!(dynammicProgTable[upto].isEmpty())) {
                    String substring = doc.substring(upto, pos);                 
                     if(dictionary.containsKey(substring)) {
                       int popularity = dictionary.get(substring);
                       dynammicProgTable[pos].addString(dynammicProgTable[upto], substring, popularity);
                    } else {
                        char firstChar = substring.charAt(0);
                        if(Character.isUpperCase(firstChar)) {
                           String temp = substring.toLowerCase();
                           if(dictionary.containsKey(temp)) {
                              int popularity = dictionary.get(temp);
                              dynammicProgTable[pos].addString(dynammicProgTable[upto], substring, popularity);
                           }
                        }
                    }
                  }
               }
            }
        }
        Solutions sol = dynammicProgTable[doc.length()];
        sol.sort();
        return dynammicProgTable[doc.length()];
      }
      
       /*
      Input: char
      Output: boolean
      checks if there is punctuation in the
      given char s. If there is, return
      true, else return false.
      */
      public boolean isPunctuation(char s) {
         return punctuation.contains(s);
      }    
}