//package epfWebAssessment.Server;
//
//import epfWebAssessment.Controller.HomePageController;
//import epfWebAssessment.Controller.PrincipalController;
//
//
//import static org.springframework.boot.system.SystemProperties.get;
//import static org.springframework.http.RequestEntity.post;
//
//public class Routes {
//
//    public static final String HOME_PAGE = "/";
//    public static final String PRINCIPAL_FORM = "/";
//    private static WorkFlowServer workFlowServer;
//
//
//    public static void configure(WorkFlowServer workFlowServer) {
//        Routes.workFlowServer = workFlowServer;
//        workFlowServer.routes(() -> extracted());
//    }
//
//    private static void extracted() {
//
//        post(HOME_PAGE, HomePageController.home);
//        get(PRINCIPAL_FORM, PrincipalController.log);
//
//
//    }
//}
