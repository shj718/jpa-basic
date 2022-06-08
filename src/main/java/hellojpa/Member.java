package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 최근에는 사용하지 않음. LocalDate, LocalDateTime 으로 대체 가능
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    // 대체
    private LocalDate localDateTest;
    private LocalDateTime localDateTimeTest;

    @Lob
    private String description;

    // JPA 는 기본 생성자가 필수.
    public Member() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public LocalDate getLocalDateTest() {
        return localDateTest;
    }

    public void setLocalDateTest(LocalDate localDateTest) {
        this.localDateTest = localDateTest;
    }

    public LocalDateTime getLocalDateTimeTest() {
        return localDateTimeTest;
    }

    public void setLocalDateTimeTest(LocalDateTime localDateTimeTest) {
        this.localDateTimeTest = localDateTimeTest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}