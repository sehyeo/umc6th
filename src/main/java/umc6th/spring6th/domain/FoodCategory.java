package umc6th.spring6th.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import umc6th.spring6th.domain.common.BaseEntity;

@Entity
public class FoodCategory extends BaseEntity {
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

    public static FoodCategoryBuilder builder() {
        return new FoodCategoryBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    protected FoodCategory() {
    }

    public FoodCategory(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static class FoodCategoryBuilder {
        private Long id;
        private String name;

        FoodCategoryBuilder() {
        }

        public FoodCategoryBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public FoodCategoryBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public FoodCategory build() {
            return new FoodCategory(this.id, this.name);
        }

        public String toString() {
            return "FoodCategory.FoodCategoryBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }
}
