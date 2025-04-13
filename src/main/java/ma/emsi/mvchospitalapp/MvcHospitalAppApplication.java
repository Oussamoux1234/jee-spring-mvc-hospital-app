package ma.emsi.mvchospitalapp;

import ma.emsi.mvchospitalapp.entities.Patient;
import ma.emsi.mvchospitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class MvcHospitalAppApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(MvcHospitalAppApplication.class, args);

    }
    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(Patient.builder().nom("moha")
                .dataNissance(new Date())
                .gender("male")
                .malade(false).score(21).build());
        patientRepository.save(Patient.builder().nom("nora")
                .dataNissance(new Date())
                .gender("female")
                .malade(false).score(41).build());
        patientRepository.save(Patient.builder().nom("mohamed")
                .dataNissance(new Date())
                .gender("male")
                .malade(true).score(31).build());
        patientRepository.save(Patient.builder().nom("arias")
                .dataNissance(new Date())
                .gender("male")
                .malade(false).score(231).build());
        patientRepository.findAll().forEach(System.out::println);
    }


}
