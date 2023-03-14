package com.vlasov.projectshop.config;

import com.vlasov.projectshop.entity.Country;
import com.vlasov.projectshop.entity.Order;
import com.vlasov.projectshop.entity.Product;
import com.vlasov.projectshop.entity.State;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;



@Configuration
public class AppConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedMethods={HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE,HttpMethod.PATCH};
        disabledHttpMethods(Product.class, config, unsupportedMethods);
        disabledHttpMethods(Country.class,config,unsupportedMethods);
        disabledHttpMethods(State.class,config,unsupportedMethods);
        disabledHttpMethods(Order.class,config,unsupportedMethods);

        config.exposeIdsFor(Product.class);
    }

    private static void disabledHttpMethods(Class currentClass,RepositoryRestConfiguration config, HttpMethod[] unsupportedMethods) {
        config.getExposureConfiguration()
                .forDomainType(currentClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedMethods)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedMethods)));
    }
}
