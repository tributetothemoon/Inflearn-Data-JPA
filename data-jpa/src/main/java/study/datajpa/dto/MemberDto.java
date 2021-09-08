package study.datajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "username", "teamName"})
public class MemberDto {
    private Long id;
    private String username;
    private String teamName;
}
