package com.luan.vendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.luan.vendas.model.ProdutoVenda;

public class ProdutoVendaDao {

    public boolean salvar(ProdutoVenda produtoVenda) {
        String sql = "INSERT INTO tproduto_venda (id_venda, id_produto, qtde_produto) VALUES (?, ?, ?)";

        try (Connection conn = Postgres.conectar();
             PreparedStatement ps = conn != null
                     ? conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
                     : null) {

            if (ps == null) {
                return false;
            }

            ps.setInt(1, produtoVenda.getIdVenda());
            ps.setInt(2, produtoVenda.getIdProduto());
            ps.setInt(3, produtoVenda.getQtdeProduto());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    produtoVenda.setId(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar relação produto-venda: " + e.getMessage());
        }
        return false;
    }

    public List<ProdutoVenda> listarTodos() {
        List<ProdutoVenda> relacionamentos = new ArrayList<>();
        String sql = "SELECT id_produto_venda, id_venda, id_produto, qtde_produto FROM tproduto_venda ORDER BY id_venda, id_produto";

        try (Connection conn = Postgres.conectar();
             PreparedStatement ps = conn != null ? conn.prepareStatement(sql) : null) {

            if (ps == null) {
                return relacionamentos;
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProdutoVenda produtoVenda = new ProdutoVenda(
                        rs.getInt("id_produto_venda"),
                        rs.getInt("id_venda"),
                    rs.getInt("id_produto"),
                    rs.getInt("qtde_produto")
                );
                relacionamentos.add(produtoVenda);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar relações produto-venda: " + e.getMessage());
        }
        return relacionamentos;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM tproduto_venda WHERE id_produto_venda = ?";

        try (Connection conn = Postgres.conectar();
             PreparedStatement ps = conn != null ? conn.prepareStatement(sql) : null) {

            if (ps == null) {
                return false;
            }

            ps.setInt(1, id);

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir relação produto-venda: " + e.getMessage());
        }
        return false;
    }
}