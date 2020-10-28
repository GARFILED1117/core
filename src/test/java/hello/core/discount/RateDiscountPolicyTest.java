package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 성공테스트
    @Test
    @DisplayName("VIP 는 10프로 할인이 적용되어야 한다 ")
    void vip_o () {
        //given
        Member member = new Member(1L,"memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.disCount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("회원등급이 VIP 가 아니면 할인이 적용되지 않아야한다.")
    void vip_x () {

        //given
        Member member = new Member(2L,"memberNotVip",Grade.BASIC);

        //then
        int discount = discountPolicy.disCount(member,10000);

        //then
        Assertions.assertThat(discount).isNotEqualTo(1000);

    }


}