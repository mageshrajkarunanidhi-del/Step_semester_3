import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        p.getSongs()[0] = "Hacked";

        System.out.println(p.getSongs()[0]); // Song A
        System.out.println(p.getSongCount()); // 2
    }
}