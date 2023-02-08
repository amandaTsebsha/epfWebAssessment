package epfWebAssessment.Controller;

import epfWebAssessment.Models.PrincipalClass;
import epfWebAssessment.VarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {

    @Autowired
    private VarietyService varietyService;

//    @RequestMapping({"/", "/firstName"})
//    public String displayName(final PrincipalClass principalClass) {
//        principalClass.setFirstName(Principal.getInstance());
//    }
}
