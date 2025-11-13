# MyAudio - Music Library App Simulator

**MyAudio** is a Java-based audio console app simulator that allows users to manage and interact with different types of audio content, including Songs, Audiobooks, Podcasts, and Playlists. The app simulates downloading content from an online store and managing a personal library.

---

## Features

- **Personal Library Management:** Store and organize downloaded audio content.
- **Content Types:** Supports Songs, Audiobooks, Podcasts, and Playlists.
- **Simulated Playback:** “Playing” a song prints its lyrics and song information to the console.
- **Library Operations:** Download content, list audio items and artists, delete songs or entire content from the library.
- **Object-Oriented Design:** Utilizes inheritance, polymorphism, and Java interfaces (`Comparable` and `Comparator`) for content management.

---

## Java File Purposes

- **`Library.java`** – Handles the personal library. Provides methods for downloading, listing, and deleting audio content, managing playlists, and querying artists.
- **`MyAudioUI.java`** – Contains the `main()` method and the console-based user interface. Handles user input and executes library operations.
- **`AudioContentStore.java`** – Simulates an online content store with predefined Songs and Audiobooks for download.
- **`AudioContent.java`** – Superclass for audio content objects. Subclasses include `Song`, `Audiobook`, and `Podcast`.
- **`Playlist.java`** – Represents a playlist containing multiple audio content objects. Not a subclass of `AudioContent`.
- **`Season.java`** – Subclass of `Podcast` representing seasons with multiple episodes.

---

## Technologies Used

- Core Java libraries including:
  - `java.util.ArrayList`, `List`, `Collections` for managing lists of content
  - `Comparable` and `Comparator` interfaces for sorting content
  - Object-oriented concepts such as inheritance and polymorphism

---

## Installation

1. Clone the repository:

```bash
git clone https://github.com/your-username/MyAudio.git

