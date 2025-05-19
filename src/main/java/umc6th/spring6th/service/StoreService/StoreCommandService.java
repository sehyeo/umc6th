package umc6th.spring6th.service.StoreService;

import umc6th.spring6th.domain.Mission;
import umc6th.spring6th.domain.Review;
import umc6th.spring6th.domain.Store;
import umc6th.spring6th.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request);

    Store createStore(StoreRequestDTO.StoreDTO request);

    Mission createMission(Long storeId, StoreRequestDTO.MissionDTO request);
}
