package austinproject;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * This is where you would configure your Application and run what you would
 * like.
 *
 * @author Jeremy Santorelli
 */
public class startup {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        /*CHOOSE FILES*/
        //ChooseFile c = new ChooseFile();
        //File incoming = c.getFile(); 
        //File outgoing = c.setFile();
        
        /*OR HARDCODE THEM IN*/
        File incoming = new File("src/wordfile.txt");
        File outgoing = new File("src/wordFileOutput.txt");

        ProcessTextFile p = new ProcessTextFile(incoming, outgoing);

        try {
            p.getNumberOfWords();
            p.findSearchWord();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }



}
