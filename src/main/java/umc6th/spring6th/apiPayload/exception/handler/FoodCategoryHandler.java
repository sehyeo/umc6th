package umc6th.spring6th.apiPayload.exception.handler;

import umc6th.spring6th.apiPayload.code.BaseErrorCode;
import umc6th.spring6th.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
