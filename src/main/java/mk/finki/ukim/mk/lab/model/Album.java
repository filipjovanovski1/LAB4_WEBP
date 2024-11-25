package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "Album")
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;
    private int releaseYear;

    @OneToMany
    List<Song> songs;

    public Album(String name, String genre, int year) {
        this.name = name;
        this.genre = genre;
        this.releaseYear = year;
    }
}
