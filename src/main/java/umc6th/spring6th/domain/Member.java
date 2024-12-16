package umc6th.spring6th.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc6th.spring6th.domain.common.BaseEntity;
import umc6th.spring6th.domain.enums.Gender;
import umc6th.spring6th.domain.enums.MemberStatus;
import umc6th.spring6th.domain.enums.SocialType;
import umc6th.spring6th.domain.mapping.MemberAgree;
import umc6th.spring6th.domain.mapping.MemberMission;
import umc6th.spring6th.domain.mapping.MemberPrefer;

@Entity
@DynamicUpdate
@DynamicInsert
public class Member extends BaseEntity {
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
            length = 40
    )
    private String address;
    @Column(
            nullable = false,
            length = 40
    )
    private String specAddress;
    @Enumerated(EnumType.STRING)
    @Column(
            columnDefinition = "VARCHAR(10)"
    )
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private SocialType socialType;
    @Enumerated(EnumType.STRING)
    @Column(
            columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'"
    )
    private MemberStatus status;
    private LocalDate inactiveDate;
    private String email;
    @ColumnDefault("0")
    private Integer point;
    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<MemberAgree> memberAgreeList = new ArrayList();
    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<MemberPrefer> memberPreferList = new ArrayList();
    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<Review> reviewList = new ArrayList();
    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<MemberMission> memberMissionList = new ArrayList();

    public static MemberBuilder builder() {
        return new MemberBuilder();
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

    public String getSpecAddress() {
        return this.specAddress;
    }

    public Gender getGender() {
        return this.gender;
    }

    public SocialType getSocialType() {
        return this.socialType;
    }

    public MemberStatus getStatus() {
        return this.status;
    }

    public LocalDate getInactiveDate() {
        return this.inactiveDate;
    }

    public String getEmail() {
        return this.email;
    }

    public Integer getPoint() {
        return this.point;
    }

    public List<MemberAgree> getMemberAgreeList() {
        return this.memberAgreeList;
    }

    public List<MemberPrefer> getMemberPreferList() {
        return this.memberPreferList;
    }

    public List<Review> getReviewList() {
        return this.reviewList;
    }

    public List<MemberMission> getMemberMissionList() {
        return this.memberMissionList;
    }

    protected Member() {
    }

    public Member(final Long id, final String name, final String address, final String specAddress, final Gender gender, final SocialType socialType, final MemberStatus status, final LocalDate inactiveDate, final String email, final Integer point, final List<MemberAgree> memberAgreeList, final List<MemberPrefer> memberPreferList, final List<Review> reviewList, final List<MemberMission> memberMissionList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.specAddress = specAddress;
        this.gender = gender;
        this.socialType = socialType;
        this.status = status;
        this.inactiveDate = inactiveDate;
        this.email = email;
        this.point = point;
        this.memberAgreeList = memberAgreeList;
        this.memberPreferList = memberPreferList;
        this.reviewList = reviewList;
        this.memberMissionList = memberMissionList;
    }

    public static class MemberBuilder {
        private Long id;
        private String name;
        private String address;
        private String specAddress;
        private Gender gender;
        private SocialType socialType;
        private MemberStatus status;
        private LocalDate inactiveDate;
        private String email;
        private Integer point;
        private List<MemberAgree> memberAgreeList;
        private List<MemberPrefer> memberPreferList;
        private List<Review> reviewList;
        private List<MemberMission> memberMissionList;

        MemberBuilder() {
        }

        public MemberBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public MemberBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public MemberBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public MemberBuilder specAddress(final String specAddress) {
            this.specAddress = specAddress;
            return this;
        }

        public MemberBuilder gender(final Gender gender) {
            this.gender = gender;
            return this;
        }

        public MemberBuilder socialType(final SocialType socialType) {
            this.socialType = socialType;
            return this;
        }

        public MemberBuilder status(final MemberStatus status) {
            this.status = status;
            return this;
        }

        public MemberBuilder inactiveDate(final LocalDate inactiveDate) {
            this.inactiveDate = inactiveDate;
            return this;
        }

        public MemberBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder point(final Integer point) {
            this.point = point;
            return this;
        }

        public MemberBuilder memberAgreeList(final List<MemberAgree> memberAgreeList) {
            this.memberAgreeList = memberAgreeList;
            return this;
        }

        public MemberBuilder memberPreferList(final List<MemberPrefer> memberPreferList) {
            this.memberPreferList = memberPreferList;
            return this;
        }

        public MemberBuilder reviewList(final List<Review> reviewList) {
            this.reviewList = reviewList;
            return this;
        }

        public MemberBuilder memberMissionList(final List<MemberMission> memberMissionList) {
            this.memberMissionList = memberMissionList;
            return this;
        }

        public Member build() {
            return new Member(this.id, this.name, this.address, this.specAddress, this.gender, this.socialType, this.status, this.inactiveDate, this.email, this.point, this.memberAgreeList, this.memberPreferList, this.reviewList, this.memberMissionList);
        }

        public String toString() {
            Long var10000 = this.id;
            return "Member.MemberBuilder(id=" + var10000 + ", name=" + this.name + ", address=" + this.address + ", specAddress=" + this.specAddress + ", gender=" + String.valueOf(this.gender) + ", socialType=" + String.valueOf(this.socialType) + ", status=" + String.valueOf(this.status) + ", inactiveDate=" + String.valueOf(this.inactiveDate) + ", email=" + this.email + ", point=" + this.point + ", memberAgreeList=" + String.valueOf(this.memberAgreeList) + ", memberPreferList=" + String.valueOf(this.memberPreferList) + ", reviewList=" + String.valueOf(this.reviewList) + ", memberMissionList=" + String.valueOf(this.memberMissionList) + ")";
        }
    }
}
