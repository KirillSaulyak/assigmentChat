Тестировалось:
    OC Windows, IntelliJ IDEA ultimate, docker-compose v3

Требования:
    docker, docker-compose v3, IntelliJ IDEA ultimate.

Шаги для поднятия:
    Создать артефакт В IntelliJ IDEA ultimate : Build->Build Artifacts...->assigmentChat:war->build
    По умолчанию в папке target должен создаться артефакт chat.war

    Если он создался в другой папке, то следует изменить путь в DockerFile "target/chat.war" на тот, в котором создался артефакт

    После в терминале IntelliJ IDEA ultimate прописать docker-compose up

    Когда докер запустит контейнеры, переходим по ссылке http://localhost:8080/chat

