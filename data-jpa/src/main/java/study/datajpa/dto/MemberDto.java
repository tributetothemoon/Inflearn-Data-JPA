package study.datajpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import study.datajpa.entity.Member;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(of = {"id", "username", "teamName"})
public class MemberDto {
    private Long id;
    private String username;
    private String teamName;

    public MemberDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public static MemberDto from(Member member) {
        return new MemberDto(member.getId(), member.getUsername());
    }
}
