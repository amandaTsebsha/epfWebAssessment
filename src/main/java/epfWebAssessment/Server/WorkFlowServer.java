package epfWebAssessment.Server;
import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.View;
import org.thymeleaf.spring6.view.ThymeleafView;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import org.springframework.beans.factory.parsing.Location;
import org.springframework.boot.actuate.health.HealthEndpointGroup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import epfWebAssessment.Models.ExcelFileModel;
import epfWebAssessment.Models.Employee;
import epfWebAssessment.Persistence.*;
import epfWebAssessment.Persistence.*;
//import epfWebAssessment.Persistence.collectionbased.ExpenseDAOImpl;
//import epfWebAssessment.Persistence.collectionbased.PersonDAOImpl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

//import static epfWebAssessment.Models.DateHelper.TODAY;
//import static epfWebAssessment.Models.DateHelper.TOMORROW;
//import static epfWebAssessment.Models.MoneyHelper.amountOf;

public class WorkFlowServer {
   public static final String USER = "employee";
   private static final String PAGE_DIR = "/html";
   private static final String TEMPLATE_DIR = "/templates/";

    private ApplicationContext applicationContext;



   
    @Bean
    public SpringResourceTemplateResolver templateResolver(){

        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);
        viewResolver.setViewNames(new String[] {".html", ".xhtml"});
        return viewResolver;
    }

    @Bean
    @Scope("prototype")
    public ThymeleafView mainView() {
        ThymeleafView view = new ThymeleafView("main"); // templateName = 'main'
        view.setStaticVariables(
                Collections.singletonMap("footer", "Bohemian Academy of Excellence"));
        return view;
    }

}
