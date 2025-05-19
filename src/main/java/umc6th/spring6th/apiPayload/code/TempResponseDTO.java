package umc6th.spring6th.apiPayload.code;

public class TempResponseDTO {
    public TempResponseDTO() {
    }

    public static class TempExceptionDTO {
        Integer flag;

        public static TempExceptionDTOBuilder builder() {
            return new TempExceptionDTOBuilder();
        }

        public Integer getFlag() {
            return this.flag;
        }

        public TempExceptionDTO() {
        }

        public TempExceptionDTO(final Integer flag) {
            this.flag = flag;
        }

        public static class TempExceptionDTOBuilder {
            private Integer flag;

            TempExceptionDTOBuilder() {
            }

            public TempExceptionDTOBuilder flag(final Integer flag) {
                this.flag = flag;
                return this;
            }

            public TempExceptionDTO build() {
                return new TempExceptionDTO(this.flag);
            }

            public String toString() {
                return "TempResponseDTO.TempExceptionDTO.TempExceptionDTOBuilder(flag=" + this.flag + ")";
            }
        }
    }

    public static class TempTestDTO {
        String testString;

        public static TempTestDTOBuilder builder() {
            return new TempTestDTOBuilder();
        }

        public String getTestString() {
            return this.testString;
        }

        public TempTestDTO() {
        }

        public TempTestDTO(final String testString) {
            this.testString = testString;
        }

        public static class TempTestDTOBuilder {
            private String testString;

            TempTestDTOBuilder() {
            }

            public TempTestDTOBuilder testString(final String testString) {
                this.testString = testString;
                return this;
            }

            public TempTestDTO build() {
                return new TempTestDTO(this.testString);
            }

            public String toString() {
                return "TempResponseDTO.TempTestDTO.TempTestDTOBuilder(testString=" + this.testString + ")";
            }
        }
    }
}
