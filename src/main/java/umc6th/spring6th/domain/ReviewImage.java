package umc6th.spring6th.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import umc6th.spring6th.domain.common.BaseEntity;

@Entity
public class ReviewImage extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "review_id"
    )
    private Review review;

    public static ReviewImageBuilder builder() {
        return new ReviewImageBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Review getReview() {
        return this.review;
    }

    protected ReviewImage() {
    }

    public ReviewImage(final Long id, final Review review) {
        this.id = id;
        this.review = review;
    }

    public static class ReviewImageBuilder {
        private Long id;
        private Review review;

        ReviewImageBuilder() {
        }

        public ReviewImageBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ReviewImageBuilder review(final Review review) {
            this.review = review;
            return this;
        }

        public ReviewImage build() {
            return new ReviewImage(this.id, this.review);
        }

        public String toString() {
            Long var10000 = this.id;
            return "ReviewImage.ReviewImageBuilder(id=" + var10000 + ", review=" + String.valueOf(this.review) + ")";
        }
    }
}
