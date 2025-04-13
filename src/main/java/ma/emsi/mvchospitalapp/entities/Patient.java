package ma.emsi.mvchospitalapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
@Entity
public class Patient {
    @Id @GeneratedValue
    private Long id;
    private String nom;
    private String gender;
    private Date dataNissance;
    private boolean malade;
    private int score;
}
