package com.silvaHiago.minhasFinancas.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.silvaHiago.minhasFinancas.model.enums.StatusLancamentos;
import com.silvaHiago.minhasFinancas.model.enums.TipoLancamento;

import lombok.Data;

@Entity
@Table(name = "lancamentos", schema = "financas")
@Data
public class Lancamentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer mes;
	private Integer ano;
	private BigDecimal valor;
	private String descricao;
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Enumerated(value = EnumType.STRING)
	private TipoLancamento tipo;
	
	@Enumerated(value = EnumType.STRING)
	private StatusLancamentos status;

	
}
