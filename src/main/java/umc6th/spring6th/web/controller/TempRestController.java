package umc6th.spring6th.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc6th.spring6th.apiPayload.ApiResponse;
import umc6th.spring6th.converter.TempConverter;
import umc6th.spring6th.service.TempService.TempQueryService;
import umc6th.spring6th.web.dto.TempResponse;

@RestController
@RequestMapping({"/temp"})
public class TempRestController {
    private final TempQueryService tempQueryService;

    @GetMapping({"/test"})
    public ApiResponse<TempResponse.TempTestDTO> testAPI() {
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping({"/exception"})
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag) {
        this.tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }

    public TempRestController(final TempQueryService tempQueryService) {
        this.tempQueryService = tempQueryService;
    }
}
