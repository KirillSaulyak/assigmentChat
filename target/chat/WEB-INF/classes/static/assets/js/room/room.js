$(document).ready(
    function () {

        let stompClient = null;

        connect();

        function connect() {
            let socket = new SockJS('/chat/room/ws');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function () {
                stompClient.subscribe('/room/' + idRoom, function (message) {
                    showMessage(JSON.parse(message.body));
                });
            });
        }

        function disconnect() {
            stompClient.disconnect();
            exit();
        }

        function exit() {
            window.location.href = "../"
        }

        function sendName() {
            stompClient.send("/message/" + idRoom, {}, $("#writeMessage").val());
            clearInputMessageField();
        }

        function clearInputMessageField() {
            $("#writeMessage").val("")
        }

        function showMessage(user) {
            $("#messages").append(
                "<tr>" +
                    "<td>" + user.name + "</td>" +
                    "<td>" + user.message + "</td>" +
                "</tr>"
            );
        }

        $(function () {
            $("#exit").click(function () {
                disconnect();
            });
            $("#send").click(function () {
                sendName();
            });
        });
    }
)
