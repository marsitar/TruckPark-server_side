package com.sitarski.truckparkserver.configuration;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {

        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        authenticationManagerBuilder.authenticationProvider(keycloakAuthenticationProvider);
    }

    @Bean
    public KeycloakSpringBootConfigResolver keycloakSpringBootConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        super.configure(httpSecurity);
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/drivers/**").hasRole(KeyCloakRoles.DRIVER_READ)
                .antMatchers(HttpMethod.POST, "/drivers/driver").hasRole(KeyCloakRoles.DRIVER_CREATE)
                .antMatchers(HttpMethod.PUT, "/drivers/driver").hasRole(KeyCloakRoles.DRIVER_UPDATE)
                .antMatchers(HttpMethod.DELETE, "/drivers/driver/*").hasRole(KeyCloakRoles.DRIVER_DELETE)
                .antMatchers(HttpMethod.GET, "/mops/**").hasRole(KeyCloakRoles.MOP_READ)
                .antMatchers(HttpMethod.POST, "/mops/mop").hasRole(KeyCloakRoles.MOP_CREATE)
                .antMatchers(HttpMethod.PUT, "/mops/mop").hasRole(KeyCloakRoles.MOP_UPDATE)
                .antMatchers(HttpMethod.DELETE, "/mops/mop/*").hasRole(KeyCloakRoles.MOP_DELETE)
                .antMatchers(HttpMethod.GET, "/trucks/**").hasRole(KeyCloakRoles.TRUCK_READ)
                .antMatchers(HttpMethod.POST, "/trucks/truck").hasRole(KeyCloakRoles.TRUCK_CREATE)
                .antMatchers(HttpMethod.PUT, "/trucks/truck").hasRole(KeyCloakRoles.TRUCK_UPDATE)
                .antMatchers(HttpMethod.DELETE, "/trucks/truck/*").hasRole(KeyCloakRoles.TRUCK_DELETE)
                .antMatchers(HttpMethod.GET, "/truckdriverways/**").hasRole(KeyCloakRoles.TDW_READ)
                .antMatchers(HttpMethod.POST, "/truckdriverways/truckdriverway").hasRole(KeyCloakRoles.TDW_CREATE)
                .antMatchers(HttpMethod.PUT, "/truckdriverways/truckdriverway").hasRole(KeyCloakRoles.TDW_UPDATE)
                .antMatchers(HttpMethod.DELETE, "/truckdriverways/truckdriverway/*").hasRole(KeyCloakRoles.TDW_DELETE)
                .antMatchers("/", "/**")
                .permitAll();
    }
}
