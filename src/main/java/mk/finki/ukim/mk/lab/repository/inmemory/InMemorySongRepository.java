package mk.finki.ukim.mk.lab.repository.inmemory;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemorySongRepository {
    public List<Song> findAllByAlbum_Id(Long albumId) {
        return DataHolder.songs.stream()
                .filter(r -> r.getAlbum().getId().equals(albumId))
                .toList();
    }
}
