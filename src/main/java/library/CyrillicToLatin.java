package library;

import java.io.File;
import java.util.List;

public class CyrillicToLatin {

    public void translate(String directory) {

        List<String> pathnames = FileWorker.makeList(directory);
        if (pathnames == null) {
            return;
        }

        int counter = 0;
        for (String path : pathnames) {
            ++counter;
            File file = new File(directory + "\\" + path);
            StringBuilder path2 = new StringBuilder();

            if (CyrillicToLatin.isNeededTranslate(path)) {
                boolean isAllUpperCase = CyrillicToLatin.isNameUpperCase(path);
                char previousLetter = ' ';
                char[] charArray = path.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    if (Character.UnicodeBlock.of(charArray[i]) == Character.UnicodeBlock.CYRILLIC) {
                        char nextLetter = ' ';
                        if (i + 1 < charArray.length) {
                            nextLetter = charArray[i + 1];
                        }
                        path2.append(CyrillicToLatin.changeLetter(charArray[i], previousLetter, nextLetter, isAllUpperCase));
                    } else {
                        path2.append(charArray[i]);
                    }
                    previousLetter = charArray[i];
                }

                File file2 = new File(directory + "\\" + path2);
                if (file.renameTo(file2)) {
                    System.out.println("Renamed " + path + " to " + path2);
                } else if (file2.exists()) {
                    path2 = new StringBuilder(path2.substring(0, path2.indexOf(".")) + " (2).mp3");
                    file2 = new File(directory + "\\" + path2);
                    if (file.renameTo(file2)) {
                        System.out.println("Renamed " + path + " to " + path2);
                    } else {
                        System.out.println("Can't rename");
                    }
                } else {
                    System.out.println("Can't rename");
                }
            }
        }
        System.out.println("Processed files: " + counter);
    }

    public static boolean isNeededTranslate(String path) {
        for (char c : path.toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNameUpperCase(String path) {
        for (char c : path.toCharArray()) {
            if (String.valueOf(c).equals(String.valueOf(c).toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public static String changeLetter(char c, char previous, char next, boolean isWordUpperCase) {
        boolean isNextUpper = String.valueOf(next).equals(String.valueOf(next).toUpperCase());
        switch (c) {
            case 'А':
                return "A";
            case 'а':
                return "a";
            case 'Б':
                return "B";
            case 'б':
                return "b";
            case 'В':
                return "V";
            case 'в':
                return "v";
            case 'Г':
                if (previous == 'з' || previous == 'З') {
                    return "GH";
                } else {
                    return "H";
                }
            case 'г':
                if (previous == 'з' || previous == 'З') {
                    return "gh";
                } else {
                    return "h";
                }
            case 'Ґ':
                return "G";
            case 'ґ':
                return "g";
            case 'Д':
                return "D";
            case 'д':
                return "d";
            case 'Е':
                return "E";
            case 'е':
                return "e";
            case 'Є':
                if (isWordUpperCase) {
                    return "YE";
                } else if (previous == ' ') {
                    if (isNextUpper) {
                        return "YE";
                    } else {
                        return "Ye";
                    }
                } else {
                    return "IE";
                }
            case 'є':
                if (previous == ' ') {
                    return "ye";
                } else {
                    return "ie";
                }
            case 'Ж':
                if (previous == ' ' && !isNextUpper) {
                    return "Zh";
                } else {
                    return "ZH";
                }
            case 'ж':
                return "zh";
            case 'З':
                return "z";
            case 'з':
                return "z";
            case 'И':
                return "Y";
            case 'и':
                return "y";
            case 'І':
                return "I";
            case 'і':
                return "i";
            case 'Ї':
                if (isWordUpperCase) {
                    return "YI";
                } else if (previous == ' ') {
                    if (isNextUpper) {
                        return "YI";
                    } else {
                        return "Yi";
                    }
                } else {
                    return "I";
                }
            case 'ї':
                if (previous == ' ') {
                    return "yi";
                } else {
                    return "i";
                }
            case 'Й':
                if (previous == ' ') {
                    return "Y";
                } else {
                    return "I";
                }
            case 'й':
                if (previous == ' ') {
                    return "y";
                } else {
                    return "i";
                }
            case 'К':
                return "K";
            case 'к':
                return "k";
            case 'Л':
                return "L";
            case 'л':
                return "l";
            case 'М':
                return "M";
            case 'м':
                return "m";
            case 'Н':
                return "N";
            case 'н':
                return "n";
            case 'О':
                return "O";
            case 'о':
                return "o";
            case 'П':
                return "P";
            case 'п':
                return "p";
            case 'Р':
                return "R";
            case 'р':
                return "r";
            case 'С':
                return "S";
            case 'с':
                return "s";
            case 'Т':
                return "T";
            case 'т':
                return "t";
            case 'У':
                return "U";
            case 'у':
                return "u";
            case 'Ф':
                return "F";
            case 'ф':
                return "f";
            case 'Х':
                if (previous == ' ' && !isNextUpper) {
                    return "Kh";
                } else {
                    return "KH";
                }
            case 'х':
                return "kh";
            case 'Ц':
                if (previous == ' ' && !isNextUpper) {
                    return "Ts";
                } else {
                    return "TS";
                }
            case 'ц':
                return "ts";
            case 'Ч':
                if (previous == ' ' && !isNextUpper) {
                    return "Ch";
                } else {
                    return "CH";
                }
            case 'ч':
                return "ch";
            case 'Ш':
                if (previous == ' ' && !isNextUpper) {
                    return "Sh";
                } else {
                    return "SH";
                }
            case 'ш':
                return "sh";
            case 'Щ':
                if (previous == ' ' && !isNextUpper) {
                    return "Shch";
                } else {
                    return "SHCH";
                }
            case 'щ':
                return "shch";
            case 'Ю':
                if (isWordUpperCase) {
                    return "YU";
                } else if (previous == ' ') {
                    if (isNextUpper) {
                        return "YU";
                    } else {
                        return "Yu";
                    }
                } else {
                    return "IU";
                }
            case 'ю':
                if (previous == ' ') {
                    return "yu";
                } else {
                    return "iu";
                }
            case 'Я':
                if (isWordUpperCase) {
                    return "YA";
                } else if (previous == ' ') {
                    if (isNextUpper) {
                        return "YA";
                    } else {
                        return "Ya";
                    }
                } else {
                    return "IA";
                }
            case 'я':
                if (previous == ' ') {
                    return "ya";
                } else {
                    return "ia";
                }
            case 'Ь':
            case 'ь':
            case '`':
            case '\'':
            case 'Ъ':
            case 'ъ':
                return "";
            case 'Ё':
                return "E";
            case 'ё':
                return "e";
            case 'Ы':
                return "Y";
            case 'ы':
                return "y";
            case 'Э':
                return "E";
            case 'э':
                return "e";
            case ',':
            case '.':
            case '(':
            case ')':
            case '-':
            case '_':
            case '&':
                return String.valueOf(c);
        }

        return "?";
    }
}
