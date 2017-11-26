package austinproject;

import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ProcessTextFile {

    File inputPath;
    File outputPath;

    public ProcessTextFile(File inputPath, File outputPath) {//constructor
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    public void getNumberOfWords() throws IOException {

        File file = this.inputPath;
        Scanner s = new Scanner(file);
        HashSet<String> lib = new HashSet<>();

        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            int count = 0;
            while (sc.hasNext()) {
                sc.next();
                count++;
            }
            System.out.println();
            System.out.println("The total number of word in the file is: " + count);
        }

        while (s.hasNext()) {
            String data = s.nextLine();
            String[] pieces = data.split("\\s+");
            for (int count = 0; count < pieces.length; count++) {
                if (!lib.contains(pieces[count])) {
                    lib.add(pieces[count]);
                }
            }
        }

        System.out.print("The total number of different word in the file is: " + lib.size());

    }

    public void findSearchWord() throws FileNotFoundException, IOException, Exception {

        FindWord f = new FindWord();

        BufferedReader br = new BufferedReader(new FileReader(this.inputPath));
        StringBuilder buffer = new StringBuilder();
        String str;

        while ((str = br.readLine()) != null) {
            buffer.append(str);
            buffer.append(" ");
        }

        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(buffer.toString());

        while (st.hasMoreTokens()) {
            String si = st.nextToken();
            list.add(si);
        }

        HashSet<String> set = new HashSet<>(list);
        List<String> arrayList = new ArrayList<>(set);
        Collections.sort(arrayList);

        System.out.printf("%nWords of the input file in ascending order without duplication");
        System.out.printf("%n//");
        System.out.printf("%n// ");

        for (Object ob : arrayList) {
            System.out.print(ob.toString());
            System.out.print(" ");
        }

        System.out.printf("%n// (the content of this portion is subject to the input text file)");
        System.out.printf("%n//");
        System.out.println();

        try {
            Scanner input = new Scanner(System.in);
            boolean again = true;
            boolean notTheFirst = false;
            while (again) {
                String doItAgain = "y";
                if (notTheFirst) {
                    System.out.println("Search again? (Y/any key) ");
                    doItAgain = input.next();
                }
                if ("y".equals(doItAgain) || "Y".equals(doItAgain)) {
                    notTheFirst = true;
                    System.out.printf("%n%s", "Please enter a search pattern: ");
                    String wordToSearch = input.next();

                    if (wordToSearch.equals("EINPUT")) {
                        System.out.printf("%s", "Bye!");
                        System.exit(0);
                    }

                    String data;
                    try (FileInputStream fis = new FileInputStream(this.inputPath.getPath())) {
                        byte[] buffer2 = new byte[fis.available()];
                        fis.read(buffer2);
                        data = new String(buffer2);
                    }

                    File file2 = this.outputPath;
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
                        Scanner in = new Scanner(data);
                        writer.append("\nSearching for: " + wordToSearch + "\n");
                        while (in.hasNext()) {
                            
                            String line = in.nextLine();
                            //System.out.printf("Line number " + getLine(data, matcher.start()), "%s%o%n");
                            String stringToFile = f.findWords(line, wordToSearch);
                            
                            writer.append(stringToFile);
                            
                        }
                    }
                } else {
                    System.exit(0);
                }
            }

        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }

    }

    static int getLine(String data, int start) {

        int line = 1;
        Pattern pattern = Pattern.compile("\n");
        Matcher matcher = pattern.matcher(data);
        matcher.region(0, start);

        while (matcher.find()) {
            line++;
        }

        return line;
    }

    public File getInputPath() {
        return inputPath;
    }

    public void setInputPath(File inputPath) {
        this.inputPath = inputPath;
    }

    public File getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(File outputPath) {
        this.outputPath = outputPath;
    }

}
