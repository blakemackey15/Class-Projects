import java.util.ArrayList;

//a class that allows users to add and remove consoles or games to their bakclog
public class Backlog {
	private int size;
	private ArrayList<Game> backlog = new ArrayList<Game>();
	
	public Backlog() {
		
	}
	
	public String getGameTitle(int elem) {
		return backlog.get(elem).getTitle();
	}
	
	public void addGame(Game game) {
		backlog.add(game);
		size++;
	}
	
	public void removeGame(int element) {
		backlog.remove(element);
		size--;
	}
	
	public int getSize() {
		return size;
	}
}
