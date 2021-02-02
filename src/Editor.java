import java.util.*;

public class Editor {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void editComposerInfo(Composer composer) {
		System.out.println("Edit composer's info:");
		System.out.print("Enter name:");
		String name = scanner.nextLine();
		System.out.print("Age:");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Is this a group:");
		boolean isGroup = scanner.nextBoolean();
		scanner.nextLine();
		
		editComposerInfo(composer, name, age, isGroup);
	}
	
	public static void editComposerInfo(Composer composer, String name, int age, boolean isGroup) {
		composer.setName(name);
		composer.setAge(age);
		composer.setIsGroup(isGroup);
		System.out.print("Composer's info has been updated.");
	}
	
	public static void editSongInfo(Song song) {
		System.out.println("Edit Song's info:");
		System.out.print("Enter song title:");
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
	
	public static void editSongInfo(Song song, String title, int duration, String composerName, String genre) {
		song.setTitle(title);
		song.setDuration(duration);
		Composer composer = Searcher.searchComposer(Library.getComposerList(), composerName);
		if (composer != null) {
			song.setComposer(composer);
		} else {
			song.setComposer(new Composer(composerName));
		}
		
		song.setGenre(genre);
		System.out.print("Song's info has been updated.");
	}

}
