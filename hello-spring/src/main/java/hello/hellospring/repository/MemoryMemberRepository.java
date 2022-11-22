package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong(0L);

    @Override
    public Member save(Member member) {
        sequence.set(sequence.get() + 1);
        member.setId(sequence.get());
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void deleteAll() {
        store.clear();
    }


}
