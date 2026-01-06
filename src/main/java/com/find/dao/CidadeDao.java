package com.find.dao;

import com.find.application.Cidade;
import com.find.config.DatabaseConfig;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CidadeDao {

    //Create
    private void String(Cidade cidade) {
        String sql = "INSERT INTO cidade(nome, id_cidade) VALUES (?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, cidade.getCidade());
            stm.setInt(1, cidade.getId_cidade());
            stm.executeUpdate();
            System.out.println("Cidade cadastrada com sucesso!");

        } catch (Exception e) {
            System.out.println("Errro ao cadastrar cidade!" + e.getMessage());
        }
    }

    //Read
    public List<Cidade> listarCidade() {  // ✅ Mudei para public
        List<Cidade> cidades = new ArrayList<>();
        String sql = "SELECT * FROM Cidade";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {  // ✅ ResultSet

            while (rs.next()) {  // ✅ Com parênteses
                Cidade cidade = new Cidade();
                cidade.setCidade(rs.getString("cidade"));           // ✅ getString
                cidade.setId_cidade(rs.getInt("idCidade"));        // ✅ Verifique o nome correto
                cidades.add(cidade);  // ✅ Adiciona na lista LOCAL (não recursivo!)
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar cidade: " + e.getMessage());
        }

        return cidades;  // ✅ RETORNA a lista!
    }

    //Update
    public void atualizarCidade(Cidade cidade) {
        String sql = "SELECT * FROM cidade WHERE cidade = ?";

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, cidade.getCidade());
            stm.setInt(2, cidade.getId_cidade());
            stm.executeUpdate();
            System.out.println("Cidade atualizada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar cidade:" + e.getMessage());
        }
    }

    //Delete
    public void deletarCidade(int id_cidade) {
        String sql = "DELETE FROM cidade WHERE id_cidade = ?";

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, id_cidade);
            stm.executeUpdate();
            System.out.println("Cidade deletada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao deletar cidade!" + e.getMessage());
        }
    }
}
