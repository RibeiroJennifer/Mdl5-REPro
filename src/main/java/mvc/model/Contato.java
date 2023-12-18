package mvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contato")

public class Contato {
	
	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_contato;
	private String nome;
	private String email;
	private String mensagem;
	public Long getId_contato() {
		return id_contato;
	}
	public void setId_contato(Long id_contato) {
		this.id_contato = id_contato;
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
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Override
	public String toString() {
		return "Contato [id_contato=" + id_contato + ", nome=" + nome + ", email=" + email + ", mensagem=" + mensagem
				+ "]";
	}
	
}
	