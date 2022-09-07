package library;

import java.io.File;
import java.util.List;

public class NameToLower {

    public void rename(String directory) {

        List<String> pathNames = FileWorker.makeList(directory);
        if (pathNames == null) {
            return;
        }

        int counter = 0;
        for (String path : pathNames) {
            ++counter;
            File file = new File(directory + "\\" + path);

            String path2 = path.toLowerCase().replace(' ', '_');

            File file2 = new File(directory + "\\" + (path2));
            if (file.renameTo(file2)) {
                System.out.println("Renamed " + path + " to " + path2);
            } else {
                System.out.println("Can't rename");
            }
        }
        System.out.println("Processed files: " + counter);
    }
}
