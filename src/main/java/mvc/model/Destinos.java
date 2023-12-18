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
@Table(name = "destino")

public class Destinos {
	
	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_destino;
	private String nome_destino;
	private String pais;
	private String estado;
	private String cidade;
	private String data_ida;
	private String data_volta;
	private Double preco;
	
	
	//GettersAndSetters
	
	public Long getId_destino() {
		return id_destino;
	}

	public void setId_destino(Long id_destino) {
		this.id_destino = id_destino;
	}

	public String getNome_destino() {
		return nome_destino;
	}

	public void setNome_destino(String nome_destino) {
		this.nome_destino = nome_destino;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getData_ida() {
		return data_ida;
	}

	public void setData_ida(String data_ida) {
		this.data_ida = data_ida;
	}

	public String getData_volta() {
		return data_volta;
	}

	public void setData_volta(String data_volta) {
		this.data_volta = data_volta;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	//ToString
	
	@Override
	public String toString() {
		return "Destinos [id_destino=" + id_destino + ", nome_destino=" + nome_destino + ", pais=" + pais + ", estado="
				+ estado + ", cidade=" + cidade + ", data_ida=" + data_ida + ", data_volta=" + data_volta + ", preco="
				+ preco + "]";
	}

	
	
}