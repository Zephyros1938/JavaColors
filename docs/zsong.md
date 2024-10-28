# About

A .zsong file is a file for songs to be loaded by the [Games.notegame](/Games/Games.java#L16) script.

## Contents of .zsong

### Summary

Every chunk in a .zsong file will include a NOTE_\[VOLUME, PITCH, COLOR], and SONG_DATA chunk.

The .zsong file can be human-read.

Every chunk will start with START_\[CHUNK NAME\] and end with END_\[CHUNK NAME\].

Inbetween an end of a chunk and start of a chunk can be any data. this can be used as space for comments/metadata.

#### NOTE_VOLUME, NOTE_PITCH, & NOTE_COLOR

The NOTE_VOLUME, NOTE_PITCH, and NOTE_COLOR chunks will always be 4 lines.

Every chunk should be the same length in terms of note count.

### NOTE_VOLUME

The contents of the NOTE_VOLUME chunk are composed of one Hexadecimal Byte per note.

This determines the volume of the note.

### NOTE_PITCH

The contents of the NOTE_PITCH chunk are composed of one Hexadecimal Byte per note.

This determines the pitch of the note.

### NOTE_COLOR

The contents of the NOTE_COLOR chunk are composed of 1-3 hexadeimal byte\(s\) per note.

#### 24-Bit Color (TrueColor)

Example: `00ff00 0000ff ff0000`

#### 8-Bit Color (256 Color)

Example: `0f0 00f f00`

#### 256-Color

Example: `52 15 c4`

This chunk determines the background color of each note.

#### Unique Values

Along with 3-byte hexadecimal colors, there are CONTIN, and RESETT values.
- CONTIN/CON/CO: copy the color from the previous note.
- RESETT/RES/RS: reset the color back to the terminal's default.

### SONG_DATA

The contents of the SONG_DATA chunk are composed of 2 lines of plaintext content.

The content is arranged in this order:
- song name
- song description

## Example of file contents

```
START_NOTE_VOLUME
00 00 00 00 00 00 00 00 11 11 11 11 11 11 11 11
00 00 00 00 11 11 11 11 00 00 00 00 11 11 11 11
00 00 11 11 00 00 11 11 00 00 11 11 00 00 11 11
00 11 00 11 00 11 00 11 00 11 00 11 00 11 00 11
END_NOTE_VOLUME

START_NOTE_PITCH
1f 1f 1f 1f 2a 2a 2a 2a 1f 1f 1f 1f 2a 2a 2a 2a
2a 2a 2a 2a 1f 1f 1f 1f 2a 2a 2a 2a 1f 1f 1f 1f
3a 3a 3a 3a 2f 2f 2f 2f 3a 3a 3a 3a 2f 2f 2f 2f
2f 2f 2f 2f 3a 3a 3a 3a 2f 2f 2f 2f 3a 3a 3a 3a
END_NOTE_PITCH

START_NOTE_COLOR
ff0000 CONTIN CONTIN ff0000 ff0000 ff0000 ff0000 ff0000 ff0000 ff0000 ff0000 ff0000 ff0000 ff0000 ff0000 ff0000
00ff00 CONTIN CONTIN RESETT CONTIN CONTIN 00ffa0 CONTIN CONTIN 00ff00 00ff00 00ff00 00ff00 00ff00 00ff00 00ff00
0000ff 0000ff 0000ff 0000ff 0000ff 0000ff 0000ff RESETT 0000ff 0000ff 0000ff 0000ff 0000ff 0000ff 0000ff 0000ff
ff00ff ff00ff ff00ff ff00ff ff00ff ff00ff ff00ff RESETT ff00ff ff00ff ff00ff ff00ff ff00ff ff00ff ff00ff ff00ff
END_NOTE_COLOR

START_SONG_DATA
Example Song Name
Example Song Description
END_SONG_DATA
```