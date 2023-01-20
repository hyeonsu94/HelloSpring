package hello.core.discount;

import hello.core.annotaion.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
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
