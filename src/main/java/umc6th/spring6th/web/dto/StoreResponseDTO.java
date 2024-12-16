package umc6th.spring6th.web.dto;

import java.time.LocalDateTime;

public class StoreResponseDTO {
    public StoreResponseDTO() {
    }

    public static class CreateMissionResultDTO {
        Long storeId;
        LocalDateTime createdAt;

        public static CreateMissionResultDTOBuilder builder() {
            return new CreateMissionResultDTOBuilder();
        }

        public Long getStoreId() {
            return this.storeId;
        }

        public LocalDateTime getCreatedAt() {
            return this.createdAt;
        }

        public CreateMissionResultDTO() {
        }

        public CreateMissionResultDTO(final Long storeId, final LocalDateTime createdAt) {
            this.storeId = storeId;
            this.createdAt = createdAt;
        }

        public static class CreateMissionResultDTOBuilder {
            private Long storeId;
            private LocalDateTime createdAt;

            CreateMissionResultDTOBuilder() {
            }

            public CreateMissionResultDTOBuilder storeId(final Long storeId) {
                this.storeId = storeId;
                return this;
            }

            public CreateMissionResultDTOBuilder createdAt(final LocalDateTime createdAt) {
                this.createdAt = createdAt;
                return this;
            }

            public CreateMissionResultDTO build() {
                return new CreateMissionResultDTO(this.storeId, this.createdAt);
            }

            public String toString() {
                Long var10000 = this.storeId;
                return "StoreResponseDTO.CreateMissionResultDTO.CreateMissionResultDTOBuilder(storeId=" + var10000 + ", createdAt=" + String.valueOf(this.createdAt) + ")";
            }
        }
    }

    public static class CreateStoreResultDTO {
        Long id;
        String name;
        String address;
        Long region_id;
        LocalDateTime createdAt;

        public static CreateStoreResultDTOBuilder builder() {
            return new CreateStoreResultDTOBuilder();
        }

        public Long getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getAddress() {
            return this.address;
        }

        public Long getRegion_id() {
            return this.region_id;
        }

        public LocalDateTime getCreatedAt() {
            return this.createdAt;
        }

        public CreateStoreResultDTO() {
        }

        public CreateStoreResultDTO(final Long id, final String name, final String address, final Long region_id, final LocalDateTime createdAt) {
            this.id = id;
            this.name = name;
            this.address = address;
            this.region_id = region_id;
            this.createdAt = createdAt;
        }

        public static class CreateStoreResultDTOBuilder {
            private Long id;
            private String name;
            private String address;
            private Long region_id;
            private LocalDateTime createdAt;

            CreateStoreResultDTOBuilder() {
            }

            public CreateStoreResultDTOBuilder id(final Long id) {
                this.id = id;
                return this;
            }

            public CreateStoreResultDTOBuilder name(final String name) {
                this.name = name;
                return this;
            }

            public CreateStoreResultDTOBuilder address(final String address) {
                this.address = address;
                return this;
            }

            public CreateStoreResultDTOBuilder region_id(final Long region_id) {
                this.region_id = region_id;
                return this;
            }

            public CreateStoreResultDTOBuilder createdAt(final LocalDateTime createdAt) {
                this.createdAt = createdAt;
                return this;
            }

            public CreateStoreResultDTO build() {
                return new CreateStoreResultDTO(this.id, this.name, this.address, this.region_id, this.createdAt);
            }

            public String toString() {
                Long var10000 = this.id;
                return "StoreResponseDTO.CreateStoreResultDTO.CreateStoreResultDTOBuilder(id=" + var10000 + ", name=" + this.name + ", address=" + this.address + ", region_id=" + this.region_id + ", createdAt=" + String.valueOf(this.createdAt) + ")";
            }
        }
    }

    public static class CreateReviewResultDTO {
        Long reviewId;
        LocalDateTime createdAt;

        public static CreateReviewResultDTOBuilder builder() {
            return new CreateReviewResultDTOBuilder();
        }

        public Long getReviewId() {
            return this.reviewId;
        }

        public LocalDateTime getCreatedAt() {
            return this.createdAt;
        }

        public CreateReviewResultDTO() {
        }

        public CreateReviewResultDTO(final Long reviewId, final LocalDateTime createdAt) {
            this.reviewId = reviewId;
            this.createdAt = createdAt;
        }

        public static class CreateReviewResultDTOBuilder {
            private Long reviewId;
            private LocalDateTime createdAt;

            CreateReviewResultDTOBuilder() {
            }

            public CreateReviewResultDTOBuilder reviewId(final Long reviewId) {
                this.reviewId = reviewId;
                return this;
            }

            public CreateReviewResultDTOBuilder createdAt(final LocalDateTime createdAt) {
                this.createdAt = createdAt;
                return this;
            }

            public CreateReviewResultDTO build() {
                return new CreateReviewResultDTO(this.reviewId, this.createdAt);
            }

            public String toString() {
                Long var10000 = this.reviewId;
                return "StoreResponseDTO.CreateReviewResultDTO.CreateReviewResultDTOBuilder(reviewId=" + var10000 + ", createdAt=" + String.valueOf(this.createdAt) + ")";
            }
        }
    }
}
