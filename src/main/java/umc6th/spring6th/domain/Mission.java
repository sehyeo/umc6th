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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import umc6th.spring6th.domain.common.BaseEntity;
import umc6th.spring6th.domain.mapping.MemberMission;

@Entity
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private Integer reward;
    private LocalDate deadline;
    @Column(
            nullable = false,
            length = 50
    )
    private String missionSpec;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "store_id"
    )
    private Store store;
    @OneToMany(
            mappedBy = "mission",
            cascade = {CascadeType.ALL}
    )
    private List<MemberMission> memberMissionList = new ArrayList();

    public void setStore(Store store) {
        if (this.store != null) {
            store.getMissionList().remove(this);
        }

        this.store = store;
        store.getMissionList().add(this);
    }

    public static MissionBuilder builder() {
        return new MissionBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Integer getReward() {
        return this.reward;
    }

    public LocalDate getDeadline() {
        return this.deadline;
    }

    public String getMissionSpec() {
        return this.missionSpec;
    }

    public Store getStore() {
        return this.store;
    }

    public List<MemberMission> getMemberMissionList() {
        return this.memberMissionList;
    }

    protected Mission() {
    }

    public Mission(final Long id, final Integer reward, final LocalDate deadline, final String missionSpec, final Store store, final List<MemberMission> memberMissionList) {
        this.id = id;
        this.reward = reward;
        this.deadline = deadline;
        this.missionSpec = missionSpec;
        this.store = store;
        this.memberMissionList = memberMissionList;
    }

    public static class MissionBuilder {
        private Long id;
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
        private Store store;
        private List<MemberMission> memberMissionList;

        MissionBuilder() {
        }

        public MissionBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public MissionBuilder reward(final Integer reward) {
            this.reward = reward;
            return this;
        }

        public MissionBuilder deadline(final LocalDate deadline) {
            this.deadline = deadline;
            return this;
        }

        public MissionBuilder missionSpec(final String missionSpec) {
            this.missionSpec = missionSpec;
            return this;
        }

        public MissionBuilder store(final Store store) {
            this.store = store;
            return this;
        }

        public MissionBuilder memberMissionList(final List<MemberMission> memberMissionList) {
            this.memberMissionList = memberMissionList;
            return this;
        }

        public Mission build() {
            return new Mission(this.id, this.reward, this.deadline, this.missionSpec, this.store, this.memberMissionList);
        }

        public String toString() {
            Long var10000 = this.id;
            return "Mission.MissionBuilder(id=" + var10000 + ", reward=" + this.reward + ", deadline=" + String.valueOf(this.deadline) + ", missionSpec=" + this.missionSpec + ", store=" + String.valueOf(this.store) + ", memberMissionList=" + String.valueOf(this.memberMissionList) + ")";
        }
    }
}
