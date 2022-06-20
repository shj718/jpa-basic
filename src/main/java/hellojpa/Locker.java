package hellojpa;

import javax.persistence.*;

@Entity
public class Locker {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCKER_ID")
    private Long lockerPK;

    @Column(name = "NAME")
    private String name;

    @OneToOne(mappedBy = "locker", fetch = FetchType.LAZY)
    private Member member;

    public Locker() {

    }

    public Long getId() {
        return lockerPK;
    }

    public void setId(Long id) {
        this.lockerPK = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
