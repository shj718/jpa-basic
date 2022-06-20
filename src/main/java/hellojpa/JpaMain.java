package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 애플리케이션 로딩 시점에 딱 1개

        EntityManager em = emf.createEntityManager(); // 일련의 DB 작업을 할 때마다 생성 (Ex. 장바구니에 물건 추가)

        // 트랜잭션 필수
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // DB 작업 (데이터 저장 등)
        try {
            /* Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Locker locker = new Locker();
            locker.setName("locker1");
            em.persist(locker);

            Member member = new Member();
            member.setUsername("userA");
            // *** 연관관계의 주인에 값 설정
            member.changeTeam(team);
            member.setLocker(locker);
            em.persist(member);
            // *** 주인이 아닌쪽에도 값 설정
            // team.getMembers().add(member);

            Product product = new Product();
            product.setName("productA");
            em.persist(product);

            MemberProduct memberProduct = new MemberProduct();
            memberProduct.setMember(member);
            memberProduct.setProduct(product);
            memberProduct.setOrderAmount(3);
            memberProduct.setOrderDate(LocalDateTime.now());
            em.persist(memberProduct);

            em.flush(); // 영속성 컨텍스트를 DB에 동기화
            em.clear(); // 영속성 컨텍스트 초기화

            Member findMember = em.find(Member.class, member.getId());
            System.out.println("locker.name = " + findMember.getLocker().getName());

            Album album = new Album();
            album.setArtist("백예린");
            album.setName("백예린 앨범");
            album.setPrice(30000);
            em.persist(album);

            // @MappedSuperclass 테스트
            Team team = new Team();
            team.setName("teamA");
            team.setCreatedBy("hongik");
            team.setCreatedDateTime(LocalDateTime.now());
            em.persist(team);

            Member member = new Member();
            member.setUsername("shj");
            member.setCreatedBy("admin");
            member.setCreatedDateTime(LocalDateTime.now());
            member.changeTeam(team);
            em.persist(member);

            em.flush(); // 영속성 컨텍스트를 DB에 동기화
            em.clear(); // 영속성 컨텍스트 초기화

            // 지연 로딩 테스트
            Member findMember = em.find(Member.class, member.getId());
            System.out.println("member.username = " + findMember.getUsername());
            System.out.println("member.team.name = " + findMember.getTeam().getName()); // 실제 Team DB 조회 (프록시 객체 초기화) */

            // CASCADE 테스트
            Child child1 = new Child();
            child1.setName("어린이1");
            Child child2 = new Child();
            child2.setName("어린이2");

            Parent parent = new Parent();
            parent.setName("부모");
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            // 고아 객체 테스트
            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            em.remove(findParent);
            // findParent.getChildList().remove(0);

            // 임베디드 타입 테스트
            Member member = new Member();
            member.setUsername("shj");
            member.setHomeAddress(new Address("서울", "와우산로", "94"));
            member.setWorkPeriod(new Period(LocalDateTime.now(), LocalDateTime.now().plusYears(1L)));
            em.persist(member);

            transaction.commit(); // 커밋
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close(); // 항상 잘 닫아주기 (DB 커넥션을 물고 있음)
        }

        emf.close();
    }
}
