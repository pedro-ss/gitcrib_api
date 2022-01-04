package br.com.gitcrib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.gitcrib.enums.StatusTasksEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "TITLE")
    private String title;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusTasksEnum status;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "PROJECT", referencedColumnName = "ID")
    private Project project;
}
