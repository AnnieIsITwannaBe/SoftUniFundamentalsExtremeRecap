package TextProcessingEx;

import java.util.Scanner;

public class ExtractFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        int lastIndex = getFileName(line, sb);

        sb.append(System.lineSeparator());

        getFileExtension(line, lastIndex, sb);

        handleOutput(sb);
    }

    private static void handleOutput(StringBuilder sb) {
        System.out.println(sb.toString());
    }

    private static void getFileExtension(String line, int lastIndex, StringBuilder sb) {
        String fileExtension = line.substring(lastIndex + 1);

        sb.append("File extension: ").append(fileExtension);
    }

    private static int getFileName(String line, StringBuilder sb) {
        int fileNameStartIndex = line.lastIndexOf("\\");
        int lastIndex = line.indexOf(".");

        String fileName = line.substring(fileNameStartIndex + 1, lastIndex);
        sb.append("File name: ").append(fileName);
        return lastIndex;
    }
}
