# 📄 Nowaste

## 📌 Sobre

O Nowaste é um sistema desenvolvido em Java com foco no controle de validade de produtos em estoque, voltado para empresas como supermercados.

O diferencial do sistema é que o controle é feito por lote, permitindo que um mesmo produto tenha múltiplas datas de validade, tornando o gerenciamento mais preciso e evitando desperdícios.

---

## 🎯 Problema

Empresas que trabalham com estoque enfrentam dificuldades como:

- Controlar validade de produtos por lote  
- Identificar produtos próximos do vencimento  
- Evitar perdas e prejuízos  

---

## 💡 Solução

O Nowaste resolve isso através de:

- Cadastro de produtos organizados por categoria  
- Cadastro de lotes com validade individual  
- Análise automática da validade dos lotes  

---

## ⚙️ Funcionalidades (Sprint 0)

- Cadastro de produtos  
- Cadastro de lotes com data de validade  
- Associação entre produto e lote  
- Organização por categoria  
- Verificação de validade dos lotes  

---

## 🧠 Regras de negócio

- Um produto pode ter vários lotes  
- Cada lote possui sua própria data de validade  
- O sistema define automaticamente o status do lote:
  - VÁLIDO  
  - PRÓXIMO DO VENCIMENTO  
  - VENCIDO  

---

## 🧱 Estrutura do projeto

```bash
src/
├── domain/
├── service/
└── ui/
```
📦 Principais classes

📂 Domain
Produto
Lote
Fornecedor
StatusProduto (enum)

⚙️ Service
ProdutoService
LoteService

💾 Infra
ProdutoRepositoryMemoria
LoteRepositoryMemoria

🖥️ UI
ConsoleUI
Menu

▶️ Como executar
git clone https://github.com/gabszinn/Nowaste.git

Abrir na IDE (IntelliJ ou Eclipse) e executar a classe principal.

🧪 Testes

🚧 Ainda em desenvolvimento

Planejado:

Testes unitários com JUnit
Testes BDD com Cucumber
📊 Status do projeto

✔ Sprint 0 concluída

Estrutura inicial criada
Primeira funcionalidade implementada

🚀 Próximos passos
Listagem de lotes
Produtos que vencem no mês
Produtos próximos do vencimento
Alertas
Testes automatizados

📌 Observação

As funcionalidades detalhadas estão disponíveis no backlog do projeto (GitHub Issues).

👥 Integrantes
Gabriel Felipe
Isadora Rodrigues
Wesley Carvalho
Henrique Cezar
