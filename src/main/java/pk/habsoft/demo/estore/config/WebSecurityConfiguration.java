package pk.habsoft.demo.estore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.stereotype.Component;

import pk.habsoft.demo.estore.model.UserDTO;
import pk.habsoft.demo.estore.security.DetailsService;

@Component
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DetailsService detailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailsService).passwordEncoder(UserDTO.PASSWORD_ENCODER);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
        .csrf().disable()
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
        .authorizeRequests()        
            .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
                        "/swagger-ui.html", "/webjars/**", "/swagger-resources/configuration/ui").permitAll()
            .anyRequest().authenticated()
                .and()
                .httpBasic();
        // @formatter:on
    }
}