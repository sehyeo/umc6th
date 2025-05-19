package umc6th.spring6th.converter;

import java.time.LocalDateTime;
import umc6th.spring6th.domain.Mission;
import umc6th.spring6th.domain.Review;
import umc6th.spring6th.domain.Store;
import umc6th.spring6th.web.dto.StoreRequestDTO;
import umc6th.spring6th.web.dto.StoreResponseDTO;
import umc6th.spring6th.web.dto.StoreResponseDTO.CreateMissionResultDTO;
import umc6th.spring6th.web.dto.StoreResponseDTO.CreateReviewResultDTO;
import umc6th.spring6th.web.dto.StoreResponseDTO.CreateStoreResultDTO;

public class StoreConverter {
    public StoreConverter() {
    }

    public static Review toReview(StoreRequestDTO.ReviewDTO request) {
        return Review.builder().title(request.getTitle()).score(request.getScore()).body(request.getBody()).build();
    }

    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {
        return CreateReviewResultDTO.builder().reviewId(review.getId()).createdAt(LocalDateTime.now()).build();
    }

    public static Store toStore(StoreRequestDTO.StoreDTO request) {
        return Store.builder().name(request.getName()).id(request.getId()).address(request.getAddress()).build();
    }

    public static StoreResponseDTO.CreateStoreResultDTO toCreateStoreResultDTO(Store store) {
        return CreateStoreResultDTO.builder().id(store.getId()).name(store.getName()).address(store.getAddress()).createdAt(LocalDateTime.now()).build();
    }

    public static Mission toMission(StoreRequestDTO.MissionDTO request) {
        return Mission.builder().reward(request.getReward()).deadline(request.getDeadline()).missionSpec(request.getMission_spec()).build();
    }

    public static StoreResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission) {
        return CreateMissionResultDTO.builder().storeId(mission.getId()).createdAt(LocalDateTime.now()).build();
    }
}
