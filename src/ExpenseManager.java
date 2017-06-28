import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Sudin on 6/28/2017.
 */
public class ExpenseManager {

    ExpenseManager(){}

    Expense expense;
    ExpenceTracker expenceTracker;

    public void addNewEntry(Expense expense){
        try (
                FileWriter fw = new FileWriter("Expense.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            		out.println(expense.getId());
            		out.println(expense.getExpense());
            		out.println(expense.getExpenseAmt());
            		out.println(expense.getCategory());
            		out.println(expense.getDate());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    void addAllEntry(ArrayList<String> expense){
    	
    	 try (
                 FileWriter fw = new FileWriter("Expense.txt", false);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
             	 for(int i=0;i<expense.size();i++){
             		out.println(expense.get(i));
             	 }
    		 } catch (IOException e1) {
             e1.printStackTrace();
         }
     }
    
    public void modifyEntry(){

    }
    public void DeleteEntry(int DeleteId) throws IOException{
    	
//    	for(int i=0;i<expenceTracker.expenses.size();i=i+5){
//    		if(Integer.parseInt(expenceTracker.expenses.get(i))==DeleteId){
//    			Delete1(Integer.toString(DeleteId));
//    			//Delete(expenceTracker.expenses.get(i+1));
////    			Delete(expenceTracker.expenses.get(i+2));
////    			Delete(expenceTracker.expenses.get(i+3));
////    			Delete(expenceTracker.expenses.get(i+4));
//    		}
//    	}
    }
	private void Delete1(String string) {
		// TODO Auto-generated method stub
		try{
			File inFile = new File("Expense.txt");

	      if (!inFile.isFile()) {
	        System.out.println("Parameter is not an existing file");
	        return;
	      }

	      //Construct the new file that will later be renamed to the original filename.
	      File tempFile = new File("Temp.txt");
	      File file=inFile;
	      
	      BufferedReader br = new BufferedReader(new FileReader(file));
	      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

	      String line = null;

	      //Read from the original file and write to the new
	      //unless content matches data to be removed.
	      while ((line = br.readLine()) != null) {

	        if (!line.trim().equals(string)) {

	          pw.println(line);
	          pw.flush();
	        }
	      }
	      pw.close();
	      br.close();

	      //Delete the original file
	      if (!inFile.delete()) {
	        System.out.println("Could not delete file");
	        return;
	      }

	      //Rename the new file to the filename the original file had.
	      if (!tempFile.renameTo(inFile))
	        System.out.println("Could not rename file");

	    }
	    catch (FileNotFoundException ex) {
	      ex.printStackTrace();
	    }
	    catch (IOException ex) {
	      ex.printStackTrace();
	    }
		
	}
	private void Delete(String DeleteId) throws IOException {
		// TODO Auto-generated method stub
		File inputFile = new File("Expense.txt");
		File tempFile = new File("myTempFile.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = DeleteId;
		String currentLine;

		while((currentLine = reader.readLine()) != null) {
		    // trim newline when comparing with lineToRemove
		    String trimmedLine = currentLine.trim();
		    if(trimmedLine.equals(lineToRemove)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close(); 
		//tempFile.renameTo(inputFile);
		
	}
}
