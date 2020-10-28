package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDisCountPolicy implements  DiscountPolicy{

    private int discountFixAccount = 1000; // 1000원 할인 금액
    @Override
    public int disCount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){
            return discountFixAccount;
        } else if (member.getGrade() == Grade.BASIC) {
            return 0;
        }
        return 0;
    }

}
