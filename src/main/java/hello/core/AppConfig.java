package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
    * AppConfig 는 애플리케이션의 실제 동작에 필요한 구현객체를 생성한다.
    * New MemoryMemberRepository 중복 생성 -> private 으로 생성
    * */

    /**
     * @Bean memberService -> new MemoryMemberRepository() 생성된다.
     * @Bean orderService -> new MemoryMemberRepository()  생성된다.
     *
     * 다른 두개의 MemoryMemberRepository() 생성되면서 싱글톤이 깨지는것처럼 보인다.
     *
     * */

    @Bean
    public MemberService memberService(){
       // return new MemberServiceImpl(new MemoryMemberRepository());
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
      //  return new OrderServiceImpl(new MemoryMemberRepository(), new FixDisCountPolicy());
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDisCountPolicy();
        return new RateDiscountPolicy();
    }

}
