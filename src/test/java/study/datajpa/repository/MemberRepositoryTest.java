package study.datajpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void findByUsernameAndAgeGreaterThan(){
        Member a = new Member("A", 20);
        Member b = new Member("A", 30);
        memberRepository.save(a);
        memberRepository.save(b);
        //namedQuery
        List<Member> members = memberRepository.findByUsernameAndAgeGreaterThan("A", 15);
        Assertions.assertThat(members.get(0).getAge()).isEqualTo(30);
    }

    @Test
    public void queryTest(){
        Member a = new Member("A", 20);
        Member b = new Member("A", 30);
        memberRepository.save(a);
        memberRepository.save(b);

        List<Member> findMember = memberRepository.findMember("A", 20);
        Assertions.assertThat(findMember.get(0)).isEqualTo(a);
    }
}