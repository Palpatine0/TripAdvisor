package com.example.tripadvisor.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //SETTING:custom login from
        http.formLogin()
                .loginPage("/backstage/admin_login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/backstage/admin/login")
                .successForwardUrl("/backstage/index")
                .failureForwardUrl("/backstage/admin_fail");

        //SETTING:permission intercept
        http.authorizeRequests()
                .antMatchers("/backstage/admin/login").permitAll()
                .antMatchers("/backstage/admin_fail").permitAll()
                .antMatchers("/backstage/admin_login").permitAll()
                .antMatchers("/**/*css","/**/*js").permitAll()
                .antMatchers("/frontdesk/img/**").permitAll()
                .antMatchers("/backstage/**").authenticated();
        
        //SETTING:logout
        http.logout()
                .logoutUrl("/backstage/admin/logout")
                .logoutSuccessUrl("/backstage/admin_login")
                .clearAuthentication(true)
                .invalidateHttpSession(true);

        //SETTING:permission deny
        http.exceptionHandling()
                .accessDeniedHandler(new MyAccessDeniedHandler());

        //shut down csrf protection
        http.csrf().disable();
        //trans-filed access
        http.cors();

        //super.configure(http);
    }

    //pwd encoder
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
