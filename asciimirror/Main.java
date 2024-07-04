import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path:");
        String filename = scanner.nextLine();
        File file = new File(filename);
        List<String> list = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                list.add(fileScanner.nextLine());
            }
            int longest = 0;
            for (String line : list) {
                longest = Math.max(longest, line.length());
            }
            for (String line : list) {
                String modifiedLine = line + " ".repeat(longest - line.length());
                String reversedModifiedLine = reverseString(modifiedLine);
                System.out.println(modifiedLine + " | " + reversedModifiedLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public static String reverseString(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            switch (str.charAt(i)) {
                case '<': result.append('>'); break;
                case '>': result.append('<'); break;
                case '[': result.append(']'); break;
                case ']': result.append('['); break;
                case '{': result.append('}'); break;
                case '}': result.append('{'); break;
                case '(': result.append(')'); break;
                case ')': result.append('('); break;
                case '/': result.append('\\'); break;
                case '\\': result.append('/'); break;
                default: result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
