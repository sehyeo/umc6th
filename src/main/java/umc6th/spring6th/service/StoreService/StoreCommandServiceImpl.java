package umc6th.spring6th.service.StoreService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc6th.spring6th.converter.StoreConverter;
import umc6th.spring6th.domain.Member;
import umc6th.spring6th.domain.Mission;
import umc6th.spring6th.domain.Region;
import umc6th.spring6th.domain.Review;
import umc6th.spring6th.domain.Store;
import umc6th.spring6th.repository.MemberRepository;
import umc6th.spring6th.repository.MissionRepository;
import umc6th.spring6th.repository.RegionRepository;
import umc6th.spring6th.repository.ReviewRepository;
import umc6th.spring6th.repository.StoreRepository;
import umc6th.spring6th.web.dto.StoreRequestDTO;

@Service
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final RegionRepository regionRepository;

    public Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request) {
        Review review = StoreConverter.toReview(request);
        review.setMember((Member)this.memberRepository.findById(memberId).get());
        review.setStore((Store)this.storeRepository.findById(storeId).get());
        return (Review)this.reviewRepository.save(review);
    }

    public Store createStore(StoreRequestDTO.StoreDTO request) {
        Store store = StoreConverter.toStore(request);
        store.setRegion((Region)this.regionRepository.findById(request.getRegion_id()).get());
        return (Store)this.storeRepository.save(store);
    }

    public Mission createMission(Long storeId, StoreRequestDTO.MissionDTO request) {
        Mission mission = StoreConverter.toMission(request);
        mission.setStore((Store)this.storeRepository.findById(storeId).get());
        return (Mission)this.missionRepository.save(mission);
    }

    public StoreCommandServiceImpl(final ReviewRepository reviewRepository, final MemberRepository memberRepository, final StoreRepository storeRepository, final MissionRepository missionRepository, final RegionRepository regionRepository) {
        this.reviewRepository = reviewRepository;
        this.memberRepository = memberRepository;
        this.storeRepository = storeRepository;
        this.missionRepository = missionRepository;
        this.regionRepository = regionRepository;
    }
}
