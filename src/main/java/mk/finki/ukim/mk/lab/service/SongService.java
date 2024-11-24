package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Song findById(Long id);
    Artist addArtistToSong(Artist artist, Song song);
    void save(Song song);
    void delete(Long id);
    void update(Long id, String trackId, String title, String genre, int i);
}
