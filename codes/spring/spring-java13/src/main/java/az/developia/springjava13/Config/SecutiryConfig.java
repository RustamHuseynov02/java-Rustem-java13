package az.developia.springjava13.Config;





import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecutiryConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource source;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(source);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.POST, "/users/teacher").permitAll()
		.antMatchers(HttpMethod.POST, "/users/owner").permitAll()
		.antMatchers(HttpMethod.GET, "/students/html").permitAll()
		.antMatchers(HttpMethod.GET, "/owners").permitAll()
		.antMatchers(HttpMethod.POST, "/users/admin").permitAll()
		

		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

				.anyRequest().authenticated().and()

				.httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		         http.headers().frameOptions().disable();    

                	

	}
}
