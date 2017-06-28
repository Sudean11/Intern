import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by Sudin on 6/28/2017.
 */
public class ExpenceTracker {

    Scanner scan = new Scanner(System.in);
    int selectionOption;
    ExpenseManager expenseManager;
    ArrayList<String> expenses=new ArrayList<>();
    ExpenceTracker(){
    	getData();
        Initialize();
    }
    public void Initialize(){
    	
    	System.out.println("*******************************");
        
        
    	System.out.println("Select options, 1. Manage Expense 2. View expense");
        selectionOption=scan.nextInt();
        if(selectionOption==1){
            manageExpense();
        }else if(selectionOption==2){
            viewExpense();
        }else{
            System.out.println("Invalid selection!");
            Initialize();
        }
    }

    public void viewExpense() {
        System.out.println("****************************");
        System.out.println(" All expenses.....");
        for( int i=0;i<expenses.size();i=i+5){
            System.out.println(expenses.get(i)+"      "+expenses.get(i+1)+"      "+expenses.get(i+2)+"      "+expenses.get(i+3)+"      "+expenses.get(i+4));
        }
        System.out.println("****************************");
        ArrayList<String> hightolow=new ArrayList<>();

        for(int j=0;j<expenses.size();j=j+5){
            hightolow.add(expenses.get(j+3));
        }

        Initialize();

    }

    private void manageExpense() {
        System.out.println("Select options, 1.Add 2.Modify 3.Delete");
        selectionOption=scan.nextInt();
        switch (selectionOption){
            case 1:
                addnewEntry();
                break;
            case 2:
                modifyEntry();
                break;
            case 3:
                delete();
                break;
            default:
                 System.out.println("Invalid select again!!");
        }
    }

    public void addnewEntry() {
        Scanner scan1=new Scanner(System.in);
        System.out.println("Fill out the form");
        System.out.println("Name");
        String name=scan1.next();
        System.out.println("Amount");
        int amount = 0;
        try{
        amount=scan.nextInt();
        }catch(RuntimeException e){
        	System.out.println("Sorry Amount has to be integer");
        	
        	Initialize();
        }
        System.out.println("Category");
        String category=scan1.next();
        System.out.print("Date");
        getDate();
        String date=scan1.next();
        int temporary;
        if(expenses.size()==0){
            temporary=1;
        }else{
            temporary=Integer.parseInt(expenses.get(expenses.size()-5))+1;

        }
        Expense expense=new Expense(temporary,name,amount,category,date);
        expenseManager=new ExpenseManager();
        expenseManager.addNewEntry(expense);
        System.out.println("Sucessfully Entered.");
        Initialize();

    }


    private void getDate() {
		// TODO Auto-generated method stub
    	
		
	}
	void getData(){
		File file;
		FileReader read=null;
		BufferedReader buffer;
        try {
             file = new File("Expense.txt");
             read = new FileReader(file);
             buffer = new BufferedReader(read);
            String temp = null;

            while((temp= buffer.readLine())!= null){
                expenses.add(temp);
            }
            
        }catch (IOException e){

        }finally{
        	
        }
        try {
			read.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(expenses.size()+"");
    }

    public void modifyEntry(){

    }
    public void delete(){
    	System.out.println("Enter the id you want to delete");
    	int j=scan.nextInt();
    	for(int i=0;i<expenses.size();i=i+5){
    		if(j==Integer.parseInt(expenses.get(i))){
    			expenses.remove(j);
    			expenses.remove(j);
    			expenses.remove(j);
    			expenses.remove(j);
    			expenses.remove(j);
    		}
     	}
    	
    	//writeFile();
		expenseManager=new ExpenseManager();
		expenseManager.addAllEntry(expenses);
    }
    private void writeFile() throws IOException {
		// TODO Auto-generated method stub
    	File file= new File("Expense.txt");
    	file.delete();
    	FileWriter writer = new FileWriter("Expense.txt"); 
    	for(String str: expenses) {
    	  writer.write(str);
    	}
    	writer.close();
		
	}
	public static void main(String args[]){
        new ExpenceTracker();
    }
}
