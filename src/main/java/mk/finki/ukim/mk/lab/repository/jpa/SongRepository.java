package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAll(Specification<Song> specification);
    List<Song> findAllByAlbum_Id(Long albumId);
    List<Song> findAllByReleaseYearAfterAndAlbum(int releaseYear, Album album);
}
