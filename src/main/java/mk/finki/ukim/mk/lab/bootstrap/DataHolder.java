package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.*;
import mk.finki.ukim.mk.lab.repository.jpa.AlbumRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.jpa.SongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists;
    public static List<Song> songs;
    public static List<Album> albums;

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public DataHolder(SongRepository songRepository, AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    @PostConstruct
    public void init() {
        artists = new ArrayList<>();
        artists.add(new Artist("Jon", "Bon Jovi", "Rock"));
        artists.add(new Artist("Chris", "Martin", "Pop Rock"));
        artists.add(new Artist("James", "Hetfield", "Heavy Metal"));
        artists.add(new Artist("Ozzy", "Ozbourne", "Heavy Metal"));
        artists.add(new Artist("Einar", "Solberg", "Prog Metal"));

        if (this.artistRepository.count() == 0) {
            this.artistRepository.saveAll(artists);
        }

        songs = new ArrayList<>();
        songs.add(new Song("t1","Living on a prayer", "Rock", 1978));
        songs.add(new Song("t2","Enter Sandman", "Heavy Metal", 1991));
        songs.add(new Song("t3","Crazy Train", "Heavy Metal", 1990));
        songs.add(new Song("t4","Adventure of a lifetime", "Pop rock", 2015));
        songs.add(new Song("t5","The sky is red", "Prog Metal", 2019));

        if (this.songRepository.count() == 0) {
            this.songRepository.saveAll(songs);
        }

        albums = new ArrayList<>();
        albums.add(new Album("Slippery When Wet", "Rock", 1978));
        albums.add(new Album("Metallica", "Heavy Metal", 1991));
        albums.add(new Album("Blizzard of Ozz", "Heavy Metal", 1990));
        albums.add(new Album("A Head Full Of Dreams", "Pop Rock", 2015));
        albums.add(new Album("Pitfalls", "Prog Metal", 2019));

        System.out.println(albumRepository);
        if (this.albumRepository.count() == 0) {
            this.albumRepository.saveAll(albums);
        }
    }
}
