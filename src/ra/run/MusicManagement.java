package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;

public class MusicManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("************************MUSIC-MANAGEMENT*************************");
        Singer singer = new Singer();
        Song song = new Song();
        while (true){
            System.out.println("1. Singer Management");
            System.out.println("2. Song Management");
            System.out.println("3. Find Song");
            System.out.println("4. Sign Out");

            byte choice = Byte.parseByte(singer.inputFromUser(scanner, "\\d")) ;

            switch (choice){
                case 1 :

                    while (true){
                        System.out.println("************************SINGER-MANAGEMENT*************************");
                        System.out.println("1. Add Singer");
                        System.out.println("2. Display All Singer");
                        System.out.println("3. Update By Id");
                        System.out.println("4. Delete By Id");
                        System.out.println("5. Sign Out");
                        byte choiceSinger = Byte.parseByte(singer.inputFromUser(scanner, "\\d")) ;

                        switch (choiceSinger){

                            case 1 :
                                singer.inputData(scanner);
                                break;
                            case 2 :
                                singer.displayData();
                                break;
                            case 3 :
                                singer.updateSingerById(scanner);
                                break;
                            case 4 :
                                singer.deleteSingerById(scanner);
                                break;
                            case 5 :
                               return;
                            default:
                                System.out.println("Your choice is out of range");
                                break;

                        }
                    }


                case 2 :

                    while (true){
                        System.out.println("************************SONG-MANAGEMENT*************************");
                        System.out.println("1. Add Song");
                        System.out.println("2. Display All Song");
                        System.out.println("3. Update By Id");
                        System.out.println("4. Delete By Id");
                        System.out.println("5. Sign Out");
                        byte choiceSong = Byte.parseByte(song.inputFromUser(scanner, "\\d")) ;

                        switch (choiceSong){
                            case 1 :
                                song.addSong(scanner);
                                break;
                            case 2 :
                                song.displayAllSong();
                                break;
                            case 3 :
                                song.updateSongById(scanner);
                                break;

                            case 4 :
                                song.deleteSongById(scanner);
                                break;
                            case 5 :
                                return;
                            default:
                                System.out.println("Your choice is out of range");
                                break;

                        }
                    }


                case 3 :

                    while (true){
                        System.out.println("************************SEARCH-MANAGEMENT*************************");
                        Syst`em.out.println("1. Find Song By SingerName or description");
                        System.out.println("2. Find Singer By Singer Name");
                        System.out.println("3. Display 10 songs create by nearest");
                        System.out.println("4. Sign Out");
                        byte choiceSearch = Byte.parseByte(song.inputFromUser(scanner, "\\d")) ;

                        switch (choiceSearch){
                            case 1 :
                                song.addSong(scanner);
                                break;
                            case 2 :
                                singer.searchByNameSinger(scanner);
                                break;
                            case 3 :
                                song.updateSongById(scanner);
                                break;

                            case 4 :
                                song.deleteSongById(scanner);
                                break;
                            case 5 :
                                return;
                            default:
                                System.out.println("Your choice is out of range");
                                break;

                        }
                    }

                case 4 :
                    return;


                default:
                    System.out.println("Your choice is out of range");

                break;
            }
        }
    }
}
