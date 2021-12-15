package services;

import DAO.ISongDAO;
import DAO.SongDAO;
import model.Song;

import java.sql.SQLException;
import java.util.List;

public class SongService implements ISongService{
    private ISongDAO songDAO;

    public SongService(){
        songDAO = new SongDAO();
    }

    @Override
    public List<Song> selectAllSong(){
        return songDAO.selectAllSong();
    }
    @Override
    public void addNewSong(Song newSong){
        songDAO.insertSong(newSong);
    }
    @Override
    public boolean updateSong(Song song) throws SQLException {
        return songDAO.updateSong(song);
    }
    @Override
    public boolean deleteSong(int id) throws SQLException {
        return songDAO.deleteSong(id);
    }
    @Override
    public int getSongCount(){
        return songDAO.getCount();
    }
}
