package uk.co.breschbrothers.fencingcalc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.breschbrothers.fencingcalc.entity.Fency;

public interface FencyRepository extends JpaRepository<Fency, Long> {
}
