package com.mikalai.spring.domain;

import java.io.Serializable;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;



@Entity
@Table(name="contact")
@NamedQueries({
    @NamedQuery(
      name="Contact.findAllWithDetail",
      query="select distinct c from Contact c left join fetch c.contactTelDetails t left join fetch c.hobbies h"),
    
    @NamedQuery(
            name="Contact.findById",
            query="select distinct c from Contact c left join fetch c.contactTelDetails t left join fetch c.hobbies h where c.id=:id")
 })
public class Contact implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int version;

    private Set<ContactTelDetail> contactTelDetails = new HashSet<ContactTelDetail>();
    private Set<Hobby> hobbies = new HashSet<Hobby>();
    
    
    @ManyToMany(/*fetch=FetchType.EAGER*/)
    @JoinTable(name="contact_hobby_detail", joinColumns = @JoinColumn(name="CONTACT_ID"),
    inverseJoinColumns = @JoinColumn(name="HOBBY_ID"))
    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Contact [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", birthDate=" + birthDate
                + ", contactTelDetails=" + /*contactTelDetails +*/ "]";
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
    public void setBirthDate(Date date) {
        this.birthDate = date;
    }
    
    @OneToMany(mappedBy="contact", cascade=CascadeType.ALL, orphanRemoval=true/*, fetch=FetchType.EAGER*/)
    public Set<ContactTelDetail> getContactTelDetails() {
        return contactTelDetails;
    }
    public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }
    
    @Version
    @Column(name="VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    public void addContactTelDetails(ContactTelDetail contactTelDetail){
        
        contactTelDetail.setContact(this);
        getContactTelDetails().add(contactTelDetail);
    }
    
    public void removeContactTelDetails(ContactTelDetail contactTelDetail){
        
        
        getContactTelDetails().remove(contactTelDetail);
    }


}
