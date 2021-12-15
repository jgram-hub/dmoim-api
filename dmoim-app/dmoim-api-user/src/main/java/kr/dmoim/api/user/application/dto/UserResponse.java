package kr.dmoim.api.user.application.dto;


import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import kr.dmoim.domain.user.domain.entity.UserEntity;
import kr.dmoim.core.domain.vo.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class UserResponse {

    @JsonView(UserViews.List.class)
    @Schema(description = "사용자아이디")
    private final Long userId;

    @JsonView(UserViews.List.class)
    @Schema(description = "이메일")
    private final Email email;

    @JsonView(UserViews.List.class)
    @Schema(description = "닉네임")
    private final String nickName;

    @JsonView(UserViews.List.class)
    @Schema(description = "삭제여부")
    private final Boolean deleted;

    @JsonView(UserViews.List.class)
    @Schema(description = "버전")
    private final Long version;

    @JsonView(UserViews.List.class)
    @Schema(description = "생성자")
    private final Long createdBy;

    @JsonView(UserViews.List.class)
    @Schema(description = "생성일시")
    private final LocalDateTime createdAt;

    /*@Schema(description = "갱신자")*/
    private final Long updatedBy;

    /*@Schema(description = "갱신일시")*/
    private final LocalDateTime updatedAt;


    public static UserResponse fromEntity(final UserEntity userEntity) {
        return UserResponse
                .builder()
                    .userId(userEntity.getUserId())
                    .email(userEntity.getEmail())
                    .nickName(userEntity.getNickName())
                    .version(userEntity.getVersion())
                    .createdBy(userEntity.getCreatedBy())
                    .createdAt(userEntity.getCreatedAt())
                    .updatedBy(userEntity.getUpdatedBy())
                    .updatedAt(userEntity.getUpdatedAt())
                .build();
    }
}
