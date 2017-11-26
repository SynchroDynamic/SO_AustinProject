package austinproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeremy Santorelli
 */
public class FindWord {

    public String findWords(String str, String search) throws Exception {//This can easily be added into your project

        try {
            String fileText = " " + str + " ";//text from file
            String searchWord = " " + search + " ";//the word being searched
            List<Integer> indexOfSearch = new ArrayList<>();

            /*get indexes*/
            int index = fileText.indexOf(searchWord);
            indexOfSearch.add(index);
            while (index >= 0) {
                index = fileText.indexOf(searchWord, index + 1);
                indexOfSearch.add(index);
                
            }
            
            String fullCarets = "";
            System.out.println(str);//print the text from file
            if(indexOfSearch.size() >= 1){
            for (int j = 0; j < indexOfSearch.size() - 1; j++) {//each index of search word
                String spaces = "";//spaces to caret
                int indexTo = 0;//how many spaces will be added
                if (j < 1 && indexOfSearch.get(j) != -1) {
                    indexTo = indexOfSearch.get(j);//the first index
                } else if (indexOfSearch.get(j) != -1) {
                    indexTo = (indexOfSearch.get(j) - indexOfSearch.get(j - 1) - 1);//all other indexes in the row
                }
                if (indexTo >= 0 && indexOfSearch.get(j) != -1) {
                    for (int i = 0; i < indexTo; i++) {//add appropriate number of spaces to word  
                        spaces += " ";//add a space
                    }
                    fullCarets += (spaces + "^");
                    System.out.print(spaces + "^");//print the spaces and spaces
                }
            }
            
            System.out.println("");//used to make the print slightly easier to look at.
            
            return str + "\n" + fullCarets + "\n";
            }
            return "";
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
        
    }    
}
