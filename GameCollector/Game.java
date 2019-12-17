//class that represents a game in the collection
public class Game {
	private String title;
	private String console;
	private String releaseDate;
	
	public Game(String title, String console, String releaseDate) {
		this.title = title;
		this.console = console;
		this.releaseDate = releaseDate;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setConsole(String console) {
		this.console = console;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getConsole() {
		return console;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
}
