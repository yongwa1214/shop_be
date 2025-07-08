package kr.co.wikibook.gallery.account.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
//@NoArgsConstructor // 기본 생성자
@Getter
public class AccountJoinReq {
    private String name;
    private String loginId;
    private String loginPw;

}
