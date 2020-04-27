package uk.co.breschbrothers.fencingcalc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.breschbrothers.fencingcalc.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
