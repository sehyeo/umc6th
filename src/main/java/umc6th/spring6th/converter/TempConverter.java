package umc6th.spring6th.converter;

import umc6th.spring6th.web.dto.TempResponse;
import umc6th.spring6th.web.dto.TempResponse.TempExceptionDTO;
import umc6th.spring6th.web.dto.TempResponse.TempTestDTO;

public class TempConverter {
    public TempConverter() {
    }

    public static TempResponse.TempTestDTO toTempTestDTO() {
        return TempTestDTO.builder().testString("This is Test!").build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag) {
        return TempExceptionDTO.builder().flag(flag).build();
    }
}
