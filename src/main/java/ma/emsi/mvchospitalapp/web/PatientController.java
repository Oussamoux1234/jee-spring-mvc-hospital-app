package ma.emsi.mvchospitalapp.web;

import lombok.AllArgsConstructor;
import ma.emsi.mvchospitalapp.entities.Patient;
import ma.emsi.mvchospitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public String index(Model model, @RequestParam(name = "page",defaultValue ="0" ) int pageN,
                        @RequestParam(name="size",defaultValue = "6") int size,
                        @RequestParam(name ="keyword",defaultValue = "")String keyw) {
        Page<Patient> patientsPage = patientRepository.findByNomContains(keyw, PageRequest.of(pageN, size));
       // Page<Patient> patientsPage = patientRepository.findAll(PageRequest.of(pageN,size));
        model.addAttribute("pages",new int[patientsPage.getTotalPages()]);
        model.addAttribute("patients", patientsPage.getContent());
        model.addAttribute("currentP",pageN);
        model.addAttribute("keyword",keyw);
        return "patients";
    }
    @GetMapping("/delete")
    public String deletePatient(@RequestParam(name="id") Long id ,String keyword, @RequestParam(name = "page",defaultValue ="0" ) int pagec) {
        patientRepository.deleteById(id);
        return "redirect:/index?page="+pagec+"&keyword="+keyword;
    }
}
