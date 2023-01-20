package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    /**
     * MemoryMemberRepository를 다른 방식으로 변경할 예정이어서, 컴포넌트 스캔 방식 → 자바 코드 스프링 빈 주입
     * 참고
     *   - XML 설정 방식은 최근에는 잘 사용하지 않음
     *   - DI에는 필드 주입, setter 주입, 생성자 주입 3가지 방법이 있고, 의존관계가 실행 중에 동적으로 변하는 경우가 없어 생성자 주입
     *   -
     */
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
