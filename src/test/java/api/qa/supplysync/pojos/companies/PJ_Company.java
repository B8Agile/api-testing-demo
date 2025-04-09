package api.qa.supplysync.pojos.companies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PJ_Company {

    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String blocked;
    private String reason;
    private String message;
    private List<PJ_AllCompanies>company;


}
