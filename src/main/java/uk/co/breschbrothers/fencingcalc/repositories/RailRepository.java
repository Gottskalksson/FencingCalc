package uk.co.breschbrothers.fencingcalc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.breschbrothers.fencingcalc.entity.Rail;

public interface RailRepository extends JpaRepository<Rail, Long> {
}
