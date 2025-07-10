package kr.co.wikibook.gallery.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class AccountLoginRes {
    private int id;
    private String name;


    @JsonIgnore // json 으로 만들어질때 loginPw는 빠진다
    private String loginPw;
}
