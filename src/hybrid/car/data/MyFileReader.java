package hybrid.car.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * The Class MyFileReader.
 */
public class MyFileReader {
	
	/** The file. */
	private String file;
	
	/**
	 * Instantiates a new my file reader.
	 *
	 * @param filename the filename
	 */
	public MyFileReader(String filename)
	{
		this.file = filename;
	}
	
	/**
	 * Read file.
	 *
	 * @return the file's lines in array list
	 */
	public ArrayList<String> readFile()
	{

		  BufferedReader inputStream = null;
		  ArrayList<String> tokens = new ArrayList<String>();

		  try {
		    inputStream = new BufferedReader(new FileReader(file));
		    String input;
		    while ((input = inputStream.readLine()) != null) {
		        tokens.add(input);
		    }
		  } catch(IOException ioe){
		    System.out.println("Error Reading the file !!!");
		    System.out.println(ioe);
		    return null;
		  }
		  return tokens;
	}
	
	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName()
	{
		return file;
	}

}
