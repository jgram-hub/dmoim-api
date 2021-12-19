package kr.dmoim.api.user.application.response;


import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import kr.dmoim.api.user.presentation.view.UserView;
import kr.dmoim.core.domain.vo.Email;
import kr.dmoim.domain.user.domain.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class UserResponse {

    @JsonView({UserView.List.class, UserView.Detail.class})
    @Schema(description = "사용자아이디")
    private final Long userId;

    @JsonView({UserView.List.class, UserView.Detail.class})
    @Schema(description = "이메일")
    private final Email email;

    @JsonView({UserView.List.class, UserView.Detail.class})
    @Schema(description = "닉네임")
    private final String nickName;

    @JsonView(UserView.List.class)
    @Schema(description = "삭제여부")
    private final Boolean deleted;

    @JsonView(UserView.Detail.class)
    @Schema(description = "버전")
    private final Long version;

    @JsonView(UserView.List.class)
    @Schema(description = "생성자")
    private final Long createdBy;

    @JsonView({UserView.List.class, UserView.Detail.class})
    @Schema(description = "생성일시")
    private final LocalDateTime createdAt;

    @JsonView(UserView.List.class)
    @Schema(description = "갱신자")
    private final Long updatedBy;

    @JsonView({UserView.List.class, UserView.Detail.class})
    @Schema(description = "갱신일시")
    private final LocalDateTime updatedAt;


    public static UserResponse fromEntity(final UserEntity userEntity) {
        return UserResponse
                .builder()
                    .userId(userEntity.getUserId())
                    .email(userEntity.getEmail())
                    .nickName(userEntity.getNickName())
                    .version(userEntity.getVersion())
                    .deleted(userEntity.getDeleted())
                    .createdBy(userEntity.getCreatedBy())
                    .createdAt(userEntity.getCreatedAt())
                    .updatedBy(userEntity.getUpdatedBy())
                    .updatedAt(userEntity.getUpdatedAt())
                .build();
    }
}
