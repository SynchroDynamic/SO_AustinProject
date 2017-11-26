package austinproject;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ChooseFile {

    private JFrame frame;

    public ChooseFile() {
        frame = new JFrame();

        frame.setVisible(true);
        
    }

    public File getFile() throws Exception {
        JFileChooser fc = new JFileChooser();
        BringToFront();
        if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(null)) {
            frame.setVisible(false);
            return fc.getSelectedFile();
        } else {
            throw new Exception("Next time select a file.");
            
        }
        
    }

    public File setFile() throws Exception {

        JFileChooser fc = new JFileChooser();
        BringToFront();
        if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(null)) {
            frame.setVisible(false);

            try {

                File file = fc.getSelectedFile();

                if (file.createNewFile()) {
                    System.out.println("File is created!");
                } else {
                    System.out.println("File already exists.");
                }
                
                return fc.getSelectedFile();

            } catch (IOException e) {
               throw new Exception("Unable to create file");
            }

        } else {
            throw new Exception("Next time select a file.");
        }
        
        
    }

    private void BringToFront() {
        frame.setExtendedState(JFrame.ICONIFIED);
        frame.setExtendedState(JFrame.NORMAL);

    }

}
