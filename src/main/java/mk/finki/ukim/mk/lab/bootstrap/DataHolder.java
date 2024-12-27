package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.enumerations.Role;
import mk.finki.ukim.mk.lab.repository.jpa.AlbumRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.jpa.SongRepository;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists;
    public static List<Song> songs;
    public static List<Album> albums;
    public static List<User> users;

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public DataHolder(SongRepository songRepository, AlbumRepository albumRepository, ArtistRepository artistRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        artists = new ArrayList<>();
        artists.add(new Artist("Coldplay", "", "Pop Rock"));
        artists.add(new Artist("Metallica", "", "Heavy Metal"));
        artists.add(new Artist("Leprous", "", "Prog Metal"));
        artists.add(new Artist("Polyphia", "", "Prog Rock"));

        if (this.artistRepository.count() == 0) {
            this.artistRepository.saveAll(artists);
        }

        albums = new ArrayList<>();
        albums.add(new Album("Metallica (Black Album)", "Heavy Metal", 1991));
        albums.add(new Album("A Head Full Of Dreams", "Pop Rock", 2015));
        albums.add(new Album("Pitfalls", "Prog Metal", 2019));
        albums.add(new Album("The Most Hated", "Prog Rock", 2017));

        if (this.albumRepository.count() == 0) {
            this.albumRepository.saveAll(albums);
        }

        songs = new ArrayList<>();
        songs.add(new Song("t0", "Bohemian Rhapsody", "Rock", 1975));
        songs.add(new Song("t1", "Don't Stop Me Now", "Rock", 1978));
        songs.add(new Song("t2", "Another One Bites the Dust", "Rock", 1980));
        songs.add(new Song("t3", "We Will Rock You", "Rock", 1977));
        songs.add(new Song("t4", "We Are the Champions", "Rock", 1977));
        songs.add(new Song("t5", "Somebody to Love", "Rock", 1976));
        songs.add(new Song("t6", "Radio Ga Ga", "Rock", 1984));
        songs.add(new Song("t7", "Under Pressure (Ft. David Bowie)", "Rock", 1981));
        songs.add(new Song("t8", "Crazy Little Thing Called Love", "Rock", 1979));
        songs.add(new Song("t9", "Killer Queen", "Rock", 1974));
        songs.add(new Song("t10", "I Want to Break Free", "Rock", 1984));
        songs.add(new Song("t11", "The Show Must Go On", "Rock", 1991));

        songs.add(new Song("t12", "Rolling in the Deep", "Soul", 2010));
        songs.add(new Song("t13", "Someone Like You", "Soul", 2011));
        songs.add(new Song("t14", "Set Fire to the Rain", "Soul", 2011));
        songs.add(new Song("t15", "Hello", "Soul", 2015));
        songs.add(new Song("t16", "When We Were Young", "Soul", 2015));
        songs.add(new Song("t17", "Turning Tables", "Soul", 2011));
        songs.add(new Song("t18", "Skyfall", "Soul", 2012));
        songs.add(new Song("t19", "Chasing Pavements", "Soul", 2008));
        songs.add(new Song("t20", "Make You Feel My Love", "Soul", 2008));
        songs.add(new Song("t21", "Rumour Has It", "Soul", 2011));
        songs.add(new Song("t22", "Hometown Glory", "Soul", 2007));
        songs.add(new Song("t23", "Easy on Me", "Soul", 2021));

        songs.add(new Song("t24", "Blood and Thunder", "Sludge Metal", 2004));
        songs.add(new Song("t25", "Iron Tusk", "Sludge Metal", 2004));
        songs.add(new Song("t26", "Crystal Skull", "Sludge Metal", 2006));
        songs.add(new Song("t27", "Colony of Birchmen", "Sludge Metal", 2006));
        songs.add(new Song("t28", "Oblivion", "Sludge Metal", 2009));
        songs.add(new Song("t29", "Divinations", "Sludge Metal", 2009));
        songs.add(new Song("t30", "The Czar", "Sludge Metal", 2009));
        songs.add(new Song("t31", "Black Tongue", "Sludge Metal", 2011));
        songs.add(new Song("t32", "Curl of the Burl", "Sludge Metal", 2011));

        songs.add(new Song("t33", "Shine On You Crazy Diamond", "Prog Rock", 1975));
        songs.add(new Song("t34", "Time", "Prog Rock", 1973));
        songs.add(new Song("t35", "Money", "Prog Rock", 1973));
        songs.add(new Song("t36", "Comfortably Numb", "Prog Rock", 1979));
        songs.add(new Song("t37", "Echoes", "Prog Rock", 1971));
        songs.add(new Song("t38", "Us and Them", "Prog Rock", 1973));


        for (int i = 0; i < 12; i++) {
            songs.get(i).setAlbum(albums.getFirst());
        }
        for (int i = 12; i < 24; i++) {
            songs.get(i).setAlbum(albums.get(1));
        }
        for (int i = 24; i < 33; i++) {
            songs.get(i).setAlbum(albums.get(2));
        }
        for (int i = 33; i < 39; i++) {
            songs.get(i).setAlbum(albums.get(3));
        }

        if (this.songRepository.count() == 0) {
            this.songRepository.saveAll(songs);
        }

        users = new ArrayList<>();
        users.add(new User("ficoo", passwordEncoder.encode("Filipj123"), "Filip", "Jovanovski", Role.ROLE_USER));
        users.add(new User("berizco", passwordEncoder.encode("B3R1Z"), "Beriz", "Kurtanovikj", Role.ROLE_USER));
        users.add(new User("majaan", passwordEncoder.encode("anevska12"), "Maja", "Anevska", Role.ROLE_USER));
        users.add(new User("admin", passwordEncoder.encode("78951"), "admin", "admin", Role.ROLE_ADMIN));

        if (this.userRepository.count() == 0) {
            this.userRepository.saveAll(users);
        }
    }
}
