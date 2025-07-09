/**
 * @file CharacterChecker.java
 * @description Main application class for Character Checker with UI and logic
 * @author Vishal Thakur <vishalthakurx@gmail.com>
 * @copyright Copyright (c) 2025 Vishal Thakur
 * @license Character Checker Custom License - All Rights Reserved
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CharacterChecker {
    private static final Logger logger = Logger.getLogger(CharacterChecker.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        
        System.out.println("Welcome to Character Checker - Educational Character Analysis Tool");
        
        while (running) {
            displayMenu();
            try {
                int choice = getUserChoice();
                
                switch (choice) {
                    case 1:
                        analyzeSingleCharacter();
                        break;
                    case 2:
                        analyzeString();
                        break;
                    case 3:
                        processTextFile();
                        break;
                    case 4:
                        showEncodingTutorial();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Thank you for using Character Checker!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (InvalidInputException e) {
                System.out.println("Input error: " + e.getMessage());
                logger.log(Level.WARNING, "Invalid input provided", e);
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                logger.log(Level.SEVERE, "Unexpected error", e);
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Analyze a Single Character");
        System.out.println("2. Analyze a String");
        System.out.println("3. Process a Text File");
        System.out.println("4. Character Encoding Tutorial");
        System.out.println("0. Exit");
        System.out.print("\nEnter your choice: ");
    }

    private static int getUserChoice() throws InvalidInputException {
        try {
            String input = scanner.nextLine().trim();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid number");
        }
    }

    private static void analyzeSingleCharacter() throws InvalidInputException {
        System.out.print("\nEnter a single character to analyze: ");
        String input = scanner.nextLine();
        
        if (input.length() != 1) {
            throw new InvalidInputException("Please enter exactly one character");
        }
        
        char c = input.charAt(0);
        
        System.out.println("\n===== CHARACTER ANALYSIS =====");
        System.out.println("Character: '" + c + "'");
        System.out.println("Unicode value: U+" + String.format("%04X", (int) c) + " (decimal: " + (int) c + ")");
        System.out.println("Binary: " + Integer.toBinaryString(c));
        System.out.println("Hexadecimal: 0x" + Integer.toHexString(c).toUpperCase());
        
        System.out.println("\nCharacter Properties:");
        System.out.println("- Letter: " + Character.isLetter(c));
        System.out.println("- Digit: " + Character.isDigit(c));
        System.out.println("- Whitespace: " + Character.isWhitespace(c));
        System.out.println("- Uppercase: " + Character.isUpperCase(c));
        System.out.println("- Lowercase: " + Character.isLowerCase(c));
        System.out.println("- Letter or Digit: " + Character.isLetterOrDigit(c));
        System.out.println("- ASCII: " + (c < 128));
        System.out.println("- Control Character: " + Character.isISOControl(c));
        System.out.println("- Defined in Unicode: " + Character.isDefined(c));
        
        if (Character.isLetter(c)) {
            System.out.println("\nCase conversion:");
            System.out.println("- To uppercase: '" + Character.toUpperCase(c) + "'");
            System.out.println("- To lowercase: '" + Character.toLowerCase(c) + "'");
        }
    }

    private static void analyzeString() {
        System.out.print("\nEnter a string to analyze: ");
        String input = scanner.nextLine();
        
        if (input.isEmpty()) {
            System.out.println("Empty string provided.");
            return;
        }
        
        int length = input.length();
        int letters = 0, digits = 0, whitespace = 0, uppercase = 0, lowercase = 0, other = 0;
        
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                letters++;
                if (Character.isUpperCase(c)) {
                    uppercase++;
                } else if (Character.isLowerCase(c)) {
                    lowercase++;
                }
            } else if (Character.isDigit(c)) {
                digits++;
            } else if (Character.isWhitespace(c)) {
                whitespace++;
            } else {
                other++;
            }
        }
        
        System.out.println("\n===== STRING ANALYSIS =====");
        System.out.println("String: \"" + input + "\"");
        System.out.println("Length: " + length + " characters");
        
        System.out.println("\nCharacter Type Distribution:");
        System.out.printf("- Letters: %d (%.1f%%)\n", letters, (letters * 100.0) / length);
        System.out.printf("- Digits: %d (%.1f%%)\n", digits, (digits * 100.0) / length);
        System.out.printf("- Whitespace: %d (%.1f%%)\n", whitespace, (whitespace * 100.0) / length);
        System.out.printf("- Other: %d (%.1f%%)\n", other, (other * 100.0) / length);
        
        if (letters > 0) {
            System.out.println("\nCase Distribution:");
            System.out.printf("- Uppercase: %d (%.1f%% of letters)\n", uppercase, (uppercase * 100.0) / letters);
            System.out.printf("- Lowercase: %d (%.1f%% of letters)\n", lowercase, (lowercase * 100.0) / letters);
        }
        
        System.out.println("\nReversed string: \"" + new StringBuilder(input).reverse() + "\"");
    }

    private static void processTextFile() {
        System.out.print("\nEnter the path to a text file: ");
        String filePath = scanner.nextLine();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            int lines = 0;
            
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
                lines++;
            }
            
            String text = content.toString();
            int chars = text.length();
            String[] words = text.split("\\s+");
            
            System.out.println("\n===== FILE ANALYSIS =====");
            System.out.println("File: " + filePath);
            System.out.println("Size: " + chars + " characters");
            System.out.println("Lines: " + lines);
            System.out.println("Words (approx): " + words.length);
            
            // Character frequency analysis
            Map<Character, Integer> charFreq = new HashMap<>();
            for (char c : text.toCharArray()) {
                charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
            }
            
            System.out.println("\nTop 10 most common characters:");
            charFreq.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .limit(10)
                    .forEach(entry -> {
                        char c = entry.getKey();
                        String display = c == '\n' ? "\\n (newline)" : 
                                        c == ' ' ? "  (space)" :
                                        c == '\t' ? "\\t (tab)" : 
                                        Character.toString(c);
                        System.out.printf("'%s': %d occurrences (%.1f%%)\n", 
                                display, 
                                entry.getValue(), 
                                (entry.getValue() * 100.0) / chars);
                    });
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            logger.log(Level.WARNING, "File reading error", e);
        }
    }

    private static void showEncodingTutorial() {
        System.out.println("\n===== CHARACTER ENCODING TUTORIAL =====");
        System.out.println("\nASCII vs Unicode:");
        System.out.println("- ASCII (American Standard Code for Information Interchange)");
        System.out.println("  * 7-bit encoding scheme (0-127)");
        System.out.println("  * Represents basic Latin letters, digits, and symbols");
        System.out.println("  * Limited to English language characters");
        System.out.println("\n- Unicode");
        System.out.println("  * Universal character encoding standard");
        System.out.println("  * Can represent characters from all writing systems");
        System.out.println("  * Currently over 143,000 characters defined");
        System.out.println("  * UTF-8, UTF-16, and UTF-32 are common implementations");
        
        System.out.println("\nCharacter Categories in Java:");
        System.out.println("Java's Character class provides methods to check character properties:");
        System.out.println("- isLetter() - letters from any language");
        System.out.println("- isDigit() - digits from any numbering system");
        System.out.println("- isWhitespace() - spaces, tabs, newlines, etc.");
        System.out.println("- isUpperCase() / isLowerCase() - case checking");
        System.out.println("- isLetterOrDigit() - combined letter or digit check");
        
        System.out.println("\nInteresting Facts:");
        System.out.println("- The most common character in English text is the space");
        System.out.println("- 'e' is typically the most common letter in English text");
        System.out.println("- Some languages have characters that change form based on position");
        System.out.println("- Emoji characters are part of Unicode (they're just special characters!)");
        System.out.println("- Some Unicode characters require more than one 'char' in Java (surrogate pairs)");
    }
}
