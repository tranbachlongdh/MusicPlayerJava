public class Song {
	private String path;
	private String title;
	private String composer;
	private String artist;
	private String album;
	private String genre;
	private int duration;
	private int year;
	private boolean isSuggest;
	
	private static final String UNKNOWN = "UNKNOWN"; 

	public Song(String title, int duration) {
		this("C:\\Users\\W_Dragon\\Music\\"+title, title, duration, UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN , 0);
	}
	
	
	public Song(String path, String title, int duration, String composer, String artist, String album, String genre, int year) {
		this.path = path;
		this.title = title;
		this.composer = composer.isEmpty()?UNKNOWN:composer;
//		this.composer = composer;
		this.artist = artist.isEmpty()?UNKNOWN:artist;
		this.album = album.isEmpty()?UNKNOWN:album;
		this.genre = genre.isEmpty()?UNKNOWN:genre;
		this.duration = duration;
		this.year = year;
		this.isSuggest = false;
	}


	public String getPath() { return path; }

	public void setPath(String path) { this.path = path; }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
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
	
	// Method to transform duration to specific format of hh:mm:ss
	public String durationFormatter() {
		return String.format("%d:%02d:%02d", duration / 3600, (duration % 3600) / 60, (duration % 60));
	}
	
	
	
	
	
	
}
