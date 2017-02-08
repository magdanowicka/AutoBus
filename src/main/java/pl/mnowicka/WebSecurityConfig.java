package pl.mnowicka;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/css/**", "/font-awesome/**", "/fonts/**", "/images/**", "/js/**").permitAll()
                .antMatchers("/", "/home", "/register", "/results", "/login", "/registrationConfirm**", "/successRegister").permitAll()
                .antMatchers("/search","/searchTest").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {



        auth.jdbcAuthentication().dataSource(this.dataSource)
                .usersByUsernameQuery("SELECT email, password, enabled FROM public.user where email=?")
                .authoritiesByUsernameQuery(
                        "SELECT email, role from public.user AS us INNER JOIN public.user_roles AS ur ON (ur.user_id = us.id) WHERE us.email=?")
//                .passwordEncoder(passwordEncoder());
;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//
//    }
}
