package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */

@Entity
@Table(name = "usuarios")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "nome", nullable = false, unique = false)
	private String nome;
	
	@Column(name = "email", nullable = false, unique = true)
    private String email;
	
	@Column(name = "telefone", nullable = false, unique = true)
    private String telefone;
	
	@Column(name = "dataNascimento", nullable = false, unique = false)
    private String dataNascimento;
	
	@Column(name = "sexo", nullable = false, unique = false)
    private String sexo;
	
	@Column(name = "cidade", nullable = false, unique = false)
    private String cidade;
	
	@Column(name = "estado", nullable = false, unique = false)
    private String estado;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	 

	public User() {
		super();
	}

	public User(String nome,String telefone,String sexo,String cidade,
			String estado,String email, String username, String password) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.sexo = sexo;
		this.cidade = cidade;
		this.estado = estado;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
