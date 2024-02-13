import java.util.*;

public class MusicPlayer {
    private String[] songTitles;
    private String[] artists;
    private String[] genres;
    private int numSongs;

    public MusicPlayer(){
        songTitles = new String[100];
        artists = new String[100];
        genres = new String[100];
        numSongs = 0;
    }

    public void addSong(String title, String artist, String genre){
        if(numSongs == songTitles.length){
            //Expand arrays if full
            String[] newTitles = new String[songTitles.length * 2];
            String[] newArtists = new String[artists.length * 2];
            String[] newGenres = new String[genres.length * 2];
            //copy existing songs to new arrays
            //source array, sourcepos, destArray, destPos, length
            System.arraycopy(songTitles, 0, newTitles, 0, songTitles.length);
            System.arraycopy(artists, 0, newArtists, 0, artists.length);
            System.arraycopy(genres, 0, newGenres, 0, genres.length);
            songTitles = newTitles; //naya title ka length banaya tho usko songTitles mein store karenge
            artists = newArtists; //newArtist banaya tho store in artists, artists mein update karenge
            genres = newGenres;
        }
        // Add the new song information to arrays
        songTitles[numSongs] = title;
        artists[numSongs] = artist;
        genres[numSongs] = genre;
        //Increment the number of songs
        numSongs++;
        System.out.println("Song added successfully!");
        }

        //Remove a song from the library by index 
        public void removeSong(int index){
            // check if index is valid 
            if(index < 0 || index >= numSongs) {
                //index smaller than 0 or greater than number of songs obviously it wont work well!
                System.out.println("Invalid song index");
                return;
        }
        // Shift songs after the removed one to the left
        //if you remove the song from the ith postion, then at that position i+1 element will substitue it
        for(int i = index;  i < numSongs - 1; i++) {
            songTitles[i] = songTitles[i + 1];
            artists[i] = artists[i + 1];
            genres[i] = genres[i + 1];
        }
        // Decrement the number of songs
        numSongs--;
        System.out.println("Song has been removed, Successfully!.");
    }

    //Search for songs conatining the search term in title, artist  or genre
    public void searchSongs(String searchTerm){
        boolean found = false; //flag to indicate to find songs
        //search through each song
        for (int i=0; i<numSongs ; i++){
            //convert everytging to lowercase for case-inselitivity
            String  lowerTitle = songTitles[i].toLowerCase();
            String  lowerArtist = artists[i].toLowerCase();
            String  lowerGenre = genres[i].toLowerCase();
            String lowerSearchTerm = searchTerm.toLowerCase();
            //checking if the lowerSearchterm elemsnts match lowerTitle, lowerArtist or lowerGenre
            if (lowerTitle.contains(lowerSearchTerm) || lowerArtist.contains(lowerSearchTerm) || lowerGenre.contains(lowerSearchTerm)){
                System.out.println("Song: " + songTitles[i] + " , Artist: " + artists[i] + " and Genre: " + genres[i]);
                found = true; //set flag to indicate that song was found
            }
    }
    if(!found){
        System.out.println("No  Song Found!");
    }
}
//printing all the songs in the library

public void printAllsongs(){
    //checking if there are any songs
    if(numSongs == 0){
        System.out.println("There is no song in this Library");
        return;
    }
    for(int i = 0; i < numSongs; i++){
        System.out.println("Song: " + songTitles[i] + ", Artist: " + artists[i] + ", Genre: " + genres[i]);

    }
}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    MusicPlayer player = new MusicPlayer();

    //loop for interacting with the music player
    while(true){
        System.out.println("\n Music Player Menu: ");
        System.out.println("1. Add a Song");
        System.out.println("2. Remove a song");
        System.out.println("3. Search for Songs");
        System.out.println("4. Print All Songs");
        System.out.println("5. Exit the Programme");
        System.out.println("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                    System.out.println("Enter Song Title");
                    String title =  sc.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = sc.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = sc.nextLine();
                    player.addSong(title, artist, genre);
                    break;

            case 2:
                    System.out.print("Enter the index of the song to remove: ");
                    int index = sc.nextInt();
                    player.removeSong(index);
                    break;
            
            case 3:
                    System.out.print("Enter a search term: ");
                    String searchTerm = sc.nextLine();
                    player.searchSongs(searchTerm);
                    break;

            case 4:
                    player.printAllsongs();
                    break;
            
            case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

            //default is compulasory in switch case
            default:
                    System.out.println("Invalid Choice. Please try again.");

    }
}
}
}
