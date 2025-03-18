package Data;

public class World {
    private String gameName;
    private String publisher;


    public World() {
        this.setGameName("Cairn RPG");
        this.setPublisher("AJ Chabin, Samuel Chapin");
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

