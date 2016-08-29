package br.com.walison.dados;


/**
 * Escreva a descrição da classe Cliente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Date;

public class Cliente extends Pessoa {

    private int codigo; 
    private Date dataNascimento;
    
    public Cliente(Date dataNascimento, String nome) {
        super(nome);
        this.dataNascimento = dataNascimento;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("nome:").append(super.nome);
        sb.append(", codigo: ").append(codigo);
        sb.append(", dataNascimento: ").append(dataNascimento);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;

        Cliente cliente = (Cliente) o;

        if (codigo != cliente.codigo) return false;
        return dataNascimento != null ? dataNascimento.equals(cliente.dataNascimento) : cliente.dataNascimento == null;

    }

    @Override
    public int hashCode() {
        int result = codigo;
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        return result;
    }
}
