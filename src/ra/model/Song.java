package ra.model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Song {

    private String songId;
    private int year;
    private boolean songStatus;
    private Singer singer;
    private static byte count = 0;
    private String songName;
    private String description;
    private String songWriter;

    private Song[] songs = new Song[0];

    public Song inputData(Scanner scanner, Singer[] singers) {

        System.out.println("input the singer id you search");
        int singerId = Integer.parseInt(inputFromUser(scanner, "\\w+"));

        for (Singer item : singers) {
            if (item.getSingerId() == singerId) {
               singer =  item;
               break;
            }

        }
        return this;
    }

    public void searchSongBySingerName(){



    }

    public void updateSongById(Scanner scanner) {
        System.out.println("input the singer id you want to update");

        String songId = inputFromUser(scanner, "\\w+");
        boolean isFound = false;
        for (Song song : songs) {

            if (song.getSongId().equalsIgnoreCase(songId)) {

                System.out.println("Input Song Name");
                song.setSongName(inputFromUser(scanner, "\\w+"));

                System.out.println("Input Song Writer");
                song.setSongWriter(inputFromUser(scanner, "\\w+"));

                System.out.println("Input Song Status");
                song.setSongStatus(Boolean.parseBoolean(inputFromUser(scanner, "(true|false)")));

                System.out.println("Input Song Description");
                song.setDescription(inputFromUser(scanner, "\\w+"));

                System.out.println("Input Song Year");
                song.setYear(Integer.parseInt(inputFromUser(scanner, "\\w+")));
                isFound = true;
            }

        }
        if (!isFound) {
            System.out.println("Song Id not found");
        }

    }

    public void deleteSongById(Scanner scanner) {
        System.out.println("input the song id you want to delete");


        String songId = inputFromUser(scanner, "S\\w{3}");
        boolean isFound = false;

        Song[] newArr = new Song[songs.length - 1];

        byte newIndex = 0;
        for (Song song : songs) { // Use a 'for-each' loop for cleaner iteration
            if (song.getSongId().equals(songId)) {
                isFound = true;
            } else {
                newArr[newIndex++] = song; // Only copy if not deleting
            }
        }

        songs = newArr;

        if (!isFound) {
            System.out.println("Song Id not found");
        } else {
            System.out.println("Delete Successfully.");
        }

    }

    public void displayAllSong() {
        if (songs.length == 0) {
            System.out.println("Song Array is empty");
        }
        for (Song song : songs) {
            System.out.println(song.toString());
        }
    }


    public void addSong(Scanner scanner) {

        System.out.println("How many Song you want to add");

        byte quantity = Byte.parseByte(inputFromUser(scanner, "\\d"));

        byte arrLength = (byte) songs.length;
        Song[] newSongArr = new Song[arrLength + quantity];
        byte currentIndex = 0;

        for (int i = 0; i < arrLength; i++) {
            newSongArr[i] = songs[i];
            currentIndex++;
        }

        for (int i = currentIndex; i < newSongArr.length; i++) {
            newSongArr[currentIndex] = addPerSong(scanner);
            currentIndex++;
        }
        songs = newSongArr;

    }


    public Song addPerSong(Scanner scanner) {

        Song song = new Song();

        System.out.println("Input Song ID, start with S");
        song.setSongId(inputFromUser(scanner, "S\\w{3}"));

        System.out.println("Input Song Name");
        song.setSongName(inputFromUser(scanner, "\\w+"));

        System.out.println("Input New Singer ");

//
//       count++;
//        singer.setSingerId(count);
//        System.out.println("input singer name");
//        singer.setSingerName(inputFromUser(scanner, "\\w+"));
//
//        System.out.println("input singer age");
//        singer.setAge(Integer.parseInt(inputFromUser(scanner, "\\w+")));
//
//        System.out.println("input singer nationality");
//        singer.setNationality(inputFromUser(scanner, "\\w+"));
//
//        System.out.println("input singer gender");
//        singer.setGender(Boolean.parseBoolean(inputFromUser(scanner, "(true|false)")));
//
//        System.out.println("input singer genre");
//        singer.setGenre(inputFromUser(scanner, "\\w+"));
//


        System.out.println("Input Song Writer");
        song.setSongWriter(inputFromUser(scanner, "\\w+"));

        System.out.println("Input Song Status");
        song.setSongStatus(Boolean.parseBoolean(inputFromUser(scanner, "(true|false)")));

        System.out.println("Input Song Description");
        song.setDescription(inputFromUser(scanner, "\\w+"));

        System.out.println("Input Song Year");
        song.setYear(Integer.parseInt(inputFromUser(scanner, "\\w+")));

        return song;
    }

    public void displayTenNearestSong(){
        byte arrLength = (byte) songs.length;
        int temp = 0;
        Song[] newArr = new Song[arrLength];
//        for (int i = 0; i < arrLength; i++) {
//            if (songs[i].getYear() > songs[i++].getYear()) {
//                temp = songs[i].getYear();
//                songs[i].getYear() = songs[i++].getYear();
//                songs[i++].getYear() = temp;
//            }
//        }

        for (Song song: songs){
            System.out.println(song.toString());
        }


    }

    public String inputFromUser(Scanner scanner, String regex) {

        while (true) {
            String inputValue = scanner.nextLine();
            boolean isValid = checkValid(regex, inputValue);
            if (isValid) {
                return inputValue;
            } else {
                System.out.println("Your input is invalid");
            }

        }
    }

    public boolean checkValid(String regex, String content) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();

    }



    public Song() {
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", year=" + year +
                ", songStatus=" + songStatus +
//                ", singer Id=" + singer.getSingerId() +
//                ", singer Name=" + singer.getSingerName() +
//                ", singer Genre=" + singer.getGenre() +
//                ", singer Age=" + singer.getAge() +
//                ", singer Nationlity=" + singer.getNationality() +
                ", songName='" + songName + '\'' +
                ", description='" + description + '\'' +
                ", songWriter='" + songWriter + '\'' +
                '}';
    }

    public Song(String songId, int year, boolean songStatus, Singer singer, String songName, String description, String songWriter) {
        this.songId = songId;
        this.year = year;
        this.songStatus = songStatus;
        this.singer = singer;
        this.songName = songName;
        this.description = description;
        this.songWriter = songWriter;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }
}
