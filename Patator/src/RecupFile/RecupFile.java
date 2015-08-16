package RecupFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RecupFile {
	public byte[] getFile(String file) {
		File myFile = new File(file);
		byte[] myByteArray = new byte[(int) myFile.length()];
		BufferedInputStream fi;
			try {
				fi = new BufferedInputStream(new FileInputStream(myFile));
				fi.read(myByteArray, 0, myByteArray.length);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		return myByteArray;
	}
}
