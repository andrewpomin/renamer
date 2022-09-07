package library;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileWorker {

    public static List<String> makeList(String directory) {
        File folder = new File(directory);
        if (!folder.isDirectory()) {
            System.out.println("You chosen not a directory!");
            return null;
        }

        System.out.println("Go to directory: " + directory);
        return Arrays.stream(Objects.requireNonNull(folder.list())).toList();
    }
}
