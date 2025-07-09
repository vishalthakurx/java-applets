/**
 * @file InvalidInputException.java
 * @description Custom exception for input validation in Character Checker application
 * @author Vishal Thakur <vishalthakurx@gmail.com>
 * @copyright Copyright (c) 2025 Vishal Thakur
 * @license MIT License
 */

public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
    
    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
