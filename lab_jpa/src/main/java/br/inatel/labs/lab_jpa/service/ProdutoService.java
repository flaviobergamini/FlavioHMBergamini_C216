package br.inatel.labs.lab_jpa.service;

import br.inatel.labs.lab_jpa.entity.Produto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Service
@Transactional
public class ProdutoService {

    @PersistenceContext
    private EntityManager em;

    public Produto salvar(Produto produto){
        return em.merge(produto);
    }

    public Produto buscarProdutoPeloId(Long id){
        return em.find(Produto.class,id);
    }

    public List<Produto> listar(){
        return em.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    public void remover(Produto produto){
        produto = em.merge(produto);
        em.remove(produto);
    }
}
