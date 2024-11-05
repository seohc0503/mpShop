package hello.mpShop.member.member;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
public class Member {
    private int id;
    private String name;
    private String loginId;
    private String pw;
    private String pn;
    private String gender;
    private Date birth;
}
