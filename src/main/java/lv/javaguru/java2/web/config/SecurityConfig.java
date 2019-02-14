//package lv.javaguru.java2.web.config;
//import lv.javaguru.java2.buisnesslogic.user.login.LoginUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//    @Configuration
//    @EnableWebSecurity
//    public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Autowired
//        LoginUserService loginUserService;
//
//        @Autowired
//        public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//            auth
//                    .userDetailsService(loginUserService);
//                    //.passwordEncoder(getShaPasswordEncoder());
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {

//            http.csrf()
//                    .disable()
//                    .authorizeRequests()
//                    .antMatchers("/resources/**", "/**").permitAll()
//                    .anyRequest().permitAll()
//                    .and();
//
//            http.formLogin()
//
//                    .loginPage("/login")
//
//                    .loginProcessingUrl("/loginProcess")
//
//                    .failureUrl("/login?error")
//
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//
//                    .permitAll();
//
//            http.logout()
//
//                    .permitAll()
//
//                    .logoutUrl("/logout")
//
//                    .logoutSuccessUrl("/welcome")
//
//                    .invalidateHttpSession(true);
//
//        }
//
////        @Bean
////        public ShaPasswordEncoder getShaPasswordEncoder(){
////            return new ShaPasswordEncoder();
////        }
//
//    }
