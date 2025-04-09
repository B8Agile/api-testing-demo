package api.qa.supplysync.pojos.branches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PJ_BranchCompany {

    private String id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String blocked;
}
