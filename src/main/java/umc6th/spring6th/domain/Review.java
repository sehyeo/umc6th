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
import java.util.List;
import umc6th.spring6th.domain.common.BaseEntity;

@Entity
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            length = 40
    )
    private String title;
    private Float score;
    private String body;
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
            name = "store_id"
    )
    private Store store;
    @OneToMany(
            mappedBy = "review",
            cascade = {CascadeType.ALL}
    )
    private List<ReviewImage> reviewImageList;

    public void setMember(Member member) {
        if (this.member != null) {
            member.getReviewList().remove(this);
        }

        this.member = member;
        member.getReviewList().add(this);
    }

    public void setStore(Store store) {
        if (this.score != null) {
            store.getReviewList().remove(this);
        }

        this.store = store;
        store.getReviewList().add(this);
    }

    public static ReviewBuilder builder() {
        return new ReviewBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Float getScore() {
        return this.score;
    }

    public String getBody() {
        return this.body;
    }

    public Member getMember() {
        return this.member;
    }

    public Store getStore() {
        return this.store;
    }

    public List<ReviewImage> getReviewImageList() {
        return this.reviewImageList;
    }

    protected Review() {
    }

    public Review(final Long id, final String title, final Float score, final String body, final Member member, final Store store, final List<ReviewImage> reviewImageList) {
        this.id = id;
        this.title = title;
        this.score = score;
        this.body = body;
        this.member = member;
        this.store = store;
        this.reviewImageList = reviewImageList;
    }

    public static class ReviewBuilder {
        private Long id;
        private String title;
        private Float score;
        private String body;
        private Member member;
        private Store store;
        private List<ReviewImage> reviewImageList;

        ReviewBuilder() {
        }

        public ReviewBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ReviewBuilder title(final String title) {
            this.title = title;
            return this;
        }

        public ReviewBuilder score(final Float score) {
            this.score = score;
            return this;
        }

        public ReviewBuilder body(final String body) {
            this.body = body;
            return this;
        }

        public ReviewBuilder member(final Member member) {
            this.member = member;
            return this;
        }

        public ReviewBuilder store(final Store store) {
            this.store = store;
            return this;
        }

        public ReviewBuilder reviewImageList(final List<ReviewImage> reviewImageList) {
            this.reviewImageList = reviewImageList;
            return this;
        }

        public Review build() {
            return new Review(this.id, this.title, this.score, this.body, this.member, this.store, this.reviewImageList);
        }

        public String toString() {
            Long var10000 = this.id;
            return "Review.ReviewBuilder(id=" + var10000 + ", title=" + this.title + ", score=" + this.score + ", body=" + this.body + ", member=" + String.valueOf(this.member) + ", store=" + String.valueOf(this.store) + ", reviewImageList=" + String.valueOf(this.reviewImageList) + ")";
        }
    }
}
