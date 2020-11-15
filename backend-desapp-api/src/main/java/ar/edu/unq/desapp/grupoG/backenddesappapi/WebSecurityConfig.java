package ar.edu.unq.desapp.grupoG.backenddesappapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ar.edu.unq.desapp.grupoG.backenddesappapi.jwt.JwtEntryPoint;
import ar.edu.unq.desapp.grupoG.backenddesappapi.jwt.JwtTokenFilter;
import ar.edu.unq.desapp.grupoG.backenddesappapi.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtEntryPoint jwtEntryPoint;
    

    private String audience;

    private String issuer;

    @Bean
    JwtDecoder jwtDecoder() {
    	System.out.println("holaiiiiii");
        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)
                JwtDecoders.fromOidcIssuerLocation(issuer);
    	System.out.println("holaiiiiii2222222222222222222222222");
        OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator("ZLZVf86jl6vYHivZZ0rY2XHwDhEySLQP");
        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer("dev-2520nbes.us.auth0.com");
        OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

        jwtDecoder.setJwtValidator(withAudience);

        return jwtDecoder;
    }

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
    	System.out.println("holaaaaa jwtTokenFilter");

        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
//    	System.out.println("holaaaaa passwordEncoder");

        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	System.out.println("holaaaaa configure");

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
//    	System.out.println("holaaaaa authenticationManagerBean");

        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
//    	System.out.println("holaaaaa authenticationManager");

        return super.authenticationManager();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http.authorizeRequests()
        .antMatchers("/auth/**").permitAll()
        .mvcMatchers("/api/public").permitAll()
        .mvcMatchers("/api/private").authenticated()
        .mvcMatchers("/api/private-scoped").hasAuthority("SCOPE_read:messages")
        .and().cors()
        .and().oauth2ResourceServer().jwt();

//        http.cors().and().csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/auth/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
       

}
