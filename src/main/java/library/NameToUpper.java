package library;

import java.io.File;
import java.util.List;

public class NameToUpper {

    public void rename(String directory) {

        List<String> pathNames = FileWorker.makeList(directory);
        if (pathNames == null) {
            return;
        }

        int counter = 0;
        for (String path : pathNames) {
            ++counter;
            File file = new File(directory + "\\" + path);
            StringBuilder path2 = new StringBuilder();
            boolean previousSpace = true;

            for (char c : path.toCharArray()) {
                if (c == '.') {
                    path2.append(".mp3");
                    break;
                } else if (c == '_') {
                    previousSpace = true;
                    c = ' ';
                    path2.append(c);
                } else if (previousSpace) {
                    previousSpace = false;
                    c = Character.toUpperCase(c);
                    path2.append(c);
                } else {
                    path2.append(c);
                }
            }
            File file2 = new File(directory + "\\" + String.valueOf(path2));
            if (file.renameTo(file2)) {
                System.out.println("Renamed " + path + " to " + path2);
            } else {
                System.out.println("Can't rename");
            }
        }
        System.out.println("Processed files: " + counter);
    }
}
