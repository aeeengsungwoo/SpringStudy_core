package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository{
    // ConcurrentHashMap<>() 실무에서는 동시성 이슈가 있을 수 있어 이걸 써야하지만 예제기 때문에 그냥 해시맵을 사용
    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
