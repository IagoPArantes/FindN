package com.find.dao;

import com.find.application.Cep;
import com.find.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CepDao {

    // CREATE
    public void criarCep(Cep cep) {
        String sql = "INSERT INTO cep (cep) VALUES (?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, cep.getCep());
            stm.executeUpdate();
            System.out.println("CEP cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar CEP: " + e.getMessage());
        }
    }

    // READ
    public List<Cep> listarCep() {
        List<Cep> lista = new ArrayList<>();
        String sql = "SELECT id_cep, cep FROM cep";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Cep cep = new Cep();
                cep.setIdCep(rs.getInt("id_cep"));
                cep.setCep(rs.getString("cep"));

                lista.add(cep);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar CEPs: " + e.getMessage());
        }

        return lista;
    }

    // UPDATE
    public void editarCep(Cep cep) {
        String sql = "UPDATE cep SET cep = ? WHERE id_cep = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, cep.getCep());
            stm.setInt(2, cep.getId_cep());
            stm.executeUpdate();
            System.out.println("CEP atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao editar CEP: " + e.getMessage());
        }
    }

    // DELETE
    public void deletarCep(int idCep) {
        String sql = "DELETE FROM cep WHERE id_cep = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, idCep);
            stm.executeUpdate();
            System.out.println("CEP deletado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao deletar CEP: " + e.getMessage());
        }
    }
}
