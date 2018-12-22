/*package book.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import book.dbconfig.DatabaseConfiguration;

@Configuration
@EnableWebSecurity
public class BookAppSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	DatabaseConfiguration dbc;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//super.configure(auth);
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")
		.and().withUser("admin").password("password").roles("ADMIN");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//super.configure(auth);
		auth.jdbcAuthentication().dataSource(dbc.dataSource1())
		.usersByUsernameQuery("select userid,user_password,'true' from book_users where userid=?")
		.authoritiesByUsernameQuery("select userid,user_role from book_users where userid=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/bookapp/searchAllBooks").hasRole("ADMIN")
		.antMatchers("/bookapp/subject").hasRole("USER")
		.anyRequest().authenticated();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(web);
	}
	
	

}
*/