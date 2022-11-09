package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CriarTarefa
 *
 */
@Entity
@Table(name = "criarTarefa")

public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "nome", nullable = false, unique = false)
	private String nome;

	@Column(name = "status", nullable = false, unique = true)
	private String status;

	@Column(name = "categoria", nullable = false)
	private String categoria;

	@Column(name = "tag", nullable = false, unique = true)
    private String tag;

	@Column(name = "dataConclusao", nullable = false, unique = true)
    private String dataConclusao;
	
	public Tarefa() {
		super();
	}
	
	public Tarefa(String status, String categoria, String tag, String dataConclusao) {
		super();
		this.status = status;
		this.categoria = categoria;
		this.tag = tag;
		this.dataConclusao = dataConclusao;
		
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public String getDataConclusao() {
		return dataConclusao;
	}
	

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getStatus() {
		return status;
	}

	public String getTag() {
		return tag;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	
	
}