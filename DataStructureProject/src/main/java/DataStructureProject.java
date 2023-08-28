
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author Adel
 */
public class DataStructureProject {

   public static void main(String[] args) throws IOException  {
    /*
    // This is Done Using CSV Files
    int numOfLines = FileLines();
    System.out.println(numOfLines);
    String[] names = ReadFromFileNames();
    String[] addresses = ReadFromFileAddresses();
    
    MultiAccessKeyList<String, String> myHashMap = new MultiAccessKeyList<String, String>(numOfLines);
    
    for(int i = 0; i < numOfLines; i++) {
        myHashMap.add(names[i], addresses[i]);
    }
    
    myHashMap.add("Tomato", "Tomato Town");
    myHashMap.add("Walter Hartwell White", "308 Negra Arroyo Lane Albuquerque New Mexico 87104", 1000);
    
    
    System.out.println("Tomato Node Check:");
    System.out.println("Tomato Address (Value) :" + myHashMap.contain("Tomato Town"));
    System.out.println("Tomato Name (Key) :" + myHashMap.contains("Tomato"));
    
    System.out.println("**********************************************************************" + "\n");
    
    System.out.println("HeisenBerg Check:");
    System.out.println("HeisenBerg Address (Value) :" + myHashMap.contain("308 Negra Arroyo Lane Albuquerque New Mexico 87104"));
    System.out.println("HeisenBerg Name (Key) :" + myHashMap.contains("Walter Hartwell White") + "\n");
    
    System.out.println("**********************************************************************" + "\n");
    
    System.out.println("Remove Tomato:" + myHashMap.remove("Tomato"));
    String x = myHashMap.remove(1000);
    System.out.println("First Element Removed In Position 1000 (Index 999 in mainArray):" + x);
    
    System.out.println("**********************************************************************" + "\n");
    
    System.out.println("ALL Nodes Removed in position 1000: " + myHashMap.removeEntirePosition(1000));
    
    System.out.println("**********************************************************************" + "\n");
    
    System.out.println("Full HashMap Printing:");
    
    System.out.println(myHashMap);
    
    SavingToFile(myHashMap);
    //*/
    
    // Test Case Code
    MultiAccessKeyList<String, String> myHashMap = new MultiAccessKeyList<String, String>(4);
    myHashMap.add("A", "1");
    myHashMap.add("B", "2");
    myHashMap.add("C", "3");
    myHashMap.add("D", "4");
    myHashMap.add("E",  "5");
    myHashMap.add("F", "6");
    myHashMap.add("G", "7");
    myHashMap.add("H", "8");
    myHashMap.add("A",  "10");
    myHashMap.add("OO",  "23",2);
    myHashMap.add("O2",  "24",4);
    myHashMap.add("O5",  "25",1);
 
    System.out.println("Original HashMap:\n");
    
    System.out.println(myHashMap);
    
    System.out.println("***************************************************************");
    
    System.out.println("Contains Value 23 & Key OO :\n");
    
    System.out.println("contain key OO: " + myHashMap.contains("OO") + "\n");
     
    System.out.println("contain value 23: " + myHashMap.contain("23") + "\n");
    
    System.out.println("***************************************************************");
    
    System.out.println("contain value 5: " + myHashMap.contain("5") + "\n");
    
    System.out.println("contain key E: " + myHashMap.contains("E") + "\n");
    
    System.out.println("***************************************************************");
    
    System.out.print("Removing of Node/Entry with Key H And Returning it's Value: ");
    
    System.out.println(myHashMap.remove("H")+"\n");
    
    System.out.println("***************************************************************");
    
    System.out.print("Removing First Node Of Position 2 (Position 2 is Index 1 in mainArray in HashMap)"
                    + " And Returning the Node's Value.");
    
    System.out.println(myHashMap.remove(2) +"\n");
    
    System.out.println("***************************************************************");
    
    System.out.print("Removing ENTIRETY OF Position 2 (Position 2 is Index 1 in mainArray in HashMap)"
                    + " & Returning The Values Of Nodes (Alternate Remove Position Method): \n");
    
    System.out.println(myHashMap.removeEntirePosition(2) +"\n");
    
    System.out.println("***************************************************************");
    
    System.out.print("Removing of Node/Entry with Key A And Returning it's Value: ");
    
    System.out.println(myHashMap.remove("A")+"\n");
    System.out.print("(The node was already removed, by using the remove method at position 2 [Line 111 in code] )");
 
    System.out.println("***************************************************************");
    System.out.println("After Modification HashMap:\n");
    System.out.println(myHashMap);
    System.out.println("After Clear HashMap:\n");
    myHashMap.clear();
    System.out.println(myHashMap);
    //*/
    
 }

