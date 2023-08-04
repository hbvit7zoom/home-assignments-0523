package ru.sberbank.jd.module13auth.user.model;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.ToString;
import org.hibernate.annotations.Type;
import ru.sberbank.jd.module13auth.security.model.Privilege;

import java.util.List;

@Entity
@ToString
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private String roleName;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private List<Privilege> privileges;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
