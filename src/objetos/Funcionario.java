/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import enums.Funcao;
import java.math.BigDecimal;

/**
 *
 * @author User
 */
public class Funcionario {
    protected int id_func;
//    protected String nome;
//    protected String   cpf;
    protected Funcao funcao;
    protected String  senha;
    protected BigDecimal salario;
    protected String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    private boolean logado;

    public boolean getLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }


    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

   /* public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }*/

    public String getFuncao() {
        return funcao.name();
    }

    public void setFuncao(String funcao) {
        for(Funcao f : Funcao.values()) {
            if(f.name().equalsIgnoreCase(funcao)) {
                this.funcao = f;
            }
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
