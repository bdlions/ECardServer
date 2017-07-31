package org.bdlions.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 *
 * @author nazmul hasan
 */
@Entity
@Table(
        name = "profile",
        indexes = {
            @Index(name = "idx_name", columnList = "user_id, company_id", unique = true)
        }
)
public class Profile {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    
    private int id;

    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "company_id")
    private int companyId;
    
    @Column(name = "department")
    private String department;
    
    @Column(name = "designation")
    private String designation;

    public Profile() 
    {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
}
