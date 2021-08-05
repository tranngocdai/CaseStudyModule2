package Model;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Song {
    private int idSong = 0;
    private String name, author, singer;

    public Song() {

    }

    public Song(String name, String author, String singer) {
        this.idSong = idSong;
        this.name = name;
        this.author = author;
        this.singer = singer;
    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID bài hát: ");
        idSong = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập tên bài hát:");
        name = sc.nextLine();

        System.out.println("Nhập tên nhạc sĩ: ");
        author = sc.nextLine();

        System.out.println("Nhập tên ca sĩ:");
        singer = sc.nextLine();
    }

    public void display() {
        System.out.println(this);
    }

    public String getFileLine() {
        return idSong + "," + name + "," + author + "," + singer + "\n";
    }

    public void parse(String line) {
        String[] params = line.split(",");

        try {
            idSong = parseInt(params[0]);
            name = params[1];
            author = params[2];
            singer = params[3];
        } catch (ArrayIndexOutOfBoundsException ex) {
        } finally {
        }

    }

    @Override
    public String toString() {
        return "Song{" +
                "idSong=" + idSong +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}
