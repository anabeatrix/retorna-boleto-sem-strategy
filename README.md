# :x: Como **NÃO** implementar uma solução
### :bomb: Aplicação para leitura e retorno de boletos, utilizando uma solução simplista e não aconselhada. Alternativa a implementação com padrão Strategy.
Há situações em que a aplicação de um padrão de projeto é, sem dúvidas, a melhor alternativa, ainda que envolva um número maior de
classes. O contrário, como pode ser observado nesse projeto que possui poucas classes, não é sinônimo da aplicação do princípio [KISS](https://pt.wikipedia.org/wiki/Princ%C3%ADpio_KISS) e sujeita o código a prováveis bugs sempre que houver
alteração. :bug: 

Nesse caso específico, quatro dos cinco princípios [SOLID](https://medium.com/@brunobandev/os-princ%C3%ADpios-s-o-l-i-d-em-imagens-1b5233479c21) atendidos pelo padrão de projeto _Strategy_ são violados. São eles:
- Single Responsibility (SRP), 
- Open-Closed (OCP), 
- Liskov Substitution (LSP) e
- Interface Segregation (ISP).

:exclamation: Visto que essa solução é totalmente não recomendada, o objetivo de tal implementação é para fins acadêmicos, apenas. :mortar_board::books:
