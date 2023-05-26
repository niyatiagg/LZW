# LZW
File compression and decompression using LZW algorithm

## Introduction

The subject of the project is to implement a Lempel-Ziv-Welch (LZW) data compression and decompression algorithm using Java Programming Language.

LZW is a lossless algorithm which finds recurring patterns, saves them in a dictionary and replaces them. It uses ASCII values and further builds the dictionary by identifying patters. This algorithm can significantly decrease the size of text files and is often used for data compression. 

### Tools


### Compression

Following is the pseudo code for the LZW compression algorithm:

    STRING = get input character
    WHILE there are still input characters DO
        CHARACTER = get input character
        IF STRING+CHARACTER is in the string table then
            STRING = STRING+character
        ELSE
            output the code for STRING
            add STRING+CHARACTER to the string table
            STRING = CHARACTER
        END of IF
    END of WHILE
    output the code for STRING

### Decompression

 Following is the pseudo code for the LZW decompression algorithm:

    Read OLD
    output OLD
    CHARACTER = OLD
    WHILE there are still input characters DO
        Read NEW
        IF NEW is not in the translation table THEN
            STRING = get translation of OLD
            STRING = STRING+CHARACTER
        ELSE
            STRING = get translation of NEW
        END of IF
        output STRING
        CHARACTER = first character in STRING
        add OLD + CHARACTER to the translation table
        OLD = NEW
    END of WHILE
    
    
