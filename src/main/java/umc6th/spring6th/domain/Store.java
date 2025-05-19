package umc6th.spring6th.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import umc6th.spring6th.domain.common.BaseEntity;

@Entity
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            length = 20
    )
    private String name;
    @Column(
            nullable = false,
            length = 50
    )
    private String address;
    private Float score;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "region_id"
    )
    private Region region;
    @OneToMany(
            mappedBy = "store",
            cascade = {CascadeType.ALL}
    )
    private List<Mission> missionList = new ArrayList();
    @OneToMany(
            mappedBy = "store",
            cascade = {CascadeType.ALL}
    )
    private List<Review> reviewList = new ArrayList();

    public void setRegion(Region region) {
        if (this.region != null) {
            region.getStoreList().remove(this);
        }

        this.region = region;
        region.getStoreList().add(this);
    }

    public static StoreBuilder builder() {
        return new StoreBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Float getScore() {
        return this.score;
    }

    public Region getRegion() {
        return this.region;
    }

    public List<Mission> getMissionList() {
        return this.missionList;
    }

    public List<Review> getReviewList() {
        return this.reviewList;
    }

    protected Store() {
    }

    public Store(final Long id, final String name, final String address, final Float score, final Region region, final List<Mission> missionList, final List<Review> reviewList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.score = score;
        this.region = region;
        this.missionList = missionList;
        this.reviewList = reviewList;
    }

    public static class StoreBuilder {
        private Long id;
        private String name;
        private String address;
        private Float score;
        private Region region;
        private List<Mission> missionList;
        private List<Review> reviewList;

        StoreBuilder() {
        }

        public StoreBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public StoreBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public StoreBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public StoreBuilder score(final Float score) {
            this.score = score;
            return this;
        }

        public StoreBuilder region(final Region region) {
            this.region = region;
            return this;
        }

        public StoreBuilder missionList(final List<Mission> missionList) {
            this.missionList = missionList;
            return this;
        }

        public StoreBuilder reviewList(final List<Review> reviewList) {
            this.reviewList = reviewList;
            return this;
        }

        public Store build() {
            return new Store(this.id, this.name, this.address, this.score, this.region, this.missionList, this.reviewList);
        }

        public String toString() {
            Long var10000 = this.id;
            return "Store.StoreBuilder(id=" + var10000 + ", name=" + this.name + ", address=" + this.address + ", score=" + this.score + ", region=" + String.valueOf(this.region) + ", missionList=" + String.valueOf(this.missionList) + ", reviewList=" + String.valueOf(this.reviewList) + ")";
        }
    }
}
