package com.example.User;


import java.util.Objects;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity



public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private	Long id;
	
	@Column(name="nome")
	public String nome;
	@Column(name="email")
	private String email;
	@Column(name="telefone")
	private String telefone;
	@Column(name="password")
	private String password;
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, email, password, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(nome, other.nome)
				&& Objects.equals(password, other.password) && Objects.equals(telefone, other.telefone);
	}

	
	
	public Usuario(Long Id, String Nome, String Email, String Telefone, String Password) {
		 id=Id;
		 nome=Nome;
		 email=Email;
		 telefone=Telefone;
		 password=Password;
		 
	}
	
public Usuario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
