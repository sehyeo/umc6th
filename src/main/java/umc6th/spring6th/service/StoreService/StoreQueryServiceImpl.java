package umc6th.spring6th.service.StoreService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc6th.spring6th.domain.Store;
import umc6th.spring6th.repository.StoreRepository;

import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc6th.spring6th.domain.Store;
import umc6th.spring6th.repository.StoreRepository;

@Service
@Transactional(
        readOnly = true
)
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;

    public Optional<Store> findStore(Long id) {
        return this.storeRepository.findById(id);
    }

    public StoreQueryServiceImpl(final StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
}