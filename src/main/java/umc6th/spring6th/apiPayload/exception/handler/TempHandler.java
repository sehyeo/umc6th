package umc6th.spring6th.apiPayload.exception.handler;

import umc6th.spring6th.apiPayload.code.BaseErrorCode;
import umc6th.spring6th.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
