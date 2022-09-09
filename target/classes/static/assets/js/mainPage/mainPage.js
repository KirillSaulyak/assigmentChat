$(document).ready(
    function () {

        let stompClient = null;

        connect();

        function connect() {
            let socket = new SockJS('/chat/main-page/ws');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function () {
                stompClient.subscribe('/show-rooms', function (room) {
                    showRoom(JSON.parse(room.body));
                });
            });
        }

        function disconnect() {
            stompClient.disconnect();
            exit();
        }

        function exit() {
            $("#logoutForm").submit();
        }

        function createRoom() {
            stompClient.send("/create-room", {}, $("#nameRoom").val());
            clearInputRoomNameField();
        }

        function clearInputRoomNameField() {
            $("#nameRoom").val("")
        }

        function showRoom(room) {
            $("#roomsPlace").append(
                "<div class='col-auto'>" +
                    "<a href= room/" + room.idRoom + ">" +
                        "<button type='button' class='btn btn-primary btn-lg'>" + room.name + "</button>" +
                    "</a>" +
                "</div>"
            );
        }

        $(function () {
            $("#exit").click(function (e) {
                e.preventDefault()
                disconnect();
            });
            $("#createRoom").click(function () {
                createRoom();
            });
        });
    }
)
