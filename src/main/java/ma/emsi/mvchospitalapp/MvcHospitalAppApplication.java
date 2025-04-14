package ma.emsi.mvchospitalapp;

import ma.emsi.mvchospitalapp.entities.Patient;
import ma.emsi.mvchospitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class MvcHospitalAppApplication {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(MvcHospitalAppApplication.class, args);

    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(Patient.builder().nom("mohhha")
                    .dataNissance(new Date())
                    .gender("male")
                    .malade(false).score(211).build());
            patientRepository.save(Patient.builder().nom("nora")
                    .dataNissance(new Date())
                    .gender("female")
                    .malade(false).score(411).build());
            patientRepository.save(Patient.builder().nom("mohamed")
                    .dataNissance(new Date())
                    .gender("male")
                    .malade(true).score(131).build());
            patientRepository.save(Patient.builder().nom("arias")
                    .dataNissance(new Date())
                    .gender("male")
                    .malade(false).score(231).build());
            patientRepository.findAll().forEach(System.out::println);
        };
    };


}
