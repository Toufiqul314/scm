package com.scm.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Contact {

    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    @Column(length = 500)
    private String description;
    private String picture;
    private boolean favorite= false;

    private String websiteLink;
    private String linkedInLink;

   // private List<SocialLink> socialLinks=new ArrayList<>();

   @ManyToOne
   private User user;

   @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
   private List<SocialLink> socialLinks = new ArrayList<>();
}
