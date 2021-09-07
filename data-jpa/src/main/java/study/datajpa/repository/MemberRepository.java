package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    /*
     * 컨디션을 안 넣으면 전체조회가 된다.
     * find...By // ...에는 뭐가 들어가도 상관 없다.
     */
    List<Member> findHelloBy();

    List<Member> findTop3by();

    @Query(name = "Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username);
}
