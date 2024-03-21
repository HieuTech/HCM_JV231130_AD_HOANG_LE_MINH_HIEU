package ra.model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Singer {
    private static byte count = 0;

    private int singerId;
    private int age;
    private boolean gender;
    private String singerName;
    private String genre;
    private String nationality;

    private Singer[] singers = new Singer[0];

    public Singer() {
    }

    public Singer(int singerId, int age, boolean gender, String singerName, String genre, String nationality) {
        this.singerId = singerId;
        this.age = age;
        this.gender = gender;
        this.singerName = singerName;
        this.genre = genre;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "singerId=" + singerId +
                ", age=" + age +
                ", gender=" + (gender ? "Male" : "Female") +
                ", singerName='" + singerName + '\'' +
                ", genre='" + genre + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    public static byte getCount() {
        return count;
    }

    public static void setCount(byte count) {
        Singer.count = count;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void inputData(Scanner scanner) {

        byte arrLength = (byte) singers.length;
        System.out.println("How many singer you want to add");
        byte quantity = Byte.parseByte(inputFromUser(scanner, "\\w*"));


        Singer[] newSingerArr = new Singer[arrLength + quantity];
        byte currentIndex = 0;


        for (int i = 0; i < arrLength; i++) {
            newSingerArr[i] = singers[i];
            currentIndex++;
        }

        for (int i = currentIndex; i < newSingerArr.length; i++) {
            newSingerArr[i] = addPerSinger(scanner);
            currentIndex++;
        }

        singers = newSingerArr;

    }

    public void searchByNameSinger(Scanner scanner){

        System.out.println("input the singer name you want to search");

        String singerName = inputFromUser(scanner, "\\w+");

        for (Singer singer : singers){

            if(singer.getSingerName().contains(singerName)){
                System.out.println(singer);
            }
        }


    }

    public void updateSingerById(Scanner scanner) {
        System.out.println("input the singer id you want to update");

        int singerId = Integer.parseInt(inputFromUser(scanner, "\\w+"));
        boolean isFound = false;
        for (Singer singer : singers) {

            if (singer.getSingerId() == singerId) {
                System.out.println("input singer name");
                singer.setSingerName(inputFromUser(scanner, "\\w+"));

                System.out.println("input singer age");
                singer.setAge(Integer.parseInt(inputFromUser(scanner, "\\w+")));

                System.out.println("input singer nationality");
                singer.setNationality(inputFromUser(scanner, "\\w+"));

                System.out.println("input singer gender");
                singer.setGender(Boolean.parseBoolean(inputFromUser(scanner, "(true|false)")));

                System.out.println("input singer genre");
                singer.setGenre(inputFromUser(scanner, "\\w+"));
                isFound = true;
            }

        }
        if (!isFound) {
            System.out.println("Singer Id not found");
        }

    }

    public void deleteSingerById(Scanner scanner) {
        System.out.println("input the singer id you want to delete");



        int singerId = Integer.parseInt(inputFromUser(scanner, "\\w+"));
        boolean isFound = false;

        Singer[] newArr = new Singer[singers.length - 1];

        byte newIndex = 0;
        for (Singer singer : singers) { // Use a 'for-each' loop for cleaner iteration
            if (singer.getSingerId() == singerId) {
                isFound = true;
            } else {

                newArr[newIndex++] = singer; // Only copy if not deleting
            }
        }
        singers = newArr;

        if (!isFound) {
            System.out.println("Singer Id not found");
        } else {
            System.out.println("Delete Successfully.");
        }

    }


    public void displayData() {
        if (singers.length == 0) {
            System.out.println("Singer Array is empty");
        }
        for (Singer singer : singers) {
            System.out.println(singer.toString());
        }

    }


    public Singer addPerSinger(Scanner scanner) {

        Singer singer = new Singer();
        count++;
        singer.setSingerId(count);
        System.out.println("input singer name");
        singer.setSingerName(inputFromUser(scanner, "\\w+"));


        System.out.println("input singer age");
        singer.setAge(Integer.parseInt(inputFromUser(scanner, "\\w+")));

        System.out.println("input singer nationality");
        singer.setNationality(inputFromUser(scanner, "\\w+"));

        System.out.println("input singer gender");
        singer.setGender(Boolean.parseBoolean(inputFromUser(scanner, "(true|false)")));

        System.out.println("input singer genre");
        singer.setGenre(inputFromUser(scanner, "\\w+"));

        return singer;
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

}
