package pl.nullpointerexception.restapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.nullpointerexception.restapi.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAll();

    @Query("select p from Post p " +
            "left join fetch p.comment")
    List<Post> findAllPostsByPage(Pageable page);

    @Query("Select p From Post p")
    List<Post> findAllPosts(Pageable page);

    @Query("select p from Post p " +
            "left join fetch p.comment")
    List<Post> findAllWithComments(Pageable page);
}
