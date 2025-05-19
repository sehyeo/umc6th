package umc6th.spring6th.domain.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import umc6th.spring6th.domain.Member;
import umc6th.spring6th.domain.Terms;
import umc6th.spring6th.domain.common.BaseEntity;

@Entity
public class MemberAgree extends BaseEntity {
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
            name = "terms_id"
    )
    private Terms terms;

    public static MemberAgreeBuilder builder() {
        return new MemberAgreeBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Member getMember() {
        return this.member;
    }

    public Terms getTerms() {
        return this.terms;
    }

    protected MemberAgree() {
    }

    public MemberAgree(final Long id, final Member member, final Terms terms) {
        this.id = id;
        this.member = member;
        this.terms = terms;
    }

    public static class MemberAgreeBuilder {
        private Long id;
        private Member member;
        private Terms terms;

        MemberAgreeBuilder() {
        }

        public MemberAgreeBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public MemberAgreeBuilder member(final Member member) {
            this.member = member;
            return this;
        }

        public MemberAgreeBuilder terms(final Terms terms) {
            this.terms = terms;
            return this;
        }

        public MemberAgree build() {
            return new MemberAgree(this.id, this.member, this.terms);
        }

        public String toString() {
            Long var10000 = this.id;
            return "MemberAgree.MemberAgreeBuilder(id=" + var10000 + ", member=" + String.valueOf(this.member) + ", terms=" + String.valueOf(this.terms) + ")";
        }
    }
}
