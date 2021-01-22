package com.repair.car;

import com.repair.car.Security.LoginAuthenticationProvider;
import com.repair.car.Security.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginAuthenticationProvider loginAuthenticationProvider;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.antMatcher("/css/**");
        http.authorizeRequests()
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .anyRequest().fullyAuthenticated()
                .and().csrf().disable()
                .formLogin()//.defaultSuccessUrl("/")
                //.antMatcher("/static/**")
                .successHandler(loginSuccessHandler)

                .loginPage("/login")
                .permitAll()
                .usernameParameter("email")
                .passwordParameter("password")

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll()

                //Permision Authorities
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/register").anonymous()
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .antMatchers("/user").hasAnyAuthority("SIMPLE")
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/static/**").permitAll()



                .and()
                .authenticationProvider(loginAuthenticationProvider);
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(loginAuthenticationProvider);
    }
}
