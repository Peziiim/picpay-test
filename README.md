#  Desafio Simplificado do PicPay – Projeto Java

Este projeto é uma implementação simplificada de um sistema de transferências financeiras inspirado no modelo do **PicPay**, desenvolvido com foco no aprendizado de fundamentos do backend utilizando **Java**.

---

## Funcionalidades

- Cadastro de usuários (comuns e lojistas)
- Transferência de valores entre usuários
- Validações de saldo e tipo de usuário
- Notificações de transferência simuladas
- Uso de DTOs para comunicação entre camadas
- Estrutura modular com separação de responsabilidades

---

## Tecnologias e Conceitos

- **Java (JDK 8+)**
- **POO (Programação Orientada a Objetos)**
- **DTOs (Data Transfer Objects)**
- **Validação de regras de negócio**
- **Configuração de dependências com AppConfig**
- **Simulação de camadas de serviço, domínio e notificação**

---

## 📁 Estrutura dos Arquivos

- `User.java` – Entidade que representa um usuário do sistema.
- `UserType.java` – Enum que define se o usuário é COMUM ou LOJISTA.
- `Transaction.java` – Entidade de domínio para representar uma transação.
- `UserDTO.java` – Objeto de transferência de dados para usuários.
- `TransactionDTO.java` – DTO que encapsula os dados de uma transferência.
- `NotificationDTO.java` – Simula a notificação enviada após transação.
- `AppConfig.java` – Arquivo de configuração da aplicação.

---
# Como executar
public class Main {
    public static void main(String[] args) {
        User pagador = new User("João", "12345678900", "joao@email.com", 1000.0, UserType.COMUM);
        User recebedor = new User("Loja X", "00987654321", "loja@email.com", 500.0, UserType.LOJISTA);

        Transaction transacao = new Transaction(pagador, recebedor, 200.0);
        transacao.executar();

        System.out.println("Saldo do pagador: " + pagador.getSaldo());
        System.out.println("Saldo do recebedor: " + recebedor.getSaldo());
    }
}
