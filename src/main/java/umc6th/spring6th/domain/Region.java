package umc6th.spring6th.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import umc6th.spring6th.domain.common.BaseEntity;

@Entity
public class Region extends BaseEntity {
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
    @OneToMany(
            mappedBy = "region",
            cascade = {CascadeType.ALL}
    )
    private List<Store> storeList = new ArrayList();

    public static RegionBuilder builder() {
        return new RegionBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Store> getStoreList() {
        return this.storeList;
    }

    protected Region() {
    }

    public Region(final Long id, final String name, final List<Store> storeList) {
        this.id = id;
        this.name = name;
        this.storeList = storeList;
    }

    public static class RegionBuilder {
        private Long id;
        private String name;
        private List<Store> storeList;

        RegionBuilder() {
        }

        public RegionBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public RegionBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public RegionBuilder storeList(final List<Store> storeList) {
            this.storeList = storeList;
            return this;
        }

        public Region build() {
            return new Region(this.id, this.name, this.storeList);
        }

        public String toString() {
            Long var10000 = this.id;
            return "Region.RegionBuilder(id=" + var10000 + ", name=" + this.name + ", storeList=" + String.valueOf(this.storeList) + ")";
        }
    }
}
