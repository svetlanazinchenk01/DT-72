import java.io.*;
import java.util.*;

class Main {

    public static final Comparator<String> COMPARE = new Comparator<String>() {

        @Override
        public int compare(String a1, String a2) {
            return a1.compareToIgnoreCase(a2);

        }
    };

    public static void main(String[] args) throws FileNotFoundException {

        Scanner MLP = new Scanner(new FileReader("D:\\3 курс\\t5\\DataTask5"));
        LinkedList<String> list = new LinkedList();

        while (MLP.hasNext()) {
            String word = MLP.next();
            list.add(word);
        }

        Collections.sort(list, COMPARE);
        System.out.print(list);

    }
}
