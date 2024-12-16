package umc6th.spring6th.apiPayload.exception.handler;

import umc6th.spring6th.apiPayload.code.BaseErrorCode;
import umc6th.spring6th.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
