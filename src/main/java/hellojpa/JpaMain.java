package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
            Member member = new Member();
            member.setUsername("B");
            em.persist(member);

            // 커밋
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close(); // 항상 잘 닫아주기 (DB 커넥션을 물고 있음)
        }

        emf.close();
    }
}
