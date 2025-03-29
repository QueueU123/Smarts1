package entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")  // primary key
    private int projectId;

    @Column(name = "project_name", length = 50)
    private String projectname;

    @Column(name = "project_status", length = 50)
    private String projectstatus;

    @Column(name = "project_start")
    private Date projectstart;

    @Column(name = "project_end")
    private Date projectend;

    @Column(name = "client_name", length = 50)
    private String clientname;

    @Column(name = "contract_amount")
    private double contractamount;

    @Column(name = "downpayment")
    private double downpayment;
}
