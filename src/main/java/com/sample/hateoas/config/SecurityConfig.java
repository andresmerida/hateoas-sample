package com.sample.hateoas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.sample.hateoas.core.components.AuthenticationFailure;
import com.sample.hateoas.core.components.AuthenticationSuccess;
import com.sample.hateoas.core.components.EntryPointUnauthorizedHandler;
import com.sample.hateoas.core.security.UserDetailsServiceImpl;

/**
 * Created by andresmerida on 4/4/2016.
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;

    @Autowired
    AuthenticationFailure authenticationFailure;

    @Autowired
    AuthenticationSuccess authenticationSuccess;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    /**
     * this section defines the user accounts which can be used for
     * authentification as well as the roles each user has.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
    }

    /**
     * This section defines the auditing policy for the app.
     * - BASIC authentication is supported (enough for this REST-based demo)
     * - /employees is secured using URL auditing shown below
     * - CSRF headers are disabled since we are only testing the REST interface,
     * not a web one.
     * <p>
     * NOTE: GET is not shown which defaults to permitted.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic()
                .and()
                    .exceptionHandling()
                        .authenticationEntryPoint(entryPointUnauthorizedHandler)
                .and()
                    .formLogin()
                        .successHandler(authenticationSuccess)
                        .failureHandler(authenticationFailure)
                        .permitAll()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .authorizeRequests()
                        //.antMatchers(HttpMethod.GET, "/api/**").authenticated()
                        //.antMatchers(HttpMethod.POST, "/api/**").authenticated()
                        //.antMatchers(HttpMethod.PUT, "/api/**").authenticated()
                        //.antMatchers(HttpMethod.DELETE, "/api/**").authenticated()
                        .anyRequest().permitAll();
    }
}