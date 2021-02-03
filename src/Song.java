import java.time.Duration;
import java.math.*;
import java.util.*;

public class Song {
	private String title;
	private Composer composer;
	private Genre genre;
	private int duration;
	private int year;
	private boolean isSuggest = false;
	

	public Song(String title, int duration) {
		this(title, duration, "UNKNOWN", "UNKNOWN", 0, false);
	}
	
	public Song(String title, int duration, String composerName, String genreName, int year, boolean isSuggest) {
		this.title = title;
		this.duration = duration;
//		this.genre = genre;
		this.year = year;
		this.isSuggest = isSuggest;
		
		this.composer = Searcher.searchComposer(Library.getComposers(), composerName);
		if (this.composer==null) {
			Composer newComposer = new Composer(composerName);
			Library.addComposer(newComposer);
			this.composer = newComposer;
		}
		this.genre = Searcher.searchGenre(Library.getGenres(), genreName);
		if (this.genre==null) {
			Genre newGenre = new Genre(genreName);
			Library.addGenre(newGenre);
			this.genre = newGenre;
		}
		
	}

	public String getTitle() {
		return title;
	}

	public Composer getComposer() {
		return composer;
	}
	
	public Genre getGenre() {
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

	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isSuggest() {
		return isSuggest;
	}

	public void setSuggest(boolean isSuggest) {
		this.isSuggest = isSuggest;
	}

	public String durationFormatter() {
		return String.format("%d:%02d:%02d", duration / 3600, (duration % 3600) / 60, (duration % 60));
	}
	
	
	
	
	
	
	
	
	
}
