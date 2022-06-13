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
            System.out.println("locker.name = " + findMember.getLocker().getName()); */

            Album album = new Album();
            album.setArtist("백예린");
            album.setName("백예린 앨범");
            album.setPrice(30000);
            em.persist(album);

            transaction.commit(); // 커밋
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close(); // 항상 잘 닫아주기 (DB 커넥션을 물고 있음)
        }

        emf.close();
    }
}
