package epfWebAssessment.Configuration;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

public abstract class WebMvcConfigurerAdapter {
    protected void addResourceHandler(ResourceHandlerRegistry handlerRegistry) {
    }

    public abstract void addResourceHandlers(ResourceHandlerRegistry handlerRegistry);

    public void addFormatters(FormatterRegistry registry) {
    }


}
