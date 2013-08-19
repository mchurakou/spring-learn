package com.mikalai.finals.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;








@Entity
@Table(name="CONTACT")


@NamedQueries({
    @NamedQuery(
      name="Contact.getContactsWithDetail",
      query="select distinct c from Contact c left join fetch c.telephons t left join fetch c.hobbies h"),
    
    @NamedQuery(
            name="Contact.getContactById",
            query="select distinct c from Contact c left join fetch c.telephons t left join fetch c.hobbies h where c.id=:id")
 })
public class Contact implements Serializable, Auditable<String, Long>{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int version;
    
 // Audit fields
    private String createdBy;
    private DateTime createdDate;   
    private String lastModifiedBy;
    private DateTime lastModifiedDate;
    
    
    private List<Telephon> telephons = new ArrayList<Telephon>();
    
    private Set<Hobby> hobbies = new HashSet<Hobby>();

    @ManyToMany
    @JoinTable(name="CONTACT_HOBBY", joinColumns = @JoinColumn(name="CONTACT_ID"), inverseJoinColumns = @JoinColumn(name="HOBBY_ID"))
    public Set<Hobby> getHobbies() {
        return hobbies;
    }
    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
    
    @OneToMany(mappedBy="contact", cascade=CascadeType.ALL, orphanRemoval=true/*, fetch=FetchType.EAGER*/)
    public List<Telephon> getTelephons() {
        return telephons;
    }
    public void setTelephons(List<Telephon> telephons) {
        this.telephons = telephons;
    }
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name="BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    
    @Version
    @Column(name="VERSION")
    public int getVersion() {
        return version;
    }
  

    @Column(name="CREATED_BY")
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    @Column(name="CREATED_DATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }
    
    @Column(name="LAST_MODIFIED_BY")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    
    
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    
    @Column(name="LAST_MODIFIED_DATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
   

    @Transient
    public boolean isNew() {
        if (id == null){
            return true;
        } else{
            return false;
        }
            
    }

    @Override
    public String toString() {
        return "Contact [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", birthDate=" + birthDate + ", version="
                + version + ", createdBy=" + createdBy + ", createdDate="
                + createdDate + ", lastModifiedBy=" + lastModifiedBy
                + ", lastModifiedDate=" + lastModifiedDate + ", telephons="
                + telephons + ", hobbies=" + hobbies + "]";
    }
    public void setVersion(int version) {
        this.version = version;
    }
    
    public void addTelephon(Telephon telephon){
        
        telephon.setContact(this);
        getTelephons().add(telephon);
    }


}
