Tenia la necesidad de hacer un microservicio para auditoria pero el cliente nunca definio que queria auditar.
La idea es dejar mensajes en json, de longitud variable, en una cola de mensajeria y los saca a medida que puede para persistirlos en una base de datos NOSQL. 
Spring Cloud, Rabbit MQ o SQS, MongDB o DynamoDB

Talvez clases utilitarias para ocultar el nombre de la cola y garantizar que no mandan mensajes que no puedo procesar (Es necesario???)
