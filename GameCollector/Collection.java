import java.util.ArrayList;

//class that creates a new collection for the user
public class Collection {
	private int size;
	private ArrayList<Game> collectGames = new ArrayList<Game>();
	private ArrayList<Console> collectConsoles = new ArrayList<Console>();
	
	public Collection() {
		
	}
	
	public String getGameTitle(int elem) {
		return collectGames.get(elem).getTitle();
	}
	
	public String getConsoleName(int elem) {
		return collectConsoles.get(elem).getName();
	}
	
	public void addGame(Game game) {
		collectGames.add(game);
		size++;
	}
	
	public void removeGame(int element) {
		collectGames.remove(element);
		size--;
	}
	
	public void addConsole(Console console) {
		collectConsoles.add(console);
		size++;
	}
	
	public void removeConsole(int element) {
		collectConsoles.remove(element);
		size--;
	}
	
	public int getSize() {
		return size;
	}
}
