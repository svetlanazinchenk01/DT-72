package z;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilewithText {
    String name;
    String path;
    File file;
    boolean bool= true;

    public FilewithText() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public void openFile(String path) {
        this.path=path;
        List<File> lst = new ArrayList<>();

        try {
            java.lang.String EXTENSION = ".txt";
            java.io.File[] files = new java.io.File(path).listFiles(new ExtensionFilter(EXTENSION));
            lst = Arrays.asList(files);
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if (lst.isEmpty()){
            bool=false;
        }

        else {
            bool=true;

            System.out.println("You can open " + lst.size() + " file(s)");

            for (int i = 1; i <= lst.size(); i++)
                System.out.println(String.valueOf(i) + ". " + lst.get(i - 1));

            int swValue;
            swValue = Keyin.inInt(" Select file");

            int boolen = 2;
            if ((swValue <= lst.size()) && (swValue > 0))
                boolen = 1;

            switch (boolen) {
                case 1:
                    System.out.println("//////////////////////////////////////");
                    System.out.println("Your choice - " + lst.get(swValue - 1));
                    file = lst.get(swValue - 1);
                    name = file.getName();
                    break;
                default:
                    System.out.println("//////////////////////////////////////");
                    System.out.println("Invalid selection");
                    openFile(path);
                    break;
            }
        }
    }


}
