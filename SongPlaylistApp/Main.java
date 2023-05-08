package projects;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album1 = new Album("moose tape", "sidhu moose wala");

        album1.addSong("burberry", 4.2);
        album1.addSong("invencible", 3.4);
        album1.addSong("rack&raunds", 5.1);

        albums.add(album1);

        Album album2 = new Album("drive thru", "diljit dosanjh");

        album2.addSong("lemonade", 2.5);
        album2.addSong("peaches", 3.4);
        album2.addSong("vanilla", 4.5);

        albums.add(album2);

        LinkedList<Songs> playList1 = new LinkedList<>();

        albums.get(0).addToPlayList("burberry", playList1);
        albums.get(0).addToPlayList("invencible", playList1);
        albums.get(1).addToPlayList("lemonade", playList1);
        albums.get(1).addToPlayList("peaches", playList1);

        play(playList1);
    }

    private static void play(LinkedList<Songs> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Songs> listIterator = playList.listIterator();

        if (playList.size() == 0){
            System.out.println("This playlist have no song");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){

                case 0:
                    System.out.println("olaylist complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    } else {
                        System.out.println("no song available, reached to the end of the list");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing "+ listIterator.previous().toString());
                    } else {
                        System.out.println("we are at the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing "+ listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("we are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()){
                            System.out.println("now playing "+ listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("we have reached at the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playList.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("now playing "+ listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious()){
                                System.out.println("now playing "+ listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Availaible options \n press");
        System.out.println("0 - to quit \n"+
        "1 - to play next song \n"+
        "2 - to previous song \n"+
        "3 - to repeat the current song \n"+
        "4 - to list of all songs \n"+
        "5 - to print all available options \n"+
        "6 - to delete current song");
    }

    private static void printList(LinkedList<Songs> playList){
        Iterator<Songs> iterator = playList.iterator();

        System.out.println("-------------------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-------------------------");
    }
}