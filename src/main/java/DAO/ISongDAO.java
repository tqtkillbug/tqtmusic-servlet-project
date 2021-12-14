package DAO;

import model.Song;

import java.sql.SQLException;
import java.util.List;

public interface ISongDAO {
    List<Song> selectAllSong();


    void insertSong(Song newSong);

    boolean updateSong(Song song) throws SQLException;

    boolean deleteSong(int id) throws SQLException;
}