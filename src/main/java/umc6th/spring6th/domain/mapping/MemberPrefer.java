package umc6th.spring6th.domain.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import umc6th.spring6th.domain.FoodCategory;
import umc6th.spring6th.domain.Member;
import umc6th.spring6th.domain.common.BaseEntity;

@Entity
public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
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
            name = "category_id"
    )
    private FoodCategory foodCategory;

    public void setMember(Member member) {
        if (this.member != null) {
            member.getMemberPreferList().remove(this);
        }

        this.member = member;
        member.getMemberPreferList().add(this);
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public static MemberPreferBuilder builder() {
        return new MemberPreferBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Member getMember() {
        return this.member;
    }

    public FoodCategory getFoodCategory() {
        return this.foodCategory;
    }

    protected MemberPrefer() {
    }

    public MemberPrefer(final Long id, final Member member, final FoodCategory foodCategory) {
        this.id = id;
        this.member = member;
        this.foodCategory = foodCategory;
    }

    public static class MemberPreferBuilder {
        private Long id;
        private Member member;
        private FoodCategory foodCategory;

        MemberPreferBuilder() {
        }

        public MemberPreferBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public MemberPreferBuilder member(final Member member) {
            this.member = member;
            return this;
        }

        public MemberPreferBuilder foodCategory(final FoodCategory foodCategory) {
            this.foodCategory = foodCategory;
            return this;
        }

        public MemberPrefer build() {
            return new MemberPrefer(this.id, this.member, this.foodCategory);
        }

        public String toString() {
            Long var10000 = this.id;
            return "MemberPrefer.MemberPreferBuilder(id=" + var10000 + ", member=" + String.valueOf(this.member) + ", foodCategory=" + String.valueOf(this.foodCategory) + ")";
        }
    }
}
