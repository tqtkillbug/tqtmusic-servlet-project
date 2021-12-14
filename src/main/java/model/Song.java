package model;

public class Song {
    private int id;
    private String songName;
    private String singerName;
    private String songPath;
    private String logoPath;
    private String status;

    public Song() {
    }

    public Song(int id, String songName, String singerName, String songPath, String logoPath, String status) {
        this.id = id;
        this.songName = songName;
        this.singerName = singerName;
        this.songPath = songPath;
        this.logoPath = logoPath;
        this.status = status;
    }
    public Song(String songName, String singerName, String songPath, String logoPath, String status) {
        this.songName = songName;
        this.singerName = singerName;
        this.songPath = songPath;
        this.logoPath = logoPath;
        this.status = status;
    }

    public Song(int songId, String songName, String singerName, String status) {
        this.id = songId;
        this.songName = songName;
        this.singerName = singerName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", singerName='" + singerName + '\'' +
                ", songPath='" + songPath + '\'' +
                ", logoPath='" + logoPath + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
