package umc6th.spring6th.apiPayload.code.status;

import org.springframework.http.HttpStatus;
import umc6th.spring6th.apiPayload.code.BaseErrorCode;
import umc6th.spring6th.apiPayload.code.ErrorReasonDTO;

public enum CommonErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder().message(this.message).code(this.code).isSuccess(false).build();
    }

    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder().message(this.message).code(this.code).isSuccess(false).httpStatus(this.httpStatus).build();
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

    private CommonErrorStatus(final HttpStatus httpStatus, final String code, final String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
