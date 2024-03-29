package hello.core.member;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Nullable
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
