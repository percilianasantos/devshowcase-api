package com.devshowcase.api.entity;
import jakarta.persistence.*;
import java.util.*;
@Entity @Table(name="projects")
public class Project {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String title;
 @Column(nullable=false,length=2000) private String description;
 @Column(nullable=false) private String url;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="profile_id",nullable=false) private Profile profile;
 @ManyToMany @JoinTable(name="project_technology",joinColumns=@JoinColumn(name="project_id"),inverseJoinColumns=@JoinColumn(name="technology_id")) private List<Technology> technologies=new ArrayList<>();
 @OneToMany(mappedBy="project",cascade=CascadeType.ALL,orphanRemoval=true) private List<Feedback> feedbacks=new ArrayList<>();
 public Project(){}
 public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;} public String getUrl(){return url;} public void setUrl(String v){url=v;}
 public Profile getProfile(){return profile;} public void setProfile(Profile v){profile=v;} public List<Technology> getTechnologies(){return technologies;} public void setTechnologies(List<Technology> v){technologies=v;}
 public List<Feedback> getFeedbacks(){return feedbacks;} public void setFeedbacks(List<Feedback> v){feedbacks=v;}
}
