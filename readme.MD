## **Specification**

After a file compression failure, all the white space among words in a text file was lost. Write a program which utilizes dynamic programming to get all of the possible original documents (i.e. with white spaces between words) and ranks them in order of likelihood; all in minimal time. 

### What you have at your disposal: 

- List of unsorted top 100000 English words most used up until August 2005 which includes #comments showing you the popularity class of the word in the language: dictionary.txt



### Methodology: 

- Assume your input document will be in the form of a text file

- Your output should be a series of files, each containing one the possible original documents as well as a console print out (and/or additional file) including the ranking of the outputs.

- For simplicity you may assume that only the words in the dictionary will show up in your compressed text.

- Your program will need to know how to handle punctuation that separate sentences such as: . ? ! ;

- You may remove words with none-English letters and other problems from the library

- You may also remove all the single letter words except for 'I' , 'A', and 'a' from the library or handle them in another way. If you do not handle this situation your program will create exponentially many outputs.
