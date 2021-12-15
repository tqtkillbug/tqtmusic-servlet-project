package services;

import model.Song;

import java.sql.SQLException;
import java.util.List;

public interface ISongService {

    List<Song> selectAllSong();

    void addNewSong(Song newSong);

    boolean updateSong(Song song) throws SQLException;

    boolean deleteSong(int id) throws SQLException;

    int getSongCount();
}
