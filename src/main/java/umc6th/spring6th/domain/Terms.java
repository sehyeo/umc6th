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
import umc6th.spring6th.domain.mapping.MemberAgree;

@Entity
public class Terms extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            length = 20
    )
    private String title;
    @Column(
            nullable = false,
            length = 50
    )
    private String body;
    private Boolean optional;
    @OneToMany(
            mappedBy = "terms",
            cascade = {CascadeType.ALL}
    )
    private List<MemberAgree> memberAgreeList = new ArrayList();

    public static TermsBuilder builder() {
        return new TermsBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public Boolean getOptional() {
        return this.optional;
    }

    public List<MemberAgree> getMemberAgreeList() {
        return this.memberAgreeList;
    }

    protected Terms() {
    }

    public Terms(final Long id, final String title, final String body, final Boolean optional, final List<MemberAgree> memberAgreeList) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.optional = optional;
        this.memberAgreeList = memberAgreeList;
    }

    public static class TermsBuilder {
        private Long id;
        private String title;
        private String body;
        private Boolean optional;
        private List<MemberAgree> memberAgreeList;

        TermsBuilder() {
        }

        public TermsBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public TermsBuilder title(final String title) {
            this.title = title;
            return this;
        }

        public TermsBuilder body(final String body) {
            this.body = body;
            return this;
        }

        public TermsBuilder optional(final Boolean optional) {
            this.optional = optional;
            return this;
        }

        public TermsBuilder memberAgreeList(final List<MemberAgree> memberAgreeList) {
            this.memberAgreeList = memberAgreeList;
            return this;
        }

        public Terms build() {
            return new Terms(this.id, this.title, this.body, this.optional, this.memberAgreeList);
        }

        public String toString() {
            Long var10000 = this.id;
            return "Terms.TermsBuilder(id=" + var10000 + ", title=" + this.title + ", body=" + this.body + ", optional=" + this.optional + ", memberAgreeList=" + String.valueOf(this.memberAgreeList) + ")";
        }
    }
}
