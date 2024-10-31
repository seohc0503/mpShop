package hello.mpShop.member.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Getter
@Setter
@Component
@NoArgsConstructor
public class Member {
    private int id;
    private String name;
    private String loginId;
    private String pw;
    private String pn;
    private String gender;
    private Date birth;
}
