package edu.hm.microblogging.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "microblogs")
public class Microblog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", nullable = false)
  private String userId;

  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "created_at", nullable = false)
  @CreationTimestamp
  private Timestamp createdAt;

  public Microblog() {}

  public Microblog(String userId, String content) {
    this.userId = userId;
    this.content = content;
  }

  public Long getId() {
    return id;
  }

  public String getUserId() {
    return userId;
  }

  public String getContent() {
    return content;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }
}
