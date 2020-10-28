package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPrice = 10;

    @Override
    public int disCount(Member member, int price) {
        // VIP 회원이면 할인
        if(member.getGrade() == Grade.VIP ){
            return price*discountPrice/100;
        } else {
            return 0;
        }
    }
}
