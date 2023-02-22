package com.devolpay.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Component
@Scope("prototype")
@Log4j2
@EqualsAndHashCode(callSuper=false)
@Data
@Document
public class Cliente  implements Serializable {

    @Id
    private String id;
    @NotEmpty
    private String nombres;
    @NotEmpty
    private String apellidos;
    @NotEmpty
    private String dni;
    private String telefono;
    private String direccion;


}
