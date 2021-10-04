package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id","username","age"})
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String userName;
    private int age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String userName) {
        this.userName = userName;
    }
}
