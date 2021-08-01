package app.web.safetravels;

public class SpringSecurityConfig {
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().
//        disable()
//            .authorizeRequests()
//            .antMatchers(HttpMethod.OPTIONS, "/**")
//            .permitAll();
//            .anyRequest()
//            .authenticated()
//            .and()
//            .httpBasic();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
//        authorizeRequests().antMatchers(HttpMethod.GET, "/**").hasAnyRole("ADMIN", "USER")
//                           .antMatchers(HttpMethod.POST, "/routeA/**").hasAnyRole("ADMIN", "USER")
//                           .antMatchers(HttpMethod.POST, "/routeB/**").hasRole("ADMIN")
//                           .antMatchers(HttpMethod.DELETE, "/routeB/**").hasRole("ADMIN").and().
//        requestCache().requestCache(new NullRequestCache()).and().
//        httpBasic().authenticationEntryPoint(authenticationEntryPoint).and().
//        cors().and().
//        csrf().disable();
//    }
}
