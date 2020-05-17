package in.gov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import in.gov.wf.security.AuthSecurity;


@SpringBootApplication
public class ProjectalterationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectalterationApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<AuthSecurity> dawsonApiFilter() {
		FilterRegistrationBean<AuthSecurity> registration = new FilterRegistrationBean<AuthSecurity>();
		registration.setFilter(new AuthSecurity());
		registration.addUrlPatterns("/project_alt_ftn/secure/*");
		return registration;
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
