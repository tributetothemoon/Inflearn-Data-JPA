package study.datajpa.repository;

import lombok.Getter;

@Getter
public class UsernameOnlyDto {
    private final String username;

    public UsernameOnlyDto(String username) { // 파라미터 이름으로 프로젝션
        this.username = username;
    }
}
