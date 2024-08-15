// NAME: Anthony Gillard
// DATE: 2-26-23

// MAIN IDEA:
// Loop/go through each line
// At each charcter, check all directions for the full word.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFind {

    // Check word if the first char of the word matchs the grid char
    public static boolean checkWordExist(char[][] grid, String originalWord) {

        // In case a word is give with a space ex. Grocery Store
        String word = originalWord;
        word = word.replace(" ", "");

        // Count number of searches
        int counter = 0;

        // Fully traverse through grid (rows and columns)
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                counter++;

                // Make sure the grid and column is in bound
                if (row >= grid.length || row < 0 || column >= grid[row].length || column < 0) {
                    System.out.print("Out Of Bounds");
                    System.exit(0);
                }

                // Check to make sure the word length is valid
                if (word.length() > grid.length) {
                    System.out.print(word + " is bigger than the grid length, invalid word");
                    System.exit(0);
                }

                // Check is one char is given
                if (grid[row][column] == word.charAt(0) && oneChar(grid, word, row, column, counter)) {
                    return true;
                }

                // Search in all 8 directions once first char is matched
                if (grid[row][column] == word.charAt(0) && horizontal(grid, word, row,
                        column, counter, originalWord)) {
                    return true;
                } else if (grid[row][column] == word.charAt(0) && vertical(grid, word, row,
                        column, counter, originalWord)) {
                    return true;
                } else if (grid[row][column] == word.charAt(0) && diagonal(grid, word, row,
                        column, counter, originalWord)) {
                    return true;
                }

                /*
                 * // Search in all 8 directions once first char is matched
                 * /*
                 * up: -1,0
                 * down: 1,0
                 * east: 0,1
                 * west: 0,-1
                 * 
                 * /*
                 * int[] x = { -1, 1, 0, 0 };
                 * int[] y = { 0, 0, 1, -1 };
                 * 
                 * // If the FIRST character match begin the search
                 * if (grid[row][column] == word.charAt(0)) {
                 * 
                 * int r = 0;
                 * int c = 0;
                 * 
                 * // Search in all 8 directions
                 * for (int d = 0; d < 8; d++) {
                 * int j = 1;
                 * 
                 * // Search Code:
                 * r = x[row];
                 * c = y[column];
                 * 
                 * // Check if next chars match, if not break
                 * if (grid[row][column + j] != word.charAt(j)) {
                 * break;
                 * }
                 * 
                 * // If at that position the character matches, increment j
                 * if (grid[r][c] == word.charAt(j)) {
                 * j++;
                 * }
                 * 
                 * if (j == word.length()) {
                 * return true;
                 * }
                 * 
                 * }
                 * }
                 */
            }
        }

        // Return false if no word is found in all 8 directions
        return false;

    }

    public static boolean oneChar(char[][] grid, String word, int row, int column, int counter) {
        // Incase only a single character is given
        if (word.length() == 1) {
            if (grid[row][column] == word.charAt(0)) {
                int r = row + 1;
                int c = column + 1;
                System.out.println(word + " was found " + r + ", " + c + " ." + "(" + counter + ")");
                return true;
            }
        }
        return false;
    }

    // BRUTE FORCE STRING MATCHING (LEVITIN):
    public static boolean horizontal(char[][] grid, String word, int row, int column, int counter,
            String originalWord) {
        // Left to right
        for (int i = 0; i < grid.length - word.length();) {
            int j = 1;
            while (j < word.length()) {
                // Check Bounds
                if (column + j >= grid[row].length || column + j < 0) {
                    break;
                }

                // Check if next chars match, if not break
                if (grid[row][column + j] != word.charAt(j)) {
                    break;
                }

                // if next chars match, will increment j
                if (grid[row][column + j] == word.charAt(j)) {
                    j = j + 1;
                }
            }

            if (j == word.length()) {
                int r = row + 1;
                int c = column + 1;
                System.out.println(
                        originalWord + " was found starting " + r + ", " + c + " oriented East. " + "(" + counter
                                + ")");
                return true;
            }
            break;
        }

        // Right to left
        for (int i = 0; i < grid.length - word.length();) {
            int j = 1;
            while (j < word.length()) {
                if (column - j < 0 || column - j >= grid[row].length) {
                    break;
                }

                if (grid[row][column - j] != word.charAt(j)) {
                    break;
                }

                if (grid[row][column - j] == word.charAt(j)) {
                    j = j + 1;
                }
            }

            if (j == word.length()) {
                int r = row + 1;
                int c = column + 1;
                System.out.println(
                        originalWord + " was found starting " + r + ", " + c + " oriented West. " + "(" + counter
                                + ")");
                return true;
            }
            break;
        }
        return false;
    }

    public static boolean vertical(char[][] grid, String word, int row, int column, int counter, String originalWord) {
        // Up
        for (int i = 0; i < grid.length - word.length();) {
            int j = 1;
            while (j < word.length()) {
                if (row - j > grid.length || row - j < 0) {
                    break;
                }

                if (grid[row - j][column] != word.charAt(j)) {
                    break;
                }

                if (grid[row - j][column] == word.charAt(j)) {
                    j = j + 1;
                }
            }

            if (j == word.length()) {
                int r = row + 1;
                int c = column + 1;
                System.out.println(
                        originalWord + " was found starting " + r + ", " + c + " oriented North. " + "(" + counter
                                + ")");
                return true;
            }
            break;
        }

        // Down
        for (int i = 0; i < grid.length - word.length();) {
            int j = 1;
            while (j < word.length()) {
                if (row + j >= grid.length || row + j < 0) {
                    break;
                }

                if (grid[row + j][column] != word.charAt(j)) {
                    break;
                }

                if (grid[row + j][column] == word.charAt(j)) {
                    j = j + 1;
                }
            }

            if (j == word.length()) {
                int r = row + 1;
                int c = column + 1;
                System.out.println(
                        originalWord + " was found starting " + r + ", " + c + " oriented South. " + "(" + counter
                                + ")");
                return true;
            }
            break;
        }

        return false;
    }

    public static boolean diagonal(char[][] grid, String word, int row, int column, int counter, String originalWord) {
        // North East
        for (int i = 0; i < grid.length - word.length();) {
            int j = 1;
            while (j < word.length()) {
                if (row - j > grid.length || row - j < 0 || column + j >= grid[row].length || column + j < 0) {
                    break;
                }

                if (grid[row - j][column + j] != word.charAt(j)) {
                    break;
                }

                if (grid[row - j][column + j] == word.charAt(j)) {
                    j = j + 1;
                }
            }

            if (j == word.length()) {
                int r = row + 1;
                int c = column + 1;
                System.out
                        .println(originalWord + " was found starting " + r + ", " + c + " oriented North East. " + "("
                                + counter
                                + ")");
                return true;
            }
            break;
        }

        // North West
        for (int i = 0; i < grid.length - word.length();) {
            int j = 1;
            while (j < word.length()) {
                if (row - j > grid.length || row - j < 0 || column - j < 0 || column - j >= grid[row].length) {
                    break;
                }

                if (grid[row - j][column - j] != word.charAt(j)) {
                    break;
                }

                if (grid[row - j][column - j] == word.charAt(j)) {
                    j = j + 1;
                }
            }

            if (j == word.length()) {
                int r = row + 1;
                int c = column + 1;
                System.out
                        .println(originalWord + " was found starting " + r + ", " + c + " oriented North West. " + "("
                                + counter
                                + ")");
                return true;
            }
            break;
        }

        // South East
        for (int i = 0; i < grid.length - word.length();) {
            int j = 1;
            while (j < word.length()) {
                if (row + j >= grid.length || row + j < 0 || column + j >= grid[row].length || column + j < 0) {
                    break;
                }

                if (grid[row + j][column + j] != word.charAt(j)) {
                    break;
                }

                if (grid[row + j][column + j] == word.charAt(j)) {
                    j = j + 1;
                }
            }

            if (j == word.length()) {
                int r = row + 1;
                int c = column + 1;
                System.out
                        .println(originalWord + " was found starting " + r + ", " + c + " oriented South East. " + "("
                                + counter
                                + ")");
                return true;
            }
            break;
        }

        // South West
        for (int i = 0; i < grid.length - word.length();) {
            int j = 1;
            while (j < word.length()) {
                if (row + j >= grid.length || row + j < 0 || column - j < 0 || column - j >= grid[row].length) {
                    break;
                }

                if (grid[row + j][column - j] != word.charAt(j)) {
                    break;
                }

                if (grid[row + j][column - j] == word.charAt(j)) {
                    j = j + 1;
                }
            }

            if (j == word.length()) {
                int r = row + 1;
                int c = column + 1;
                System.out
                        .println(originalWord + " was found starting " + r + ", " + c + " oriented South West. " + "("
                                + counter
                                + ")");
                return true;
            }
            break;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {

        String str = "";
        ArrayList<char[]> Array = new ArrayList<char[]>();
        char[][] grid = new char[100][100];

        if (args[0].length() < 1) {
            System.err.print("No file given, input a file name: ");
        } else {
            File file = new File(args[0]);

            try (Scanner scan = new Scanner(file)) {
                while (scan.hasNextLine()) {
                    str = scan.nextLine().trim().concat("\n").replaceAll(" ", "");

                    // Except character, and digits replace all.
                    str = str.replaceAll("[^a-zA-Z0-9]+", "");

                    if (str.length() != 0) {
                        Array.add(str.toCharArray());
                    }
                }

                grid = new char[Array.size()][100];

                for (int i = 0; i < Array.size(); i++) {
                    grid[i] = (char[]) Array.get(i);
                }

                // Words
                if (args.length == 2) {
                    File wordFile = new File(args[1]);
                    try (Scanner sc = new Scanner(wordFile)) {
                        String words = "";
                        while (sc.hasNextLine()) {
                            words = sc.nextLine().toUpperCase();
                            if (checkWordExist(grid, words)) {

                            } else {
                                System.out.println(words + " was not found");
                            }
                        }
                    }

                } else {
                    try (Scanner sc = new Scanner(System.in)) {
                        while (true) {
                            System.out.print("Input: ");
                            String userInput = sc.nextLine().toUpperCase();
                            System.out.println();
                            if (userInput.isEmpty()) {
                                System.exit(0);
                            }

                            if (checkWordExist(grid, userInput)) {
                            } else {
                                System.out.println(userInput + " was not found");
                            }
                        }
                    }
                }
            }
        }
    }
}