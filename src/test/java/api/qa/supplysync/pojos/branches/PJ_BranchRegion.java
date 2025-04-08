package api.qa.supplysync.pojos.branches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.java.eo.Se;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PJ_BranchRegion {

    private String id;
    private String region;

}
