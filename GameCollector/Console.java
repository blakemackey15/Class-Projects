
public class Console {
	private String name;
	private String releaseDate;
	
	public Console(String name, String releaseDate) {
		this.name = name;
		this.releaseDate = releaseDate;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getName() {
		return name;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
}
