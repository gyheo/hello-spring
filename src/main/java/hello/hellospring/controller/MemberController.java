package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Component 애노테이션이 있으면 자동으로 빈 등록
 * @Controller 사용 시 빈으로 등록되는 이유도 @Component 애노테이션을 포함하고 있어서
 * @Controller, @Service, @Repository 모두 스프링 빈으로 자동 등록
 *
 * Spring Bean
 *   - Spring Container에서 관리하는 객체, 기본적으로 Singleton으로 등록(유일하게 하나만 등록)
 *   - 설정으로 싱글톤이 아니게 설정할 수 있지만 특별한 경우를 제외하고서는 모두 Singleton으로 사용
 */
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
