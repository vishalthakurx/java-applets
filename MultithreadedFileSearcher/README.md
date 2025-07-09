# Multithreaded File Searcher

**Author:** Vishal Thakur  
**Email:** vishalthakurx@gmail.com  
**GitHub:** [@vishalthakurx](https://github.com/vishalthakurx)

## Description
A powerful file search tool that uses Java threads and concurrency utilities to search for keywords in files across directories.

## Features
- Recursive directory traversal
- Multithreaded file processing
- Thread pool management
- Line-by-line keyword matching
- Detailed search results with file paths and line numbers

## How to Run
```bash
javac MultithreadedFileSearcher.java
java MultithreadedFileSearcher <directory> <keyword>
```

### Example
```bash
java MultithreadedFileSearcher /path/to/search "public class"
```

## Concepts Demonstrated
- **Multithreading**: ExecutorService and thread pools
- **File I/O**: BufferedReader for efficient file reading
- **Recursion**: Directory traversal
- **Concurrency**: Parallel file processing
- **Command Line Arguments**: Program argument handling

## Educational Value
Excellent for learning concurrent programming, file handling, and performance optimization through parallelization.
