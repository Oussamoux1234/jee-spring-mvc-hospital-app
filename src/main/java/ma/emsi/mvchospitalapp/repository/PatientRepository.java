package ma.emsi.mvchospitalapp.repository;

import ma.emsi.mvchospitalapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
