package patator.tree;

import java.io.File;
import java.util.ArrayList;

public class Tree {

	private ArrayList<File> test;
	
	public Tree(String arg){
		
		test = new ArrayList<File>();
		listf(arg, test);
		//System.out.println(test);
		
	}
	public void listf(String directoryName, ArrayList<File> files) {
	    File directory = new File(directoryName);

	    // get all the files from a directory
	    File[] fList = directory.listFiles();
	    for (File file : fList) {
	        if (file.isFile()) {
	            files.add(file);
	        } else if (file.isDirectory()) {
	            listf(file.getAbsolutePath(), files);
	        }
	    }
	}
	
	public String getTree(){
		return test.toString();
	}
}
