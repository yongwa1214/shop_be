package kr.co.wikibook.gallery.account;

import kr.co.wikibook.gallery.account.model.*;
import kr.co.wikibook.gallery.common.util.HttpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class AccountService {
    private final AccountMapper accountMapper;

    public int join(AccountJoinReq req){
        String hashedPw = BCrypt.hashpw(req.getLoginPw(), BCrypt.gensalt()); // pw 암호화
        // 암호화가 된 비밀번호를 갖는 AccountJoinReq 객체를 만들어주세요.
        AccountJoinReq changedReq = new AccountJoinReq(req.getName(),
                                                           req.getLoginId(), hashedPw); // 이건 새로운 AccountJoinReq다
        return accountMapper.save(changedReq);
    }

    public AccountLoginRes login(AccountLoginReq req){
        AccountLoginRes res = accountMapper.findByLoginId(req);
        // // 아이디가 없거나 비밀번호가 다르다면
        if(res == null || !BCrypt.checkpw(req.getLoginPw(), res.getLoginPw())){ // .checkpw 첫번째: 받은 비번 두번째: db에 있는 암호화된 비번
            return null; // return null; 처리
        }



        return res;
    }
}

