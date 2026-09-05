package com.todocode.springsecurity.security.config;

import com.todocode.springsecurity.security.config.filter.JwtTokenValidator;
import com.todocode.springsecurity.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import com.todocode.springsecurity.utils.JwtUtils;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {
    /*
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests()
                .requestMatchers("/calificacion","/calificacion/average").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic()
                .and()
                .build();
    }
    */

   /* @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults()) //se usa cuando solo vas a logear con usuarios y contraseñas
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    // Endpoints públicos
                    http.requestMatchers(HttpMethod.GET, "/holanoseg").permitAll();
                    http.requestMatchers(HttpMethod.GET, "/holaseg").hasAuthority("READ");
                    http.anyRequest().denyAll();
                })
                .build();
    }*/


   @Autowired
    private JwtUtils jwtUtils;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
              //  .httpBasic(Customizer.withDefaults()) //se usa cuando solo vas a logear con usuarios y contraseñas
                .authorizeHttpRequests(auth -> auth
                // Esto le da pase libre absoluto en la cadena de filtros a todo lo que esté en /auth/
                .requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
        )

                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)

                .build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsServiceImp userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
       // provider.setUserDetailsService(userDetailsService());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return   new BCryptPasswordEncoder(); //NoOpPasswordEncoder.getInstance();
    }




/* esto fue para probar
    @Bean
    public UserDetailsService userDetailsService () {
        List userDetailsList = new ArrayList<>();

        userDetailsList.add(User.withUsername("todocode")
                .password("1234") // esto si no está codificado, sino, tiene que seguir el algoritmo de codificación
                .roles("ADMIN")
                .authorities("CREATE", "READ", "UPDATE", "DELETE")
                .build());

        userDetailsList.add(User.withUsername("seguidor")
                .password("1234") // esto si no está codificado, sino, tiene que seguir el algoritmo de codificación
                .roles("USER")
                .authorities("READ")
                .build());

        userDetailsList.add(User.withUsername("actualizador")
                .password("1234") // esto si no está codificado, sino, tiene que seguir el algoritmo de codificación
                .roles("USER")
                .authorities("UPDATE")
                .build());

        return new InMemoryUserDetailsManager(userDetailsList);
    }

*/


}
