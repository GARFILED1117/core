package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDisCountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository;// = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy; // interface에만 의존함

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order order(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원정보를 조회하고
        int discountPrice = discountPolicy.disCount(member, itemPrice); // 할인 정책에 회원을 넘겨 할인금액을 가져온다
        return new Order(memberId,itemName,itemPrice,discountPrice); // 해당 정보를 리턴한다.
    }
}
