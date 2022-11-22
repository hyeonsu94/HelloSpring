package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private static float discountRate = 0.1f;

    @Override
    public int discount(Member member, int price) {
        int discountAmount = 0;
        if (member.getGrade() == Grade.VIP) {
            discountAmount = (int) (price * discountRate);
        }
        return discountAmount;
    }
}
