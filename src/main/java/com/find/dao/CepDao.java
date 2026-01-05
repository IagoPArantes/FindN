package com.find.dao;

import com.find.application.Cep;
import com.find.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class cepDao {

    //Create
    public void criarCep(Cep cep) {
        String sql = "INSERT INTO Cep (cep) VALUES (?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, cep.getCep());
            stm.executeUpdate();
            System.out.println("Cep cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar Cep!" + e.getMessage());
        }
    }

    //Read
    List<Cep> listarCep() {
        List<Cep> lista = new ArrayList<>();
        String sql = "SELECT id_cep, cep FROM Cep";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

                while (rs.next()) {
                    Cep cep = new Cep();
                    cep.setId(rs.getInt("id_cep"));
                    cep.setCep(rs.getString("cep"));

                    lista.add(cep);
                }

            } catch (Exception e) {
                System.out.println("Erro ao listar CEPs: " + e.getMessage());
            }

            return lista;
        }
    }
    
    //Update
    public void editarCep(Cep cep) {
        String sql = "UPDATE Cep SET cep = ? WHERE id_cep = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, cep.getCep());
            stm.setInt(1, cep.getIdCep());
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao editar Cep!" + e.getMessage());
        }
    }

    //Delete
    public void deletarCep(int id_cep) {
        String sql = "DELETE FROM Cep WHERE id_cep = ?";

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql)){

            stm.setInt(1, id_cep);
            stm.executeUpdate();
            System.out.println("Cep deletado com sucesso!");

        }catch (Exception e) {
            System.out.println("Erro ao deletar Cep!" + e.getMessage());
        }
    }
}
