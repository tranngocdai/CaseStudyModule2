package View;

import Model.Song;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongView {
    static List<Song> songList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;

        do {
            showMenu();
            choose = Integer.parseInt(sc.nextLine());
            
            switch (choose) {
                case 1:
                    addSong();
                    break;
                case 2:
                    editSong();
                    break;
                case 3:
                    deleteSong();
                    break;
                case 4:
                    displaySong();
                    break;
                case 5:
                    saveFileSong();
                    break;
                case 6:
                    readFileSong();
                    break;
                case 7:
                    System.out.println("Thoát");
                default:
                    System.out.println("Nhập sai!");
                    break;
            }

        } while (choose != 7);
    }

    private static void readFileSong() {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            fis = new FileInputStream("song.txt");

            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(reader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Song song = new Song();
                song.parse(line);

                songList.add(song);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void saveFileSong() {
        System.out.println("Bắt đầu lưu:");
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("song.txt",true);
            //lưu dữ liệu
            for (Song song1 : songList) {
                String line = song1.getFileLine();
                //chuyển dữ liệu sang dạng byte[]
                byte[] b = line.getBytes(StandardCharsets.UTF_8);
                //save
                fos.write(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void displaySong() {
        for (Song song : songList) {
            song.display();
        }
    }

    private static void deleteSong() {
        System.out.println("Nhập ID bài hát để xoá: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Song song1 : songList) {
            if (song1.getIdSong() == id) {
                songList .remove(song1);
                break;
            }
        }
    }

    private static void editSong() {
        System.out.println("Nhập ID bài hát để sửa: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Song song1 : songList) {
            if (song1.getIdSong() == id) {
                song1.input();
                break;
            }
        }
    }

    private static void addSong() {
        System.out.println("Nhập số lượng bài hát cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            Song song = new Song();
            song.input();
            songList.add(song);
        }
    }

    public static void showMenu() {
        System.out.println("1. Thêm bài hát:");
        System.out.println("2. Sửa thông tin bài hát theo id:");
        System.out.println("3. Xoá bài hát theo id:");
        System.out.println("4. Hiển thị các bài hát:");
        System.out.println("5. Lưu vào file song.txt");
        System.out.println("6. Đọc nội dung file song.txt");
        System.out.println("7. Thoát !");
    }
}
