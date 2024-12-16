package umc6th.spring6th.web.controller;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc6th.spring6th.apiPayload.ApiResponse;
import umc6th.spring6th.converter.StoreConverter;
import umc6th.spring6th.domain.Mission;
import umc6th.spring6th.domain.Review;
import umc6th.spring6th.domain.Store;
import umc6th.spring6th.service.StoreService.StoreCommandService;
import umc6th.spring6th.validation.annotation.ExistMember;
import umc6th.spring6th.validation.annotation.ExistStore;
import umc6th.spring6th.web.dto.StoreRequestDTO;
import umc6th.spring6th.web.dto.StoreResponseDTO;

@RestController
@Validated
@RequestMapping({"/stores"})
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping({"/{storeId}/reviews"})
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.@Valid ReviewDTO request, @ExistStore @PathVariable(name = "storeId") Long storeId, @ExistMember @RequestParam(name = "memberId") Long memberId) {
        Review review = this.storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }

    @PostMapping({"/new"})
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.@Valid StoreDTO request) {
        Store store = this.storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateStoreResultDTO(store));
    }

    @PostMapping({"/{storeId}/missions"})
    public ApiResponse<StoreResponseDTO.CreateMissionResultDTO> createMission(@RequestBody @Valid StoreRequestDTO.@Valid MissionDTO request, @ExistStore @PathVariable(name = "storeId") Long storeId) {
        Mission mission = this.storeCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateMissionResultDTO(mission));
    }

    public StoreRestController(final StoreCommandService storeCommandService) {
        this.storeCommandService = storeCommandService;
    }
}
