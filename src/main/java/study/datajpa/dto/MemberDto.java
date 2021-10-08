package study.datajpa.dto;

import lombok.Data;

@Data
public class MemberDto {

    private Long id;
    private String userName;
    private String team;

    public MemberDto(Long id, String userName, String team) {
        this.id = id;
        this.userName = userName;
        this.team = team;
    }
}
