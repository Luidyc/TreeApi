package TreeApi.TreeApi.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="node")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

///* Utilizando do Lombok para gerar Getters, Setters e Construtores  */
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nodeTitle;
    @ManyToOne
    @JoinColumn(name="parent_id")
    @JsonBackReference
    private Node parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Node> children;

}
