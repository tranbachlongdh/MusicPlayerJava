import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.math.*;
import java.util.*;
import java.util.List;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static Playlist nowPlaying = new Playlist("Now Playing");
	private static Playlist recentlyPlayed = new Playlist("Recently Played");
	private static ArrayList<Playlist> playlists = new ArrayList<>();

	private static Mp3Player mp3Player;


	public static void playAllSongs(){
		// Clear all old songs in the list
		Editor.clearPlaylist(nowPlaying.getSongs());

		// Add all new songs to the linkedList
		System.out.println("There are " + Adder.addSongsToPlaylist(nowPlaying, Library.getSongs()) +
							" song have been added to " + nowPlaying.getName());

		// Play the Now Playing playlist
		mp3Player.playSongs(nowPlaying);

	}

	public static void songsMenu(){
		String choice;
		boolean exit = false;
		Displayer.songsMenu();
		while (!exit) {
			System.out.println("Choose your option:");
			choice = scanner.nextLine();
			switch (choice) {
				case "1": {
					playAllSongs();
					break;
				}
				case "2": {
					// Stop
					break;
				}
				case "3": {
//					// Shuffle
					break;
				}
				case "4": {
					// Search
					break;
				}
				case "5": {
					// Add to playlist
					break;
				}
				case "6": {
					// Love
					break;
				}
				case "0": {
					Displayer.songsMenu();
					break;
				}
				case "9": {
					exit = true;
				}
			}

			//while
		}
	}

	public static void playListsMenu(){
		String choice;
		boolean exit = false;
		Displayer.playListsMenu();
		while (!exit) {
			System.out.println("Choose your option:");
			choice = scanner.nextLine();
			switch (choice) {
				case "1": {

					break;
				}
				case "2": {
					// Stop
					break;
				}
				case "3": {
//					// Shuffle
					break;
				}
				case "4": {
					// Search
					break;
				}
				case "5": {
					// Add to playlist
					break;
				}
				case "6": {
					// Love
					break;
				}
				case "0": {
					Displayer.playListsMenu();
					break;
				}
				case "9": {
					exit = true;
				}
			}

			//while
		}
	}

	public static void main(String[] args) throws IOException, ReadOnlyFileException, TagException, InvalidAudioFrameException, CannotReadException {

		playlists.add(nowPlaying);
		playlists.add(recentlyPlayed);

		String choice;
		boolean exit = false;
		Displayer.mainMenu();
		String path;

		while (!exit) {
			Displayer.mainMenu();
			System.out.println("Choose your option:");
			choice = scanner.nextLine();
			switch (choice) {
				case "0": {
					Displayer.mainMenu();
					break;
				}
				case "1": {
					path = ProcessDir.choosePath();
					Library.addSongs(path);
					break;
				}
				case "2": {
					Displayer.songsMenu();
					songsMenu();
					break;
				}
				case "3": {
					playListsMenu();
					break;
				}
				case "4": {
					Displayer.displayArtist(false);
					break;
				}
				case "5": {
					Displayer.displayAlbum(false);
					break;
				}
				case "6": {
					Displayer.displayGenre(false);
					break;
				}
				case "7": {
					Displayer.displayComposers(false);
					break;
				}
				case "8": {
					playAllSongs();
					break;
				}
				case "9": {
					exit = true;
				}
			}

		//while
		}





		//main
	}





//class
}




//		Song song1 = new Song("My love", 180, "westLife", "westLife", "Road to the West", "POP", 2005);
//		Song song2 = new Song("Uptown girl", 195, "westLife", "westLife", "Road to the West", "POP", 2005);
//		Song song3 = new Song("Flying without wings", 265, "westLife123", "westLife", "Road to the West", "POP", 2005);
//		Song song4 = new Song("Love 5", 265);
//		JFileChooser fileChooser=new JFileChooser();
//		fileChooser.setCurrentDirectory(new File("C:\\Users\\W_Dragon\\Music\\"));
//		fileChooser.setDialogTitle("Select Mp3");
//		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//		fileChooser.setFileFilter(new FileNameExtensionFilter("Mp3 files","mp3"));
//		Component selectButton = null;
//		if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
//			File myFile = fileChooser.getSelectedFile();
//			String filename = fileChooser.getSelectedFile().getName();
//			String filePath = fileChooser.getSelectedFile().getPath();
//		}






