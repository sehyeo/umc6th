package umc6th.spring6th.domain.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import umc6th.spring6th.domain.Member;
import umc6th.spring6th.domain.Mission;
import umc6th.spring6th.domain.common.BaseEntity;
import umc6th.spring6th.domain.enums.MissionStatus;

@Entity
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Enumerated(EnumType.STRING)
    private MissionStatus status;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "member_id"
    )
    private Member member;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "mission_id"
    )
    private Mission mission;

    public static MemberMissionBuilder builder() {
        return new MemberMissionBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public MissionStatus getStatus() {
        return this.status;
    }

    public Member getMember() {
        return this.member;
    }

    public Mission getMission() {
        return this.mission;
    }

    protected MemberMission() {
    }

    public MemberMission(final Long id, final MissionStatus status, final Member member, final Mission mission) {
        this.id = id;
        this.status = status;
        this.member = member;
        this.mission = mission;
    }

    public static class MemberMissionBuilder {
        private Long id;
        private MissionStatus status;
        private Member member;
        private Mission mission;

        MemberMissionBuilder() {
        }

        public MemberMissionBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public MemberMissionBuilder status(final MissionStatus status) {
            this.status = status;
            return this;
        }

        public MemberMissionBuilder member(final Member member) {
            this.member = member;
            return this;
        }

        public MemberMissionBuilder mission(final Mission mission) {
            this.mission = mission;
            return this;
        }

        public MemberMission build() {
            return new MemberMission(this.id, this.status, this.member, this.mission);
        }

        public String toString() {
            Long var10000 = this.id;
            return "MemberMission.MemberMissionBuilder(id=" + var10000 + ", status=" + String.valueOf(this.status) + ", member=" + String.valueOf(this.member) + ", mission=" + String.valueOf(this.mission) + ")";
        }
    }
}
