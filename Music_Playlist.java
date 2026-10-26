class Node {
    String song;
    Node next;
    public Node(String song) { this.song = song; this.next = null; }
}

class Playlist {
    Node head;

    public void addSong(String song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        System.out.println(song + " added to playlist.");
    }

    public void removeSong(String song) {
        if (head == null) return;
        if (head.song.equals(song)) {
            head = head.next;
            System.out.println(song + " removed.");
            return;
        }
        Node temp = head;
        while (temp.next != null && !temp.next.song.equals(song)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println(song + " removed.");
        } else {
            System.out.println("Song not found.");
        }
    }

    public void displayPlaylist() {
        System.out.print("Playlist: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.song + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }
}

public class MusicPlaylist {
    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist();
        myPlaylist.addSong("Song A");
        myPlaylist.addSong("Song B");
        myPlaylist.addSong("Song C");
        
        myPlaylist.displayPlaylist();
        
        myPlaylist.removeSong("Song B");
        myPlaylist.displayPlaylist();
    }
}
