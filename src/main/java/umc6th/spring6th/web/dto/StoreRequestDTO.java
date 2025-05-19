package umc6th.spring6th.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class StoreRequestDTO {
    public StoreRequestDTO() {
    }

    public static class MissionDTO {
        @NotNull Integer reward;
        @NotNull LocalDate deadline;
        @NotNull String mission_spec;

        public MissionDTO() {
        }

        public Integer getReward() {
            return this.reward;
        }

        public LocalDate getDeadline() {
            return this.deadline;
        }

        public String getMission_spec() {
            return this.mission_spec;
        }
    }

    public static class StoreDTO {
        @NotNull Long id;
        @NotBlank String name;
        @NotNull String address;
        @NotNull Long region_id;

        public StoreDTO() {
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
    }

    public static class ReviewDTO {
        @NotBlank String title;
        @NotNull Float score;
        @NotBlank String body;

        public ReviewDTO() {
        }

        public String getTitle() {
            return this.title;
        }

        public Float getScore() {
            return this.score;
        }

        public String getBody() {
            return this.body;
        }
    }
}
