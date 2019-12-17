import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//a java program that allows users to add games and consoles to their collection
public class GameCollector {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Collection gameCollect = new Collection();
		Collection consoleCollect = new Collection();
		Backlog backlog = new Backlog();
		int choice = 1;
		File games = new File("games collection.txt");
		File consoles = new File("consoles collection.txt");
		File backlogFile = new File("backlog.txt");
		
		try {
			//create new files when the user launches the application
			FileWriter gamesWriter = new FileWriter(games);
			FileWriter consolesWriter = new FileWriter(consoles);
			FileWriter backlogWriter = new FileWriter(backlogFile);
			do {
				System.out.println("Select a function: ");
				System.out.println("0 - End program");
				System.out.println("1 - add game to collection");
				System.out.println("2 - add console to collection");
				System.out.println("3 - add game to backlog");
				System.out.println("4 - remove a game from collection");
				System.out.println("5 - remove a console from collection");
				System.out.println("6 - remove a game from backlog");
				System.out.println("7 - display collection of games");
				System.out.println("8 - display collection of consoles");
				System.out.println("9 - display backlog");
				choice = input.nextInt();
				
				//adds a game to the collection
				if(choice == 1) {
					System.out.println("What is the title of the game?");
					input.nextLine();
					String title = input.nextLine();
					System.out.println("What platform do you own it on?");
					input.nextLine();
					String platform = input.nextLine();
					System.out.println("When was it released? Enter in mm/dd/yyyy format");
					String releaseDate = input.next();
					Game newGame = new Game(title, platform, releaseDate);
					gameCollect.addGame(newGame);
					gamesWriter.write(title);
					
				}
							
				//adds a system to the collection
				else if(choice == 2) {
					System.out.println("What is the name of the console?");
					input.nextLine();
					String name = input.nextLine();	
					System.out.println("What is the release date? Enter in mm/dd/yyyy format");
					String releaseDate = input.next();	
					Console newConsole = new Console(name, releaseDate);
					consoleCollect.addConsole(newConsole);
					consolesWriter.write(name);
				}
							
				//adds a game to the backlog
				else if(choice == 3) {
					System.out.println("What is the title of the game?");
					input.nextLine();
					String title = input.nextLine();			
					System.out.println("What platform do you own it on?");
					input.nextLine();
					String platform = input.nextLine();		
					System.out.println("When was it released? Enter in mm/dd/yyyy format");
					String releaseDate = input.next();	
					Game backlogGame = new Game(title, platform, releaseDate);
					backlog.addGame(backlogGame);
					backlogWriter.write(title);
				}
							
				//removes a game from the collection
				else if(choice == 4) {
					System.out.println("The size of your collection of games is " + gameCollect.getSize());
					System.out.println("Enter the element of the game in the collection that you would like to remove: ");
					int removeIndex = input.nextInt();
								
					gameCollect.removeGame(removeIndex);
					String title = gameCollect.getGameTitle(removeIndex);
					Path path = Paths.get(games.getAbsolutePath());
					Charset charset = StandardCharsets.UTF_8;
					String content = new String(Files.readAllBytes(path), charset);
					content = content.replaceAll(title, "");
					Files.write(path, content.getBytes(charset));
						
				}
							
				//remove a console from the collection
				else if(choice == 5) {
					System.out.println("The size of your collection of consoles is " + consoleCollect.getSize());
					System.out.println("Enter the element of the console in the collection that you would like to remove: ");
					int removeIndex = input.nextInt();
								
					consoleCollect.removeConsole(removeIndex);
					String name = consoleCollect.getConsoleName(removeIndex);
					Path path = Paths.get(consoles.getAbsolutePath());
					Charset charset = StandardCharsets.UTF_8;
					String content = new String(Files.readAllBytes(path), charset);
					content = content.replaceAll(name, "");
					Files.write(path, content.getBytes(charset));
					
				}
							
				//remove a game from the backlog
				else if(choice == 6) {
					System.out.println("The size of your backlog is " + backlog.getSize());
					System.out.println("Enter the element of the game in the backlog that you would like to remove: ");
					int removeIndex = input.nextInt();
							
					backlog.removeGame(removeIndex);
					String title = backlog.getGameTitle(removeIndex);
					Path path = Paths.get(backlogFile.getAbsolutePath());
					Charset charset = StandardCharsets.UTF_8;
					String content = new String(Files.readAllBytes(path), charset);
					content = content.replaceAll(title, "");
					Files.write(path, content.getBytes(charset));
				}
							
				//display game collection
				else if(choice == 7) {
					for(int i = 0; i < gameCollect.getSize(); i++) {
						System.out.println(gameCollect.getGameTitle(i));
					}
				}
							
				//display console collection
				else if(choice == 8) {
					for(int i = 0; i < consoleCollect.getSize(); i++) {
						System.out.println(consoleCollect.getConsoleName(i));
					}
				}
							
				//display backlog
				else if(choice == 9) {
					for(int i = 0; i < backlog.getSize(); i++) {
						System.out.println(backlog.getGameTitle(i));
					}
				}
				else if(choice > 9) {
					System.out.println("Enter a valid command.");
				}
			//loop runs while choice does not equal 0
			}while(choice != 0);
			gamesWriter.close();
			consolesWriter.close();
			backlogWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			input.close();
		}
	}
}
