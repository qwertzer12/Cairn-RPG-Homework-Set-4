package Data;

public class World {
    String gameName;
    String publisher;

    public World() {
        this.gameName = "Cairn RPG";
        this.publisher = "AJ Chabin, Samuel Chapin";
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}