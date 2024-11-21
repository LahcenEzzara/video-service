package ma.xproce.inventoryservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Builder
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePublication;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Creator creator;

    // Default constructor
    public Video() {
    }

    // All-args constructor
    public Video(Long id, String name, String url, String description, Date datePublication, Creator creator) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.datePublication = datePublication;
        this.creator = creator;
    }

    // Getters and Setters
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }
}
