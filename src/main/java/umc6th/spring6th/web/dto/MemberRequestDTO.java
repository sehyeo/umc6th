package umc6th.spring6th.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import umc6th.spring6th.validation.annotation.ExistCategories;

public class MemberRequestDTO {
    public MemberRequestDTO() {
    }

    public static class JoinDto {
        @NotBlank String name;
        @NotNull Integer gender;
        @NotNull Integer birthYear;
        @NotNull Integer birthMonth;
        @NotNull Integer birthDay;
        @Size(
                min = 5,
                max = 12
        ) String address;
        @Size(
                min = 5,
                max = 12
        ) String specAddress;
        @ExistCategories
        List<Long> preferCategory;

        public JoinDto() {
        }

        public String getName() {
            return this.name;
        }

        public Integer getGender() {
            return this.gender;
        }

        public Integer getBirthYear() {
            return this.birthYear;
        }

        public Integer getBirthMonth() {
            return this.birthMonth;
        }

        public Integer getBirthDay() {
            return this.birthDay;
        }

        public String getAddress() {
            return this.address;
        }

        public String getSpecAddress() {
            return this.specAddress;
        }

        public List<Long> getPreferCategory() {
            return this.preferCategory;
        }
    }
}
