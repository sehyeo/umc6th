package umc6th.spring6th.apiPayload.code;

import org.springframework.http.HttpStatus;

public class ReasonDTO {
    private HttpStatus httpStatus;
    private final boolean isSuccess;
    private final String code;
    private final String message;

    public boolean getIsSuccess() {
        return this.isSuccess;
    }

    ReasonDTO(final HttpStatus httpStatus, final boolean isSuccess, final String code, final String message) {
        this.httpStatus = httpStatus;
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    public static ReasonDTOBuilder builder() {
        return new ReasonDTOBuilder();
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static class ReasonDTOBuilder {
        private HttpStatus httpStatus;
        private boolean isSuccess;
        private String code;
        private String message;

        ReasonDTOBuilder() {
        }

        public ReasonDTOBuilder httpStatus(final HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ReasonDTOBuilder isSuccess(final boolean isSuccess) {
            this.isSuccess = isSuccess;
            return this;
        }

        public ReasonDTOBuilder code(final String code) {
            this.code = code;
            return this;
        }

        public ReasonDTOBuilder message(final String message) {
            this.message = message;
            return this;
        }

        public ReasonDTO build() {
            return new ReasonDTO(this.httpStatus, this.isSuccess, this.code, this.message);
        }

        public String toString() {
            String var10000 = String.valueOf(this.httpStatus);
            return "ReasonDTO.ReasonDTOBuilder(httpStatus=" + var10000 + ", isSuccess=" + this.isSuccess + ", code=" + this.code + ", message=" + this.message + ")";
        }
    }
}
