package mvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compras")

public class Compras {
	
	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_compra;
	private String data_compra;
	private Double total_compra;
	
	
	@ManyToOne
	@JoinColumn(name = "usuario_id_usuario")
	private Usuarios usuario;
	
	@ManyToOne
	@JoinColumn(name = "destino_id_destino")
	private Destinos destino;
	
	
	
	
	public Long getId_compra() {
		return id_compra;
	}



	public void setId_compra(Long id_compra) {
		this.id_compra = id_compra;
	}



	public String getData_compra() {
		return data_compra;
	}



	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}



	public Double getTotal_compra() {
		return total_compra;
	}



	public void setTotal_compra(Double total_compra) {
		this.total_compra = total_compra;
	}



	public Usuarios getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}



	public Destinos getDestino() {
		return destino;
	}



	public void setDestino(Destinos destino) {
		this.destino = destino;
	}


	//ToString

	@Override
	public String toString() {
		return "Compras [id_compra=" + id_compra + ", data_compra=" + data_compra + ", total_compra=" + total_compra
				+ ", usuario=" + usuario + ", destino=" + destino + "]";
	}
	
}