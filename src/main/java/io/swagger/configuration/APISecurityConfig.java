package io.swagger.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;



@EnableWebSecurity
public class APISecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${devops.http.auth-token-header-name}")
    private String principalRequestHeader;

    @Value("${devops.http.auth-token}")
    private String principalRequestValue;

   
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);

        filter.setAuthenticationManager(new AuthenticationManager() {

            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String principal = (String) authentication.getPrincipal();
                if (!principalRequestValue.equals(principal))
                {
                    throw new BadCredentialsException("The API key was not found or not the expected value.");
                }
                authentication.setAuthenticated(true);
                return authentication;
            }
        });


        httpSecurity.
            antMatcher("/DevOps").
            csrf().disable().
            sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
            and().addFilter(filter).authorizeRequests().anyRequest().authenticated();
    }




    @Configuration 
    @Order(1)
    public static class ApiConfiguration extends WebSecurityConfigurerAdapter { 

        @Value("${devops.http.auth-jwt-name}")
        private String HEADER;
    
        @Override 
        protected void configure(HttpSecurity http) throws Exception { 
            // doesn't really make sense to protect a REST API using form login but it is just for illustration 
            APIKeyAuthFilter jwtFilter = new APIKeyAuthFilter(HEADER);

            jwtFilter.setAuthenticationManager(new AuthenticationManager() {
    
                @Override
                public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                    String principal = (String) authentication.getPrincipal();
    
                    authentication.setAuthenticated(true);
                    return authentication;
                }
            });

            http.
            antMatcher("/DevOps").
            csrf().disable().
            sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
            and().addFilter(jwtFilter).authorizeRequests().anyRequest().authenticated();
    
        } 

    } 

}
