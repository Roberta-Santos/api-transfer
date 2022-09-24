package br.com.itau.apitransfer.entity;

import br.com.itau.apitransfer.formatters.OffsetDateTimeDeserializer;
import br.com.itau.apitransfer.formatters.OffsetDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "transfer")
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Id", example = "1234")
    @Getter
    private Long id;

    @Column(name = "originAccount", unique = true, nullable = false)
    @ApiModelProperty(notes = "Número da conta de origem", example = "95702")
    @Getter
    private Long originAccount;

    @Column(name = "destinationAccount", unique = true, nullable = false)
    @ApiModelProperty(notes = "Número da conta de destino", example = "95702")
    @Getter
    private Long destinationAccount;

    @Column(name = "balance", nullable = false)
    @ApiModelProperty(notes = "Saldo da conta", example = "100.00")
    @Getter
    @Setter
    private float balance;

    @Column(name = "transferDate", nullable = false)
    @ApiModelProperty(notes = "Data da transferência", example = "2018-11-13T22:08:20.257Z")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @Getter
    private OffsetDateTime transferDate;
}
