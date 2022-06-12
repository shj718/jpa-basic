package hellojpa;

import javax.persistence.*;

@Entity
public class Locker {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCKER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;

    public Locker() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
