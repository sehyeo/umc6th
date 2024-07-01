package umc.spring.study.service.StoreService;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Region;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request);

    Store createStore(StoreRequestDTO.StoreDTO request);

    Mission createMission(Long storeId, StoreRequestDTO.MissionDTO request);
}
