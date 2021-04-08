package IngerGYM;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	// Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/horario").permitAll();
        http.authorizeRequests().antMatchers("/registro.html").permitAll();
       
        // Private pages (all other pages)
        
        /*---------------USER PAGES-------------*/
        http.authorizeRequests().antMatchers("/bienvenido").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/clase").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/suscribirse").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/verClases").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/opiniones").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/opiniones/opinionEnviada").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/reservarPiscina").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/reservarGimnasio").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/salas").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/zumba").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/aquagym").hasAnyRole("USER");
        
        
        /*---------------ADMIN PAGES-------------*/
        http.authorizeRequests().antMatchers("/tarifa").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/tarifa/{id}").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/usuariosDisponibles").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/clientes/{id}").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/clientes/{id}/darDeBaja").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/crear").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/crearClase.html").hasAnyRole("ADMIN");
        
        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("usuario");
        http.formLogin().passwordParameter("contrasena");
        http.formLogin().defaultSuccessUrl("/bienvenido");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
        
        // Disable CSRF at the moment
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	// Enable default password encoder (mandatory since Spring Security 5 to avoid storing passwords in plain text)
    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        
    	// User
        auth.inMemoryAuthentication().withUser("user").password(encoder.encode("pass")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("pass")).roles("USER", "ADMIN");
    	
    }

}