# Music-Library
MyAudio: Audio App Simulator


Description

This audio app simulator stores and manages audio content of various types, such as, Songs, Audio Books, Podcasts, and Playlists in a personal library. Audio content is downloaded from an audio content store (AudioContentStore.java) and can do many things. In this app, playing a song currently means printing its lyrics and song information. The java programming includes more complex topics like, inheritance, polymorphism, interface comparable, and interface comparator. All the functions of this app are currently working, however the equals method for some of the classes return false due to no use of these methods. 

Java File Purposes

1. Library: The library class contains the personal library with different methods such as, downloading, listing audio content and artists, deleting songs and audio content from library lists and playlists.

2. MyAudioUI: This class has the main() method and the user interface (UI). It reads lines of input from the user to call methods and perform certain actions.

3. AudioContentStore: This class simulates an online store to download content from to go to your library. It consists of predefined songs and audiobooks.

4. AudioContent: This superclass has subclasses, Song, Audiobook, and Podcast. These are essentially objects representing a type of audio content.

5. Playlist: This class is also a type of audio content but it is not an extension of AudioContent because it contains an array list of audio content. 

6. Season: This subclass is an extension of the Podcast class because a podcast consists of seasons with episodes.
