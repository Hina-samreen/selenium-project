package de.ecom.hilfsprog;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class CSVFileUtility {
	
	@Test
	public static void CSVFileRead(String FilePath) throws IOException {
		
		CSVReader reader = new CSVReader(new FileReader(FilePath));

		  List<String[]> list=reader.readAll();
		  
		  //System.out.println("Total rows which we have is "+list.size());
		  System.out.println("Total rows which we have is "+list.size());
		            
		 // create Iterator reference
		  Iterator<String[]>iterator= list.iterator();
		    
		 // Iterate all values 
		 while(iterator.hasNext()){
		     
		 String[] str=iterator.next();
		   
		 System.out.print(" Values are ");

		 for(int i=0;i<str.length;i++)
		{

		   System.out.print(" "+str[i]);

		}
		   System.out.println("   ");
		     
		    
		}
		 
		 reader.close();
		
	}

}
