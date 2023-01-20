package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private static int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        int discountAmount = 0;
        if (member.getGrade() == Grade.VIP) {
            discountAmount = discountFixAmount;
        }
        return discountAmount;
    }
}
