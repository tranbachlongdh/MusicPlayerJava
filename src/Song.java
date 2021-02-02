import java.time.Duration;
import java.math.*;
import java.util.*;

public class Song {
	private String title;
	private Composer composer;
	private String genre;
	private int duration;

	public Song(String title, int duration) {
		this(title, duration, "UNKNOWN", "UNKNOWN");
	}
	
	public Song(String title, int duration, String composerName, String genre) {
		this.title = title;
		this.duration = duration;
		this.genre = genre;
		
		this.composer = Searcher.searchComposer(Library.getComposerList(), composerName);
		if (this.composer==null) {
			Composer newComposer = new Composer(composerName);
			Library.addComposer(newComposer);
			System.out.println("Contructor Song.");
			this.composer = newComposer;
		}
	}

	public String getTitle() {
		return title;
	}

	public Composer getComposer() {
		return composer;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setComposer(Composer composer) {
		this.composer = composer;
	}

	
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String durationFormatter() {
		return String.format("%d:%02d:%02d", duration / 3600, (duration % 3600) / 60, (duration % 60));
	}
	
	
	
	
	
	
	
	
	
}
