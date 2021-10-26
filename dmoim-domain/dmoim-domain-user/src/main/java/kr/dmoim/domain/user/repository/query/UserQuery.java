package kr.dmoim.domain.user.repository.query;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserQuery {

    private String email;
    private String nickName;

}