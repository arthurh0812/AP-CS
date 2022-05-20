package constuctor;

public class AlbumRunner {
    public static void main(String[] args) {

        //Test-1
        Album a = new Album("MC K", 9);
        System.out.println(a.getArtistTracks());

        //Test-2
        Album b = new Album(2);
        System.out.println(b.getTracks());

        //Test-3
        Album c = new Album("The Bland Band", 5);
        System.out.println(c.getTracks());
    }
}

