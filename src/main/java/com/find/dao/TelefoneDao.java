package com.find.dao;

import com.find.application.Telefone;
import com.find.config.DatabaseConfig;

import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TelefoneDao {

    //CREATE
    public void criarTelefone(Telefone telefone) {
        String sql = "INSERT INTO Telefone (telefone) VALUES (?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, telefone.getTelefone());
            stm.executeUpdate();
            System.out.println("Telefone criado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar Telefone! " + e.getMessage());
        }
    }

    //READ
    public List<Telefone> listarTelefone() {
        List<Telefone> listarTelefone = new ArrayList<>();
        String sql = "SELECT * FROM Telefone";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {

            while (rs.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(rs.getInt("id_telefone"));
                telefone.setTelefone(rs.getString("telefone"));
                listarTelefone.add(telefone);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar Telefones: " + e.getMessage());
        }

        return listarTelefone;
    }

    //UPDATE
    public void editarTelefone(Telefone telefone) {
        String sql = "UPDATE Telefone SET telefone = ? WHERE id_telefone = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, telefone.getTelefone());
            stm.setInt(2, telefone.getId_telefone());
            stm.executeUpdate();
            System.out.println("Telefone atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    //DELETE
    public void deletarTelefone(int id_telefone) {
        String sql = "DELETE FROM Telefone WHERE id_telefone = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, id_telefone);
            stm.executeUpdate();
            System.out.println("Telefone deletado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao deletar telefone! " + e.getMessage());
        }
    }

    // Adicione este método no TelefoneDao
    public Telefone buscarPorId(int id) {
        String sql = "SELECT * FROM Telefone WHERE id_telefone = ?";
        Telefone telefone = null;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                telefone = new Telefone();
                telefone.setId(rs.getInt("id_telefone"));
                telefone.setTelefone(rs.getString("telefone"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar telefone: " + e.getMessage());
        }

        return telefone;
    }
}