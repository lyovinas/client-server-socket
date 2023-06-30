#  Клиент-серверное приложение на сокетах

Небольшой проект, состоящий из двух приложений: клиентского и серверного, обменивающихся данными через сокеты.
Проект написан для знакомства с сокетами, основами многопоточности, созданием и использованием jar-файлов.

Основной функционал:
- Сервер после запуска  находится в ожидании подключения клиента.
При подключении клиента считывается отправленное им сообщение и отправляется значение числового счетчика.
Каждое клиентское подключение обрабатывается в отдельном потоке.
- Клиентское приложение отправляет запрос на сервер, считывает ответное сообщение и завершает работу.
---
- Функционал по созданию сокетов и приему/отправке данных вынесен в отдельный класс Connection.  
Для его использования создан jar-файл командой `jar cf Connection.jar *`, выполненной в директории `\out\production\Utils`, содержащей пакеты ru\demo с классом Connection.class.  
- Сервер запускается командой `java -cp .;..\Utils\Connection.jar Server` из директории `\out\production\Server`, содержащей серверное приложение Server.class.  
- Клиент запускается аналогично, командой `java -cp .;..\Utils\Connection.jar Client`
---  
## Инструменты

IntelliJ IDEA | Java
