package mk.finki.ukim.mk.lab.service.impl;

import jakarta.transaction.Transactional;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.jpa.AlbumRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.jpa.SongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import mk.finki.ukim.mk.lab.service.specifications.FieldFilterSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static mk.finki.ukim.mk.lab.service.specifications.FieldFilterSpecification.filterContainsText;
import static mk.finki.ukim.mk.lab.service.specifications.FieldFilterSpecification.filterEquals;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        song.getPerformers().add(artist);
        artist.getSongs().add(song);
        songRepository.save(song);
        artistRepository.save(artist);
        return artist;
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public void update(Long id, String trackId, String title, String genre, int year, Long albumId) {
        Song song = songRepository.findById(id).get();
        song.setTrackId(trackId);
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(year);
        Album album = albumRepository.findById(albumId).get();
        album.getSongs().add(song);
        song.setAlbum(album);
        this.songRepository.save(song);
    }

    @Override
    public List<Song> findAllByAlbum_Id(Long albumId) {
        return songRepository.findAllByAlbum_Id(albumId);
    }

    @Override
    public List<Song> findByAlbumAndYear(Long albumId, int releaseYear) {
        Specification<Song> specification = Specification
                .where(filterEquals(Song.class, "album.id", albumId))
                .and(FieldFilterSpecification.greaterThan(Song.class, "releaseYear", (long) releaseYear));

        return this.songRepository.findAll(specification);
    }
}
