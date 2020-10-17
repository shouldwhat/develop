## 프로젝트 소개
Spring Boot 환경에서 Kafka에 Message를 Produce/Consume 할 수 있는 가장 심플한 방법을 다룹니다.

## 준비
1. Install Kafka : https://github.com/shouldwhat/linux-script/blob/master/docker/kafka/docker-compose.yml

## Produce API
1. "/produces/{message}/model", POST

## Output
```
2020-10-17 15:42:38.186  INFO 28808 --- [nio-8080-exec-4] c.e.k.producer.ProduceController         : send => helloWorld
2020-10-17 15:42:38.192  INFO 28808 --- [ntainer#0-0-C-1] c.e.k.consumer.KafkaMessageConsumer      : Consumed => Message [message=helloWorld]
```
