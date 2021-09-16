package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    public Team(String name) {
        this(null, name);
    }

    public Team(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "team", orphanRemoval = true)
    private List<Member> members = new ArrayList<>();
}
