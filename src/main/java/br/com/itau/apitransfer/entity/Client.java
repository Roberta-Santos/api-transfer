package br.com.itau.apitransfer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Id", example = "1234")
    @Getter
    private Long id;

    @Column(name = "name", nullable = false)
    @ApiModelProperty(notes = "Nome", example = "Roberta Fonseca Santos de Paula")
    @Getter
    @Setter
    private String name;

    @Column(name = "accountNumber", unique = true, nullable = false)
    @ApiModelProperty(notes = "Número da conta", example = "95702")
    @Getter
    private Long accountNumber;

    @Column(name = "accountBalance", nullable = false)
    @ApiModelProperty(notes = "Saldo da conta", example = "100.00")
    @Getter
    @Setter
    private float accountBalance;
}
