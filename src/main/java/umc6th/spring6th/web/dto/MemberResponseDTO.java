package umc6th.spring6th.web.dto;

import java.time.LocalDateTime;

public class MemberResponseDTO {
    public MemberResponseDTO() {
    }

    public static class JoinResultDTO {
        Long memberId;
        LocalDateTime createdAt;

        public static JoinResultDTOBuilder builder() {
            return new JoinResultDTOBuilder();
        }

        public Long getMemberId() {
            return this.memberId;
        }

        public LocalDateTime getCreatedAt() {
            return this.createdAt;
        }

        public JoinResultDTO() {
        }

        public JoinResultDTO(final Long memberId, final LocalDateTime createdAt) {
            this.memberId = memberId;
            this.createdAt = createdAt;
        }

        public static class JoinResultDTOBuilder {
            private Long memberId;
            private LocalDateTime createdAt;

            JoinResultDTOBuilder() {
            }

            public JoinResultDTOBuilder memberId(final Long memberId) {
                this.memberId = memberId;
                return this;
            }

            public JoinResultDTOBuilder createdAt(final LocalDateTime createdAt) {
                this.createdAt = createdAt;
                return this;
            }

            public JoinResultDTO build() {
                return new JoinResultDTO(this.memberId, this.createdAt);
            }

            public String toString() {
                Long var10000 = this.memberId;
                return "MemberResponseDTO.JoinResultDTO.JoinResultDTOBuilder(memberId=" + var10000 + ", createdAt=" + String.valueOf(this.createdAt) + ")";
            }
        }
    }
}
