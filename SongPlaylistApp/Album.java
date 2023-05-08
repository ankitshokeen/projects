package projects;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Songs> song;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.song = song;
    }
    public Album(){

    }

    public Songs findSong(String title){
        for (Songs checkedSong : song){
            if (checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }
    public boolean addSong(String title, double duration){
        if (findSong(title) == null){
            song.add(new Songs(title, duration));
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Songs> PlayList){
        int index = trackNumber -1;
        if (index > 0 && index <= this.song.size()){
            PlayList.add(this.song.get(index));
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Songs> PlayList){
        for (Songs checkedSongs: song){
            if (checkedSongs.getTitle().equals(title)){
                PlayList.add(checkedSongs);
                return true;
            }
        }
        return false;
    }
}