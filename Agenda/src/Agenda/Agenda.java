package Agenda;

import javax.swing.JOptionPane;

abstract class Compromisso {
    private String data;
    private String descricao;

    public Compromisso(String data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract String getTipoCompromisso();

    public abstract String getInformacoes();

    public abstract double calcularTempoGasto();
}

class CompromissoSimples extends Compromisso {
    private double duracao;

    public CompromissoSimples(String data, String descricao, double duracao) {
        super(data, descricao);
        this.duracao = duracao;
    }

    public double getDuracao() {
        return duracao;
    }

    @Override
    public String getTipoCompromisso() {
        return "Compromisso Simples";
    }

    @Override
    public String getInformacoes() {
        return "Data: " + getData() + "\n" +
                "Descri��o: " + getDescricao() + "\n" +
                "Dura��o: " + duracao + " horas";
    }

    @Override
    public double calcularTempoGasto() {
        return duracao;
    }
}

class CompromissoReuniao extends Compromisso {
    private int numeroParticipantes;
    private double duracao;

    public CompromissoReuniao(String data, String descricao, int numeroParticipantes, double duracao) {
        super(data, descricao);
        this.numeroParticipantes = numeroParticipantes;
        this.duracao = duracao;
    }

    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public double getDuracao() {
        return duracao;
    }

    @Override
    public String getTipoCompromisso() {
        return "Reuni�o";
    }

    @Override
    public String getInformacoes() {
        return "Data: " + getData() + "\n" +
                "Descri��o: " + getDescricao() + "\n" +
                "N�mero de Participantes: " + numeroParticipantes + "\n" +
                "Dura��o: " + duracao + " horas";
    }

    @Override
    public double calcularTempoGasto() {
        return duracao * numeroParticipantes;
    }
}

class Agenda {
    private Compromisso[] compromissos;
    private int contador;

    public Agenda(int capacidade) {
        compromissos = new Compromisso[capacidade];
        contador = 0;
    }

    public void adicionarCompromisso(Compromisso compromisso) {
        if (contador < compromissos.length) {
            compromissos[contador] = compromisso;
            contador++;
            JOptionPane.showMessageDialog(null, "Compromisso adicionado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "A agenda est� cheia!");
        }
    }

    public void listarCompromissos() {
        if (contador > 0) {
            StringBuilder mensagem = new StringBuilder();
            mensagem.append("Lista de Compromissos:\n");
            for (int i = 0; i < contador; i++) {
                mensagem.append("\nCompromisso ").append(i + 1).append(":\n");
                mensagem.append(compromissos[i].getInformacoes()).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensagem.toString());
        } else {
            JOptionPane.showMessageDialog(null, "N�o h� compromissos na agenda.");
        }
    }
}