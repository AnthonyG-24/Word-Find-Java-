[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=10194427&assignment_repo_type=AssignmentRepo)
# WordFind
<!-----
NEW: Check the "Suppress top comment" option to remove this info from the output.

Conversion time: 0.33 seconds.


Using this Markdown file:

1. Paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β31
* Sat Oct 16 2021 10:16:34 GMT-0700 (PDT)
* Source doc: PA02 WordFind
----->


See the (Adobe Acrobat) **_WordFind.pdf_** file for a basic description of the problem. Below are clarifications and specific requirements.

Write your name email clearly at the beginning of any files you submit. We'll use GitHub Classroom for WIP and Final Submission. **Important: Commit early and often.**

Name your program (i.e., your main class) **WordFind**. (That's an uppercase 'W' and uppercase 'F', and the rest of the characters are lowercase.)

Copies of the two files described below for the Cashiers, North Carolina puzzle are available in this repo.

Your program should accept two command line arguments (also called "command line parameters").

The word-find grid should be read in when your program starts. Read it from the filename specified as the first command line argument.

The second command line argument is optional. If it exists, it will be the name of the file containing the list of words to search for. If this argument is present (and the file exists), you will search for each of the words in the file, and print the word and its location (if found). If the word was not found, indicate this fact. Print this information to _standard output_. (If you want to capture the results to a file, redirect the output to a file.)

(Characterizing a command line argument as _optional _does **_not_** mean you can choose to implement it or not, depending on how you feel. Rather, it means that when the program is invoked, it can be invoked with or without the command line argument. Your program needs to do one thing if it's invoked with one command line argument, and something different if it's invoked with two command line arguments.)

Optional: Your program should keep track of the number of comparisons made in searching for each word. Print this number at the end of the same line as your output for the word searched for, in parentheses.

Program output should closely match the sample.

* Adhere to the grid numbering scheme used in the example.
* Print only one line for each word searched for.
* Do not print extra blank lines after each word is found.
* Only print the word you're searching for once.
* Don't forget to print a message if the word isn't found, as indicated.
* Stop your search after the first occurrence of the search word is found.
* Ignore case in your comparisons.
* Print your comparison count whether the word is found or not.
* Your comparison counts will differ from the sample.

If the second command line argument isn't present, prompt for a word to search for, and read a single word/phrase from the keyboard. Print the results as in the example, and then prompt the user for another word. If no word is entered, exit the program.

The word-find grid will have _r_ rows and _c_ columns. The format of the word-find file grid will be 2_r_+1 strings, each on a separate line, and each string of length 2_c_+1. You may assume _r_ and _c_ are each greater than zero and less than 100, but _r_ and _c_ are not necessarily equal. Each line will be separated by a line of hyphens (-), and each letter on a line will be separated by a vertical bar (|). Note you may be asked to find a _phrase,_ multiple words separated by the space character. These phrases appear in the grid without spaces. (But, in your output, it's best to print the phrase _with_ spaces.)

The format of the word list file will be an arbitrary number of words to search for, each word on a separate line. If no input files are given (i.e., no command line arguments are specified), or if a specified file does not exist, print an error message and cleanly exit the program. You need not handle improperly constructed input files in any particular way (i.e., it is okay if your program crashes with input files that do not match the above specification).

Your program should handle input files that were created in both the Unix and Windows environments. (These environments have different line-ending characters.) I do not expect you'll need to do extra work to satisfy this requirement; rather, I expect you to avoid making your program unnecessarily dependent on files created in one environment versus another.
