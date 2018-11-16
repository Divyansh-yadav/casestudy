package com.impetus.ogos.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

/** Security Configuration for basic Authentication.
 * 
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAppUserDetailsService myAppUserDetailsService;

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    /** Static Initializer. */
    private static final Logger LOGGER = Logger.getLogger(SecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.debug("INSIDE CONFIGURE");
        http.cors().and().csrf().disable()
            .authorizeRequests()
            .antMatchers("/user/addUser", "/logout").permitAll()
            .antMatchers("/user/**")
            .hasAnyAuthority("ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_SERVICEPROVIDER")
            .anyRequest().fullyAuthenticated()
            .and()
            .logout()
            .permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST")).and().httpBasic().and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and().httpBasic().realmName("MY APP REALM")
            .authenticationEntryPoint(customAuthenticationEntryPoint);
        LOGGER.debug("END CONFIGURE");
    }

    /** Global Configuration for decoding password.
     * 
     * @param auth
     *            object of AuthenticationManagerBuilder.
     * @throws Exception
     *             exception Object. */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.debug("INSDE CONFIGUREGLOBAL");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder);
        LOGGER.debug("END CONFIGUREGLOBAL");

    }

    /**
     * This will be used to create the json we'll send back to the client from the CustomAuthenticationEntryPoint class.
     * @return Jackson2JsonObjectMapper object.
     */
    @Bean
    public Jackson2JsonObjectMapper jackson2JsonObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        return new Jackson2JsonObjectMapper(mapper);
    }
}