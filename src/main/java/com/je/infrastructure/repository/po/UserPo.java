package com.je.infrastructure.repository.po;

import com.je.domain.User;
import com.je.domain.valueobject.Password;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

/**
 * indexes = @Index(name = "idx_name", unique = true, columnList = "name")
 * not work！
 */
@Getter
@Table(name = "user")
@Entity
public class UserPo {

    @Id
    private Long id;

    private String name;

    private String password;

    private Instant registeredTime;

    public static UserPo fromDo(User user) {
        UserPo po = new UserPo();
        po.id = user.getId();
        po.name = user.getName();
        po.password = user.getPassword().getValue();
        po.registeredTime = user.getRegisteredTime();
        return po;
    }

    public User toDo() {
        return new User(id, name, new Password(password, false), registeredTime);
    }

}
