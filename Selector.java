/**
 * 
 */
package selector;

import java.io.*;
import java.util.Scanner;

/**
 * Go through a file full of numbers, and for each number that is NOT there, print a specified line containing that number.
 * @author zschuetz
 * @created 2017.05.19 zschuetz
 */
public class Selector {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		boolean iFound=false;
		String numSought=null;
		try {
			File f = new File("src/config_src.txt");
			String content = new Scanner(f).useDelimiter("\\Z").next();
			
			//print lines that aren't there
			for (int i=2100; i<3100; i++) {
				numSought=String.valueOf(i);
				//check if it's in there somewhere
				iFound=content.contains(numSought);
//				if (iFound) {System.out.println("here's one");}
				//add it if it's not
				if (iFound==false) {
					System.out.println("    <OptionState Id=\"ProofingTools_"+i+"\" State=\"Absent\" Children=\"force\"/>");
				}
				//reset
				iFound=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
