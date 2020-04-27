package uk.co.breschbrothers.fencingcalc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.breschbrothers.fencingcalc.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
