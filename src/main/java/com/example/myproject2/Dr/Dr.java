package com.example.myproject2.Dr;

import javax.persistence.*;

@Entity
@Table(name = "dr")
public class Dr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = false, length = 60)
    private String DrName;
    @Column(nullable = false)
    private Integer DrAge;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(length = 15, nullable = false, unique = false)
    private String DrPhone;

    private boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrName() {
        return DrName;
    }

    public void setDrName(String drName) {
        DrName = drName;
    }

    public Integer getDrAge() {
        return DrAge;
    }

    public void setDrAge(Integer drAge) {
        DrAge = drAge;
    }

    public String getDrPhone() {
        return DrPhone;
    }

    public void setDrPhone(String drPhone) {
        DrPhone = drPhone;
    }

    @Override
    public String toString() {
        return "Dr{" +
                "DrID=" + id +
                ", DrName='" + DrName + '\'' +
                ", DrAge=" + DrAge +
                ", DrPhone='" + DrPhone + '\'' +
                '}';
    }
}
