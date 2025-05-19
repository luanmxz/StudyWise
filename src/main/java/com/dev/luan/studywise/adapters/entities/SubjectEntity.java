package com.dev.luan.studywise.adapters.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subject_id")
    private UUID id;

    @Column(name = "subject_name")
    private String name;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubtopicEntity> subtopics = new ArrayList<>();

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public List<SubtopicEntity> getSubtopics() {
        return subtopics;
    }

    public void setSubtopics(List<SubtopicEntity> subtopics) {
        this.subtopics = subtopics;
    }
}
