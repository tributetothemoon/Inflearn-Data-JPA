package study.datajpa.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;
import study.datajpa.repository.MemberRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/username/{id}")
    public String findUsernameById(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id).orElseThrow();
        return member.getUsername();
    }

    @GetMapping("/usernameByDomainConverterClass/{id}")
    public String findUsernameById(@PathVariable("id") Member member) {
        return member.getUsername();
    }

    @GetMapping("/members")
    public Page<MemberDto> list(@PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return memberRepository.findAll(pageable)
                .map(MemberDto::from);
    }

    @PostConstruct
    public void init() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            members.add(new Member("user" + i, i));
        }
        memberRepository.saveAll(members);
    }
}
