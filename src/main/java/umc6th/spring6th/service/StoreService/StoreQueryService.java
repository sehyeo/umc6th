package umc6th.spring6th.service.StoreService;

import umc6th.spring6th.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
}
