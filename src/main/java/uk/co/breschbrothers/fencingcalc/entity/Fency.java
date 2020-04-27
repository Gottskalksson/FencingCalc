package uk.co.breschbrothers.fencingcalc.entity;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "fencies")
public class Fency extends EntityBase {

    @ManyToOne
    @NotNull
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
