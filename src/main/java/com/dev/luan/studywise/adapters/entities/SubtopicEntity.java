package com.dev.luan.studywise.adapters.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "subtopics")
public class SubtopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subtopic_id", updatable = false)
    private UUID id;

    @Column(name = "subtopic_name", columnDefinition = "TEXT", nullable = false, updatable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectEntity subject;

    @OneToMany(mappedBy = "subtopic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RevisionUnitEntity> revisionUnits = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RevisionUnitEntity> getRevisionUnits() {
        return revisionUnits;
    }

    public void setRevisionUnits(List<RevisionUnitEntity> revisionUnits) {
        this.revisionUnits = revisionUnits;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }
}
