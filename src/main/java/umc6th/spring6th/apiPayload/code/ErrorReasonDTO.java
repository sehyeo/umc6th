package umc6th.spring6th.apiPayload.code;

import org.springframework.http.HttpStatus;

public class ErrorReasonDTO {
    private HttpStatus httpStatus;
    private final boolean isSuccess;
    private final String code;
    private final String message;

    public boolean getIsSuccess() {
        return this.isSuccess;
    }

    ErrorReasonDTO(final HttpStatus httpStatus, final boolean isSuccess, final String code, final String message) {
        this.httpStatus = httpStatus;
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    public static ErrorReasonDTOBuilder builder() {
        return new ErrorReasonDTOBuilder();
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

    public static class ErrorReasonDTOBuilder {
        private HttpStatus httpStatus;
        private boolean isSuccess;
        private String code;
        private String message;

        ErrorReasonDTOBuilder() {
        }

        public ErrorReasonDTOBuilder httpStatus(final HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ErrorReasonDTOBuilder isSuccess(final boolean isSuccess) {
            this.isSuccess = isSuccess;
            return this;
        }

        public ErrorReasonDTOBuilder code(final String code) {
            this.code = code;
            return this;
        }

        public ErrorReasonDTOBuilder message(final String message) {
            this.message = message;
            return this;
        }

        public ErrorReasonDTO build() {
            return new ErrorReasonDTO(this.httpStatus, this.isSuccess, this.code, this.message);
        }

        public String toString() {
            String var10000 = String.valueOf(this.httpStatus);
            return "ErrorReasonDTO.ErrorReasonDTOBuilder(httpStatus=" + var10000 + ", isSuccess=" + this.isSuccess + ", code=" + this.code + ", message=" + this.message + ")";
        }
    }
}