   public static void SavingToFile (MultiAccessKeyList HashMap) throws FileNotFoundException, IOException {
      FileWriter writer = new FileWriter("Project_Test_DataOUTPUT.csv");
      BufferedWriter bw = new BufferedWriter(writer);

      bw.write(HashMap.toString());    

      bw.newLine();

      //closing is mandatory or glitches occurs in the csv file
      bw.close();
      
      writer.close();
      
      //console confirmation to make sure it reached end of method
      System.out.println("SAVING TO CSV FILE \"Project_Test_DataOUTPUT.csv\" IS SUCCESSFUL");
                                                     }
   
   public static String[] ReadFromFileNames() throws FileNotFoundException, IOException {
        //Decleartions
        
        String file = "Project_Test_Data.csv"; //file name (position of the file for netBeans -> inside the project folder only (don't go to src or anywhere), for jGrasp -> in the same directory as this java file)
        BufferedReader reader = new BufferedReader(new FileReader(file));; 
        String line = "";

        Object[] lines = reader.lines().toArray(); 
        int linesInFile = lines.length; // this and line above is used to dynmaically set the arraySize of the names and addresses arrays and make sure no extra space is there or wasted (we can use this in lists and set up the array value using this technique aswell)
        int counter = 0; // This is used to determine what is name and what is address, if modulus is zero (zowje) then it's name, if modulus != 0 (fardee) then it's address 
        int counterForArrayIncrement = 0; //this is for looping thro names and addresses arrays
        
        String[] names = new String[linesInFile]; 
        String[] addresses = new String[linesInFile]; 
        
        
        reader = new BufferedReader(new FileReader(file)); // don't delete this line or everything will be null
        while((line = reader.readLine()) != null ) {//this while loop goes line by line through the whole csv file
            
            String[] row = line.split(",");// split each row into 2 strings using "," into names and addresses
            
            for(String stringFromRow : row) { //for each loop (stringFromRow means string inside each line in csv file)
                                              //this for each loop is made to assign names and addresses to the their respective arrays
                if(counter % 2 == 0){
                    names[counterForArrayIncrement] = stringFromRow;
                }
                else {
                    addresses[counterForArrayIncrement] = stringFromRow;
                }
                ++counter;
            }
            counterForArrayIncrement++; 
            System.out.println(); // go to the next line in csv file
            
        }//end for while loop
        
        reader.close(); // this is for memory management, don't delete it, leave it alone (it's not complosury but best practice to type it and makes program faster)

     return names;
        
   } 

   public static String[] ReadFromFileAddresses() throws FileNotFoundException, IOException {
        //Decleartions
        
        String file = "Project_Test_Data.csv"; //file name (position of the file for netBeans -> inside the project folder only (don't go to src or anywhere), for jGrasp -> in the same directory as this java file)
        BufferedReader reader = new BufferedReader(new FileReader(file));; 
        String line = "";

        Object[] lines = reader.lines().toArray(); 
        int linesInFile = lines.length; // this and line above is used to dynmaically set the arraySize of the names and addresses arrays and make sure no extra space is there or wasted (we can use this in lists and set up the array value using this technique aswell)
        int counter = 0; // This is used to determine what is name and what is address, if modulus is zero (zowje) then it's name, if modulus != 0 (fardee) then it's address 
        int counterForArrayIncrement = 0; //this is for looping thro names and addresses arrays
        
        String[] names = new String[linesInFile]; 
        String[] addresses = new String[linesInFile]; 
        
        
        reader = new BufferedReader(new FileReader(file)); // don't delete this line or everything will be null
        while((line = reader.readLine()) != null ) {//this while loop goes line by line through the whole csv file
            
            String[] row = line.split(",");// split each row into 2 strings using "," into names and addresses
            
            for(String stringFromRow : row) { //for each loop (stringFromRow means string inside each line in csv file)
                                              //this for each loop is made to assign names and addresses to the their respective arrays
                if(counter % 2 == 0){
                    names[counterForArrayIncrement] = stringFromRow;
                }
                else {
                    addresses[counterForArrayIncrement] = stringFromRow;
                }
                ++counter;
            }
            counterForArrayIncrement++; 
            System.out.println(); // go to the next line in csv file
            
        }//end for while loop
        
        reader.close(); // this is for memory management, don't delete it, leave it alone (it's not complosury but best practice to type it and makes program faster)

     return addresses;
        
   } 
   
   public static int FileLines() throws FileNotFoundException, IOException {
   //Decleartions
        String file = "Project_Test_Data.csv"; //file name (position of the file for netBeans -> inside the project folder only (don't go to src or anywhere), for jGrasp -> in the same directory as this java file)
        BufferedReader reader = new BufferedReader(new FileReader(file)); 

        Object[] lines = reader.lines().toArray(); 
        return lines.length;
        
   }
    
}