package kr.co.wikibook.gallery.account.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class AccountLoginReq {
    private String loginId;
    private String loginPw;
}
