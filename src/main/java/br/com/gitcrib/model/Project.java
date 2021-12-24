package br.com.gitcrib.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.gitcrib.enums.StatusProjectEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PROJECT_STATUS")
    @Enumerated(EnumType.STRING)
    private StatusProjectEnum projectStatus;
    
    @ManyToOne
    @JoinColumn(name = "FOUNDER", referencedColumnName = "ID")
    private Founder founder;

    @OneToMany
    @JoinColumn(name = "TASK", referencedColumnName = "ID")
    private List<Task> tasks;
}
