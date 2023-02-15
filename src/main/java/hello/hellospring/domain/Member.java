package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //jpa가 관리하는 엔티티가 된다
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db에 값을 넣으면 db가 id를 자동으로 생성해 주는 것을 identity라고 한다.
    private Long id;
    private String name;

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
