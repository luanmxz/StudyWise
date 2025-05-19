package com.dev.luan.studywise.adapters.entities;

import java.time.OffsetDateTime;
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
@Table(name = "revision_units")
public class RevisionUnitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "revision_unit_id", updatable = false)
    private UUID id;

    @Column(name = "affirmation", columnDefinition = "TEXT", nullable = false)
    private String affirmation;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime updatedAt;

    @Column(name = "displayed_times", updatable = true)
    private Long displayedTimes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectEntity subject;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subtopic_id", nullable = false)
    private SubtopicEntity subtopic;

    @OneToMany(mappedBy = "revisionUnit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionEntity> questions = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "generated_by_user_id", nullable = false)
    private UserEntity generatedBy;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAffirmation() {
        return affirmation;
    }

    public void setAffirmation(String affirmation) {
        this.affirmation = affirmation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getDisplayedTimes() {
        return displayedTimes;
    }

    public void setDisplayedTimes(Long displayedTimes) {
        this.displayedTimes = displayedTimes;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public SubtopicEntity getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(SubtopicEntity subtopic) {
        this.subtopic = subtopic;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    public UserEntity getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(UserEntity generatedBy) {
        this.generatedBy = generatedBy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((affirmation == null) ? 0 : affirmation.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
        result = prime * result + ((displayedTimes == null) ? 0 : displayedTimes.hashCode());
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
        result = prime * result + ((subtopic == null) ? 0 : subtopic.hashCode());
        result = prime * result + ((questions == null) ? 0 : questions.hashCode());
        result = prime * result + ((generatedBy == null) ? 0 : generatedBy.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RevisionUnitEntity other = (RevisionUnitEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (affirmation == null) {
            if (other.affirmation != null)
                return false;
        } else if (!affirmation.equals(other.affirmation))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
        if (updatedAt == null) {
            if (other.updatedAt != null)
                return false;
        } else if (!updatedAt.equals(other.updatedAt))
            return false;
        if (displayedTimes == null) {
            if (other.displayedTimes != null)
                return false;
        } else if (!displayedTimes.equals(other.displayedTimes))
            return false;
        if (subject == null) {
            if (other.subject != null)
                return false;
        } else if (!subject.equals(other.subject))
            return false;
        if (subtopic == null) {
            if (other.subtopic != null)
                return false;
        } else if (!subtopic.equals(other.subtopic))
            return false;
        if (questions == null) {
            if (other.questions != null)
                return false;
        } else if (!questions.equals(other.questions))
            return false;
        if (generatedBy == null) {
            if (other.generatedBy != null)
                return false;
        } else if (!generatedBy.equals(other.generatedBy))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RevisionUnitEntity [id=" + id + ", affirmation=" + affirmation + ", description=" + description
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", displayedTimes=" + displayedTimes
                + ", subject=" + subject + ", subtopic=" + subtopic + ", questions=" + questions
                + ", generatedBy=" + generatedBy + "]";
    }
}
