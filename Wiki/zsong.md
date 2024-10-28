# About

A .zsong file is a file for songs to be loaded by the [Games.notegame](/Games/Games.java#L16) script.

## Contents of .zsong

### Summary

Every chunk in a .zsong file will include a NOTE_DATA, COLOR_DATA, and SONG_DATA chunk.

These files can be read as text files.

Every chunk will start with START_\[CHUNK NAME\] and end with END_\[CHUNK NAME\].

Inbetween an end of a chunk and start of a chunk can be any data. this can be used as space for comments.

#### NOTE_DATA & COLOR_DATA

The NOTE_DATA and COLOR_DATA chunks will always be 4 lines.

The COLOR_DATA chunk will always be the same length as NOTE_DATA in terms of notes, with an added 3 RETURN values, which will be explained below.

### NOTE_DATA

The contents of the NOTE_DATA chunk are composed of one Hexadecimal-Byte per note.

This determines the volume of the note.

### COLOR_DATA

The contents of the COLOR_DATA chunk are composed of 3 hexadeimal bytes per note.

This chunk determines the background color of each note.

#### Color Values

Along with 3-byte hexadecimal colors, there are CONTIN, RETURN, and RESETT values.
- CONTIN: copy the color from the previous note.
- RETURN: always on the end of each line, except for the last line.
- RESETT: reset the color back to the terminal's default.

### SONG_DATA

The contents of the SONG_DATA chunk are composed of 2 lines of plaintext content.

The content is arranged in this order:
- song name
- song description

## Example of file contents

```
START_NOTE_DATA
00 00 00 00 00 00 00 00 11 11 11 11 11 11 11 11 
00 00 00 00 11 11 11 11 00 00 00 00 11 11 11 11 
00 00 11 11 00 00 11 11 00 00 11 11 00 00 11 11 
00 11 00 11 00 11 00 11 00 11 00 11 00 11 00 11 
END_NOTE_DATA

Example comment

START_COLOR_DATA
FF0000 CONTIN CONTIN FF0000 FF0000 FF0000 FF0000 FF0000 FF0000 FF0000 FF0000 FF0000 FF0000 FF0000 FF0000 FF0000 RETURN
00FF00 CONTIN CONTIN RESETT CONTIN CONTIN 00FFA0 CONTIN CONTIN 00FF00 00FF00 00FF00 00FF00 00FF00 00FF00 00FF00 RETURN
0000FF 0000FF 0000FF 0000FF 0000FF 0000FF 0000FF RESETT 0000FF 0000FF 0000FF 0000FF 0000FF 0000FF 0000FF 0000FF RETURN
FF00FF FF00FF FF00FF FF00FF FF00FF FF00FF FF00FF RESETT FF00FF FF00FF FF00FF FF00FF FF00FF FF00FF FF00FF FF00FF
END_COLOR_DATA

START_SONG_DATA
Example song name
Example song description
END_SONG_DATA
```