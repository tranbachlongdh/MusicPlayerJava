import java.util.*;

public class Editor {
	private static Scanner scanner = new Scanner(System.in);
	
	//----------------------------------Composer-------------------------------------------------------
	
//	public static void editComposerInfo(Composer composer, String name, int age, boolean isGroup) {
//		composer.setName(name);
//		System.out.print("Composer's info has been updated.");
//	}
//	
//	public static void editComposerInfo(Composer composer) {
//		System.out.println("Edit composer's info:");
//		System.out.print("Enter new name:");
//		String name = scanner.nextLine();
//		System.out.print("Age:");
//		int age = scanner.nextInt();
//		scanner.nextLine();
//		System.out.print("Is this a group (Y/N):"); 
//		String isGroup = scanner.nextLine();
//		boolean isGroupBoolean;
//		if (isGroup.toLowerCase().equals("y")) {
//			isGroupBoolean = true;
//		} else {
//			isGroupBoolean = false;
//		}
//		
//		editComposerInfo(composer, name, age, isGroupBoolean);
//	}
	
	//----------------------------------Song-------------------------------------------------------
	
	public static void editSongInfo(Song song, String title, int duration, String composerName, String genreName) {
		song.setTitle(title);
		song.setDuration(duration);
		Composer composer = Searcher.searchComposer(Library.getComposers(), composerName);
		if (composer != null) {
			song.setComposer(composer);
		} else {
			Composer newComposer = new Composer(composerName);
			Library.addComposer(newComposer);
			song.setComposer(newComposer);
		}
		

		Genre genre = Searcher.searchGenre(Library.getGenres(), genreName);
		if (genre != null) {
			song.setGenre(genre);
		} else {
			Genre newGenre = new Genre(genreName);
			Library.addGenre(newGenre);
			song.setGenre(newGenre);
		}
		System.out.print("Song's info has been updated.");
	}
	
	public static void editSongInfo(Song song) {
		System.out.println("Edit Song's info:");
		System.out.print("Enter new song title:");
		String title = scanner.nextLine();
		System.out.print("Duration (second):");
		int duration = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter composer's name:");
		String composerName = scanner.nextLine();
		System.out.print("Genre:");
		String genre = scanner.nextLine();
		
		editSongInfo(song, title, duration, composerName, genre);
	}

	//-----------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
