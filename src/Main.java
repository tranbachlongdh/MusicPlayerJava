import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import java.io.IOException;
import java.time.Duration;
import java.math.*;
import java.util.*;

public class Main {
	
//	private static ArrayList<Album> albumList = new ArrayList<Album>();

	public static void main(String[] args) throws IOException, ReadOnlyFileException, TagException, InvalidAudioFrameException, CannotReadException {
		Date date = new Date();
		
//		Song song1 = new Song("My love", 180, "westLife", "westLife", "Road to the West", "POP", 2005);
//		Song song2 = new Song("Uptown girl", 195, "westLife", "westLife", "Road to the West", "POP", 2005);
//		Song song3 = new Song("Flying without wings", 265, "westLife123", "westLife", "Road to the West", "POP", 2005);
//		Song song4 = new Song("Love 5", 265);
		String path = "C:\\Users\\W_Dragon\\Music\\";

		// Get the list of Mp3 files in directory
		List<String> mp3List = ProcessDir.process(path);

		// Go through each file and add to library
		for(String s : mp3List) {
			List<String> fileInfo = ProcessDir.mp3FileInfo(s);
			Library.addSong(new Song(fileInfo.get(0), fileInfo.get(1), Integer.valueOf(fileInfo.get(2)), fileInfo.get(3),  fileInfo.get(4),  fileInfo.get(5), fileInfo.get(5), Integer.valueOf(fileInfo.get(7))));
		}
		
//		Library.addSong(song1);
//		Library.addSong(song2);
//		Library.addSong(song3);
//		Library.addSong(song4);
		
		
//		Playlist myPlaylist = new Playlist("myPlaylist");
//		Adder.addSongToPlaylist(myPlaylist, song1);
//		Adder.addSongToPlaylist(myPlaylist, song2);
//		Adder.addSongToPlaylist(myPlaylist, song3);
//		Adder.addSongToPlaylist(myPlaylist, song4);
		
		Displayer.displaySongs(Library.getSongs(), true);
//		Displayer.displayByProperty("composer", true);
//		Displayer.displayByProperty("genre", true);

//		Displayer.displayByProperty("composer", true);
//		Displayer.displayGenres(genres, isFullInfo);
		
		
		
		
		
//		Library.getSongList();
		
		
		
//		ArrayList<Song> songList = new ArrayList<Song>();
//
//		

//		
//		Album album1 = new Album("Road to the West", westLife, date, songList);
//		album1.addSong(song1);
//		album1.addSong(song2);
//		album1.addSong(song3);
//		
//		Album album2 = new Album("Road to the West", westLife, date, songList);
//		album2.addSong(song1);
//		album2.addSong(song2);
//		album2.addSong(song3);
//		album2.addSong(song3);
//		
//		albumList.add(album1);
//		albumList.add(album2);
//		
//		for (int i=0; i<albumList.size(); i++) {
//			Album album = albumList.get(i);
//			album.listAllSong(true);
//		}
	}
}
