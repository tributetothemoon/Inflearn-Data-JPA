package study.datajpa.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import study.datajpa.entity.Member;

import javax.persistence.criteria.*;

public class MemberSpec {
    public static Specification<Member> teamName(final String teamName) {
        return new Specification<Member>() {
            @Override
            public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                if (StringUtils.hasText(teamName)) {
                    return null;
                }

                Join<Object, Object> team = root.join("team", JoinType.INNER);// 회원과 조인
                return criteriaBuilder.equal(team.get("name"), teamName);
            }
        };
    }

    public static Specification<Member> userName(final String username) {
        return (root, query, builder) -> builder.equal(root.get("username"), username);
    }
}
