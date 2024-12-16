
package umc6th.spring6th.apiPayload.exception;

import umc6th.spring6th.apiPayload.code.BaseErrorCode;
import umc6th.spring6th.apiPayload.code.ErrorReasonDTO;

public class GeneralException extends RuntimeException {
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }

    public BaseErrorCode getCode() {
        return this.code;
    }

    public GeneralException(final BaseErrorCode code) {
        this.code = code;
    }
}
