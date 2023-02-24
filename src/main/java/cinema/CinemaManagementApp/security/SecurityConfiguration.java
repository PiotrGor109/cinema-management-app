//package cinema.CinemaManagementApp.security;
//
//import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
//import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
//import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//
//import javax.annotation.security.RolesAllowed;
//
//@KeycloakConfiguration
//public class SecurityConfiguration extends KeycloakWebSecurityConfigurerAdapter {
//
//    @Bean
//    KeycloakSpringBootConfigResolver keycloakSpringBootConfigResolver()
//    {
//        return new KeycloakSpringBootConfigResolver();
//    }
//
//    @Autowired
//    void configureGlobal(AuthenticationManagerBuilder auth){
//        var authoritiyMapper = new SimpleAuthorityMapper();
//        authoritiyMapper.setPrefix("ROLE_");
//        authoritiyMapper.setConvertToUpperCase(true);
//        KeycloakAuthenticationProvider keycloakAuthenticationProvider = new KeycloakAuthenticationProvider();
//        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(authoritiyMapper);
//        auth.authenticationProvider(keycloakAuthenticationProvider);
//    }
//
//
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//    }
//
//    @RolesAllowed("USER")
//    @Override
//    public void configure(final HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.authorizeRequests()
//                .antMatchers("/shows")
//                .hasRole("USER")
//                .antMatchers("/cinemahalls")
//                .hasRole("USER")
//                .antMatchers("/tickets")
//                .hasRole("USER")
//                .antMatchers("/seats")
//                .hasRole("USER")
//                .antMatchers("/reservations")
//                .hasRole("USER")
//                .anyRequest()
//                .permitAll();
//       // .hasRole("USER")
//    }
//}
