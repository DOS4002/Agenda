package Agenda;

import javax.swing.JOptionPane;


public class AppAgenda{
    public static void main(String[] args) {
        Agenda agenda = new Agenda(10);

        while (true) {
            String opcao = JOptionPane.showInputDialog("Selecione uma opção:\n" +
                    "1. Adicionar Compromisso\n" +
                    "2. Listar Compromissos\n" +
                    "3. Sair");

            if (opcao == null || opcao.equals("3")) {
                JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                break;
            }

            switch (opcao) {
                case "1":
                    String tipoCompromisso = JOptionPane.showInputDialog("Selecione o tipo de compromisso:\n" +
                            "1. Compromisso Simples\n" +
                            "2. Reunião");

                    String data = JOptionPane.showInputDialog("Digite a data do compromisso:");
                    String descricao = JOptionPane.showInputDialog("Digite a descrição do compromisso:");

                    if (tipoCompromisso.equals("1")) {
                        double duracao = Double.parseDouble(JOptionPane.showInputDialog("Digite a duração do compromisso em horas:"));
                        CompromissoSimples compromissoSimples = new CompromissoSimples(data, descricao, duracao);
                        agenda.adicionarCompromisso(compromissoSimples);
                    } else if (tipoCompromisso.equals("2")) {
                        int numeroParticipantes = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de participantes da reunião:"));
                        double duracao = Double.parseDouble(JOptionPane.showInputDialog("Digite a duração da reunião em horas:"));
                        CompromissoReuniao compromissoReuniao = new CompromissoReuniao(data, descricao, numeroParticipantes, duracao);
                        agenda.adicionarCompromisso(compromissoReuniao);
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                    }
                    break;

                case "2":
                    agenda.listarCompromissos();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }
}
