/**
 * 
 */
package blankfiller;

import java.io.*;
import java.util.Scanner;

/**
 * Go through a file full of numbers, and for each number that is NOT there, print a specified line containing that number.
 * Originally designed for updating the config.xml of the Office Proofing Tools installer to reduce extraneous installations.
 * @author zschuetz
 * @created 2017.05.19 zschuetz
 */
public class BlankFiller {

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
			for (int i=1025; i<2100; i++) {
				boolean localDebug=false;
				numSought=String.valueOf(i);
				//check if it's in there somewhere
				iFound=content.contains(numSought);
				if (localDebug) {
					if (iFound) {System.out.println("here's one");}					
				}
				//skip it if it is, add it if it's not
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
