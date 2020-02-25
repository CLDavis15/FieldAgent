package corbos.fieldagent.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
public class Agent {

    @Id
    private String identifier;
    @NotBlank(message = "First name must not be empty.")
    @Size(max = 30, message = "First name must be less than 30 characters.")
    private String firstName;
    private String middleName;
    @NotBlank(message = "Last name must not be empty.")
    @Size(max = 50, message = "Last name must be less than 50 characters.")
    private String lastName;
    private String pictureUrl;
    @NotNull(message="Requird birthdate")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    
    @Min(value=36, message="Min height is 36 inches")
    @Max(value=96, message="Max height is 96 inches")
    private int height;
    @NotNull(message="Need activation date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate activationDate;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "security_clearance_id")
    private SecurityClearance securityClearance;

}
