package APITranspotadora.Transportadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import APITranspotadora.Transportadora.model.ProdutoRastreio;

@Repository
public interface ProdutoRastreioRepository extends JpaRepository<ProdutoRastreio, Long> {

	public ProdutoRastreio findByCodigoDeRastreio(String codigoDeRastreio);
	
}
