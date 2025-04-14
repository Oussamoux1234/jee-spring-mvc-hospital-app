package ma.emsi.mvchospitalapp.web;

import lombok.AllArgsConstructor;
import ma.emsi.mvchospitalapp.entities.Patient;
import ma.emsi.mvchospitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "patients";
    }
    @GetMapping("/delete")
    public String deletePatient(@RequestParam(name="id") Long id) {
        patientRepository.deleteById(id);
        return "redirect:/index";
    }
}
