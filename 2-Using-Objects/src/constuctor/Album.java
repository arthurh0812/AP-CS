package constuctor;

public class Album {
    private String artist;
    private int tracks;

    public Album(int t) {
        artist = "";
        tracks = t;
    }

    public Album(String a, int t) {
        artist = a;
        tracks = t;
    }

    public String getArtistTracks() {
        return artist + "-" + tracks;
    }

    public int getTracks() {
        return tracks;
    }
}
