package spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration // 공유 설정 파일이다
@EnableWebSecurity //웹 시큐리티 파일
public class WebSecurityConfigClass{

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf().disable(); //csrf 공격 차단

        // 요청에 대한 페이지 별 설정
        http.authorizeHttpRequests()
                .antMatchers("/"
                        ,"/member/login"
                        ,"/member/join")
                .permitAll() //모든 접근 허용
                .antMatchers("/"
                        ,"/css/**"
                        ,"/img/**"
                        ,"/js/**").permitAll()
                //.authenticated() = 인증이 되어야 접근 가능( 로그아웃은 로그인이 되어야 하니까)
                .antMatchers("/member/logout").authenticated()

            //MEMBE,ADMIN,SELLER
                //.hasAnyRole 권환 추가
                .antMatchers("/member/memberShip").hasAnyRole("ADMIN","MEMBER")
                // ADMIN,SELLER
                .antMatchers("/shop/**").hasAnyRole("ADMIN","SELLER")
                // ADMIN
                .antMatchers("/admin/**").hasAnyRole("ADMIN");
    // 로그인 설정 localhost:8080/login의 페이지를 설정 할수있음
        http.formLogin()
                //직접 로그인페이지를 설정 member/login이 이 페이지의 로그인 페이지임
                .loginPage("/member/login")
                //username의 즉 아이디의 파라미터를 email로 설정 왜? 우리는 email을 아이디로 쓰는걸 커스텀 했으니까
                .usernameParameter("email")
                // 마찬가지
                .passwordParameter("password")
                .loginProcessingUrl("/member/login") //form URL POST
                //로그인 성공시 이동 페이지 설정
                .defaultSuccessUrl("/index")
                .permitAll();

        //로그아웃 설정
        //반대로 로그 아웃 설정!
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")) //개발자가 직접 로그 아웃url 설정
                .logoutSuccessUrl("/");

        return http.build();
    }

}
